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
    public static final Color MS_BOOST_COLOR = Color.CYAN;
    
    private int timeLeft = Powerup.LIFESPAN;
    
    public MovementSpeed(Player player){
        this.player = player;
        super.draw(PU_WIDTH, PU_HEIGHT, MS_BOOST_COLOR);
    }
    
    public void act() 
    {
        if (timeLeft == 0) {
            getWorld().removeObject(this);
        }
        timeLeft--;
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
