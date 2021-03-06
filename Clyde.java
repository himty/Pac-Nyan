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
   private int startTime;

    public Clyde() {
        getImage().scale(CELL_SIZE, CELL_SIZE);
        currDirectionStr = "left";
        currDirection = 1;
        startTime = 100;
    }
    
    /**
     * Act - do whatever the Clyde wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (startTime > 0) {
            startTime--;
        }
        else {
            if (isScared()) {
                doScareMode();
            }
            else {
                if (counter == 0 || !canMove(currDirectionStr)) {
                    counter = CELL_SIZE * 4;
                    prevDirection = currDirection;
                    do {
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
                }
                
                if (canMove(currDirectionStr)) {
                    move(currDirectionStr);
                }
                counter--;
            } 
        }
    }
}
