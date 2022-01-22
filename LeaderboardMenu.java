import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LeaderboardMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeaderboardMenu extends World
{
    //declaring world dimensions
    public static final int MENU_WIDTH = GameWorld.WORLD_WIDTH;
    public static final int MENU_HEIGHT = GameWorld.WORLD_HEIGHT;

    // Other static variables
    private static final Font TITLE_FONT = new Font("Courier New", true, false, 40);
    private static final Font SCORE_FONT = new Font("Courier New", true, false, 35);
    
    private GreenfootImage bgImage;
    
    //declaring actors
    private Button backButton;

    public LeaderboardMenu()
    {    
        super(MENU_WIDTH, MENU_HEIGHT, 1);

        // Draw background
        bgImage = new GreenfootImage(getWidth() + 1, getHeight() + 1);
        bgImage.setColor(Color.WHITE);
        bgImage.fill();

        // Draw score title
        bgImage.setColor(Color.BLACK);
        bgImage.setFont(TITLE_FONT);
        bgImage.drawString("Score: ", getWidth() / 5, getHeight() / 3);

        // Read score data and display the top scores
        bgImage.setFont(SCORE_FONT);
        ScoreFile scoreFile = ScoreFile.getInstance();
        int scoreOffset = 0;
        for (Pair p : scoreFile.getScoreData())
        {
            bgImage.drawString(p.getFirst() + " - " + p.getSecond(), getWidth() / 5, getHeight() * 2 / 4 + scoreOffset);
            scoreOffset += 60;

            if ((getHeight() * 2 / 4 + scoreOffset) > getWidth()) break;
        }
        
        //add button
        backButton = new Button("Back");
        addObject(backButton, getWidth() * 3 / 4, getHeight() * 5 / 6);
        
        // Set the background image
        setBackground(bgImage);
    }
    
    public void act(){
        //takes the user back to the main menu
        if(Greenfoot.mouseClicked(backButton)){
            Greenfoot.setWorld(new MainMenu());
            backButton.playClickSound();
        }
    }
}