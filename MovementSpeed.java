import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MovementSpeed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovementSpeed extends Powerup
{
    //declaring image
    private GreenfootImage image = new GreenfootImage("PowerupIcons/movement_speed-icon.png");
    
    //declaring constants
    public static final int MS_BOOST = 2;
    public static final Color MS_BOOST_COLOR = Color.CYAN;
    
    public MovementSpeed(Player player){
        image.scale(PU_WIDTH, PU_HEIGHT);
        this.player = player;
        super.draw(PU_WIDTH, PU_HEIGHT, MS_BOOST_COLOR);
    }
    
    public void act() 
    {
        super.act();
    }    
    
    public void activate(){
        player.setSpeed(MS_BOOST);
    }
    
    public void deactivate(){
        player.setSpeed(-MS_BOOST);
    }
    
    public GreenfootImage getImage(){
        return image;
    }
    
    public String toString(){
        return "Movement Speed Boost";
    }
    
    public Color getColor(){
        return MS_BOOST_COLOR;
    }
}
