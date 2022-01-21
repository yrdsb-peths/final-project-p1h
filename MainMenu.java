import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    //declaring world dimensions
    public static final int MENU_WIDTH = GameWorld.WORLD_WIDTH;
    public static final int MENU_HEIGHT = GameWorld.WORLD_HEIGHT;
    
    //declaring background variables
    private GreenfootImage bgImage = new GreenfootImage("manchester_apocalypse.jpg");
    public static final Font MENU_TITLE_FONT = new Font("Courier New", true, false, MENU_HEIGHT / 8);
    public static final Color MENU_TITLE_COLOR = Color.WHITE;
    private String title = "The\nHorde";
    
    private GreenfootSound bgMusic = new GreenfootSound("main_menu.mp3");
    private boolean musicStarted = false;
    
    //declaring actors
    private Button playButton, instructionsButton;
    
    public MainMenu()
    {    
        // Create a new world with MENU_WIDTH * MENU_HEIGHT cells with a cell size of 1x1 pixels.
        super(MENU_WIDTH, MENU_HEIGHT, 1); 

        //drawing background
        setBackground(bgImage);
        bgImage.setColor(MENU_TITLE_COLOR);
        bgImage.setFont(MENU_TITLE_FONT);
        bgImage.drawString(title, getWidth() / 8, getHeight() / 4);
        
        //adding buttons
        playButton = new Button("Play");
        addObject(playButton, getWidth() * 3 / 4, getHeight() * 2 / 3);
        instructionsButton = new Button("How to Play");
        addObject(instructionsButton, getWidth() * 3 / 4, getHeight() * 5 / 6);
    }
    
    public void act()
    {
        //checking if the user clicked any of the buttons and take them to the respective world
        if (Greenfoot.mouseClicked(playButton)) {
            Greenfoot.setWorld(new GameWorld());
            bgMusic.stop();
        }
        else if (Greenfoot.mouseClicked(instructionsButton)) Greenfoot.setWorld(new InstructionsMenu());
        
        // Start music, and prevent redundency
        if (!musicStarted) {
            bgMusic.playLoop();
            musicStarted = true;
        }
    }
}