import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerupIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerupIcon extends Actor
{
    public static final Font COURIER_NEW = new Font("Courier New", 10);
    
    GreenfootImage image = new GreenfootImage(Powerup.WIDTH, Powerup.HEIGHT+20);
    public int timeLeft;
    public Powerup powerup;
    
    public PowerupIcon(Powerup powerup) {
        timeLeft = Powerup.LIFESPAN;
        this.powerup = powerup;
    }
    
    /**
     * Act - do whatever the PowerupIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        timeLeft -= 1;
        draw();
    }
    
    private void draw() {
        image.clear();
        image.setFont(COURIER_NEW);
        image.setColor(Color.GRAY);
        image.fillRect(0, 0, Powerup.WIDTH, Powerup.HEIGHT);
        image.setColor(Color.RED);
        image.fillRect(2, 2, 16, 16);
        image.setColor(Color.BLACK);
        String text = String.valueOf(timeLeft);
        image.drawString(text, (image.getWidth() - (int)(text.length() * COURIER_NEW.getSize() * 0.58)) / 2, 30);
        setImage(image);
    }
}
