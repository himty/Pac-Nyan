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
        homeX = 375;
        homeY = 165;
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
    
    private void followPacNyan() {
        List<PacNyan> list = getWorld().getObjects(PacNyan.class);
        if (list.size() > 0) {
            PacNyan pac = list.get(0);
            pacX = pac.getXCoord();
            pacY = pac.getYCoord();

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
    
    private void goHome() {   
        List<PacNyan> list = getWorld().getObjects(PacNyan.class);
        if (list.size() > 0) {
            PacNyan pac = list.get(0);
            pacX = pac.getXCoord();
            pacY = pac.getYCoord();
        }
    	
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
}
