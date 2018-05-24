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
     * scales pacdot image
     */
    public void act() 
    {
        getImage().scale( 7,7);
    }    
    public boolean isEaten()
    {
       return getWorld().getObjectsAt(0, 0, PacDot.class).isEmpty();
    }
}
