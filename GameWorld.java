import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    
    //declaring actors
    private Player player;
    
    //declaring instance variables
    private int numPool = START_NUM_POOL;
    private int decrTimer = POOL_DECR_DELAY;
    
    public GameWorld()
    {   
        // Create a new world with WORLD_WIDTH * WORLD_HEIGHT    cells with a cell size of 1x1 pixels.
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        
        //creating a new player at the specified location
        player = new Player();
        addObject(player, getWidth() / 2, getHeight() / 2);
    }
    
    public void act(){
        spawnEnemies();
        //increases the chance of enemies spawning when the timer hits 0
        if(numPool > END_NUM_POOL && decrTimer == 0) numPool--;
        decrTimer--;
        if(decrTimer < 0) decrTimer = POOL_DECR_DELAY;
    }
    
    //method to spawn enemies
    private void spawnEnemies(){
        //generating random numbers for the type of enemy and where to spawn it
        int rdmX = Greenfoot.getRandomNumber(WORLD_WIDTH);
        int rdmY = Greenfoot.getRandomNumber(WORLD_HEIGHT);
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
            else if(rdmSide == 1) addObject(enemy, rdmX, WORLD_HEIGHT);
            else if(rdmSide == 2) addObject(enemy, 0, rdmY);
            else if(rdmSide == 3) addObject(enemy, WORLD_WIDTH, rdmY);
        }
    }
}
