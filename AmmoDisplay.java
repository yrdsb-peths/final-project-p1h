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
    public static final int AMMO_DISPLAY_WIDTH = GameWorld.WORLD_WIDTH / 4;
    public static final int AMMO_DISPLAY_HEIGHT = GameWorld.WORLD_HEIGHT / 11;
    public static final Color ammoColor = Color.YELLOW;
    public static final Font ammoFont = new Font("Courier New", true, false, GameWorld.WORLD_HEIGHT / 20);
    
    //declaring instance variables
    private int ammo;
    private String display;
    
    public AmmoDisplay(int ammo){
        //setting the player's ammo
        this.ammo = ammo;
        if(ammo < 10) display = "AMMO:  " + this.ammo + "/?";
        else display = "AMMO: " + this.ammo + "/?";
        //creating and setting the image for the ammo display
        image =  new GreenfootImage(AMMO_DISPLAY_WIDTH + 1, AMMO_DISPLAY_HEIGHT + 1);
        drawAmmoDisplay();
        setImage(image);
    }
    
    //method to update the player's ammo
    public void update(int ammo) 
    {
        //updating the ammo and the display
        this.ammo = ammo;
        if(ammo < 10) display = "AMMO:  " + this.ammo + "/?";
        else display = "AMMO: " + this.ammo + "/?";
        drawAmmoDisplay();
        setImage(image);
    }
    
    //method to draw the ammo display
    private void drawAmmoDisplay(){
        //drawing the display
        image.clear();
        image.setColor(ammoColor);
        image.setFont(ammoFont);
        image.drawString(display, AMMO_DISPLAY_WIDTH / 20, (AMMO_DISPLAY_HEIGHT + ammoFont.getSize() / 2) / 2);
    }
}