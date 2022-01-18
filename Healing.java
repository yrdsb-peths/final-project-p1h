import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Healing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Healing extends Powerup
{
    //declaring constant
    public static final Color HEALING_COLOR = Color.GREEN;
    
    public Healing(Player player){
        this.player = player;
        super.draw(PU_WIDTH, PU_HEIGHT, HEALING_COLOR);
    }
    
    public void act()
    {
        super.act();
    }
    
    public void activate(){
        player.setCurrHP(player.getMaxHP());
    }
    
    public String toString(){
        return "Instant Healing";
    }
    
    public boolean needsIcon(){
        return false;
    }
    
    public Color getColor(){
        return HEALING_COLOR;
    }
}