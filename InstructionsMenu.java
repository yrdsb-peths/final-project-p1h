import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionsMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionsMenu extends World
{
    //declaring world dimensions
    public static final int INSTRUCTIONS_WIDTH = GameWorld.WORLD_WIDTH;
    public static final int INSTRUCTIONS_HEIGHT = GameWorld.WORLD_HEIGHT;
    
    //declaring background variables
    private GreenfootImage bg = new GreenfootImage("Backgrounds/InstructionsMenu.png");
    public static final Font INSTRUCTIONS_TITLE_FONT = MainMenu.MENU_TITLE_FONT;
    public static final Color INSTRUCTIONS_TITLE_COLOR = MainMenu.MENU_TITLE_COLOR;
    private String title = "Instructions";
    public static final Font INSTRUCTIONS_FONT = new Font("Courier New", false, false, INSTRUCTIONS_HEIGHT / 20);
    public static final Color INSTRUCTIONS_COLOR = INSTRUCTIONS_TITLE_COLOR;
    private String goal = "GOAL: Achieve The Highest Score By\nKilling The Horde";
    private String controls = "Mouse Click: Fire\nMouse: Aim\nW: Forward\nA: Left\nS: Backwards\nD: Right";
    
    //declaring actors
    private Button backButton;
    
    public InstructionsMenu()
    {    
        // Create a new world with INSTRUCTIONS_WIDTH*INSTRUCTIONS_HEIGHT cells with a cell size of 1x1 pixels.
        super(INSTRUCTIONS_WIDTH, INSTRUCTIONS_HEIGHT, 1);
        
        //drawing background
        bg.scale(getWidth() + 1, getHeight() + 1);
        bg.setColor(INSTRUCTIONS_TITLE_COLOR);
        bg.setFont(INSTRUCTIONS_TITLE_FONT);
        bg.drawString(title, (getWidth() - (int)(title.length() * INSTRUCTIONS_TITLE_FONT.getSize() * 0.58)) / 2, getHeight() / 6);
        bg.setColor(Color.WHITE);
        bg.setFont(INSTRUCTIONS_FONT);
        bg.drawString(goal, getWidth() * 4 / 20, getHeight() * 3 / 10);
        bg.drawString(controls, getWidth() * 4 / 20, getHeight() * 5 / 10);
        setBackground(bg);
        
        //adding button
        backButton = new Button("Back");
        addObject(backButton, getWidth() * 3 / 4, getHeight() * 5 / 6);
    }
    
    public void act(){
        //takes the user back to the main menu if they pressed the button
        if(Greenfoot.mouseClicked(backButton)){
            Greenfoot.setWorld(new MainMenu());
            backButton.playClickSound();
        }
    }
}