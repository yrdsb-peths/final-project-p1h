import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NormalEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalEnemy extends Enemy
{
    //declaring the normal enemy's dimensions
    public static final int NORM_WIDTH = Player.PLAYER_WIDTH;
    public static final int NORM_HEIGHT = Player.PLAYER_HEIGHT;
    
    //initializing constants
    public static final int NORM_SCORE = 50; //score the player gets after killing this enemy
    public static final int NORM_HP = 4;
    public static final int NORM_DMG = 3;
    public static final int NORM_SPEED = 2;
    public static final int NORM_DELAY = 30;
    
    public NormalEnemy(){
        super();
        //setting the image for the normal enemy
        image = drawNormalEnemy(NORM_WIDTH, NORM_HEIGHT);
        setImage(image);
        //setting variables
        score = NORM_SCORE;
        currHP = NORM_HP;
        dmg = NORM_DMG;
        speed = NORM_SPEED;
        DELAY = NORM_DELAY;
        currDelay = 0;
    }
    
    public void act() 
    {
        super.act();
    }
    
    //method to draw the normal enemy
    private GreenfootImage drawNormalEnemy(int width, int height){
        GreenfootImage image = new GreenfootImage(width + 1, height + 1);
        image.setColor(Color.BLUE);
        int[] xVertices = {0, width, 0};
        int[] yVertices = {0, height / 2, height};
        image.fillPolygon(xVertices, yVertices, 3);
        return image;
    }
}
