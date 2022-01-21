import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackgroundCover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackgroundCover extends SuperSmoothMover
{
    //declaring the background cover's dimensions and image variables
    private GreenfootImage image;
    public static final int COVER_WIDTH = EndScreen.ENDING_WIDTH;
    public static final int COVER_HEIGHT = EndScreen.ENDING_HEIGHT;
    
    public BackgroundCover(){
        //drawing the background cover
        image = new GreenfootImage(COVER_WIDTH + 1, COVER_HEIGHT + 1);
        image.fill();
        setImage(image);
    }
    
    public void act() 
    {
        //moves the background cover down the screen
        int yVal = getY();
        if(yVal + COVER_HEIGHT / 2 < COVER_HEIGHT){
            setLocation(getX(), yVal++);
        }
        else getWorld().removeObject(this);
    }    
}
