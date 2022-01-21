import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    //declaring world dimensions
    public static final int ENDING_WIDTH = GameWorld.WORLD_WIDTH;
    public static final int ENDING_HEIGHT = GameWorld.WORLD_HEIGHT;
    
    //declaring background variables
    private GreenfootImage bg;
    private GreenfootImage bgImage = new GreenfootImage("EndScreenBackground.png");
    public static final Font ENDING_TITLE_FONT = MainMenu.MENU_TITLE_FONT;
    public static final Color ENDING_TITLE_COLOR = MainMenu.MENU_TITLE_COLOR;
    private String title = "You Died";
    
    //declaring actors
    private Button backButton;
    
    //declaring instance variables
    private int currHeight = ENDING_HEIGHT;
    
    public EndScreen()
    {    
        // Create a new world with ENDING_WIDTH*ENDING_HEIGHT cells with a cell size of 1x1 pixels.
        super(ENDING_WIDTH, ENDING_HEIGHT, 1);
        
        //drawing background
        bg = new GreenfootImage(getWidth() + 1, getHeight() + 1);
        bgImage.scale(getWidth() + 1, getHeight() + 1);
        drawBackground(currHeight);
        
        //add cover
        //BackgroundCover cover = new BackgroundCover();
        //addObject(cover, 0, 0);
        //add button
        backButton = new Button("Back");
        addObject(backButton, getWidth() * 3 / 4, getHeight() * 5 / 6);
        
        // Add player's score to score file
        
    }
    
    public void act(){
        drawBackground(currHeight);
        if(currHeight > 0) currHeight--;
        
        //takes the user back to the main menu
        if(Greenfoot.mouseClicked(backButton)){
            Greenfoot.setWorld(new MainMenu());
            backButton.playClickSound();
        }
    }
    
    private void drawBackground(int coverHeight){
        bg.drawImage(bgImage, 0, 0);
        bgImage.setColor(ENDING_TITLE_COLOR);
        bgImage.setFont(ENDING_TITLE_FONT);
        bgImage.drawString(title, (getWidth() - (int)(title.length() * ENDING_TITLE_FONT.getSize() * 0.58)) / 2, getHeight() / 2);
        setBackground(bgImage);
    }
}