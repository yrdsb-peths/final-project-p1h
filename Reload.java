import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reload here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reload extends Powerup
{
    private GreenfootImage image;
    private Player player;
    
    public Reload(Player player) {
        this.player = player;
        draw();
    }
    
    /**
     * Act - do whatever the Reload wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void activate() {
        player.instantReload();
    }
    
    public void draw() {
        image = new GreenfootImage(Powerup.WIDTH, Powerup.HEIGHT);
        image.setColor(Color.GRAY);
        image.fillRect(0, 0, Powerup.WIDTH, Powerup.HEIGHT);
        image.setColor(Color.ORANGE);
        image.fillRect(2, 2, 16, 16);
        setImage(image);
    }
    
    public String toString() {
        return "Reloaded";
    }
    
    public boolean needsIcon() {
        return false;
    }
    
}
