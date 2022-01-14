import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireRate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireRate extends Powerup
{
    //declaring constants
    public static final int FR_BOOST = 2;
    public static final Color FR_BOOST_COLOR = Color.BLUE;
    
    public FireRate(Player player){
        this.player = player;
        super.draw(FR_BOOST_COLOR);
    }
    
    public void act() 
    {
        
    }    
    
    public void activate(){
        player.setShootCD(FR_BOOST);
    }
    
    public void deactivate(){
        player.setShootCD(-FR_BOOST);
    }
    
    public String toString(){
        return "Fire Rate Boost";
    }
    
    public Color getColor(){
        return FR_BOOST_COLOR;
    }
}