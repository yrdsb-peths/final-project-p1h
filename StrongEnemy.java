import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StrongEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StrongEnemy extends Enemy
{
    //declaring dimensions and image to reference width and height
    private static GreenfootImage refImage = new GreenfootImage("strong/move/skeleton-move_0.png");
    public static final int STR_WIDTH = refImage.getWidth() / 2;
    public static final int STR_HEIGHT = refImage.getHeight() / 2;
    
    //initializing constants
    public static final int STR_SCORE = 200; //score the player gets after killing this enemy
    public static final int STR_HP = 20;
    public static final int STR_DMG = 10;
    public static final int STR_SPEED = 2;
    public static final int STR_ATTACK_DURATION = 60;
    public static final int STR_ATTACK_DELAY = 30;
    public static final int STR_DMG_SPRITE_NUM = 5;
    public static final int STR_MOVE_ACT = 2;
    
    //declaring sprites
    private GreenfootImage[] strMovingSprites = new GreenfootImage[17];
    private GreenfootImage[] strAttackingSprites = new GreenfootImage[9];
    
    public StrongEnemy(){
        super();
        
        //initializing sprites
        for (int i = 0; i < strMovingSprites.length; i++) {
            strMovingSprites[i] = new GreenfootImage("strong/move/skeleton-move_" + i + ".png");
            strMovingSprites[i].scale(STR_WIDTH, STR_HEIGHT);
        }
        for (int i = 0; i < strAttackingSprites.length; i++) {
            strAttackingSprites[i] = new GreenfootImage("strong/attack/skeleton-attack_" + i + ".png");
            strAttackingSprites[i].scale(STR_WIDTH, STR_HEIGHT);
        }
        
        setImage(strMovingSprites[0]); //setting the strong enemy's image
        
        //setting variables
        score = STR_SCORE;
        currHP = STR_HP;
        dmg = STR_DMG;
        speed = STR_SPEED;
        attackduration = STR_ATTACK_DURATION;
        attackdelay = STR_ATTACK_DELAY;
        dmgSpriteNum = STR_DMG_SPRITE_NUM;
        moveAct = STR_MOVE_ACT;
        movingSprites = strMovingSprites;
        attackingSprites = strAttackingSprites;
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