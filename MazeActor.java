import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MazeActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MazeActor extends Actor
{    
    private static final int SPEED = 1;
    private static final int CELL_SIZE = 30;
    
    private static final int EAST = 90;
    private static final int SOUTH = 180;
    private static final int WEST = 270;
    private static final int NORTH = 0;

    public abstract void setImageDir(String dir);
    
    public boolean canMove(String dir) {
        if (dir.equals("up")) {
            int wallX = (int)(getX() / CELL_SIZE) * CELL_SIZE + CELL_SIZE / 2;
            int wallY = (int)(getY() / CELL_SIZE) * CELL_SIZE - CELL_SIZE / 2;
            return (!isVerticallyCentered() || getWorld().getObjectsAt(wallX, wallY, Wall.class).isEmpty() == true
                && getWorld().getObjectsAt(wallX, wallY, Void.class).isEmpty() == true
                && getWorld().getObjectsAt(wallX, wallY, Bar.class).isEmpty() == true)
                && isHorizontallyCentered();
        }
        else if (dir.equals("down")) {
            int wallX = (int)(getX() / CELL_SIZE) * CELL_SIZE + CELL_SIZE / 2;
            int wallY = ((int)(getY() / CELL_SIZE) + 1) * CELL_SIZE + CELL_SIZE / 2;
            return (!isVerticallyCentered() ||getWorld().getObjectsAt(wallX, wallY, Wall.class).isEmpty() == true
                && getWorld().getObjectsAt(wallX, wallY, Void.class).isEmpty() == true
                && getWorld().getObjectsAt(wallX, wallY, Bar.class).isEmpty() == true)
                && isHorizontallyCentered();
        }
        else if (dir.equals("left")) {
            int wallX = (int)(getX() / CELL_SIZE) * CELL_SIZE - CELL_SIZE / 2;
            int wallY = (int)(getY() / CELL_SIZE) * CELL_SIZE + CELL_SIZE / 2;
            return (!isHorizontallyCentered() || getWorld().getObjectsAt(wallX, wallY, Wall.class).isEmpty() == true
                && getWorld().getObjectsAt(wallX, wallY, Void.class).isEmpty() == true
                && getWorld().getObjectsAt(wallX, wallY, Bar.class).isEmpty() == true)
                && isVerticallyCentered();
        }
        else if (dir.equals("right")){
            int wallX = ((int)(getX() / CELL_SIZE) + 1) * (CELL_SIZE) + CELL_SIZE / 2;
            int wallY = (int)(getY() / CELL_SIZE) * CELL_SIZE + CELL_SIZE / 2;
            return (!isHorizontallyCentered() || getWorld().getObjectsAt(wallX, wallY, Wall.class).isEmpty() == true
                && getWorld().getObjectsAt(wallX, wallY, Void.class).isEmpty() == true
                && getWorld().getObjectsAt(wallX, wallY, Bar.class).isEmpty() == true)
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
    
    public GreenfootImage getHorizImage(GreenfootImage img) {
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
    
    public GreenfootImage getVertImage(GreenfootImage img) {
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
