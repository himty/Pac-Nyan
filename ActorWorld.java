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
import greenfoot.GreenfootImage;
import greenfoot.World;
import greenfoot.Color;

import java.util.ArrayList;

/**
 * An <code>ActorWorld</code> is occupied by actors. <br />
 * This class is not tested on the AP CS A and AB exams.
 */

public class ActorWorld extends World
{
    private static final int DEFAULT_ROWS = 15;
    private static final int DEFAULT_COLS = 25;
    private static final int CELL_SIZE = 30;
    
    private final char WALL = 'x';
    private final char VOID = '_';
    private final char EMPTY = ' ';

    private final char[][] WALL_MAP = 
    {
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
        {'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x'}, 
        {'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', ' ', 'x'}, 
        {'x', ' ', 'x', '_', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', '_', 'x', ' ', 'x'}, 
        {'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', 'x', ' ', 'x'}, 
        {'x', ' ', ' ', ' ', ' ', ' ', 'x', '_', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', '_', 'x', ' ', ' ', ' ', ' ', ' ', 'x'}, 
        {'x', ' ', 'x', 'x', 'x', ' ', 'x', '_', 'x', ' ', 'x', 'x', ' ', 'x', 'x', ' ', 'x', '_', 'x', ' ', 'x', 'x', 'x', ' ', 'x'}, 
        {'x', ' ', 'x', '_', 'x', ' ', 'x', '_', 'x', ' ', 'x', ' ', ' ', ' ', 'x', ' ', 'x', '_', 'x', ' ', 'x', '_', 'x', ' ', 'x'}, 
        {'x', ' ', 'x', 'x', 'x', ' ', 'x', '_', 'x', ' ', 'x', ' ', ' ', ' ', 'x', ' ', 'x', '_', 'x', ' ', 'x', 'x', 'x', ' ', 'x'}, 
        {'x', ' ', ' ', ' ', ' ', ' ', 'x', '_', 'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', '_', 'x', ' ', ' ', ' ', ' ', ' ', 'x'}, 
        {'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', ' ', 'x', 'x', 'x', ' ', 'x'}, 
        {'x', ' ', 'x', '_', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', '_', 'x', ' ', 'x'}, 
        {'x', ' ', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', ' ', 'x'}, 
        {'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x'}, 
        {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
    };
    
    private final char[][] WALL_MAP_OLD = 
        {
            {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
            {'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x'},
            {'x', ' ', 'x', 'x', 'x', 'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', 'x', 'x', 'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', 'x', 'x', 'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', ' ', 'x'},
            {'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x'},
            {'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', ' ', ' ', ' ', 'x', 'x', 'x', ' ', 'x', ' ', 'x', ' ', 'x', ' ', 'x', 'x', 'x', ' ', ' ', ' ', 'x', 'x', 'x', 'x', ' ', 'x', ' ', 'x'},
            {'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x'},
            {'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x'},
            {'x', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', 'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x'},
            {'x', 'x', 'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x'},
            {'x', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x'},
            {'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x'},
            {'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x'},
            {'x', ' ', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', 'x', 'x', ' ', 'x'},
            {'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x'},
            {'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x'},
            {'x', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x'},
            {'x', 'x', 'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x'},
            {'x', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', 'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x'},
            {'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x'},
            {'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x'},
            {'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', ' ', ' ', ' ', 'x', 'x', 'x', ' ', 'x', ' ', 'x', ' ', 'x', ' ', 'x', 'x', 'x', ' ', ' ', ' ', 'x', 'x', 'x', 'x', ' ', 'x', ' ', 'x'},
            {'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'x'},
            {'x', ' ', 'x', 'x', 'x', 'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', 'x', 'x', 'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', 'x', 'x', 'x', ' ', 'x', ' ', 'x', 'x', 'x', 'x', ' ', 'x'},
            {'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x'},
            {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
        };

    private Grid<GridActor> grid;
    
    /**
     * Constructs an actor world with a default grid.
     */
    public ActorWorld()
    {
        super(DEFAULT_COLS, DEFAULT_ROWS, CELL_SIZE);
        paintGrid();
        grid = new BoundedGrid<GridActor>(this);
        initGameMap();
    }

    /**
     * Adds an actor to this world at a given location.
     * @param loc the location at which to add the actor
     * @param occupant the actor to add
     */
    public void add(Location loc, GridActor occupant)
    {
        occupant.putSelfInGrid(getGrid(), loc);
    }

    /**
     * Adds an occupant at a random location.
     * @param occupant the occupant to add
     */
    public void addRandom(GridActor occupant)
    {
        Location loc = getRandomEmptyLocation();
        if (loc != null)
            add(loc, occupant);
    }
    
    /**
     * Adds an occupant at a given location.
     * @param occupant the occupant to add
     */
    public void add(GridActor occupant, Location loc)
    {
        if (loc != null)
            add(loc, occupant);
    }

    /**
     * Removes an actor from this world.
     * @param loc the location from which to remove an actor
     * @return the removed actor, or null if there was no actor at the given
     * location.
     */
    public GridActor remove(Location loc)
    {
        GridActor occupant = getGrid().get(loc);
        if (occupant == null)
            return null;
        occupant.removeSelfFromGrid();
        return occupant;
    }

    /**
     * Gets a random empty location in this world.
     * @return a random empty location
     */
    public Location getRandomEmptyLocation()
    { 
        int rows = getHeight();
        int cols = getWidth();

        // get all valid empty locations and pick one at random
        ArrayList<Location> emptyLocs = new ArrayList<Location>();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
            {
                Location loc = new Location(i, j);
                if (grid.isValid(loc) && grid.get(loc) == null)
                    emptyLocs.add(loc);
            }
        if (emptyLocs.size() == 0)
            return null;
        int r = Greenfoot.getRandomNumber(emptyLocs.size());
        return emptyLocs.get(r);
    }
        
    /**
     * Greenfoot: Paint the grid pattern onto the background.
     */
    public Grid<GridActor> getGrid()
    {
        return grid;
    }
    
    /**
     * Greenfoot: Paint the grid pattern onto the background.
     */
    private void paintGrid()
    {
        GreenfootImage bg = getBackground();
        int cellSize = getCellSize();
        bg.setColor(Color.BLACK);
        for (int x = 0; x < bg.getWidth(); x += cellSize) {
            bg.drawLine(x, 0, x, bg.getHeight());
        }
        for (int y = 0; y < bg.getHeight(); y += cellSize) {
            bg.drawLine(0, y, bg.getWidth(), y);
        }
        setBackground(bg);
    }

    /**
     * This method contains the code from the 'BugRunner' class from the 
     * 'firstProject' example from the original version.
     */
    public void initGameMap() 
    {
        createWalls();
    }
    
    /**
     * Creates the walls in the map based off char[][] WALL_MAP
     */
    private void createWalls() {
        for (int row = 0; row < WALL_MAP.length; row++) {
            for(int col = 0; col < WALL_MAP[0].length; col++) {
                if (WALL_MAP[row][col] == WALL) {
                    add(new Wall(), new Location(row, col));
                }
                else if (WALL_MAP[row][col] == VOID) {
                    add(new Void(), new Location(row, col));
                }
                else if (WALL_MAP[row][col] == EMPTY) {
                    //do nothing
                }
            }
        }
    } 
}