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
    public static final int PU_ICON_WIDTH = Powerup.PU_WIDTH;
    public static final int PU_ICON_HEIGHT = PU_ICON_WIDTH;
    public static final Font PU_ICON_FONT = new Font("Courier New", true, false, 10);
    private GreenfootImage image;
    
    //declaring instance variables
    private int timeLeft;
    private Powerup powerup;
    
    public PowerupIcon(Powerup powerup){
        image = new GreenfootImage(PU_ICON_WIDTH, PU_ICON_HEIGHT);
        timeLeft = Powerup.DURATION;
        this.powerup = powerup;
    }
    
    public void act() 
    {
        timeLeft--;
        drawPowerupIcon(PU_ICON_WIDTH, PU_ICON_HEIGHT);
    }
    
    //getter methods
    
    public Powerup getPowerup(){
        return powerup;
    }
    
    public int getTimeLeft(){
        return timeLeft;
    }
    
    //setter methods
    
    public void setTimeLeft(int timeLeft){
        this.timeLeft = timeLeft;
    }
    
    //method to draw the powerup icon
    private void drawPowerupIcon(int width, int height){
        image.clear();
        image.setFont(PU_ICON_FONT);
        image.setColor(Color.GRAY);
        image.fillRect(0, 0, width, height);
        image.setColor(powerup.getColor());
        image.fillRect(width / 10, height / 10, width * 8 / 10, height * 8 / 10);
        image.setColor(Color.BLACK);
        String text = String.valueOf(timeLeft / 60);
        image.drawString(text, (image.getWidth() - (int)(text.length() * PU_ICON_FONT.getSize() * 0.58)) / 2, (image.getHeight() + PU_ICON_FONT.getSize() / 2) / 2);
        setImage(image);
    }
}