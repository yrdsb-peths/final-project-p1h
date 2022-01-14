import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    //declaring variables for world dimensions
    public static final int WORLD_WIDTH = 960;
    public static final int WORLD_HEIGHT = 540;
    
    //initializing constants
    public static final int START_NUM_POOL = 180; //smaller the pool the larger the chance to spawn an enemy
    public static final int END_NUM_POOL = 90;
    public static final int POOL_DECR_DELAY = 60; //acts between decreasing the number pool by 1
    //chance of fast or strong enemy spawning (as a percent, 0 <= sum <= 100)
    public static final int FAST_ENEMY_CHANCE = 20;
    public static final int STR_ENEMY_CHANCE = 30;
    public static final int POWERUP_FREQUENCY = 500; // 1 in x chance    
    
    //declaring actors
    private Player player;
    private PowerupNotification powerupNotification;
    
    //declaring lists for the powerups
    private ArrayList<Powerup> powerupsInPlay = new ArrayList<Powerup>();
    private ArrayList<PowerupIcon> powerupIconsInPlay = new ArrayList<PowerupIcon>();
    
    //declaring instance variables
    private int numPool,decrTimer;
    
    public GameWorld()
    {   
        // Create a new world with WORLD_WIDTH * WORLD_HEIGHT    cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        
        //initializing instance variables
        numPool = START_NUM_POOL;
        decrTimer = POOL_DECR_DELAY;
        
        //creating a new player and powerup notification at the specified location
        player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
        powerupNotification = new PowerupNotification();
        addObject(powerupNotification, getWidth() / 2, getHeight() / 2);
    }
    
    public void act(){
        spawnEnemies();
        //increases the chance of enemies spawning when the timer hits 0
        if(numPool > END_NUM_POOL && decrTimer == 0) numPool--;
        decrTimer--;
        if(decrTimer < 0) decrTimer = POOL_DECR_DELAY;
        handlePowerups();
    }
    
    //method to spawn enemies
    private void spawnEnemies(){
        //generating random numbers for the type of enemy and where to spawn it
        int rdmX = Greenfoot.getRandomNumber(getWidth());
        int rdmY = Greenfoot.getRandomNumber(getHeight());
        int rdmSide = Greenfoot.getRandomNumber(4);
        int rdmEnemy = Greenfoot.getRandomNumber(100);
        Actor enemy;
        
        //spawns an enemy if the random number chosen from the number pool is equal to 0
        if(Greenfoot.getRandomNumber(numPool) == 0){
            //chooses type of enemy
            if(rdmEnemy < FAST_ENEMY_CHANCE) enemy = new FastEnemy();
            else if(rdmEnemy < FAST_ENEMY_CHANCE + STR_ENEMY_CHANCE) enemy = new StrongEnemy();
            else enemy = new NormalEnemy();
            //spawns enemy at a random location at the edge of the world
            if(rdmSide == 0) addObject(enemy, rdmX, 0);
            else if(rdmSide == 1) addObject(enemy, rdmX, getHeight());
            else if(rdmSide == 2) addObject(enemy, 0, rdmY);
            else if(rdmSide == 3) addObject(enemy, getWidth(), rdmY);
        }
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
            addObject(powerupsInPlay.get(powerupsInPlay.size() - 1), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
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
                addObject(powerupIconsInPlay.get(i), (int)(getWidth() - Powerup.PU_WIDTH * (i + 1) * 1.5), 100);
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
