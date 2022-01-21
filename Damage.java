import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Damage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Damage extends Powerup
{
    //declaring image
    private GreenfootImage image = new GreenfootImage("PowerupIcons/damage-icon.png");
    
    //declaring constants
    public static final int DMG_BOOST = 2;
    public static final Color DMG_BOOST_COLOR = Color.RED;
    
    public Damage(Player player){
        image.scale(PU_WIDTH, PU_HEIGHT);
        this.player = player;
        super.draw(PU_WIDTH, PU_HEIGHT, DMG_BOOST_COLOR);
    }
    
    public void act() 
    {
        super.act();
    }    
    
    public void activate(){
        player.setDmg(DMG_BOOST);
    }
    
    public void deactivate(){
        player.setDmg(-DMG_BOOST);
    }
    
    public GreenfootImage getImage(){
        return image;
    }
    
    public String toString(){
        return "Damage Boost";
    }
    
    public Color getColor(){
        return DMG_BOOST_COLOR;
    }
}
