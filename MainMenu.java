import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main menu of the game
 * 
 * @author (Vaughn Chan) 
 * @version (2.0: 01/22/2022)
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
    public static final Font MENU_SCORE_FONT = new Font("Courier New", true, false, MENU_HEIGHT / 15);
    public static final Color MENU_SCORE_COLOR = Color.YELLOW;
    
    //declaring actors
    private Button playButton, instructionsButton, leaderboardButton;
    
    //declaring instance variables
    private GreenfootSound bgMusic = new GreenfootSound("BackgroundMusic/MainMenuMusic.mp3");
    private boolean musicStarted = false;
    
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
        bg.drawString(title, getWidth() / 8, getHeight() / 4);
        setBackground(bg);
        
        //adding buttons
        playButton = new Button("Play");
        addObject(playButton, getWidth() * 3 / 4, (int) (getHeight() * 1.9 / 3));
        instructionsButton = new Button("How to Play");
        addObject(instructionsButton, getWidth() * 3 / 4, (int) (getHeight() * 2.3 / 3));
        leaderboardButton = new Button("Leaderboard");
        addObject(leaderboardButton, getWidth() * 3 / 4, (int) (getHeight() * 2.7 / 3));
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
            bgMusic.stop();
        }
        else if (Greenfoot.mouseClicked(instructionsButton)){
            Greenfoot.setWorld(new InstructionsMenu());
            playButton.playClickSound();
        }
        else if (Greenfoot.mouseClicked(leaderboardButton)){
            Greenfoot.setWorld(new LeaderboardMenu());
            playButton.playClickSound();
        }
        
        // Start music, and prevent redundency
        if (!musicStarted) {
            bgMusic.playLoop();
            musicStarted = true;
        }
    }
}