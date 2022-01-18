import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MuzzleFlash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MuzzleFlash extends SuperSmoothMover
{
    //declaring the muzzle flash's dimensions and image
    private static GreenfootImage image = new GreenfootImage("rifle/muzzle_flash.png");
    public static final int MUZZLE_FLASH_WIDTH = image.getWidth() / 3;
    public static final int MUZZLE_FLASH_HEIGHT = image.getHeight() / 3;
    
    //declaring actors
    Player player;
    
    //declaring instance variables
    private int transparency = 255;
    
    public MuzzleFlash(){
        //setting the muzzle flash's image
        image.scale(MUZZLE_FLASH_WIDTH, MUZZLE_FLASH_HEIGHT);
        setImage(image);
    }
    
    public void act() 
    {
        //follow rifle
        player = getWorld().getObjects(Player.class).get(0); //(from Mr. Cohen)
        setLocation(player.getX(), player.getY());
        setRotation(player.getRotation());
        move(Player.PLAYER_WIDTH / 2 + MUZZLE_FLASH_WIDTH / 3);
        setRotation(getRotation() + 90);
        move(Player.PLAYER_HEIGHT * 3 / 10);
        setRotation(getRotation() - 90);
        
        //fade out effect
        transparency -= 20;
        if (transparency <= 0) {
            getWorld().removeObject(this);
            return;
        }
        image.setTransparency(transparency);
        setImage(image);
    }    
}
