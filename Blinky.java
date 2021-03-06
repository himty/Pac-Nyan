import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Blinky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blinky extends Ghost
{
    private String currDirection;
    private static final int CELL_SIZE = 30;
        
    public Blinky() {
        getImage().scale(30, 30);
        currDirection = "-";
    }
    
    /**
     * Act - do whatever the Blinky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isScared()) {
            doScareMode();
        }
        else {
            List<PacNyan> list = getWorld().getObjects(PacNyan.class);
            if (list.size() > 0) {
                PacNyan pac = list.get(0);
                int pacX = pac.getX();
                int pacY = pac.getY();
                String pacDir = pac.getDirection();
                if (Math.abs(pacX - getX()) > CELL_SIZE 
                    && Math.abs(pacY - getY()) > CELL_SIZE) {    
                    if (pacDir.equals("left")) {
                        pacX += CELL_SIZE;
                    }
                    if (pacDir.equals("right")) {
                        pacX -= CELL_SIZE;
                    }
                    if (pacDir.equals("up")) {
                        pacY += CELL_SIZE;
                    }
                    if (pacDir.equals("down")) {
                        pacY -= CELL_SIZE;
                    }
                }
    
                if (getX() <= pacX) {
                    //Blinky is on the left. Close in on the pacNyan
                    if (getY() < pacY && canMove("down")) {
                        currDirection = "down";
                    }
                    else if (getY() > pacY && canMove("up")) {
                        currDirection = "up";
                    }
                    else if (canMove("right")){
                        currDirection = "right";
                    }
                    else {
                        //if this is a dead end
                        currDirection = "left";
                    }
                }
                else {
                    //Pinky is on the right. keep going left
                    if (canMove("left")) {
                        currDirection = "left";
                    }
                    else if (getY() < pacY && canMove("down")) {
                        currDirection = "down";
                    }
                    else if (getY() > pacY && canMove("up")) {
                        currDirection = "up";
                    }
                    else {
                        //if this is a dead end
                        currDirection = "right";
                    }
                }
    
                if (canMove(currDirection)) {
                    move(currDirection);
                }
            }
        }
    }    
}
