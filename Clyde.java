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
    /**
     * Number of steps to left to take before making a decision to turn
     */
    private int numMoreSteps;
    
    /**
     * The maximum number of steps Clyde can take before making a decision
     * to turn or not to turn
     */
    private final static int INDECICITIVITY = 2;
    
    public Clyde() {
        getImage().scale(30, 30);
        numMoreSteps = (int)(Math.random() * INDECICITIVITY);
    }
    /**
     * Act - do whatever the Clyde wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        /*
            //turn left, turn right, or keep going straight?
            double rand = Math.random();
            if(rand < 0.2) {
               if(!hasWallOnLeft()) {
                    turnLeft();
                }
                else if(!hasWallOnRight()) {
                    turnRight();
                }
            }
            else if (rand > 0.8 || hasWallInFront()) {
                if(!hasWallOnRight()) {
                    turnRight();
                }
                else if (!hasWallOnLeft()){
                    turnLeft();
                }
            }                 
        move(1);
        */
    } 
    
    public void turnLeft() {
        setRotation(getRotation() + 270);
        getImage().rotate(90);
    }
    
    public void turnRight() {
        setRotation(getRotation() + 90);
        getImage().rotate(270);
    }
    
    public void turnAround() {
        setRotation(getRotation() + 180);
        getImage().rotate(180);
    }
    
    public boolean hasWallInFront() {
           return (getRotation() == 0 && getOneObjectAtOffset(1, 0, Wall.class) != null)
                || (getRotation() == 90 && getOneObjectAtOffset(0, 1, Wall.class) != null)
                || (getRotation() == 180 && getOneObjectAtOffset(-1, 0, Wall.class) != null)
                || (getRotation() == 270 && getOneObjectAtOffset(0, -1, Wall.class) != null);
    }
    
    public boolean hasWallOnLeft() {
           return (getRotation() == 0 && getOneObjectAtOffset(0, -1, Wall.class) != null)
                || (getRotation() == 90 && getOneObjectAtOffset(1, 0, Wall.class) != null)
                || (getRotation() == 180 && getOneObjectAtOffset(0, 1, Wall.class) != null)
                || (getRotation() == 270 && getOneObjectAtOffset(-1, 0, Wall.class) != null);
    }
    
    public boolean hasWallOnRight() {
           return (getRotation() == 0 && getOneObjectAtOffset(0, 1, Wall.class) != null)
                || (getRotation() == 90 && getOneObjectAtOffset(-1, 0, Wall.class) != null)
                || (getRotation() == 180 && getOneObjectAtOffset(0, -1, Wall.class) != null)
                || (getRotation() == 270 && getOneObjectAtOffset(1, 0, Wall.class) != null);
    }
}
