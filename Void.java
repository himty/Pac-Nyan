import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Void here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Void extends Actor
{
    private static final int DEFAULT_SIZE = 30;
    private Color myColor;
    
    public Void() {
        getImage().scale(DEFAULT_SIZE, DEFAULT_SIZE);
        myColor = new Color(156, 223, 252);
    }
    
    /**
     * Act - do whatever the Void wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    /**
     * Overrides getImage so that setting the color will change the image.
     * @return    the Greenfoot image of this actor.
     */
    public GreenfootImage getImage()
    {
        return ColoredImage.getImage(this, super.getImage(), myColor);
    }
}
