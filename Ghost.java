import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ghost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends MazeActor
{
    private GreenfootImage img;
    private static final int EAST = 90;
    private static final int SOUTH = 180;
    private static final int WEST = 270;
    private static final int NORTH = 0;
       
    private static final int CELL_SIZE = 30;
    private static final int CELL_OFFSET = (int)(CELL_SIZE * 1.5);
    private boolean isMovingLeft = true;
    
    /**
     * Act - do whatever the Ghost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
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
    
    public void moveForward() {
        switch (getRotation()) {
            case 0:
                moveRight();
                break;
            case 90:
                moveDown();
                break;
            case 180:
                break;
            case 270:
                break;
        }
    }
    
    public void moveLeft() {
        if(!hasWallOnLeft()) {
            setLocation(getX() - 1, getY());
        }
        //flip the image
        if(!isMovingLeft) {
            setImage(getHorizImage(getImage()));
            isMovingLeft = true;
        }
    }
    
    public void moveRight() {
        if(!hasWallOnLeft()) {
             setLocation(getX() + 1, getY());
        }
        
        //flip the image
        if(isMovingLeft) {
            setImage(getHorizImage(getImage()));
            isMovingLeft = false;
        }
    }
    
    public void moveUp() {
        if (!hasWallAbove()) {
            setLocation(getX(), getY() - 1);
        }
    }
    
    public void moveDown() {
        if(!hasWallBelow()) {
            setLocation(getX(), getY() + 1);
        }
    }
    
    private boolean canMoveTo(int x, int y) {
        return getWorld().getObjectsAt(x, y, Wall.class).isEmpty() == false
                && getWorld().getObjectsAt(x, y, Void.class).isEmpty() == false;
    }
    
     public boolean hasWallAbove() {
         return canMoveTo(getX(), getY() - CELL_OFFSET);
    }
    
    public boolean hasWallBelow() {
        return canMoveTo(getX(), getY() + CELL_OFFSET);
    }
    
    public boolean hasWallOnLeft() {
        return canMoveTo(getX() - CELL_OFFSET, getY());
    }
    
    public boolean hasWallOnRight() {
        return canMoveTo(getX() + CELL_OFFSET, getY());
    }
}
