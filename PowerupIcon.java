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
    public int timeLeft;
    public Powerup powerup;
    
    public PowerupIcon(Powerup powerup){
        image = new GreenfootImage(PU_ICON_WIDTH, PU_ICON_HEIGHT);
        timeLeft = Powerup.LIFESPAN;
        this.powerup = powerup;
    }
    
    public void act() 
    {
        timeLeft -= 1;
        drawPowerupIcon();
    }
    
    //method to draw the powerup icon
    private void drawPowerupIcon(){
        image.clear();
        image.setFont(PU_ICON_FONT);
        image.setColor(Color.GRAY);
        image.fillRect(0, 0, PU_ICON_WIDTH, PU_ICON_HEIGHT);
        image.setColor(powerup.getColor());
        image.fillRect(2, 2, 16, 16);
        image.setColor(Color.BLACK);
        String text = String.valueOf(timeLeft / 60);
        image.drawString(text, (image.getWidth() - (int)(text.length() * PU_ICON_FONT.getSize() * 0.58)) / 2, (image.getHeight() + PU_ICON_FONT.getSize() / 2) / 2);
        setImage(image);
    }
}
