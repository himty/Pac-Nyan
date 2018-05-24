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

/*
 * Slightly modified for use in Greenfoot.
 * @author Michael Kolling
 */

import greenfoot.Greenfoot;
import greenfoot.*;

import java.util.ArrayList;

/**
 * An <code>ActorWorld</code> is occupied by actors. <br />
 * This class is not tested on the AP CS A and AB exams.
 */

public class ActorWorld extends World
{
    private static final int DEFAULT_ROWS = 450;
    private static final int DEFAULT_COLS = 750;
    private static final int CELL_SIZE = 30;
    private static final int WIDTH = DEFAULT_COLS * CELL_SIZE;
    private static final int HEIGHT = DEFAULT_ROWS * CELL_SIZE;
    private static final int MENU_HEIGHT = 45;
    
    private final char WALL = 'x';
    private final char VOID = '_';
    private final char PACDOT = 'o';
    private final char POWERPELLET = 'G';
    private final char BAR = '-';
    private final char EMPTY = ' ';
    private final char GHOST_RED = 'r';
    private final char GHOST_BLUE = 'b';
    private final char GHOST_YELLOW = 'y';
    private final char GHOST_PINK = 'p';
    private final char PACNYAN = 'A';

    private char[][] myMap;
    private Menu myMenu;
    
    private ArrayList<Actor> actors;
    
    /**
     * Constructs an actor world with a default grid.
     */
    public ActorWorld()
    {
        super(DEFAULT_COLS, DEFAULT_ROWS + MENU_HEIGHT, 1);
        myMap = new char[][]
       {
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
        {'x', 'G', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'G', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'G', 'x'}, 
        {'x', 'o', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'o', 'x'}, 
        {'x', 'o', 'x', '_', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', '_', 'x', 'o', 'x'}, 
        {'x', 'o', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'o', 'x'}, 
        {'x', 'o', 'o', 'o', 'o', 'o', 'x', '_', 'x', 'o', 'o', 'o', 'r', 'o', 'o', 'o', 'x', '_', 'x', 'o', 'o', 'o', 'o', 'o', 'x'}, 
        {'x', 'o', 'x', 'x', 'x', 'o', 'x', '_', 'x', 'o', 'x', 'x', '-', 'x', 'x', 'o', 'x', '_', 'x', 'o', 'x', 'x', 'x', 'o', 'x'}, 
        {'x', 'o', 'x', '_', 'x', 'o', 'x', '_', 'x', 'o', 'x', 'b', 'y', 'p', 'x', 'o', 'x', '_', 'x', 'o', 'x', '_', 'x', 'o', 'x'}, 
        {'x', 'o', 'x', 'x', 'x', 'o', 'x', '_', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', '_', 'x', 'o', 'x', 'x', 'x', 'o', 'x'}, 
        {'x', 'o', 'o', 'o', 'o', 'o', 'x', '_', 'x', 'o', 'o', 'G', 'x', 'G', 'o', 'o', 'x', '_', 'x', 'o', 'o', 'o', 'o', 'o', 'x'}, 
        {'x', 'o', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'o', 'x'}, 
        {'x', 'o', 'x', '_', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'A', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', '_', 'x', 'o', 'x'}, 
        {'x', 'o', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'o', 'x'}, 
        {'x', 'G', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'G', 'x', 'G', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'G', 'x'}, 
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
    };
        
       actors = new ArrayList<Actor>();
       setPaintOrder(PacNyan.class, Blinky.class, Inky.class, Pinky.class, Clyde.class, Wall.class, Void.class);
        
       setBackground(new GreenfootImage("rainbow_background.png"));
       myMenu = new Menu(DEFAULT_COLS, MENU_HEIGHT);
       add(myMenu, new Location(myMap.length * CELL_SIZE + MENU_HEIGHT / 2, myMap[0].length * CELL_SIZE / 2));
       initGameMap();
       Greenfoot.setSpeed(60);
       Greenfoot.start();
    }

    /**
     * Adds an actor to this world at a given location.
     * @param loc the location at which to add the actor
     * @param occupant the actor to add
     */
    public void add(Location loc, Actor occupant)
    {
        addObject(occupant, loc.getCol(), loc.getRow());
        occupant.setLocation(loc.getCol(), loc.getRow());
    }
    
    /**
     * Adds an occupant at a given location.
     * @param occupant the occupant to add
     */
    public void add(Actor occupant, Location loc)
    {
        if (loc != null)
            add(loc, occupant);
    }

    /**
     * Creates the walls in the map based off char[][] WALL_MAP
     */
    private void initGameMap() {        
        for (int row = 0; row < myMap.length; row++) {
            for(int col = 0; col < myMap[0].length; col++) {
                int tempRow = (int)(row * CELL_SIZE + CELL_SIZE * 0.5);
                int tempCol = (int)(col * CELL_SIZE + CELL_SIZE * 0.5);
                
                if (myMap[row][col] == WALL) {
                    add(new Wall(), new Location(tempRow, tempCol));
                }
                else if (myMap[row][col] == VOID) {
                    add(new Void(), new Location(tempRow, tempCol));
                }
                else if (myMap[row][col] == BAR) {
                    add(new Bar(), new Location(tempRow, tempCol));
                }
                else if (myMap[row][col] == EMPTY) {
                    //do nothing
                } else if (myMap[row][col] == GHOST_RED) {
                    add(new Blinky(), new Location(tempRow, tempCol));
                } else if (myMap[row][col] == GHOST_BLUE) {
                    add(new Inky(), new Location(tempRow, tempCol));
                } else if (myMap[row][col] == GHOST_YELLOW) {
                    add(new Clyde(), new Location(tempRow, tempCol));
                } else if (myMap[row][col] == GHOST_PINK) {
                    add(new Pinky(), new Location(tempRow, tempCol));
                } else if (myMap[row][col] == PACNYAN) {
                    add(new PacNyan(), new Location(tempRow, tempCol));
                } else if (myMap[row][col] == PACDOT) {
                    add(new PacDot(), new Location(tempRow, tempCol));
                } else if (myMap[row][col] == POWERPELLET) {
                    add (new PowerPellet(), new Location(tempRow, tempCol));
                }
            }
        }
    } 
    
    public boolean isWallAtLoc(Location loc) {
        return myMap[loc.getRow()][loc.getCol()] == WALL;
    }
    
    public Menu getMenu(){
        return myMenu;
    }
    
    public void resetGhost(Ghost g) {
        g.setLocation(375, 165);
    }
    
    public void resetWorld() {
        removeObjects(getObjects(Wall.class));
        removeObjects(getObjects(Void.class));
        removeObjects(getObjects(Blinky.class));
        removeObjects(getObjects(Inky.class));
        removeObjects(getObjects(Pinky.class));
        removeObjects(getObjects(Clyde.class));
        removeObjects(getObjects(Bar.class));
        removeObjects(getObjects(PacNyan.class));
        removeObjects(getObjects(PacDot.class));
        removeObjects(getObjects(PowerPellet.class));
        initGameMap();
    }
}
