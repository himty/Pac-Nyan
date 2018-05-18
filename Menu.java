import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends Actor
{
    private int myWidth;
    private int myHeight;
    private int myScore;
    private int myLives;
    
    public Menu(int w, int h) {
        myWidth = w;
        myHeight = h;
        myScore = 0;
        myLives = 3;
        
        updateMenu();
    }
    
    private void updateMenu() {
        int fontSize = 24;
        Color textColor = new Color(50, 150, 50);
        String scoreStr = "Score: " + Integer.toString(myScore);
        String livesStr = "Lives: " + Integer.toString(myLives);
        GreenfootImage scoreImage = new GreenfootImage(scoreStr, fontSize, textColor, new Color(0, 0, 0, 0));
        GreenfootImage livesImage = new GreenfootImage(livesStr, fontSize, textColor, new Color(0, 0, 0, 0));
        
        GreenfootImage image = new GreenfootImage(myWidth, myHeight);
        Color outerColor = new Color(255, 255, 255);
        image.setColor(outerColor);
        image.fill();
        Color innerColor = new Color(120, 180, 255);
        image.setColor(innerColor);
        image.fillRect(fontSize/8, fontSize/8, image.getWidth()-fontSize/4, image.getHeight()-fontSize/4);
        image.drawImage(scoreImage, (int)(image.getWidth() * 0.05), (image.getHeight()-scoreImage.getHeight())/2);
        image.drawImage(livesImage, (int)(image.getWidth() * 0.95) - livesImage.getWidth(), (image.getHeight()-livesImage.getHeight())/2);
        setImage(image);
    }
    
    public void increaseScoreBy(int points) {
        myScore += points;
    }
    
    public void decreaseLives() {
        myLives--;
    }
    
    public int getScore() {
        return myScore;
    }
    
    public int getLives() {
        return myLives;
    }
}
