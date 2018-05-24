import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Pinky is a ghost that tries to ambush the PacNyan
 * 
 * @author Jenny Wang
 * @version (a version number or a date)
 */
public class Pinky extends Ghost
{
    private String currDirection;
    
    public Pinky() {
        getImage().scale(30, 30);
        currDirection = "-";
    }
    
    /**
     * Act - do whatever the Pinky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        List<PacNyan> list = getWorld().getObjects(PacNyan.class);
        if (list.size() > 0) {
            PacNyan pac = list.get(0);
            int pacX = pac.getX();
            int pacY = pac.getY();
            String pacDir = pac.getDirection();

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
}
