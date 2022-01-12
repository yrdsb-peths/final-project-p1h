import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Healing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Healing extends Powerup
{
    private GreenfootImage image;
    private Player player;
    
    public Healing(Player player) {
        this.player = player;
        draw();
    }
    
    /**
     * Act - do whatever the Healing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void activate() {
        player.playerHp = player.playerMaxHp;
    }
    
    public void draw() {
        image = new GreenfootImage(Powerup.WIDTH, Powerup.HEIGHT);
        image.setColor(Color.GRAY);
        image.fillRect(0, 0, Powerup.WIDTH, Powerup.HEIGHT);
        image.setColor(Color.GREEN);
        image.fillRect(2, 2, 16, 16);
        setImage(image);
    }
    
    public String toString() {
        return "Healing Boost";
    }
    
    public boolean needsIcon() {
        return false;
    }
    
}
