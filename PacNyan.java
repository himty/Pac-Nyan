import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PacNyan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.Color;
public class PacNyan extends Actor
{
    private GreenfootImage img;
    
    private static final int EAST = 90;
    private static final int SOUTH = 180;
    private static final int WEST = 270;
    private static final int NORTH = 0;
    
    private static final int SPEED = 2;
    
    private String lastKey; // last key pressed
    
    public PacNyan()
    {
        img = getImage();
        img.scale(40, 46);
    }
    /**
     * Act - do whatever the PacNyan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("up"))
        {
            if(lastKey == "left")
            {
                setImage(img);
                getImage().mirrorHorizontally();
            }
            setRotation(NORTH);
            lastKey = "up";
            
            if (canMove())
            {
                move();
            }
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            if(lastKey == "left")
            {
                setImage(img);
                getImage().mirrorHorizontally();
            }
            setRotation(EAST);
            lastKey = "right";
            
            if (canMove())
            {
                move();
            }
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            if(lastKey == "left")
            {
                setImage(img);
                getImage().mirrorHorizontally();
            }
            setRotation(SOUTH);
            lastKey = "down";
            
            if (canMove())
            {
                move();
            }
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            setRotation(WEST);
            if(lastKey != "left")
            {
               getImage().mirrorHorizontally();
            }
            lastKey = "left";
            
            if (canMove())
            {
                move();
            }
        }
    }
    
    /**
     * Moves the NYANCAT forward, putting a flower into the location it previously
     * occupied.
     */
    public void move()
    {
        if(lastKey == "up")
        {
            setLocation(getX(), getY() - SPEED);
        }
        else if(lastKey == "down")
        {
            setLocation(getX(), getY() + SPEED);
        }
        else if(lastKey == "left")
        {
            setLocation(getX() - SPEED, getY());
        }
        else if(lastKey == "right")
        {
            setLocation(getX() + SPEED, getY());
        }
    }
    
    /**
     * Tests whether this NYANCAT can move forward into a location that is empty or
     * contains a flower.
     * @return true if this NYANCAT can move.
     */
    public boolean canMove()
    {
        return true;
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
        // EDIT TO RESTRICT TO IF WALL IS IN THE WAY, ETC.
    }
    
    public GreenfootImage getReverseImage(GreenfootImage img) {
        int w = img.getWidth(), h = img.getHeight();
        GreenfootImage image = new GreenfootImage(w, h);
        for (int y=0; y<h; y++) for (int x=1; x<=w; x++)
            image.setColorAt(w-x, y, img.getColorAt(x-1, y));
        return image;
    }
}
