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
    public static final int PU_WIDTH = GameWorld.WORLD_WIDTH / 50;
    public static final int PU_HEIGHT = PU_WIDTH;
    protected GreenfootImage image;
    
    //declaring constants
    public static final int LIFESPAN = 480; //how long the powerup lasts in the world
    public static final int DURATION = 600; //how long its effect lasts
    
    //declaring instance variables
    protected Player player;
    protected int timeLeft = LIFESPAN;
    
    public Powerup(){
        image = new GreenfootImage(PU_WIDTH + 1, PU_HEIGHT + 1);
    }
    
    public void act(){
        timeLeft--;
        if (timeLeft == 0) getWorld().removeObject(this);
    }
    
    //method to activate the powerup benefits
    public void activate(){
        
    }
    
    //method to deactivate the powerup benefits
    public void deactivate(){
        
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
    
    //method to draw the powerup
    public void draw(int width, int height, Color color){
        image.setColor(Color.BLACK);
        image.fillRect(0, 0, width, height);
        image.setColor(color);
        image.fillRect(width / 10, height / 10, width * 9 / 10, height * 9 / 10);
        setImage(image);
    }
}
