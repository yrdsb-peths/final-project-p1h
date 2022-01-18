import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NormalEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalEnemy extends Enemy
{
    //declaring dimensions and image to reference width and height
    private static GreenfootImage refImage = new GreenfootImage("normal/move/saunter0.png");
    public static final int NORM_WIDTH = refImage.getWidth() * 2;
    public static final int NORM_HEIGHT = refImage.getHeight() * 2;
    
    //initializing constants
    public static final int NORM_SCORE = 50; //score the player gets after killing this enemy
    public static final int NORM_HP = 4;
    public static final int NORM_DMG = 3;
    public static final int NORM_SPEED = 2;
    public static final int NORM_DURATION = 30;
    public static final int NORM_DELAY = 30;
    public static final int NORM_DMG_SPRITE_NUM = 11;
    
    //declaring sprites
    private GreenfootImage[] normMovingSprites = new GreenfootImage[32];
    private GreenfootImage[] normAttackingSprites = new GreenfootImage[20];
    
    public NormalEnemy(){
        super();
        
        //initializing sprites
        for (int i = 0; i < normMovingSprites.length; i++) {
            normMovingSprites[i] = new GreenfootImage("normal/move/saunter" + i + ".png");
            normMovingSprites[i].scale(NORM_WIDTH, NORM_HEIGHT);
        }
        for (int i = 0; i < normAttackingSprites.length; i++) {
            normAttackingSprites[i] = new GreenfootImage("normal/attack2/attack02_" + i + ".png");
            normAttackingSprites[i].scale(NORM_WIDTH, NORM_HEIGHT);
        }
        
        setImage(normMovingSprites[0]); //setting the normal enemy's image
        
        //setting variables
        score = NORM_SCORE;
        currHP = NORM_HP;
        dmg = NORM_DMG;
        speed = NORM_SPEED;
        duration = NORM_DURATION;
        delay = NORM_DELAY;
        dmgSpriteNum = NORM_DMG_SPRITE_NUM;
        movingSprites = normMovingSprites;
        attackingSprites = normAttackingSprites;
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
