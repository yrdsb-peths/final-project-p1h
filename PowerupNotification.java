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
    public static final int PU_NOTIF_WIDTH = GameWorld.WORLD_WIDTH;
    public static final int PU_NOTIF_HEIGHT = GameWorld.WORLD_HEIGHT / 10;
    public static final Font PU_NOTIF_FONT = new Font("Courier New", true, true, 30);
    private String name = "";
    private GreenfootImage image;
    
    //declaring constants
    public static final int POPUP_TIME = 60;
    
    //declaring instance variables
    private int currTime = 0;
    private boolean displaying = false;
    
    public PowerupNotification(){
        //drawing the powerup notification then setting its image
        image = new GreenfootImage(PU_NOTIF_WIDTH + 1, PU_NOTIF_HEIGHT + 1);
        setImage(image);
    }
    
    public void act() 
    {
        if(displaying) currTime++;
        //clears the notification after it reached its time
        if(currTime == POPUP_TIME){
            image.clear();
            displaying = false;
            currTime = 0;
        }
    }
    
    //method to set the display text of the powerup notification
    public void setDisplay(Powerup powerup){
        this.name = powerup.toString();
        displaying = true;
        image.clear();
        drawPowerupNotification(powerup.getColor());
    }
    
    //method to draw the powerup notification
    public void drawPowerupNotification(Color bgColor){
        image.setColor(bgColor);
        image.setFont(PU_NOTIF_FONT);
        image.setTransparency(150);
        image.fillRect(0, 0, image.getWidth(), image.getHeight());
        image.setTransparency(255);
        image.setColor(Color.BLACK);
        image.drawString(name, (image.getWidth() - (int)(name.length() * PU_NOTIF_FONT.getSize() * 0.58)) / 2, (image.getHeight() + PU_NOTIF_FONT.getSize() / 2) / 2);
    }
}