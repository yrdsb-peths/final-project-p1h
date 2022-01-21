import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Healing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Healing extends Powerup
{
    //declaring image
    private GreenfootImage image = new GreenfootImage("PowerupIcons/healing-icon.png");
    
    //declaring constant
    public static final Color HEALING_COLOR = Color.GREEN;
    
    public Healing(Player player){
        image.scale(PU_WIDTH, PU_HEIGHT);
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
    
    public GreenfootImage getImage(){
        return image;
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
