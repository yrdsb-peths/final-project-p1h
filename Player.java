import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends SuperSmoothMover
{
    //declaring the player's dimensions and image
    private GreenfootImage image;
    public static final int PLAYER_WIDTH = GameWorld.WORLD_WIDTH / 20;
    public static final int PLAYER_HEIGHT = PLAYER_WIDTH;
    
    //declaring constants
    public static final int PLAYER_MAX_HP = 100;
    public static final int PLAYER_SPEED = 5;
    public static final int PLAYER_MAG_SIZE = 15;
    public static final int PLAYER_SHOOT_CD = 10;
    public static final int PLAYER_RELOAD_TIME = 60; //(number of acts)
    public static final int PLAYER_DMG = 4;
    
    //declaring actors
    private StatBar hpBar;
    private ScoreDisplay scoreDisplay;
    private AmmoDisplay ammoDisplay;
    
    //declaring instance variables
    private int score;
    private int ammo;
    private int currShootCD = 0;
    private boolean reloading;
    private int reloadTimer = PLAYER_RELOAD_TIME;
    //declaring mouse tracker
    private MouseInfo mouse;
    private boolean mouseDown = false;
    
    //declaring stats
    private int currHP = PLAYER_MAX_HP;
    
    public Player(){
        image = new GreenfootImage(PLAYER_WIDTH + 1, PLAYER_HEIGHT + 1); //creating the blank GreenfootImage used for the player
        //drawing the player then setting the image for the player
        drawPlayer(PLAYER_WIDTH, PLAYER_HEIGHT);
        setImage(image);
        
        //resetting player score
        score = 0;
        ammo = PLAYER_MAG_SIZE;
        
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
        if(Greenfoot.isKeyDown("w")) setLocation(getX(), getY() - PLAYER_SPEED);
        if(Greenfoot.isKeyDown("a")) setLocation(getX() - PLAYER_SPEED, getY());
        if(Greenfoot.isKeyDown("s")) setLocation(getX(), getY() + PLAYER_SPEED);
        if(Greenfoot.isKeyDown("d")) setLocation(getX() + PLAYER_SPEED, getY());
        
        //checks if the mouse is down (from "danpost" on Greenfoot)
        if(Greenfoot.mousePressed(null)){
            mouseDown = true;
        }
        else if(Greenfoot.mouseClicked(null)){
            mouseDown = false;
        }
        
        //shoots a bullet if the use presses the mouse button and the shoot cooldown has expired
        if(ammo > 0 && currShootCD <= 0 && mouseDown && !reloading){
            Bullet bullet = new Bullet();
            bullet.setRotation(getRotation());
            getWorld().addObject(bullet, getX(), getY());
            bullet.move(PLAYER_WIDTH / 2 + bullet.BULLET_WIDTH / 2);
            currShootCD = PLAYER_SHOOT_CD;
            ammo--;
            ammoDisplay.update(ammo);
        }
        currShootCD--; //update shoot cooldown
        
        if(ammo <= 0 || Greenfoot.isKeyDown("r")) reloading = true; //reloads weapon if ammo runs out or if user presses "r"
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
    }
    
    //method to draw the player
    private void drawPlayer(int width, int height){
        int[] xVertices = {0, width, 0};
        int[] yVertices = {0, height / 2, height};
        image.fillPolygon(xVertices, yVertices, 3);
    }
}
