import greenfoot.*;

/**
 * Write a description of class EnemySprites here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemySprites  
{
    //declaring enemy sprites
    public static GreenfootImage[] fastEnemyMovingSprites = new GreenfootImage[17];
    public static GreenfootImage[] fastEnemyAttackingSprites = new GreenfootImage[9];

    public static GreenfootImage[] strongEnemyMovingSprites = new GreenfootImage[32];
    public static GreenfootImage[] strongEnemyAttackingSprites = new GreenfootImage[20];
    
    public static GreenfootImage[] normalEnemyMovingSprites = new GreenfootImage[8];
    public static GreenfootImage[] normalEnemyAttackingSprites = new GreenfootImage[8];

    public static void initializeSprites() {
        //fast
        for (int i = 0; i < fastEnemyMovingSprites.length; i++) {
            fastEnemyMovingSprites[i] = new GreenfootImage("fast/move/skeleton-move_"+i+".png");
        }
        for (int i = 0; i < fastEnemyAttackingSprites.length; i++) {
            fastEnemyAttackingSprites[i] = new GreenfootImage("fast/attack/skeleton-attack_"+i+".png");
        }
        
        //strong
        for (int i = 0; i < strongEnemyMovingSprites.length; i++) {
            strongEnemyMovingSprites[i] = new GreenfootImage("strong/move/saunter"+i+".png");
        }
        for (int i = 0; i < strongEnemyAttackingSprites.length; i++) {
            strongEnemyAttackingSprites[i] = new GreenfootImage("strong/attack1/attack01_"+i+".png");
        }
        
        //normal
         for (int i = 0; i < normalEnemyMovingSprites.length; i++) {
            normalEnemyMovingSprites[i] = new GreenfootImage("normal/move/troll-move_"+i+".png");
        }
        for (int i = 0; i < normalEnemyAttackingSprites.length; i++) {
            normalEnemyAttackingSprites[i] = new GreenfootImage("normal/attack/troll-attack_"+i+".png");
        }
    }
    
}
