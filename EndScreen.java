import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    //declaring world dimensions
    public static final int ENDING_WIDTH = GameWorld.WORLD_WIDTH;
    public static final int ENDING_HEIGHT = GameWorld.WORLD_HEIGHT;
    
    //declaring actors
    private Button backButton;
    
    public EndScreen()
    {    
        // Create a new world with ENDING_WIDTH*ENDING_HEIGHT cells with a cell size of 1x1 pixels.
        super(ENDING_WIDTH, ENDING_HEIGHT, 1);
        
        //add button
        backButton = new Button("Back");
        addObject(backButton, getWidth() * 3 / 4, getHeight() * 5 / 6);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(backButton)) Greenfoot.setWorld(new MainMenu());  //takes the user back to the main menu
    }
}
