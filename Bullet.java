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
    
    //declaring actors
    Player player;
    
    //declaring instance variables
    private Class targetClass; //target class tracking (from Mr. Cohen)
    private int dmg;
    
    public Bullet(){
        image = new GreenfootImage(BULLET_WIDTH + 1, BULLET_HEIGHT + 1); //creating the blank GreenfootImage used for the bullet
        drawBullet(BULLET_WIDTH, BULLET_HEIGHT);
        setImage(image);
    }
    
    public void act() 
    {
        player = getWorld().getObjects(Player.class).get(0); //(from Mr. Cohen)
        dmg = player.getDmg();
        move(SPEED); //moves the bullet forward
        if(collisionDetection() || isAtEdge()) getWorld().removeObject(this); //removes bullet if when it hits an object or leaves the screen
    }
    
    //method to check if the laser has collided with another actor (from Mr. Cohen)
    private boolean collisionDetection(){
        Actor target = getOneIntersectingObject(targetClass);
        if(target != null){
            /*if(target instanceof Player){ //deals damage to player if the laser hits the player
                Player player = (Player) target;
                player.dealDmg(dmg);
            }
            else */if(target instanceof Enemy){
                Enemy enemy;
                /*if(explosive){ //deals damage to all enemies in the area of the torpedo if it is a torpedo
                    List<Enemy> enemies = getObjectsInRange(explosionRange, Enemy.class); //(from "danpost" on Greenfoot)
                    for(var i = 0; i < enemies.size(); i++){
                        enemy = enemies.get(i);
                        enemy.dealDmg(dmg);
                    }
                }*/
                //else{ //deals damage to the enemy if the laser hits the enemy
                    enemy = (Enemy) target;
                    enemy.dealDmg(dmg);
                    return true;
                //}
            }
            
        }
        return false;
    }
    
    //method to draw the bullet
    private void drawBullet(int width, int height){
        image.drawLine(0, height / 2, width, height / 2);
    }
}
