import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    //declaring variables for world dimensions
    public static final int WORLD_WIDTH = 960;
    public static final int WORLD_HEIGHT = 540;
    
    //declaring actors
    private Player player;
    
    public GameWorld()
    {   
        // Create a new world with WORLD_WIDTH * WORLD_HEIGHT    cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        
        //creating a new player at the specified location
        player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
    }
}
