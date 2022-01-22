import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends SuperSmoothMover
{
    //declaring the player's dimensions and image to reference width and height
    private static GreenfootImage refImage = new GreenfootImage("Player/RifleSprites/Move/survivor-move_rifle_0.png");
    public static final int PLAYER_WIDTH = refImage.getWidth() / 3;
    public static final int PLAYER_HEIGHT = refImage.getHeight() / 3;
    
    //initializing constants
    public static final int PLAYER_MAX_HP = 100;
    public static final int PLAYER_SPEED = 3;
    public static final int PLAYER_DMG = 4;
    public static final int PLAYER_MAG_SIZE = 15;
    public static final int PLAYER_SHOOT_CD = 10;
    public static final int PLAYER_RELOAD_TIME = 60; //(number of acts)
    
    //declaring actors
    private StatBar hpBar;
    private ScoreDisplay scoreDisplay;
    private AmmoDisplay ammoDisplay;
    
    //declaring instance variables
    private int score = 0;
    //stats
    private int maxHP = PLAYER_MAX_HP;
    private int currHP = maxHP;
    private int speed = PLAYER_SPEED;
    private int dmg = PLAYER_DMG;
    private int shootCD = PLAYER_SHOOT_CD;
    private int currShootCD = 0;
    private int ammo = PLAYER_MAG_SIZE;
    private boolean unlimitedAmmo = false;
    private boolean reloading;
    private int reloadTimer = PLAYER_RELOAD_TIME;
    //mouse tracker
    private MouseInfo mouse;
    private boolean mouseDown = false;
    //sprites
    private GreenfootImage[] rifleMovingSprites = new GreenfootImage[20];
    private GreenfootImage[] rifleReloadingSprites = new GreenfootImage[20];
    //sprite info
    private int rifleMovingSpriteNum = 0;
    private int rifleReloadingSpriteNum = 0;
    private boolean isMoving = false;
    //sound
    private GreenfootSound[] rifleSounds;
    private int rifleSoundsIndex = 0;
    
    public Player(){
        //initializing sprites
        for (int i = 0; i < rifleMovingSprites.length; i++) {
            rifleMovingSprites[i] = new GreenfootImage("Player/RifleSprites/Move/survivor-move_rifle_"+i+".png");
            rifleMovingSprites[i].scale(PLAYER_WIDTH, PLAYER_HEIGHT);
        }
        for (int i = 0; i < rifleReloadingSprites.length; i++) {
            rifleReloadingSprites[i] = new GreenfootImage("Player/RifleSprites/Reload/survivor-reload_rifle_"+i+".png");
            rifleReloadingSprites[i].scale(PLAYER_WIDTH, PLAYER_HEIGHT);
        }
        setImage(rifleMovingSprites[0]); //setting the image of the player
        
        //creating the player's hp bar and score display
        hpBar = new StatBar(100, currHP, GameWorld.WORLD_WIDTH / 5, GameWorld.WORLD_HEIGHT / 30, PLAYER_HEIGHT, null, Color.GREEN, Color.RED, false, Color.BLUE, GameWorld.WORLD_HEIGHT / 180);
        scoreDisplay = new ScoreDisplay(score);
        ammoDisplay = new AmmoDisplay(ammo);
        
        //creating sound array
        rifleSounds = new GreenfootSound[10];
        for(int i = 0; i < rifleSounds.length; i++) rifleSounds[i] = new GreenfootSound("PlayerSoundEffects/RifleShot.wav");
    }
    
    public void addedToWorld(World world){ //(from Mr. Cohen)
        //adding player hp bar, score display, and ammo display to the world
        world.addObject(hpBar, GameWorld.WORLD_WIDTH * 9 / 50, GameWorld.WORLD_HEIGHT / 16);
        world.addObject(scoreDisplay, GameWorld.WORLD_WIDTH / 6, GameWorld.WORLD_HEIGHT / 12);
        world.addObject(ammoDisplay, GameWorld.WORLD_WIDTH * 91 / 100, GameWorld.WORLD_HEIGHT * 19 / 20);
    }
    
    public void act() 
    {
        mouse = Greenfoot.getMouseInfo();
        if(mouse != null) turnTowards(mouse.getX(), mouse.getY()); //making the player face the mouse
        
        //movement
        isMoving = false;
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY() - speed);
            isMoving = true;
        }
        if(Greenfoot.isKeyDown("a")) {
            setLocation(getX() - speed, getY());
            isMoving = true;
        }
        if(Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + speed);
            isMoving = true;
        }
        if(Greenfoot.isKeyDown("d")) {
            setLocation(getX() + speed, getY());
            isMoving = true;
        }
        
        //checks if the mouse is down (from "danpost" on Greenfoot)
        if(Greenfoot.mousePressed(null)) mouseDown = true;
        else if(Greenfoot.mouseClicked(null)) mouseDown = false;
        
        //shoots a bullet and adds muzzle flash if the user presses the mouse button
        if(ammo > 0 && currShootCD <= 0 && mouseDown && !reloading){
            if(!unlimitedAmmo){
                ammo--;
                ammoDisplay.update(ammo);
            }
            currShootCD = shootCD;
            
            //adds bullet
            Bullet bullet = new Bullet();
            bullet.setRotation(getRotation());
            getWorld().addObject(bullet, getX(), getY());
            bullet.move(PLAYER_WIDTH / 2 + bullet.BULLET_WIDTH / 3);
            bullet.setRotation(bullet.getRotation() + 90);
            bullet.move(PLAYER_HEIGHT * 29 / 100);
            bullet.setRotation(bullet.getRotation() - 90);
            
            //adds muzzle flash
            if(getWorld().getObjects(MuzzleFlash.class).size() > 0){
                MuzzleFlash prevFlash = getWorld().getObjects(MuzzleFlash.class).get(0); //(from Mr. Cohen)
                getWorld().removeObject(prevFlash);
            }
            MuzzleFlash muzzleFlash = new MuzzleFlash();
            muzzleFlash.setRotation(getRotation());
            getWorld().addObject(muzzleFlash, getX(), getY());
            muzzleFlash.move(PLAYER_WIDTH / 2 + muzzleFlash.MUZZLE_FLASH_WIDTH / 3);
            muzzleFlash.setRotation(muzzleFlash.getRotation() + 90);
            muzzleFlash.move(PLAYER_HEIGHT * 3 / 10);
            muzzleFlash.setRotation(muzzleFlash.getRotation() - 90);
            
            //playing rifle shot sound
            rifleSounds[rifleSoundsIndex].play();
            rifleSoundsIndex++;
            if(rifleSoundsIndex >= rifleSounds.length) rifleSoundsIndex = 0;
        }
        currShootCD--; //update shoot cooldown
        
         //reloads weapon if ammo runs out or if user presses "r"
        if((ammo <= 0 || (Greenfoot.isKeyDown("r") && ammo < PLAYER_MAG_SIZE)) && !reloading){
            reloading = true;
            rifleReloadingSpriteNum = 0;
            GreenfootSound reloadSound = new GreenfootSound("PlayerSoundEffects/PlayerReload.wav");
            reloadSound.play();
        }
        //reloads weapon
        if(reloading){
            reloadTimer--;
            if(reloadTimer == 0){
                reloading = false;
                reloadTimer = PLAYER_RELOAD_TIME;
                ammo = PLAYER_MAG_SIZE;
                ammoDisplay.update(ammo);
            }
        }
        
        handleSprites();
        
        //ends the game if the player dies
        if(currHP <= 0){
            //adding score to scorefile
            ScoreFile scoreFile = ScoreFile.getInstance();
            scoreFile.addScoreData(score);
            
            GameWorld.endGame(); //taking the user to the endscreen
        }
    }
    
    //method to handle sprites
    private void handleSprites() {
        //manages reload animations
        if (reloading) {
            if (reloadTimer % 3 == 0) {
                if(rifleReloadingSpriteNum < 19) rifleReloadingSpriteNum++;
            }
            setImage(rifleReloadingSprites[rifleReloadingSpriteNum]);
            return;
        }
        
        //manages move animations
        if (isMoving) {
            rifleMovingSpriteNum++;
            if (rifleMovingSpriteNum == rifleMovingSprites.length) rifleMovingSpriteNum = 0;
            setImage(rifleMovingSprites[rifleMovingSpriteNum]);
        }
    }
    
    //getter methods
    
    //method to get the player's score
    public int getScore()
    {
        return score;
    }
    
    //method to get the powerup objects intersecting the player
    public List<Powerup> getIntersectingObjects() {
        return getIntersectingObjects(Powerup.class);
    }
    
    //method to get the player's max hp
    public int getMaxHP(){
        return maxHP;
    }
    
    //method to get the player's damage
    public int getDmg(){
        return dmg;
    }
    
    //setter methods
    
    //method to deal damage to the player
    public void dealDmg(int dmg){
        currHP -= dmg;
        if(currHP < 0) currHP = 0;
        hpBar.update(currHP);
    }
    
    //method to set the player's score
    public void setScore(int points){
        score += points;
        scoreDisplay.update(score);
    }
    
    //method to set the player's current hp
    public void setCurrHP(int currHP){
        this.currHP = currHP;
        hpBar.update(currHP);
    }
    
    //method to set the player's speed
    public void setSpeed(int increase){
        speed += increase;
    }
    
    //method to set the player's damage
    public void setDmg(int increase){
        dmg += increase;
    }
    
    //method to set the player's shoot cooldown
    public void setShootCD(int decrease){
        shootCD -= decrease;
    }
    
    //method to set the player's amount of ammo
    public void setAmmo(int ammo){
        this.ammo = ammo;
        ammoDisplay.update(ammo);
    }
    
    //method to set the state of the unlimited ammo powerup (active/not active)
    public void setUnlimitedAmmo(boolean unlimitedAmmo){
        this.unlimitedAmmo = unlimitedAmmo;
    }
}