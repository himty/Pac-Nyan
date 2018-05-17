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
    private String queuedKey; // last key that was unsuccessfully pressed
                              // (there was a wall in that direction)
    private String currDirection;
    
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
        lastKey = "-";
        queuedKey = "-";
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
    
    public boolean canMove(String dir) {
        if (dir.equals("up")) {
            int wallX = (int)(getX() / CELL_SIZE) * CELL_SIZE + CELL_SIZE / 2;
            int wallY = (int)(getY() / CELL_SIZE) * CELL_SIZE - CELL_SIZE / 2;
            return (!isVerticallyCentered() || getWorld().getObjectsAt(wallX, wallY, Wall.class).isEmpty() == true
                && getWorld().getObjectsAt(wallX, wallY, Void.class).isEmpty() == true)
                && isHorizontallyCentered();
        }
        else if (dir.equals("down")) {
            int wallX = (int)(getX() / CELL_SIZE) * CELL_SIZE + CELL_SIZE / 2;
            int wallY = ((int)(getY() / CELL_SIZE) + 1) * CELL_SIZE + CELL_SIZE / 2;
            return (!isVerticallyCentered() ||getWorld().getObjectsAt(wallX, wallY, Wall.class).isEmpty() == true
                && getWorld().getObjectsAt(wallX, wallY, Void.class).isEmpty() == true)
                && isHorizontallyCentered();
        }
        else if (dir.equals("left")) {
            int wallX = (int)(getX() / CELL_SIZE) * CELL_SIZE - CELL_SIZE / 2;
            int wallY = (int)(getY() / CELL_SIZE) * CELL_SIZE + CELL_SIZE / 2;
            return (!isHorizontallyCentered() || getWorld().getObjectsAt(wallX, wallY, Wall.class).isEmpty() == true
                && getWorld().getObjectsAt(wallX, wallY, Void.class).isEmpty() == true)
                && isVerticallyCentered();
        }
        else if (dir.equals("right")){
            int wallX = ((int)(getX() / CELL_SIZE) + 1) * (CELL_SIZE) + CELL_SIZE / 2;
            int wallY = (int)(getY() / CELL_SIZE) * CELL_SIZE + CELL_SIZE / 2;
            return (!isHorizontallyCentered() || getWorld().getObjectsAt(wallX, wallY, Wall.class).isEmpty() == true
                && getWorld().getObjectsAt(wallX, wallY, Void.class).isEmpty() == true)
                && isVerticallyCentered();
        }
        else {
            //if dir == "-" (a placeholder)
            return false;
        }
    }
    
        /**
     * Moves the NYANCAT forward, putting a flower into the location it previously
     * occupied.
     */
    public void move(String dir)
    {
        if(dir.equals("up"))
        {
            setLocation(getX(), getY() - SPEED);
        }
        else if(dir.equals("down"))
        {
            setLocation(getX(), getY() + SPEED);
        }
        else if(dir.equals("left"))
        {
            setLocation(getX() - SPEED, getY());
        }
        else if(dir.equals("right"))
        {
            setLocation(getX() + SPEED, getY());
        }
    }

    /**
     * Returns whether this actor is in the middle of a
     * cell in terms of y-coordinate
     */
    private boolean isVerticallyCentered() {
        return (getY() - CELL_SIZE / 2) % CELL_SIZE == 0;
    }
    
    /**
     * Returns whether this actor is in the middle of a
     * cell in terms of x-coordinate
     */
    private boolean isHorizontallyCentered() {
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
}