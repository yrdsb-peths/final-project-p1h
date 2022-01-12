import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends SuperSmoothMover
{
    //declaring the player's image
    protected GreenfootImage image;
    
    //declaring instance variables
    protected Actor target;
    protected int score, currHP, dmg, speed, DELAY, currDelay; //enemy stats
    
    public Enemy(){
        
    }
    
    public void act() 
    {
        if(currHP <= 0) getWorld().removeObject(this);
        else{
            target = getOneIntersectingObject(Player.class);
            if(target != null && currDelay == 0){
                Player player = (Player) target;
                player.dealDmg(dmg);
                currDelay = DELAY;
            }
            else if(currDelay == 0){
                //turn towards the player
                target = getWorld().getObjects(Player.class).get(0); //(from Mr. Cohen)
                Player player = (Player) target;
                turnTowards(player.getX(), player.getY());
                move(speed);
            }
            else currDelay--;
            if(currHP <= 0) getWorld().removeObject(this);
        }
    }
    
    //setter methods
    //method to deal damage to the enemy
    public void dealDmg(int dmg){
        currHP -= dmg;
    }
}
