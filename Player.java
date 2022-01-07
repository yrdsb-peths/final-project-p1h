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
    public static final int SPEED = 5;
    public static final int SHOOT_CD = 10;
    
    //declaring actors
    private StatBar hpBar;
    
    //declaring instance variables
    private int currShootCD = 0;
    //declaring mouse tracker
    private MouseInfo mouse;
    private boolean mouseDown = false;
    
    //declaring stats
    private int playerHp = PLAYER_MAX_HP;
    
    public Player(){
        image = new GreenfootImage(PLAYER_WIDTH + 1, PLAYER_HEIGHT + 1); //creating the blank GreenfootImage used for the player
        //drawing the player then setting the image for the player
        drawPlayer(PLAYER_WIDTH, PLAYER_HEIGHT);
        setImage(image);
        
        //creating the player's hp bar
        hpBar = new StatBar(100, playerHp, GameWorld.WORLD_WIDTH / 10, GameWorld.WORLD_HEIGHT / 50, 0, Color.GREEN, Color.RED, false, Color.BLUE, GameWorld.WORLD_HEIGHT / 180);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mouse = Greenfoot.getMouseInfo(); //setting variable to track the mouse
        if(mouse != null) turnTowards(mouse.getX(), mouse.getY()); //making the player face the mouse
        //movement
        if(Greenfoot.isKeyDown("w")) setLocation(getX(), getY() - SPEED);
        if(Greenfoot.isKeyDown("a")) setLocation(getX() - SPEED, getY());
        if(Greenfoot.isKeyDown("s")) setLocation(getX(), getY() + SPEED);
        if(Greenfoot.isKeyDown("d")) setLocation(getX() + SPEED, getY());
        
        //checks if the mouse is down (from "danpost" on Greenfoot)
        if(Greenfoot.mousePressed(null)){
            mouseDown = true;
        }
        else if(Greenfoot.mouseClicked(null)){
            mouseDown = false;
        }
        currShootCD--;
        if(currShootCD <= 0 && mouseDown){
            Bullet bullet = new Bullet();
            bullet.setRotation(getRotation());
            getWorld().addObject(bullet, getX(), getY());
            bullet.move(PLAYER_WIDTH / 2 + bullet.BULLET_WIDTH / 2);
            currShootCD = SHOOT_CD;
        }
    }
    
    //method to draw the player
    private void drawPlayer(int width, int height){
        int[] xVertices = {0, width, 0};
        int[] yVertices = {0, height / 2, height};
        image.fillPolygon(xVertices, yVertices, 3);
    }
}
