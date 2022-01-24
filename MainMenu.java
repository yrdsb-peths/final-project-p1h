import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main menu of the game
 * 
 * @author (Vaughn Chan) 
 * @version (3.0: 01/23/2022)
 */
public class MainMenu extends World
{
    //declaring world dimensions
    public static final int MENU_WIDTH = GameWorld.WORLD_WIDTH;
    public static final int MENU_HEIGHT = GameWorld.WORLD_HEIGHT;
    
    //declaring background variables
    private GreenfootImage bg = new GreenfootImage("Backgrounds/MainMenu.jpg");
    public static final Font MENU_TITLE_FONT = new Font("Courier New", true, false, MENU_HEIGHT / 8);
    public static final Color MENU_TITLE_COLOR = Color.RED;
    private String title = "The\nHorde";
    public static final Font MENU_HEADER_FONT = new Font("Courier New", true, false, MENU_HEIGHT / 15);
    public static final Font MENU_SCORE_FONT = new Font("Courier New", true, false, MENU_HEIGHT / 20);
    public static final Color MENU_SCORE_COLOR = Color.YELLOW;
    private String scoreHeader = "Top Scores:";
    
    //initializing constants
    public static final int NUM_SCORES = 5;
    public static final int SCORE_OFFSET = MENU_HEIGHT / 20;
    
    //declaring actors
    private Button playButton, instructionsButton;
    
    //declaring instance variables
    private static GreenfootSound bgMusic = new GreenfootSound("BackgroundMusic/MainMenuMusic.mp3");
    private static boolean musicStarted;
    
    /**
     * MainMenu Constructor
     */
    public MainMenu()
    {    
        // Create a new world with MENU_WIDTH * MENU_HEIGHT cells with a cell size of 1x1 pixels.
        super(MENU_WIDTH, MENU_HEIGHT, 1); 

        //drawing background
        bg.setColor(MENU_TITLE_COLOR);
        bg.setFont(MENU_TITLE_FONT);
        bg.drawString(title, getWidth() / 8, getHeight() / 5);
        bg.setColor(MENU_SCORE_COLOR);
        bg.setFont(MENU_HEADER_FONT);
        bg.drawString(scoreHeader, getWidth() / 10, getHeight() * 31 / 50);
        // Read score data and display the top scores
        bg.setFont(MENU_SCORE_FONT);
        ScoreFile scoreFile = ScoreFile.getInstance();
        int scoreOffset = 0;
        for (Pair p : scoreFile.getScoreData())
        {
            bg.drawString(p.getFirst() + " - " + p.getSecond(), getWidth() / 10, getHeight() * 7 / 10 + scoreOffset);
            scoreOffset += SCORE_OFFSET;

            if (scoreOffset / SCORE_OFFSET == NUM_SCORES) break;
        }
        setBackground(bg);
        
        //adding buttons
        playButton = new Button("Play");
        addObject(playButton, getWidth() * 3 / 4, (int) (getHeight() * 2 / 3));
        instructionsButton = new Button("How to Play");
        addObject(instructionsButton, getWidth() * 3 / 4, (int) (getHeight() * 5 / 6));
        
        musicStarted = false;
        
        // Reset player score, since transitioning from game to main menu directly does not reset score
        // NOTE: This should never happen in the game itself, only in development
        Player.score = 0;
    }
    
    /**
     * Act Method
     * 
     * Checks if the user clicked any of the buttons, and take them to the respective worlds if they did
     */
    public void act()
    {
        //checking if the user clicked any of the buttons and take them to the respective world
        if (Greenfoot.mouseClicked(playButton)){
            Greenfoot.setWorld(new GameWorld());
            playButton.playClickSound();
            
            // stop the music when the user enters the GameWorld
            bgMusic.stop();
        }
        else if (Greenfoot.mouseClicked(instructionsButton)){
            Greenfoot.setWorld(new InstructionsMenu());
            playButton.playClickSound();
        }
        
        // Start music, and prevent redundency
        if (!musicStarted) {
            bgMusic.playLoop();
            musicStarted = true;
        }
    }
}