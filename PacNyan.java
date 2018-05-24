import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PacNyan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.Color;
public class PacNyan extends MazeActor
{
   private GreenfootImage img;
       
    private String lastKey; // last key pressed
    private String queuedKey; // last key that was unsuccessfully pressed
                              // (there was a wall in that direction)
    private String currDirection;
    
    private static final int EAST = 90;
    private static final int SOUTH = 180;
    private static final int WEST = 270;
    private static final int NORTH = 0;
    
    private static final int WIDTH = 40;
    private static final int HEIGHT = 46;
    private static final int CELL_SIZE = 30;
    private int points;
    private int ghostTimer;
    
    public PacNyan()
    {
        img = getImage();
        img.scale(WIDTH, HEIGHT);
        
        lastKey = "-";
        queuedKey = lastKey;
        currDirection = lastKey;
        points = 0;
        ghostTimer = 0;
    }
    
    /**
     * Act - do whatever the PacNyan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("up"))
        {           
            lastKey = "up";
        }
        else if(Greenfoot.isKeyDown("right"))
        {            
            lastKey = "right";
        }
        else if(Greenfoot.isKeyDown("down"))
        {            
            lastKey = "down";
        }
        else if(Greenfoot.isKeyDown("left"))
        {         
            lastKey = "left";
        }        
                    
        if (canMove(queuedKey))
        {
            currDirection = queuedKey;
            lastKey = queuedKey;
            setImageDir(queuedKey);
            move(queuedKey);
            queuedKey = "-";
        }
        else if (canMove(lastKey)) {
            currDirection = lastKey;
            setImageDir(lastKey);
            move(lastKey);
        }
        else {
            if (canMove(currDirection)) {
                move(currDirection);
            }
            //couldn't move at all
            if (lastKey != currDirection) {
                 queuedKey = lastKey;
            }
        }
        if (getWorld().getObjects(Fruit.class).isEmpty()){generateFruit();}
        eat();
    }
    public void generateFruit()
    {
        Actor fruit = new Fruit();
        int[] genPtRow = new int[]
        {5, 9, 15, 19, 23}; 
        int[] genPtCol = new int[]
        {1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        int randoX = genPtRow[(int)(Math.random() * (genPtRow.length - 1))];
        int randoY = genPtCol[(int)(Math.random() * (genPtCol.length - 1))];
        if(getWorld().getObjects(Fruit.class).isEmpty() && Greenfoot.getRandomNumber(10000) > 9997) 
        {
            getWorld().addObject(fruit, randoX, randoY);
            fruit.setLocation(getX(), getY() - 10);
        }
    }
    public void eat()
    {
        Actor dot = getOneObjectAtOffset(0,0, PacDot.class); 
        Actor powa = getOneObjectAtOffset(0,0, PowerPellet.class); 
        Actor fruit = getOneObjectAtOffset(0,0, Fruit.class);
        
        if (dot != null)
        {
            getWorld().removeObject(dot);
            points += 10;
        }
        else if (powa != null)
        {
            getWorld().removeObject(powa);
            // turnOnScareMode();
            // ghostTimer = 0;
            points += 50;
        }
        else if (fruit != null)
        {
            getWorld().removeObject(fruit);
            points += 100;
        }
    }
    public int getTotalPoints()
    {
        return points;
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
    
    public String getDirection() {
        return currDirection;
    }
}
