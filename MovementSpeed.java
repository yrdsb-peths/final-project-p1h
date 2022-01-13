import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MovementSpeed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovementSpeed extends Powerup
{
    //declaring constants
    public static final int MS_BOOST = 2;
    public static final Color MS_BOOST_COLOR = Color.MAGENTA;
    
    public MovementSpeed(Player player){
        this.player = player;
        super.draw(MS_BOOST_COLOR);
    }
    
    public void act() 
    {
        
    }    
    
    public void activate(){
        player.setSpeed(MS_BOOST);
    }
    
    public void deactivate(){
        player.setSpeed(-MS_BOOST);
    }
    
    public String toString(){
        return "Movement Speed Boost";
    }
    
    public Color getColor(){
        return MS_BOOST_COLOR;
    }
}
