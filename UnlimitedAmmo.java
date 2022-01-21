import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UnlimitedAmmo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnlimitedAmmo extends Powerup
{
    //declaring the unlimited ammo powerup's image variables
    private GreenfootImage image = new GreenfootImage("PowerupIcons/unlimited_ammo-icon.png");
    
    //initializing constants
    public static final Color UNLIMITED_AMMO_COLOR = Color.ORANGE;
    
    public UnlimitedAmmo(Player player){
        image.scale(PU_WIDTH, PU_HEIGHT);
        this.player = player;
        super.draw(PU_WIDTH, PU_HEIGHT, UNLIMITED_AMMO_COLOR);
    }
    
    public void act()
    {
        super.act();
    }    
    
    public void activate(){
        player.setAmmo(player.PLAYER_MAG_SIZE);
        player.setUnlimitedAmmo(true);
    }
    
    public void deactivate(){
        player.setUnlimitedAmmo(false);
    }
    
    public GreenfootImage getImage(){
        return image;
    }
    
    public String toString(){
        return "Unlimited Ammo";
    }
    
    public Color getColor(){
        return UNLIMITED_AMMO_COLOR;
    }
}