import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    public static final int WORLD_WIDTH = 960;
    public static final int WORLD_HEIGHT = 540;
    public static final int POWERUP_FREQUENCY = 500; // 1 in x chance    
    
    private ArrayList<Powerup> powerupsInPlay = new ArrayList<Powerup>();
    private ArrayList<PowerupIcon> powerupIconsInPlay = new ArrayList<PowerupIcon>();
    private PowerupDisplay powerupDisplay = new PowerupDisplay();
    
    private MouseInfo mouseInfo;
    
    private Player player = new Player();
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        addObject(powerupDisplay, 480, 270);
        
        addObject(player, WORLD_WIDTH/2, WORLD_HEIGHT/2);
    }
    
    public void act() {
        handlePowerupCollision();
        handlePowerups();
    }
    
    private void handlePowerups() {
        // Handle powerup collision with player
        List<Powerup> lst = player.getIntersectingObjects();
        for (Powerup i : lst) {
            i.activate();
            powerupDisplay.setText(i.toString());
            removeObject(i);
        }
        
        // Spawn powerup icons
        for (int i = 0; i < powerupIconsInPlay.size(); i++) {
            if (lst.contains(powerupIconsInPlay.get(i).powerup)) {
                addObject(powerupIconsInPlay.get(i), (int)(WORLD_WIDTH-Powerup.WIDTH*(i+1)*1.5), 100);
            }
        }
        // Remove icon if timer reached 0
        for (PowerupIcon i : new ArrayList<PowerupIcon>(powerupIconsInPlay)) {
            if (i.timeLeft == 0) {
                removeObject(i);
                i.powerup.deactivate();
                powerupsInPlay.remove(i.powerup);
                powerupIconsInPlay.remove(i);
            }
        }
        
        // Decide whether or not to spawn a powerup
        if (Greenfoot.getRandomNumber(POWERUP_FREQUENCY) == 0) {
            int x = Greenfoot.getRandomNumber(6);
            Powerup powerup = new Powerup();
            if (x == 0) {
                powerup = new Damage(player);
            } else if (x == 1) {
                powerup = new FireRate(player);
            } else if (x == 2) {
                powerup = new Healing(player);
            } else if (x == 3) {
                powerup = new MaxHealth(player);
            } else if (x == 4) {
                powerup = new MovementSpeed(player);
            } else if (x == 5) {
                powerup = new Reload(player);
            }
            powerupsInPlay.add(powerup);
            if (powerup.needsIcon()) {
                powerupIconsInPlay.add(new PowerupIcon(powerup));
            }
            
            // Spawn powerup
            addObject(powerupsInPlay.get(powerupsInPlay.size()-1), Greenfoot.getRandomNumber(WORLD_WIDTH), Greenfoot.getRandomNumber(WORLD_HEIGHT));
        }
    }
    
}
