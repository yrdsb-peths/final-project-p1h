import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireRate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireRate extends Powerup
{
    //declaring the firerate powerup's image variables
    private GreenfootImage image = new GreenfootImage("PowerupIcons/FireRate.png");
    
    //initializing constants
    public static final int FR_BOOST = 2;
    public static final Color FR_BOOST_COLOR = Color.YELLOW;
    
    /**
     * FireRate Constructor
     *
     * @param player the player in the world
     */
    public FireRate(Player player){
        image.scale(PU_WIDTH, PU_HEIGHT);
        this.player = player;
        super.draw(PU_WIDTH, PU_HEIGHT);
    }
    
    /**
     * Act Method
     */
    public void act() 
    {
        super.act();
    }    
    
    /**
     * Method to activate the powerup benefits: increase the player's firerate
     */
    public void activate(){
        player.setShootCD(FR_BOOST);
    }
    
    /**
     * Method to deactivate the powerup benefits: reset the player's firerate
     */
    public void deactivate(){
        player.setShootCD(-FR_BOOST);
    }
    
    /**
     * Method to get the image of the powerup
     *
     * @return the powerup's image
     */
    public GreenfootImage getImage(){
        return image;
    }
    
    /**
     * Method to get the notification name of the powerup
     *
     * @return the powerup's notification name
     */
    public String toString(){
        return "Fire Rate Boost";
    }
    
    /**
     * Method to get the color of the powerup
     *
     * @return the powerup's color
     */
    public Color getColor(){
        return FR_BOOST_COLOR;
    }
}
