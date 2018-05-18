import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inky extends Ghost
{
    private static final int CELL_SIZE = 30;
    private int homeX;
    private int homeY;
    private String currDirection;
    
    private final char LEFT = 'l';
    private final char RIGHT = 'r';
    private final char UP = 'u';
    private final char DOWN = 'd';
    private final char[][] flowMap = 
    {
            {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
            {'x', 'r', 'r', 'r', 'r', 'd', 'l', 'l', 'l', 'r', 'r', 'd', 'x', 'd', 'l', 'l', 'r', 'r', 'r', 'd', 'l', 'l', 'l', 'l', 'x'}, 
            {'x', 'd', 'x', 'x', 'x', 'd', 'x', 'x', 'x', 'x', 'x', 'd', 'x', 'd', 'x', 'x', 'x', 'x', 'x', 'd', 'x', 'x', 'x', 'd', 'x'}, 
            {'x', 'd', 'x', '_', 'x', 'r', 'r', 'r', 'r', 'd', 'l', 'l', 'r', 'r', 'r', 'd', 'l', 'l', 'l', 'l', 'x', '_', 'x', 'd', 'x'}, 
            {'x', 'd', 'x', 'x', 'x', 'u', 'x', 'x', 'x', 'd', 'x', 'x', 'x', 'x', 'x', 'd', 'x', 'x', 'x', 'u', 'x', 'x', 'x', 'd', 'x'}, 
            {'x', 'r', 'r', 'r', 'r', 'u', 'x', '_', 'x', 'r', 'r', 'r', ' ', 'l', 'l', 'l', 'x', '_', 'x', 'u', 'l', 'l', 'l', 'l', 'x'}, 
            {'x', 'u', 'x', 'x', 'x', 'u', 'x', '_', 'x', 'u', 'x', 'x', 'u', 'x', 'x', 'u', 'x', '_', 'x', 'u', 'x', 'x', 'x', 'u', 'x'}, 
            {'x', 'u', 'x', '_', 'x', 'u', 'x', '_', 'x', 'u', 'x', 'r', 'u', 'l', 'x', 'u', 'x', '_', 'x', 'u', 'x', '_', 'x', 'u', 'x'}, 
            {'x', 'd', 'x', 'x', 'x', 'u', 'x', '_', 'x', 'u', 'x', 'x', 'x', 'x', 'x', 'u', 'x', '_', 'x', 'd', 'x', 'x', 'x', 'u', 'x'}, 
            {'x', 'r', 'r', 'r', 'r', 'd', 'x', '_', 'x', 'u', 'l', 'l', 'r', 'r', 'r', 'u', 'x', '_', 'x', 'd', 'l', 'l', 'l', 'l', 'x'}, 
            {'x', 'u', 'x', 'x', 'x', 'd', 'x', 'x', 'x', 'u', 'x', 'x', 'x', 'x', 'x', 'u', 'x', 'x', 'x', 'd', 'x', 'x', 'x', 'u', 'x'}, 
            {'x', 'u', 'x', '_', 'x', 'r', 'r', 'r', 'r', 'u', 'l', 'l', 'l', 'r', 'r', 'u', 'l', 'l', 'l', 'l', 'x', '_', 'x', 'u', 'x'}, 
            {'x', 'u', 'x', 'x', 'x', 'u', 'x', 'x', 'x', 'x', 'x', 'u', 'x', 'u', 'x', 'x', 'x', 'x', 'x', 'u', 'x', 'x', 'x', 'u', 'x'}, 
            {'x', 'r', 'r', 'r', 'r', 'u', 'r', 'r', 'r', 'r', 'r', 'u', 'x', 'u', 'l', 'l', 'l', 'l', 'l', 'u', 'l', 'l', 'l', 'u', 'x'}, 
            {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
        };
    
    public Inky() {
        getImage().scale(30, 30);
        homeX = 345;
        homeY = 225;
        currDirection = "-";
    }
    
    /**
     * Act - do whatever the Inky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        goHome();
        // Add your action code here.
    }   
    
    private void goHome() {        
        if (isHorizontallyCentered() && isVerticallyCentered()) {
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
            else if (flowMap[centeredY][centeredX] == ' ') {
                //do nothing because it has arrived at home
                //start pursuing the pacnyan
                currDirection = "-";
            }
        }
        
        if (canMove(currDirection)) {
            move(currDirection);
        }
    }
    
    public void getCoords() {
        int myX = (int)(getX() / CELL_SIZE) * CELL_SIZE + CELL_SIZE / 2;
        int myY = (int)(getY() / CELL_SIZE) * CELL_SIZE + CELL_SIZE / 2;
        System.out.println("x: " + myX + " y: " + myY);
    }
}
