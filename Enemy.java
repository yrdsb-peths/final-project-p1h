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
    protected Player player;
    protected int score, currHP, dmg, speed; //enemy stats
    
    public Enemy(){
        
    }
    
    public void act() 
    {
        //turn towards the player
        player = getWorld().getObjects(Player.class).get(0); //(from Mr. Cohen)
        turnTowards(player.getX(), player.getY());
        move(speed);
        if(currHP <= 0) getWorld().removeObject(this);
    }
    
    public void dealDmg(int dmg){
        currHP -= dmg;
    }
}
