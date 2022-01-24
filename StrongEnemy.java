import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The strong enemy (large zombie in a t-shirt)
 * 
 * @author (Edison Lim) 
 * @version (3.0: 01/24/2022)
 */
public class StrongEnemy extends Enemy
{
    //declaring the strong enemy's dimensions and image to reference width and height
    private static GreenfootImage refImage = new GreenfootImage("Enemies/StrongEnemySprites/Move/skeleton-move_0.png");
    public static final int STR_WIDTH = refImage.getWidth() / 2;
    public static final int STR_HEIGHT = refImage.getHeight() / 2;
    
    //initializing constants
    public static final int STR_SCORE = 200; //score the player gets after killing this enemy
    public static final int STR_HP = 20;
    public static final int STR_DMG = 10;
    public static final int STR_SPEED = 2;
    public static final int STR_ATTACK_DURATION = 60;
    public static final int STR_ATTACK_DELAY = 30;
    public static final int STR_DMG_SPRITE_NUM = 5; //sprite number where the enemy actually hits the player
    public static final int STR_MOVE_ACT = 2; //number of acts before switching to the next moving sprite
    
    //declaring sprites
    private GreenfootImage[] strMovingSprites = new GreenfootImage[17];
    private GreenfootImage[] strAttackingSprites = new GreenfootImage[9];
    
    /**
     * StrongEnemy Constructor
     */
    public StrongEnemy(){
        super();
        
        //initializing sprites
        for (int i = 0; i < strMovingSprites.length; i++) {
            strMovingSprites[i] = new GreenfootImage("Enemies/StrongEnemySprites/Move/skeleton-move_" + i + ".png");
            strMovingSprites[i].scale(STR_WIDTH, STR_HEIGHT);
        }
        for (int i = 0; i < strAttackingSprites.length; i++) {
            strAttackingSprites[i] = new GreenfootImage("Enemies/StrongEnemySprites/Attack/skeleton-attack_" + i + ".png");
            strAttackingSprites[i].scale(STR_WIDTH, STR_HEIGHT);
        }
        setImage(strMovingSprites[0]); //setting the image of the strong enemy
        
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
        attackSounds = new GreenfootSound[1];
        for(int i = 0; i < attackSounds.length; i++) attackSounds[i] = new GreenfootSound("ZombieSoundEffects/StrongPunch.wav");
    }
    
    /**
     * Act Method
     */
    public void act() 
    {
        super.act();
    }
}