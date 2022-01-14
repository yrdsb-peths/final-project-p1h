import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Damage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Damage extends Powerup
{
    //declaring constants
    public static final int DMG_BOOST = 2;
    public static final Color DMG_BOOST_COLOR = Color.RED;
    
    public Damage(Player player){
        this.player = player;
        super.draw(DMG_BOOST_COLOR);
    }
    
    public void act() 
    {
        
    }    
    
    public void activate(){
        player.setDmg(DMG_BOOST);
    }
    
    public void deactivate(){
        player.setDmg(-DMG_BOOST);
    }
    
    public String toString(){
        return "Damage Boost";
    }
    
    public Color getColor(){
        return DMG_BOOST_COLOR;
    }
}