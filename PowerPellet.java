import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerPellet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerPellet extends GridActor
{
    public PowerPellet()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - (120*8) , image.getHeight() - (120*6));//diff = 60
        setImage(image);
    }
    /**
     * Act - do whatever the PowerPellet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
