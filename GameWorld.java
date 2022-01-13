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
    private PowerupNotification powerupNotification = new PowerupNotification();
    
    private MouseInfo mouseInfo;
    
    private Player player = new Player();
    
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        addObject(powerupNotification, 480, 270);
        
        addObject(player, WORLD_WIDTH/2, WORLD_HEIGHT/2);
    }
    
    public void act() {
        handlePowerups();
    }
    
    //method to handle the powerups
    private void handlePowerups() {
        // Decide whether or not to spawn a powerup
        if (Greenfoot.getRandomNumber(POWERUP_FREQUENCY) == 0) {
            int rdnPowerup = Greenfoot.getRandomNumber(6);
            Powerup powerup = new Powerup();
            if (rdnPowerup == 0) powerup = new Damage(player);
            else if (rdnPowerup == 1) powerup = new FireRate(player);
            else if (rdnPowerup == 2) powerup = new Healing(player);
            else if (rdnPowerup == 3) powerup = new MaxHP(player);
            else if (rdnPowerup == 4) powerup = new MovementSpeed(player);
            else powerup = new UnlimitedAmmo(player);
            powerupsInPlay.add(powerup);
            if(powerup.needsIcon()) powerupIconsInPlay.add(new PowerupIcon(powerup));
            
            // Spawn powerup
            addObject(powerupsInPlay.get(powerupsInPlay.size() - 1), Greenfoot.getRandomNumber(WORLD_WIDTH), Greenfoot.getRandomNumber(WORLD_HEIGHT));
        }
        
        // Handle powerup collision with player
        List<Powerup> puList = player.getIntersectingObjects();
        for (Powerup i: puList) {
            i.activate();
            powerupNotification.setDisplay(i);
            removeObject(i);
        }
        
        // Spawn powerup icons
        for (int i = 0; i < powerupIconsInPlay.size(); i++) {
            if (puList.contains(powerupIconsInPlay.get(i).powerup)) {
                addObject(powerupIconsInPlay.get(i), (int)(WORLD_WIDTH - Powerup.PU_WIDTH * (i + 1) * 1.5), 100);
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
    }
}
