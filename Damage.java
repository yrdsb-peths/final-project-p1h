import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Damage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Damage extends Powerup
{
    private GreenfootImage image;
    private Player player;
    private int value = 2;
    
    public Damage(Player player) {
        this.player = player;
        draw();
    }
    /**
     * Act - do whatever the Damage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void activate() {
        player.damage += value;
    }
    
    public void deactivate() {
        player.damage -= value;
    }
    
    public void draw() {
        image = new GreenfootImage(Powerup.WIDTH, Powerup.HEIGHT);
        image.setColor(Color.GRAY);
        image.fillRect(0, 0, Powerup.WIDTH, Powerup.HEIGHT);
        image.setColor(Color.RED);
        image.fillRect(2, 2, 16, 16);
        setImage(image);
    }
    
    public String toString() {
        return "Damage Boost";
    }
    
    public boolean needsIcon() {
        return true;
    }
    
}
