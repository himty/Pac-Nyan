/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

import greenfoot.*;



/**
 * A <code>Rock</code> is an actor that does nothing. It is commonly used to
 * block other actors from moving. <br />
 * The API of this class is testable on the AP CS A and AB exams.
 */

public class Bar extends Actor
{
    private static final int DEFAULT_SIZE = 30;
    private Color myColor;

    /**
     * Constructs a black rock.
     */
    public Bar()
    {
        getImage().scale(DEFAULT_SIZE, DEFAULT_SIZE);
        //getImage().scale(DEFAULT_SIZE, DEFAULT_SIZE);
        //setColor(DEFAULT_COLOR);
    }

    /**
     * Overrides the <code>act</code> method in the <code>Actor</code> class
     * to do nothing.
     */
    public void act()
    {
        
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
