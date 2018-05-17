import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Clyde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clyde extends Ghost
{        
   private static final int CELL_SIZE = 30;
   private int counter;
   private int currDirection;
   private String currDirectionStr;
   private int prevDirection;

    public Clyde() {
        getImage().scale(CELL_SIZE, CELL_SIZE);
        currDirectionStr = "left";
        currDirection = 1;
    }
    
    /**
     * Act - do whatever the Clyde wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (counter == 0 || !canMove(currDirectionStr)) {
            System.out.println("x: " + getX() + " y: " + getY());
            counter = CELL_SIZE * 4;
            prevDirection = currDirection;
            do {
                System.out.println(currDirectionStr + "?");
                currDirection = (int)(Math.random() * 10);
                if (currDirection == 0) {
                    currDirectionStr = "up";
                }
                else if (currDirection == 1) {
                    currDirectionStr = "left";
                }
                else if (currDirection == 2) {
                    currDirectionStr = "down";
                }
                else if (currDirection == 3) {
                    currDirectionStr = "right";
                }
            } while (!canMove(currDirectionStr));
            System.out.println("picked " + currDirectionStr);
        }
        
        if (canMove(currDirectionStr)) {
            move(currDirectionStr);
        }
        counter--;
    } 
}
