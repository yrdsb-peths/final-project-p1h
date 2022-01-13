import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UnlimitedAmmo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnlimitedAmmo extends Powerup
{
    //declaring constant 
    public static final Color UNLIMITED_AMMO_COLOR = Color.ORANGE;
    
    public UnlimitedAmmo(Player player){
        this.player = player;
        super.draw(UNLIMITED_AMMO_COLOR);
    }
    
    public void act() 
    {
        
    }    
    
    public void activate(){
        player.setAmmo(player.PLAYER_MAG_SIZE);
        player.setUnlimitedAmmo(true);
    }
    
    public void deactivate(){
        player.setUnlimitedAmmo(false);
    }
    
    public String toString(){
        return "Unlimited Ammo";
    }
    
    public Color getColor(){
        return UNLIMITED_AMMO_COLOR;
    }
}
