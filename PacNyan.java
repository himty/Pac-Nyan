import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PacNyan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.Color;
public class PacNyan extends MazeActor
{
   private GreenfootImage img;
       
    private String lastKey; // last key pressed
    private String queuedKey; // last key that was unsuccessfully pressed
                              // (there was a wall in that direction)
    private String currDirection;
    
    private static final int EAST = 90;
    private static final int SOUTH = 180;
    private static final int WEST = 270;
    private static final int NORTH = 0;
    
    private static final int WIDTH = 40;
    private static final int HEIGHT = 46;
    private static final int HORIZ_OFFSET_LEFT = WIDTH / 2;
    private static final int HORIZ_OFFSET_RIGHT = WIDTH / 2;
    private static final int VERT_OFFSET = HEIGHT / 2;
    private boolean isMovingLeft = true;
    
    public PacNyan()
    {
        img = getImage();
        img.scale(WIDTH, HEIGHT);
        
        lastKey = "-";
        queuedKey = lastKey;
        currDirection = lastKey;
    }
    
    /**
     * Act - do whatever the PacNyan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("up"))
        {           
            lastKey = "up";
        }
        else if(Greenfoot.isKeyDown("right"))
        {            
            lastKey = "right";
        }
        else if(Greenfoot.isKeyDown("down"))
        {            
            lastKey = "down";
        }
        else if(Greenfoot.isKeyDown("left"))
        {         
            lastKey = "left";
        }        
                    
        if (canMove(queuedKey))
        {
            currDirection = queuedKey;
            lastKey = queuedKey;
            setImageDir(queuedKey);
            move(queuedKey);
            queuedKey = "-";
        }
        else if (canMove(lastKey)) {
            currDirection = lastKey;
            setImageDir(lastKey);
            move(lastKey);
        }
        else {
            if (canMove(currDirection)) {
                move(currDirection);
            }
            //couldn't move at all
            if (lastKey != currDirection) {
                 queuedKey = lastKey;
            }
        }
    }   
    
    public void setImageDir(String dir) {
        if (dir.equals("up")) {
            setImage(img);
            setRotation(NORTH);
        }
        else if (dir.equals("right")) {
            setImage(img);
            setRotation(EAST);
        }
        else if (dir.equals("down")) {
            setImage(img);
            setRotation(SOUTH);
        }
        else if (dir.equals("left")){
            setRotation(WEST);
            setImage(getHorizImage(img));
        }
    }
}
   