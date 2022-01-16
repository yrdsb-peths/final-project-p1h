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
    private static GreenfootImage image = new GreenfootImage("rifle/move/survivor-move_rifle_0.png");
    public static final int PLAYER_WIDTH = image.getWidth() / 2;
    public static final int PLAYER_HEIGHT = image.getHeight() / 2;
    
    //initializing constants
    public static final int PLAYER_MAX_HP = 100;
    public static final int PLAYER_SPEED = 5;
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
    //declaring mouse tracker
    private MouseInfo mouse;
    private boolean mouseDown = false;
    
    //declaring sprites
    private GreenfootImage[] rifleMovingSprites = new GreenfootImage[20];
    private GreenfootImage[] rifleReloadingSprites = new GreenfootImage[20];
    
    //declaring sprite information
    private int rifleMovingSpriteNumber = 0;
    private int rifleReloadingSpriteNumber = 0;
    private boolean isMoving = false;
    
    public Player(){
        //initialize sprites
        for (int i = 0; i < rifleMovingSprites.length; i++) {
            rifleMovingSprites[i] = new GreenfootImage("rifle/move/survivor-move_rifle_"+i+".png");
            rifleMovingSprites[i].scale(rifleMovingSprites[i].getWidth() / 2, rifleMovingSprites[i].getHeight() / 2);
        }
        for (int i = 0; i < rifleReloadingSprites.length; i++) {
            rifleReloadingSprites[i] = new GreenfootImage("rifle/reload/survivor-reload_rifle_"+i+".png");
            rifleReloadingSprites[i].scale(rifleReloadingSprites[i].getWidth() / 2, rifleReloadingSprites[i].getHeight() / 2);
        }
        
        setImage(rifleMovingSprites[0]); //setting the player's image
        
        //creating the player's hp bar and score display
        hpBar = new StatBar(100, currHP, GameWorld.WORLD_WIDTH / 5, GameWorld.WORLD_HEIGHT / 30, PLAYER_HEIGHT, null, Color.GREEN, Color.RED, false, Color.BLUE, GameWorld.WORLD_HEIGHT / 180);
        scoreDisplay = new ScoreDisplay(score);
        ammoDisplay = new AmmoDisplay(ammo);
    }
    
    public void addedToWorld(World world){ //(from Mr. Cohen)
        //adding player hp bar, score display, and ammo display to the world
        world.addObject(hpBar, GameWorld.WORLD_WIDTH / 6, GameWorld.WORLD_HEIGHT / 15);
        world.addObject(scoreDisplay, GameWorld.WORLD_WIDTH * 57 / 320, GameWorld.WORLD_HEIGHT / 8);
        world.addObject(ammoDisplay, GameWorld.WORLD_WIDTH * 6 / 7, GameWorld.WORLD_HEIGHT * 19 / 20);
    }
    
    public void act() 
    {
        mouse = Greenfoot.getMouseInfo(); //setting variable to track the mouse
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
        
        //shoots a bullet and adds muzzle flash if the use presses the mouse button
        if(ammo > 0 && currShootCD <= 0 && mouseDown && !reloading){
            currShootCD = shootCD;
            if(!unlimitedAmmo){
                ammo--;
                ammoDisplay.update(ammo);
            }
            //adds bullet
            Bullet bullet = new Bullet();
            bullet.setRotation(getRotation());
            getWorld().addObject(bullet, getX(), getY());
            bullet.move(PLAYER_WIDTH / 2 + bullet.BULLET_WIDTH / 3);
            bullet.setRotation(bullet.getRotation() + 90);
            bullet.move(PLAYER_HEIGHT * 29 / 100);
            bullet.setRotation(bullet.getRotation() - 90);
            //adds muzzle flash
            MuzzleFlash muzzleFlash = new MuzzleFlash();
            muzzleFlash.setRotation(getRotation());
            getWorld().addObject(muzzleFlash, getX(), getY());
            muzzleFlash.move(PLAYER_WIDTH / 2 + muzzleFlash.MUZZLE_FLASH_WIDTH / 3);
            muzzleFlash.setRotation(muzzleFlash.getRotation() + 90);
            muzzleFlash.move(PLAYER_HEIGHT * 3 / 10);
            muzzleFlash.setRotation(muzzleFlash.getRotation() - 90);
        }
        currShootCD--; //update shoot cooldown
        
        if(ammo <= 0 || (Greenfoot.isKeyDown("r") && ammo < PLAYER_MAG_SIZE)) reloading = true; //reloads weapon if ammo runs out or if user presses "r"
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
    }
    
    //method to handle sprites
    private void handleSprites() {
        //adds reload animation
        if (reloading) {
            if (reloadTimer % 3 == 0) {
                rifleReloadingSpriteNumber++;
                if (rifleReloadingSpriteNumber == 20) rifleReloadingSpriteNumber = 0;
            }
            setImage(rifleReloadingSprites[rifleReloadingSpriteNumber]);
            return;
        }
        //adds moving animation
        if (isMoving) {
            rifleMovingSpriteNumber++;
            if (rifleMovingSpriteNumber == rifleMovingSprites.length) rifleMovingSpriteNumber = 0;
            setImage(rifleMovingSprites[rifleMovingSpriteNumber]);
        }
    }
    
    //getter methods
    //method to deal damage to the player
    public void dealDmg(int dmg){
        currHP -= dmg;
        if(currHP < 0) currHP = 0;
        hpBar.update(currHP);
    }
    
    public List<Powerup> getIntersectingObjects() {
        return getIntersectingObjects(Powerup.class);
    }
    
    public int getMaxHP(){
        return maxHP;
    }
    
    public int getDmg(){
        return dmg;
    }
    
    //setter methods
    
    public void setScore(int points){
        score += points;
        scoreDisplay.update(score);
    }
    
    public void setCurrHP(int currHP){
        this.currHP = currHP;
        hpBar.update(currHP);
    }
    
    public void setSpeed(int increase){
        speed += increase;
    }
    
    public void setDmg(int increase){
        dmg += increase;
    }
    
    public void setShootCD(int decrease){
        shootCD -= decrease;
    }
    
    public void setAmmo(int ammo){
        this.ammo = ammo;
        ammoDisplay.update(ammo);
    }
    
    public void setUnlimitedAmmo(boolean unlimitedAmmo){
        this.unlimitedAmmo = unlimitedAmmo;
    }
}
