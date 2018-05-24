import java.util.List;

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
    private int pacX;
    private int pacY;
    private String currDirection;
    private boolean isFollowingPacNyan;
    
    public Inky() {
        getImage().scale(30, 30);
        homeX = 375;
        homeY = 225;
        currDirection = "-";
        isFollowingPacNyan = true;
        
        //to not mess up calculations
        pacX = Integer.MAX_VALUE;
        pacY = Integer.MAX_VALUE;
    }
    
    /**
     * Act - do whatever the Inky wants to do. This method is called whenever
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
                pacX = pac.getX();
                pacY = pac.getY();
            }
        
            if (isFollowingPacNyan
                    && (getX() - pacX) * (getX() - pacX) + (getY() - pacY) * (getY() - pacY) > 15000) {
                followPacNyan();
            }
            else if (isFollowingPacNyan) {
                // too close to the PacNyan
                if (Math.random() < 0.005) {
                    isFollowingPacNyan = false;
                    goHome();
                }
                else {
                    followPacNyan();
                }
            } else {
                if(getX() == homeX && getY() == homeY) {
                    isFollowingPacNyan = true;
                    followPacNyan();
                }
                else {
                    goHome();
                }
            }
        }
    }   
    
    private void followPacNyan() {
        if (getX() <= pacX) {
            //Pinky is on the left. Close in on the pacNyan
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
