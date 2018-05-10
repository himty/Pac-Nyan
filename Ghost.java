import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ghost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends Actor
{
    private boolean isMovingLeft = true;
    
    /**
     * Act - do whatever the Ghost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
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
    
    private GreenfootImage getReverseImage(GreenfootImage img) {
        int w = img.getWidth(), h = img.getHeight();
        GreenfootImage image = new GreenfootImage(w, h);
        for (int y=0; y<h; y++) for (int x=1; x<=w; x++)
            image.setColorAt(w-x, y, img.getColorAt(x-1, y));
        return image;
    }
}
