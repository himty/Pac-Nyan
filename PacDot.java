import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PacDot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacDot extends GridActor
{
    public PacDot()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 890 , image.getHeight() - 670); //diff = 220
        setImage(image);
        
    }
    public boolean isEaten()
    {
        PacNyan pac = new PacNyan();
        if (pac.getLocation() == getLocation())
        {
            removeSelfFromGrid();
        }
    }
    /**
     * Act - do whatever the PacDot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
