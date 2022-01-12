import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MaxHealth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MaxHealth extends Powerup
{
    private GreenfootImage image;
    private Player player;
    private int value = 2;
    
    public MaxHealth(Player player) {
        this.player = player;
        draw();
    }
    
    /**
     * Act - do whatever the MaxHealth wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void activate() {
        player.playerMaxHp += value;
    }
    
    public void deactivate() {
        player.playerMaxHp -= value;
    }
    
    public void draw() {
        image = new GreenfootImage(Powerup.WIDTH, Powerup.HEIGHT);
        image.setColor(Color.GRAY);
        image.fillRect(0, 0, Powerup.WIDTH, Powerup.HEIGHT);
        image.setColor(Color.YELLOW);
        image.fillRect(2, 2, 16, 16);
        setImage(image);
    }
    
    public String toString() {
        return "Max Health Boost";
    }
    
    public boolean needsIcon() {
        return true;
    }
    
}
