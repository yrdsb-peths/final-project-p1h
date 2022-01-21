import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BloodSplatter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BloodSplatter extends Actor
{
    //declaring the blood splatter's dimensions and image variables
    private static GreenfootImage image = new GreenfootImage("BloodSplatter.png");
    public static final int BLOOD_SPLATTER_WIDTH = StrongEnemy.STR_WIDTH;
    public static final int BLOOD_SPLATTER_HEIGHT = BLOOD_SPLATTER_WIDTH;
    
    //declaring instance variables
    private int transparency = 60;
    
    public BloodSplatter(){
        //setting the blood splatter's image
        image.scale(BLOOD_SPLATTER_WIDTH, BLOOD_SPLATTER_HEIGHT);
        setImage(image);
    }
    
    public void act() 
    {
        //fade out effect
        transparency--;
        if (transparency <= 0) {
            getWorld().removeObject(this);
            return;
        }
        image.setTransparency(transparency);
        setImage(image);
    }    
}
