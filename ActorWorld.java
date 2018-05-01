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
    private static final int DEFAULT_ROWS = 30;
    private static final int DEFAULT_COLS = 30;
    private static final int CELL_SIZE = 20;

    private Grid<GridActor> grid;
    
    /**
     * Constructs an actor world with a default grid.
     */
    public ActorWorld()
    {
        super(DEFAULT_ROWS, DEFAULT_COLS, CELL_SIZE);
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
        placeRockBoundary();
        
        placeRockT(new Location(4, 4));
    }
    
    /**
     * Initializes Rocks that surround the outside perimeter of the maze
     */
    private void placeRockBoundary() {
        for (int x = 0; x < grid.getNumCols(); x++) {
            add(new Rock(), new Location(0, x));
            add(new Rock(), new Location(grid.getNumRows() - 1, x));
        }
        
        for(int y = 1; y < grid.getNumRows() - 1; y++) {
            add(new Rock(), new Location(y, 0));
            add(new Rock(), new Location(y, grid.getNumCols() - 1));
        }
    }
    
    /**
     * Initializes Rocks that form a right-side-up T-shape with the bottom
     * of the T at Location loc
     * @parameter loc   the location of the bottom of the T
     */
    private void placeRockT(Location loc) {
        int[] rowMap = {-2, -2, -2, -1, 0};
        int[] colMap = {-1,  0,  1,  0, 0};
        
        for(int i = 0; i < rowMap.length; i++) {
            add(new Rock(), new Location(loc.getRow() + rowMap[i],
                                    loc.getCol() + colMap[i]));
        }
    }
    
    
}