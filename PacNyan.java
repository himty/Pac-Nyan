import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PacNyan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.Color;
public class PacNyan extends GridActor
{
    public PacNyan()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 213 , image.getHeight() - 275);//diff = 60
        setImage(image);
        
    }
    /**
     * Act - do whatever the PacNyan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
