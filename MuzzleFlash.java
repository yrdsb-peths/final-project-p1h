import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MuzzleFlash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MuzzleFlash extends Actor
{
    //declaring the muzzle flash's dimensions and image
    private static GreenfootImage image = new GreenfootImage("rifle/muzzle_flash.png");
    public static final int MUZZLE_FLASH_WIDTH = image.getWidth() / 2;
    public static final int MUZZLE_FLASH_HEIGHT = image.getHeight() / 2;
    
    //declaring instance variables
    private int transparency = 255;
    
    public MuzzleFlash(){
        //setting the muzzle flash's image
        image.scale(MUZZLE_FLASH_WIDTH, MUZZLE_FLASH_HEIGHT);
        setImage(image);
    }
    
    public void act() 
    {
        transparency -= 20;
        if (transparency <= 0) {
            getWorld().removeObject(this);
            return;
        }
        image.setTransparency(transparency);
        setImage(image);
    }    
}
