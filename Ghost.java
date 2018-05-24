import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Ghost is an abstract class that contains all of the
 * similarities among Blinky, Pinky, Inky, and Clyde.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends MazeActor
{
    private static final int EAST = 90;
    private static final int SOUTH = 180;
    private static final int WEST = 270;
    private static final int NORTH = 0;
    private static final int CELL_SIZE = 30;
    private int counter;
    
    private final char LEFT = 'l';
    private final char RIGHT = 'r';
    private final char UP = 'u';
    private final char DOWN = 'd';
    
    private boolean isScared;
    private String currDirection;
    
    private final char[][] flowMap = 
    {
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
        {'x', 'r', 'r', 'r', 'r', 'd', 'l', 'l', 'l', 'r', 'r', 'd', 'x', 'd', 'l', 'l', 'r', 'r', 'r', 'd', 'l', 'l', 'l', 'l', 'x'}, 
        {'x', 'd', 'x', 'x', 'x', 'd', 'x', 'x', 'x', 'x', 'x', 'd', 'x', 'd', 'x', 'x', 'x', 'x', 'x', 'd', 'x', 'x', 'x', 'd', 'x'}, 
        {'x', 'd', 'x', '_', 'x', 'r', 'r', 'r', 'r', 'd', 'l', 'l', 'r', 'r', 'r', 'd', 'l', 'l', 'l', 'l', 'x', '_', 'x', 'd', 'x'}, 
        {'x', 'd', 'x', 'x', 'x', 'u', 'x', 'x', 'x', 'd', 'x', 'x', 'x', 'x', 'x', 'd', 'x', 'x', 'x', 'u', 'x', 'x', 'x', 'd', 'x'}, 
        {'x', 'r', 'r', 'r', 'r', 'u', 'x', '_', 'x', 'r', 'r', 'r', 'd', 'l', 'l', 'l', 'x', '_', 'x', 'u', 'l', 'l', 'l', 'l', 'x'}, 
        {'x', 'u', 'x', 'x', 'x', 'u', 'x', '_', 'x', 'u', 'x', 'x', 'd', 'x', 'x', 'u', 'x', '_', 'x', 'u', 'x', 'x', 'x', 'u', 'x'}, 
        {'x', 'u', 'x', '_', 'x', 'u', 'x', '_', 'x', 'u', 'x', 'r', 'l', 'l', 'x', 'u', 'x', '_', 'x', 'u', 'x', '_', 'x', 'u', 'x'}, 
        {'x', 'd', 'x', 'x', 'x', 'u', 'x', '_', 'x', 'u', 'x', 'x', 'x', 'x', 'x', 'u', 'x', '_', 'x', 'd', 'x', 'x', 'x', 'u', 'x'}, 
        {'x', 'r', 'r', 'r', 'r', 'd', 'x', '_', 'x', 'u', 'l', 'l', 'r', 'r', 'r', 'u', 'x', '_', 'x', 'd', 'l', 'l', 'l', 'l', 'x'}, 
        {'x', 'u', 'x', 'x', 'x', 'd', 'x', 'x', 'x', 'u', 'x', 'x', 'x', 'x', 'x', 'u', 'x', 'x', 'x', 'd', 'x', 'x', 'x', 'u', 'x'}, 
        {'x', 'u', 'x', '_', 'x', 'r', 'r', 'r', 'r', 'u', 'l', 'l', 'l', 'r', 'r', 'u', 'l', 'l', 'l', 'l', 'x', '_', 'x', 'u', 'x'}, 
        {'x', 'u', 'x', 'x', 'x', 'u', 'x', 'x', 'x', 'x', 'x', 'u', 'x', 'u', 'x', 'x', 'x', 'x', 'x', 'u', 'x', 'x', 'x', 'u', 'x'}, 
        {'x', 'r', 'r', 'r', 'r', 'u', 'r', 'r', 'r', 'r', 'r', 'u', 'x', 'u', 'l', 'l', 'l', 'l', 'l', 'u', 'l', 'l', 'l', 'u', 'x'}, 
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
    };
    
    private GreenfootImage img;
    
    public Ghost() {
        img = getImage();
        isScared = true;
        currDirection = "-";
    }
    
    public void doScareMode() {
        isScared = true;
        System.out.println(getX() + " " + getY());
        setImage("scared ghost.png");
        getImage().scale(30, 30);
   
        if (counter <= 0) {
            isScared = false;
            setImage(img);
        }
        else {
            //move("left");
            goHome();
        }
        counter--;
    }
    
    public void setImageDir(String dir) {
        // image does not change
    }
    
    public void goHome() {   
        if (isHorizontallyCentered() && isVerticallyCentered() || !canMove(currDirection)) {
            int centeredX = (int)((getX() - CELL_SIZE / 2) / CELL_SIZE);
            int centeredY = (int)((getY() - CELL_SIZE / 2) / CELL_SIZE);
            if (flowMap[centeredY][centeredX] == RIGHT) {
                currDirection = "right";
            }
            else if (flowMap[centeredY][centeredX] == LEFT) {
                currDirection = "left";
            }
            else if (flowMap[centeredY][centeredX] == UP) {
                currDirection = "up";
            }
            else if (flowMap[centeredY][centeredX] == DOWN) {
                currDirection = "down";
            }
            else {
                //do nothing because it has arrived at home
                //start pursuing the pacnyan
                currDirection = "-";
            }
        }
        
        if (canMove(currDirection)) {
            move(currDirection);
        }
    }
    
    public void setScared() {
        isScared = true;
        counter = 1000;
    }
    
    public boolean isScared() {
        return isScared;
    }
}
