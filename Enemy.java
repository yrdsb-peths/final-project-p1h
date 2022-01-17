import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends SuperSmoothMover
{
    //declaring instance variables
    protected Actor target;
    protected int score, currHP, dmg, speed, DELAY, currDelay; //enemy stats
    //sprites
    protected GreenfootImage[] movingSprites;
    protected GreenfootImage[] attackingSprites;
    //sprite info
    protected int movingSpriteNum = 0;
    protected int attackingSpriteNum = 0;
    
    public Enemy(){
        
    }
    
    public void act() 
    {
        if(currHP <= 0){
            target = getWorld().getObjects(Player.class).get(0); //(from Mr. Cohen)
            Player player = (Player) target;
            player.setScore(score); //give points to player
            getWorld().removeObject(this); //enemy dies
        }
        else{
            target = getOneIntersectingObject(Player.class);
            if(target != null && currDelay == 0){ //attack the player
                Player player = (Player) target;
                player.dealDmg(dmg);
                currDelay = DELAY;
            }
            else if(currDelay == 0){
                //turn towards the player
                target = getWorld().getObjects(Player.class).get(0); //(from Mr. Cohen)
                Player player = (Player) target;
                turnTowards(player.getX(), player.getY());
                movingSpriteNum++;
                move(speed);
                if (movingSpriteNum == movingSprites.length) {
                    movingSpriteNum = 0;
                }
                setImage(movingSprites[movingSpriteNum]);
            }
            else currDelay--;
        }
    }
    
    //setter methods
    
    //method to deal damage to the enemy
    public void dealDmg(int dmg){
        currHP -= dmg;
    }
}
