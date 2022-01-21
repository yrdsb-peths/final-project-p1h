import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerupNotification here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerupNotification extends Actor
{   
    //declaring the powerup notification's dimensions and image variables
    private GreenfootImage image;
    public static final int PU_NOTIF_WIDTH = GameWorld.WORLD_WIDTH;
    public static final int PU_NOTIF_HEIGHT = GameWorld.WORLD_HEIGHT / 12;
    public static final Font PU_NOTIF_FONT = new Font("Courier New", true, true, PU_NOTIF_HEIGHT * 2 / 3);
    
    //initializing constants
    public static final int POPUP_TIME = 60;
    
    //declaring instance variables
    private int currTime = 0;
    
    public PowerupNotification(Powerup powerup){
        //drawing the powerup notification
        image = new GreenfootImage(PU_NOTIF_WIDTH + 1, PU_NOTIF_HEIGHT + 1);
        drawPowerupNotification(powerup);
        setImage(image);
    }
    
    public void act() 
    {
        //clears the notification after it reached its time
        currTime++;
        if(currTime == POPUP_TIME) getWorld().removeObject(this);
    }
    
    //method to draw the powerup notification
    public void drawPowerupNotification(Powerup powerup){
        image.setColor(powerup.getColor());
        image.setFont(PU_NOTIF_FONT);
        image.setTransparency(150);
        image.fillRect(0, 0, image.getWidth(), image.getHeight());
        image.setTransparency(255);
        image.setColor(Color.BLACK);
        image.drawString(powerup.toString(), (image.getWidth() - (int)(powerup.toString().length() * PU_NOTIF_FONT.getSize() * 0.58)) / 2, (image.getHeight() + PU_NOTIF_FONT.getSize() / 2) / 2);
    }
}