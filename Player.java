import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends SuperSmoothMover
{
    //declaring the player's dimensions
    private GreenfootImage image;
    public static final int PLAYER_WIDTH = GameWorld.WORLD_WIDTH / 10;
    public static final int PLAYER_HEIGHT = PLAYER_WIDTH;
    
    //declaring constants
    public static final int PLAYER_MAX_HP = 100;
    
    //declaring actors
    private StatBar hpBar;
    
    //declaring mouse tracker
    private MouseInfo mouse;
    
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
        if(Greenfoot.isKeyDown("w")) setLocation(getX(), getY() - 5);
        if(Greenfoot.isKeyDown("a")) setLocation(getX() - 5, getY());
        if(Greenfoot.isKeyDown("s")) setLocation(getX(), getY() + 5);
        if(Greenfoot.isKeyDown("d")) setLocation(getX() + 5, getY());
    }
    
    //method to draw the player
    private void drawPlayer(int width, int height){
        int[] xVertices = {0, width, 0};
        int[] yVertices = {0, height / 2, height};
        image.fillPolygon(xVertices, yVertices, 3);
    }
}
