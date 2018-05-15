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
    
    private static final int SPEED = 1;
    
    private String lastKey; // last key pressed
    
    private static final int CELL_SIZE = 30;
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
        lastKey = "up";
    }
    
    /**
     * Act - do whatever the PacNyan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setImage(img);
            setRotation(NORTH);
            
            lastKey = "up";
            
            int newX = getX();
            int newY = getY() - SPEED;
            
            if (canMove())
            {
                moveTo(newX, newY);
            }
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            setImage(img);
            setRotation(EAST);
            
            lastKey = "right";
            
            int newX = getX() + SPEED;
            int newY = getY();
            
            if (canMove())
            {
                moveTo(newX, newY);
            }
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            setImage(img);
            setRotation(SOUTH);
            
            lastKey = "down";
            
            int newX = getX();
            int newY = getY() + SPEED;
            
            if (canMove())
            {
                moveTo(newX, newY);
            }
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            setRotation(WEST);
            setImage(getHorizImage(img));
            
            lastKey = "left";
            
            int newX = getX() - SPEED;
            int newY = getY();
            
            if (canMove())
            {
                moveTo(newX, newY);
            }
        }
        
        /*
        if(!hasWallOnRight()) {
            moveLeft();
        }
        else {
            moveDown();
        }
        */
    }   
    
    /**
     * Moves the NYANCAT forward, putting a flower into the location it previously
     * occupied.
     */
    public void move()
    {
        if(lastKey.equals("up"))
        {
            setLocation(getX(), getY() - SPEED);
        }
        else if(lastKey.equals("down"))
        {
            setLocation(getX(), getY() + SPEED);
        }
        else if(lastKey.equals("left"))
        {
            setLocation(getX() - SPEED, getY());
        }
        else if(lastKey.equals("right"))
        {
            setLocation(getX() + SPEED, getY());
        }
    }
    
    private boolean canMove() {
        System.out.println("HorizCentered: " + isHorizontallyCentered());
        System.out.println("VertCentered: " + isVerticallyCentered());
        System.out.println("X: " + getX() + " Y: " + getY());
        if (lastKey.equals("up")) {
            return getWorld().getObjectsAt(getX(), (int)(getY() - CELL_SIZE * 0.5) - 1, Wall.class).isEmpty() == true
                && getWorld().getObjectsAt(getX(), (int)(getY() - CELL_SIZE * 0.5) - 1, Void.class).isEmpty() == true
                && isHorizontallyCentered();
        }
        else if (lastKey.equals("down")) {
            return getWorld().getObjectsAt(getX(), (int)(getY() + CELL_SIZE * 0.5), Wall.class).isEmpty() == true
                && getWorld().getObjectsAt(getX(), (int)(getY() + CELL_SIZE * 0.5), Void.class).isEmpty() == true
                && isHorizontallyCentered();
        }
        else if (lastKey.equals("left")) {
            return getWorld().getObjectsAt((int)(getX() - CELL_SIZE * 0.5) - 1, getY(), Wall.class).isEmpty() == true
                && getWorld().getObjectsAt((int)(getX() - CELL_SIZE * 0.5) - 1, getY(), Void.class).isEmpty() == true
                && isVerticallyCentered();
        }
        else {
            //lastKey == right
            return getWorld().getObjectsAt((int)(getX() + CELL_SIZE * 0.5), getY(), Wall.class).isEmpty() == true
                && getWorld().getObjectsAt((int)(getX() + CELL_SIZE * 0.5), getY(), Void.class).isEmpty() == true
                && isVerticallyCentered();
        }
    }
    
    public void moveTo(int x, int y) {
        setLocation(x, y);
    }
    
    /**
     * Returns whether this actor is in the middle of a
     * cell in terms of y-coordinate
     */
    public boolean isVerticallyCentered() {
        return (getY() - CELL_SIZE / 2) % CELL_SIZE == 0;
    }
    
    /**
     * Returns whether this actor is in the middle of a
     * cell in terms of x-coordinate
     */
    public boolean isHorizontallyCentered() {
        return (getX() - CELL_SIZE / 2) % CELL_SIZE == 0;
    }
    
    private GreenfootImage getHorizImage(GreenfootImage img) {
        int tempRotation = getRotation();
        setRotation(NORTH);
        int w = img.getWidth(), h = img.getHeight();
        GreenfootImage image = new GreenfootImage(w, h);
        for (int y = 0; y < h; y++) {
            for (int x = 1; x <= w; x++) {
                image.setColorAt(w-x, y, img.getColorAt(x-1, y));
            }
        }
        setRotation(tempRotation);
        return image;
    }
    
        private GreenfootImage getVertImage(GreenfootImage img) {
        int tempRotation = getRotation();
        setRotation(NORTH);
        int w = img.getWidth(), h = img.getHeight();
        GreenfootImage image = new GreenfootImage(w, h);
        for (int x = 0; x < w; x++) {
            for (int y = 1; y <= h; y++) {
                image.setColorAt(x, h-y, img.getColorAt(x, y-1));
            }
        }
        setRotation(tempRotation);
        return image;
    }
    
    public static int getVertOffset() {
        return VERT_OFFSET - CELL_SIZE / 2;
    }
    
    public static int getHorizOffset() {
        return HORIZ_OFFSET_LEFT - CELL_SIZE / 2;
    }
   
    /*
     public boolean hasWallAbove() {
         return !canMoveTo(getX(), getY() - VERT_OFFSET);
    }
    
    public boolean hasWallBelow() {
        return !canMoveTo(getX(), getY() + VERT_OFFSET + CELL_SIZE);
    }
    
    public boolean hasWallOnLeft() {
        return !canMoveTo(getX() - HORIZ_OFFSET_LEFT, getY());
    }
    
    public boolean hasWallOnRight() {
        return !canMoveTo(getX() + HORIZ_OFFSET_RIGHT, getY());
    }
    
    private GreenfootImage getReverseImage(GreenfootImage img) {
        int w = img.getWidth(), h = img.getHeight();
        GreenfootImage image = new GreenfootImage(w, h);
        for (int y = 0; y < h; y++) {
            for (int x = 1; x <= w; x++) {
                image.setColorAt(w-x, y, img.getColorAt(x-1, y));
            }
        }
        return image;
    }
    */
}