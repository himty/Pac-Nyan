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
    
    private final char WALL = 'x';
    private final char VOID = '_';
    private final char BAR = '-';
    private final char EMPTY = ' ';
    private final char GHOST_RED = 'r';
    private final char GHOST_BLUE = 'b';
    private final char GHOST_YELLOW = 'y';
    private final char GHOST_PINK = 'p';
    private final char PACNYAN = 'A';

    private char[][] myMap;
    
    private ArrayList<Actor> actors;
    
    /**
     * Constructs an actor world with a default grid.
     */
    public ActorWorld()
    {
       super(DEFAULT_COLS, DEFAULT_ROWS, 1);
        
       myMap = new char[][] {
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x'}, 
                {'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', ' ', 'x'}, 
                {'x', ' ', 'x', '_', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', '_', 'x', ' ', 'x'}, 
                {'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', 'x', ' ', 'x'}, 
                {'x', ' ', ' ', ' ', ' ', ' ', 'x', '_', 'x', ' ', ' ', ' ', 'r', ' ', ' ', ' ', 'x', '_', 'x', ' ', ' ', ' ', ' ', ' ', 'x'}, 
                {'x', ' ', 'x', 'x', 'x', ' ', 'x', '_', 'x', ' ', 'x', 'x', '-', 'x', 'x', ' ', 'x', '_', 'x', ' ', 'x', 'x', 'x', ' ', 'x'}, 
                {'x', ' ', 'x', '_', 'x', ' ', 'x', '_', 'x', ' ', 'x', 'b', 'y', 'p', 'x', ' ', 'x', '_', 'x', ' ', 'x', '_', 'x', ' ', 'x'}, 
                {'x', ' ', 'x', 'x', 'x', ' ', 'x', '_', 'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', '_', 'x', ' ', 'x', 'x', 'x', ' ', 'x'}, 
                {'x', ' ', ' ', ' ', ' ', ' ', 'x', '_', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', '_', 'x', ' ', ' ', ' ', ' ', ' ', 'x'}, 
                {'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', 'x', ' ', 'x'}, 
                {'x', ' ', 'x', '_', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'A', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', '_', 'x', ' ', 'x'}, 
                {'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', ' ', 'x'}, 
                {'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x'}, 
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
            };
        
       actors = new ArrayList<Actor>();
        
       setBackground(new GreenfootImage("rainbow_background.png"));
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
     * This method contains the code from the 'BugRunner' class from the 
     * 'firstProject' example from the original version.
     */
    public void initGameMap() 
    {
        initSpots();
    }
    
    /**
     * Creates the walls in the map based off char[][] WALL_MAP
     */
    private void initSpots() {
        for (int row = 0; row < myMap.length; row++) {
            for(int col = 0; col < myMap[0].length; col++) {
                int temprow = (int)(row * CELL_SIZE + CELL_SIZE * 0.5);
                int tempcol = (int)(col * CELL_SIZE + CELL_SIZE * 0.5);
                
                if (myMap[row][col] == WALL) {
                    add(new Wall(), new Location(temprow, tempcol));
                }
                else if (myMap[row][col] == VOID) {
                    add(new Void(), new Location(temprow, tempcol));
                }
                else if (myMap[row][col] == BAR) {
                    add(new Bar(), new Location(temprow, tempcol));
                }
                else if (myMap[row][col] == EMPTY) {
                    //do nothing
                } else if (myMap[row][col] == GHOST_RED) {
                    add(new Blinky(), new Location(temprow, tempcol));
                } else if (myMap[row][col] == GHOST_BLUE) {
                    add(new Inky(), new Location(temprow, tempcol));
                } else if (myMap[row][col] == GHOST_YELLOW) {
                    add(new Clyde(), new Location(temprow, tempcol));
                } else if (myMap[row][col] == GHOST_PINK) {
                    add(new Pinky(), new Location(temprow, tempcol));
                } else if (myMap[row][col] == PACNYAN) {
                    add(new PacNyan(), new Location(temprow, tempcol));
                }
            }
        }
    } 
    
    public boolean isWallAtLoc(Location loc) {
        return myMap[loc.getRow()][loc.getCol()] == WALL;
    }
}