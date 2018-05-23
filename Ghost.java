import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    
    private GreenfootImage img;
    
    public Ghost() {
        img = getImage();
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
}
