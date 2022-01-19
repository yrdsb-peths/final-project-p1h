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
    public static final Color FR_BOOST_COLOR = Color.YELLOW;
    
    public FireRate(Player player){
        this.player = player;
        super.draw(PU_WIDTH, PU_HEIGHT, FR_BOOST_COLOR);
    }
    
    public void act() 
    {
        super.act();
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
