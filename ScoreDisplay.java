import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreDisplay extends Actor
{
    //declaring the score display's dimensions and image variables
    private GreenfootImage image;
    private GreenfootImage character = new GreenfootImage("CharacterDisplay.png");
    public static final int SCORE_DISPLAY_WIDTH = GameWorld.WORLD_WIDTH / 3;
    public static final int SCORE_DISPLAY_HEIGHT = GameWorld.WORLD_HEIGHT * 2 / 15;
    public static final Color scoreColor = Color.YELLOW;
    public static final Font scoreFont = new Font("Courier New", true, false, GameWorld.WORLD_HEIGHT / 20);
    
    //declaring instance variables
    private int score;
    private String display;
    
    public ScoreDisplay(int score){
        //setting the player's score
        this.score = score;
        display = "SCORE: " + this.score;
        
        //drawing the score display
        character.scale(SCORE_DISPLAY_WIDTH / 4, SCORE_DISPLAY_HEIGHT);
        image =  new GreenfootImage(SCORE_DISPLAY_WIDTH + 1, SCORE_DISPLAY_HEIGHT + 1);
        drawScoreDisplay(SCORE_DISPLAY_WIDTH + 1, SCORE_DISPLAY_HEIGHT + 1);
        setImage(image);
    }
    
    //setter methods
    
    //method to update the score display
    public void update(int score) 
    {
        this.score = score;
        display = "SCORE: " + this.score;
        drawScoreDisplay(SCORE_DISPLAY_WIDTH + 1, SCORE_DISPLAY_HEIGHT + 1);
        setImage(image);
    }
    
    //method to draw the score display
    private void drawScoreDisplay(int width, int height){
        image.clear();
        image.drawImage(character, 0, 0);
        image.setColor(scoreColor);
        image.setFont(scoreFont);
        image.drawString(display, width * 6 / 25, height * 4 / 5);
    }
}