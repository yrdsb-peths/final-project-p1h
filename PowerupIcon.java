import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerupIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerupIcon extends Actor
{
    //declaring the powerup icon's dimensions and image variables
    private GreenfootImage image;
    public static final int PU_ICON_WIDTH = Powerup.PU_WIDTH;
    public static final int PU_ICON_HEIGHT = PU_ICON_WIDTH;
    public static final Font PU_ICON_FONT = new Font("Courier New", true, false, PU_ICON_HEIGHT / 2);
    
    //declaring instance variables
    private int timeLeft;
    private Powerup powerup;
    
    public PowerupIcon(Powerup powerup){
        this.powerup = powerup;
        timeLeft = Powerup.DURATION;
        //drawing the powerup icon
        image = new GreenfootImage(PU_ICON_WIDTH, PU_ICON_HEIGHT);
        drawPowerupIcon(PU_ICON_WIDTH, PU_ICON_HEIGHT);
    }
    
    public void act() 
    {
        //update the powerup icon's timer
        timeLeft--;
        drawPowerupIcon(PU_ICON_WIDTH, PU_ICON_HEIGHT);
    }
    
    //getter methods
    
    //method to get the powerup of the powerup icon
    public Powerup getPowerup(){
        return powerup;
    }
    
    //method to get the amount of time left on the timer of the powerup
    public int getTimeLeft(){
        return timeLeft;
    }
    
    //setter methods
    
    //methods to set the timer of the powerup
    public void setTimeLeft(int timeLeft){
        this.timeLeft = timeLeft;
    }
    
    //method to draw the powerup icon
    private void drawPowerupIcon(int width, int height){
        image.clear();
        image.setFont(PU_ICON_FONT);
        image.setColor(Color.BLACK);
        image.fillRect(0, 0, width, height);
        image.drawImage(powerup.getImage(), 0, 0);
        image.setColor(Color.WHITE);
        String text = String.valueOf(timeLeft / 60 + 1);
        image.drawString(text, (image.getWidth() - (int)(text.length() * PU_ICON_FONT.getSize() * 0.58)) / 2, (image.getHeight() + PU_ICON_FONT.getSize() / 2) / 2);
        setImage(image);
    }
}
