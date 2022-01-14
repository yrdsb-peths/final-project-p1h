import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Powerup extends Actor
{
    //declaring the powerup's dimensions and image
    public static final int PU_WIDTH = GameWorld.WORLD_WIDTH / 48;
    public static final int PU_HEIGHT = PU_WIDTH;
    protected GreenfootImage image;
    
    //declaring constants
    public static final int LIFESPAN = 500;
    
    //declaring instance variables
    protected Player player;
    
    public Powerup(){
        image = new GreenfootImage(PU_WIDTH + 1, PU_HEIGHT + 1);
    }
    
    public void act(){
        
    }
    
    //method to activate the powerup benefits
    public void activate(){
        
    }
    
    //method to deactivate the powerup benefits
    public void deactivate(){
        
    }
    
    //method to draw the powerup
    public void draw(Color color){
        image = new GreenfootImage(PU_WIDTH + 1, PU_HEIGHT + 1);
        image.setColor(Color.GRAY);
        image.fillRect(0, 0, PU_WIDTH + 1, PU_HEIGHT + 1);
        image.setColor(color);
        image.fillRect(2, 2, 16, 16);
        setImage(image);
    }
    
    //returns the powerup notification name of the powerup
    public String toString(){
        return "";
    }
    
    //returns true if the powerup needs an icon showing how much longer it is active
    public boolean needsIcon(){
        return true;
    }
    
    //returns the color of the powerup
    public Color getColor(){
        return null;
    }
}