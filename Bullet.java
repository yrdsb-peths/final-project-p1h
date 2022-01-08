import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends SuperSmoothMover
{
    //declaring the bullet's dimensions and image
    private GreenfootImage image;
    public static final int BULLET_WIDTH = GameWorld.WORLD_WIDTH / 15;
    public static final int BULLET_HEIGHT = 10;
    
    //declaring bullet constants
    public static final int SPEED = 20;
    public static final int DMG = 4;
    
    public Bullet(){
        image = new GreenfootImage(BULLET_WIDTH + 1, BULLET_HEIGHT + 1); //creating the blank GreenfootImage used for the bullet
        drawBullet(BULLET_WIDTH, BULLET_HEIGHT);
        setImage(image);
    }
    
    public void act() 
    {
        move(SPEED); //moves the bullet forward
        if(/*collisionDetection() || */isAtEdge()){ //removes bullet if when it hits an object or leaves the screen
            getWorld().removeObject(this);
        }
    }
    
    //method to draw the bullet
    private void drawBullet(int width, int height){
        image.drawLine(0, height / 2, width, height / 2);
    }
}
