import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerupDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerupDisplay extends Actor
{    
    public static final Font COURIER_NEW = new Font("Courier New", 30);
    public static final int TOTAL_FRAMES_IN = 50;
    
    private String text = "";
    private GreenfootImage image = new GreenfootImage(GameWorld.WORLD_WIDTH, GameWorld.WORLD_HEIGHT/10);
    
    private int framesInWorld = 0;
    private boolean inWorld = false;
    
    public PowerupDisplay() {
        setImage(new GreenfootImage(1, 1));
    }
    
    /**
     * Act - do whatever the PowerupDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (inWorld) {
            framesInWorld += 1;
        }
        if (framesInWorld == TOTAL_FRAMES_IN) {
            inWorld = false;
            framesInWorld = 0;
            clearImage();
        }
    }
    
    public void setText(String text) {
        this.text = text;
        inWorld = true;
        clearImage();
        draw();
    }
    
    public void clearImage() {
        image.clear();
    }
    
    public void draw() {
        image.setColor(Color.RED);
        image.setFont(COURIER_NEW);
        image.setTransparency(150);
        image.fillRect(0, 0, image.getWidth(), image.getHeight());
        image.setTransparency(255);
        image.setColor(Color.BLACK);
        image.drawString(text, (image.getWidth() - (int)(text.length() * COURIER_NEW.getSize() * 0.58)) / 2, (image.getHeight() + COURIER_NEW.getSize() / 2) / 2);
        setImage(image);
    }

}
