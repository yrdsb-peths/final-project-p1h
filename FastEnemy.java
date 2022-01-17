import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FastEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FastEnemy extends Enemy
{
    //declaring the fast enemy's dimensions
    public static final int FAST_WIDTH = Player.PLAYER_WIDTH;
    public static final int FAST_HEIGHT = Player.PLAYER_HEIGHT;
    
    //initializing constants
    public static final int FAST_SCORE = 100; //score the player gets after killing this enemy
    public static final int FAST_HP = 8;
    public static final int FAST_DMG = 3;
    public static final int FAST_SPEED = 8;
    public static final int FAST_DELAY = 10;
    
    //initializing sprites
    private static final GreenfootImage[] MOVING_SPRITES = EnemySprites.fastEnemyMovingSprites;
    private static final GreenfootImage[] ATTACKING_SPRITES = EnemySprites.fastEnemyAttackingSprites;
    private static final int MOVING_SPRITE_NUM = 0;
    private static final int ATTACKING_SPRITE_NUM = 0;
    
    public FastEnemy(){
        super();
        //setting the image for the fast enemy
        //image = drawFastEnemy(FAST_WIDTH, FAST_HEIGHT);
        image = MOVING_SPRITES[0];
        setImage(image);
        //setting variables
        score = FAST_SCORE;
        currHP = FAST_HP;
        dmg = FAST_DMG;
        speed = FAST_SPEED;
        DELAY = FAST_DELAY;
        currDelay = 0;
        movingSprites = MOVING_SPRITES;
        attackingSprites = ATTACKING_SPRITES;
        movingSpriteNum = MOVING_SPRITE_NUM;
        attackingSpriteNum = ATTACKING_SPRITE_NUM;
    }
    
    public void act() 
    {
        super.act();
    }
    
    //method to draw the fast enemy
    private GreenfootImage drawFastEnemy(int width, int height){
        GreenfootImage image = new GreenfootImage(width + 1, height + 1);
        image.setColor(Color.GREEN);
        int[] xVertices = {0, width, 0};
        int[] yVertices = {0, height / 2, height};
        image.fillPolygon(xVertices, yVertices, 3);
        return image;
    }
}
