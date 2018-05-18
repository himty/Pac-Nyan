import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PacDot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacDot extends Food
{
    public PacDot()
    {
    }
    /**
     * Act - do whatever the PacDot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getImage().scale( 40,30);
    }    
    public boolean isEaten()
    {
       return getWorld().getObjectsAt(0, 0, PacNyan.class).isEmpty();
    }
}
