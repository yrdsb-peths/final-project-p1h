import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StrongEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StrongEnemy extends Enemy
{
    //declaring the strong enemy's dimensions
    public static final int STR_WIDTH = Player.PLAYER_WIDTH;
    public static final int STR_HEIGHT = Player.PLAYER_HEIGHT;
    
    //initializing constants
    public static final int STR_SCORE = 200; //score the player gets after killing this enemy
    public static final int STR_HP = 20;
    public static final int STR_DMG = 3;
    public static final int STR_SPEED = 4;
    public static final int STR_DELAY = 45;
    
    public StrongEnemy(){
        super();
        //setting the image for the strong enemy
        image = drawStrongEnemy(STR_WIDTH, STR_HEIGHT);
        setImage(image);
        //setting variables
        score = STR_SCORE;
        currHP = STR_HP;
        dmg = STR_DMG;
        speed = STR_SPEED;
        DELAY = STR_DELAY;
        currDelay = 0;
    }
    
    public void act() 
    {
        super.act();
    }
    
    //method to draw the strong enemy
    private GreenfootImage drawStrongEnemy(int width, int height){
        GreenfootImage image = new GreenfootImage(width + 1, height + 1);
        image.setColor(Color.RED);
        int[] xVertices = {0, width, 0};
        int[] yVertices = {0, height / 2, height};
        image.fillPolygon(xVertices, yVertices, 3);
        return image;
    }
}
