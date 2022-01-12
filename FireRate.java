import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireRate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireRate extends Powerup
{
    private GreenfootImage image;
    private Player player;
    private int value = 2;
    
    public FireRate(Player player) {
        this.player = player;
        draw();
    }
    
    /**
     * Act - do whatever the FireRate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void activate() {
        player.shootCd -= value;
    }
    
    public void deactivate() {
        player.shootCd += value;
    }
    
    public void draw() {
        image = new GreenfootImage(Powerup.WIDTH, Powerup.HEIGHT);
        image.setColor(Color.GRAY);
        image.fillRect(0, 0, Powerup.WIDTH, Powerup.HEIGHT);
        image.setColor(Color.BLUE);
        image.fillRect(2, 2, 16, 16);
        setImage(image);
    }
    
    public String toString() {
        return "Fire Rate Boost";
    }
    
    public boolean needsIcon() {
        return true;
    }
    
}
