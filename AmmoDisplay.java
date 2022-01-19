import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AmmoDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AmmoDisplay extends Actor
{
    //declaring variables for the ammo display's image
    private GreenfootImage image;
    private GreenfootImage rifle = new GreenfootImage("RifleDisplay.png");
    public static final int AMMO_DISPLAY_WIDTH = GameWorld.WORLD_WIDTH / 5;
    public static final int AMMO_DISPLAY_HEIGHT = GameWorld.WORLD_HEIGHT / 11;
    public static final Color ammoColor = Color.WHITE;
    public static final Font ammoFont = new Font("Courier New", true, false, GameWorld.WORLD_HEIGHT / 20);
    
    //declaring instance variables
    private int ammo;
    private String display;
    
    public AmmoDisplay(int ammo){
        //setting the player's ammo
        this.ammo = ammo;
        if(ammo < 10) display = " " + this.ammo;
        else display = "" + this.ammo;
        
        //creating and setting the image for the ammo display
        rifle.scale(AMMO_DISPLAY_WIDTH * 2 / 3, AMMO_DISPLAY_HEIGHT);
        image =  new GreenfootImage(AMMO_DISPLAY_WIDTH + 1, AMMO_DISPLAY_HEIGHT + 1);
        drawAmmoDisplay(AMMO_DISPLAY_WIDTH + 1, AMMO_DISPLAY_HEIGHT + 1);
        setImage(image);
    }
    
    //method to update the player's ammo
    public void update(int ammo) 
    {
        //updating the ammo and the display
        this.ammo = ammo;
        if(ammo < 10) display = " " + this.ammo;
        else display = "" + this.ammo;
        drawAmmoDisplay(AMMO_DISPLAY_WIDTH + 1, AMMO_DISPLAY_HEIGHT + 1);
        setImage(image);
    }
    
    //method to draw the ammo display
    private void drawAmmoDisplay(int width, int height){
        //drawing the display
        image.clear();
        image.drawImage(rifle, 0, 0);
        image.setColor(ammoColor);
        image.setFont(ammoFont);
        image.drawString(display, width * 2 / 3, (height + ammoFont.getSize() / 2) / 2);
    }
}