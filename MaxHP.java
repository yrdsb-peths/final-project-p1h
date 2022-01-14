import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MaxHP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MaxHP extends Powerup
{
    //declaring constants
    public static final int MAX_HP_INCREASE = 2;
    public static final Color MAX_HP_INCREASE_COLOR = Color.YELLOW;
    
    public MaxHP(Player player){
        this.player = player;
        super.draw(MAX_HP_INCREASE_COLOR);
    }
    
    public void act() 
    {
        
    }    
    
    public void activate(){
        player.setMaxHP(MAX_HP_INCREASE);
    }
    
    public String toString(){
        return "Max Health Increase";
    }
    
    public boolean needsIcon(){
        return false;
    }
    
    public Color getColor(){
        return MAX_HP_INCREASE_COLOR;
    }
}