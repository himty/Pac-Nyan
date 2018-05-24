import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fruit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fruit extends Food
{
    private int time;
    public Fruit()
    {
        time = 0;
    }
    /**
     * Act - do whatever the Fruit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getImage().scale( 30,30);
        if ( time == 900 ) 
        {
            getWorld().removeObject(this);
        }
        else
        {
            time++;
        }
    }    
}
