import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Write a description of class JUnitPacNyanTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JUnitPacNyanTest  
{
	// -- Test ActorWorld
	/**
	 * ActorWorld Tests:
	 * - 
	 */
	
	// -- Test Bar
	/**
	 * Bar Tests:
	 * - 
	 */
	
	// -- Test Blinky
	/**
	 * Blinky Tests:
	 * - 
	 */
	
	// -- Test Clyde
	/**
	 * Clyde Tests:
	 * - 
	 */

	// -- Test Food
	/**
	 * Food Tests:
	 * - FoodConstructor - constructs Food and checks if it's not null
	 */
	
	@Test
	public void FoodConstructor() {
		Food f = new Food();
		
		assertTrue("<< Invalid Food Constructor >>",
				f != null);
	}
	
	// -- Test Ghost
	/**
	 * Ghost Tests:
	 * - GhostConstructor - constructs Ghost and checks if it's not null
	 * - GhostScareMode - TODO
	 */
	
	@Test
	public void GhostConstructor() {
		Ghost g = new Ghost();
		
		assertTrue("<< Invalid Ghost Constructor >>",
				g != null);
	}
	
	// -- Test Inky
	/**
	 * Inky Tests:
	 * - 
	 */
	
	// -- Test MazeActor
	/**
	 * MazeActor Tests:
	 * - 
	 */
	
	// -- Test Menu
	/**
	 * Menu Tests:
	 * - 
	 */
	
	// -- Test PacDot
	/**
	 * PacDot Tests:
	 * - 
	 */
	
	// -- Test PacNyan
	/**
	 * PacNyan Tests:
	 * - PacNyanConstructor - constructs PacNyan and then compare variable values
	 * - PacNyanDoesntMove - compares x and y coordinates when its directions are "-"
	 * - PacNyanSetImageUp - compares image rotation value with given number
	 * - PacNyanSetImageDown - compares image rotation value with given number
	 * - PacNyanSetImageRight - compares image rotation value with given number
	 * - PacNyanSetImageLeft - compares image rotation value with given number
	 * - PacNyanEatPacDot - TODO
	 * - PacNyanEatPowerPellet - TODO
	 * - PacNyanEatenByGhost - TODO
	 * - PacNyanEatsGhost - TODO
	 */

	@Test
	public void pacNyanConstructor() {
		PacNyan p = new PacNyan();
		assertTrue("<< Invalid PacNyan Constructor >>",
				p.getCurrDirection().equals("-")
				&& p.getQueuedKey().equals("-")
				&& p.getLastKey().equals("-"));
	}
	
	@Test
	public void PacNyanDoesntMove() {
		int oldX = 45;
		int oldY = 45;
		
		PacNyan p = new PacNyan();
		ActorWorld w = new ActorWorld();
		w.add(p, new Location(oldX, oldY));
		p.act();
		
		assertTrue("<< PacNyan moves when it shouldn't >>",
				p.getX() == oldX
				&& p.getY() == oldY);
	}
	
	@Test
	public void PacNyanSetImageUp() {
		PacNyan p = new PacNyan();
		p.setImageDir("up");
		
		assertTrue("<< Image not facing up >>",
				p.getRotation() == 0);
	}
	
	@Test
	public void PacNyanSetImageDown() {
		PacNyan p = new PacNyan();
		p.setImageDir("down");
		
		assertTrue("<< Image not facing down >>",
				p.getRotation() == 180);
	}
	
	@Test
	public void PacNyanSetImageRight() {
		PacNyan p = new PacNyan();
		p.setImageDir("right");
		
		assertTrue("<< Image not facing right >>",
				p.getRotation() == 90);
	}
	
	@Test
	public void PacNyanSetImageLeft() {
		PacNyan p = new PacNyan();
		p.setImageDir("left");
		
		assertTrue("<< Image not facing left >>",
				p.getRotation() == 270);
	}
	
	// -- Test Pinky
	/**
	 * Pinky Tests:
	 * - PinkyConstructor - constructs Pinky and tests if not null
	 * - PinkyChasePacNyan - tests if Pinky moves closer to PacNyan to ambush
	 */
	
	@Test
	public void PinkyConstructor() {
		Pinky p = new Pinky();
		
		assertTrue("<< Invalid Pinky Constructor >>",
				p != null);
	}
	
	@Test
	public void PinkyChasePacNyan() {
		Pinky pinky = new Pinky();
		PacNyan pac = new PacNyan();
		ActorWorld w = new ActorWorld();
		
		int pinkyInitX = 45;
		int pinkyInitY = 45;
		int pacInitX = 75;
		int pacInitY = 45;
		
		w.add(pinky, new Location(pinkyInitX, pinkyInitY));
		w.add(pac, new Location(pacInitX, pacInitY));
		
		pinky.act();
		
		assertTrue("<< Pinky does not chase PacNyan >>",
				Math.abs(pinkyInitX - pacInitX) < Math.abs(pinky.getX() - pacInitX)
				|| Math.abs(pinkyInitY - pacInitY) < Math.abs(pinky.getY() - pacInitY));
	}
	
	// -- Test PowerPellet
	/**
	 * PowerPellet Tests:
	 * - 
	 */
	
	// -- Test Void
	/** 
	 * Void Tests:
	 * - VoidConstructor - constructs Void and tests if not null
	 * - VoidGetImage - compares value with null
	 */
	
	@Test
	public void VoidConstructor() {
		Void v = new Void();
		
		assertTrue("<< Invalid Void Constructor >>",
				v != null);
	}
	
	@Test
	public void VoidGetImage() {
		Void v = new Void();
		
		assertTrue("<< Invalid Image from getImage() >>",
				v.getImage() != null);
	}
	
	// -- Test Wall
	/**
	 * Wall Tests:
	 * - WallConstructor - constructs Wall and tests if not null
	 * - WallGetImage - compares value with null
	 */
	
	@Test
	public void WallConstructor() {
		Wall w = new Wall();
		
		assertTrue("<< Invalid Wall Constructor >>",
				w != null);
	}
	
	@Test
	public void WallGetImage() {
		Wall w = new Wall();
		
		assertTrue("<< Invalid Image from getImage() >>",
				w.getImage() != null);
	}
	
}
