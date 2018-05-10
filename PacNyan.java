import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PacNyan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.Color;
public class PacNyan extends Actor
{
    private boolean isMovingLeft = true;
    int counter = 50;
    
    public PacNyan()
    {
        getImage().scale(48, 36);
    }
    /**
     * Act - do whatever the PacNyan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (counter > 0) {
            moveLeft();
            
        }
        else if (counter > -50){
            moveRight();
        }
        else if (counter > -100) {
            moveUp();
        }
        else if (counter > -150) {
            moveDown();
        }
        counter--;
    }    
    
    public void moveLeft() {
        setLocation(getX() - 1, getY());
        
        //flip the image
        if(!isMovingLeft) {
            setImage(getReverseImage(getImage()));
            isMovingLeft = true;
        }
    }
    
    public void moveRight() {
        setLocation(getX() + 1, getY());
        
        //flip the image
        if(isMovingLeft) {
            setImage(getReverseImage(getImage()));
            isMovingLeft = false;
        }
    }
    
    public void moveUp() {
        setLocation(getX(), getY() - 1);
    }
    
    public void moveDown() {
        setLocation(getX(), getY() + 1);
    }
    
    public GreenfootImage getReverseImage(GreenfootImage img) {
        int w = img.getWidth(), h = img.getHeight();
        GreenfootImage image = new GreenfootImage(w, h);
        for (int y=0; y<h; y++) for (int x=1; x<=w; x++)
            image.setColorAt(w-x, y, img.getColorAt(x-1, y));
        return image;
    }
}