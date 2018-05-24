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
	 * - BarConstructor - constructs Bar and tests if not null
	 * - BarGetImage - compares value with null
	 */
	
	@Test
	public void BarConstructor() {
		Bar b = new Bar();
		
		assertTrue("<< Invalid Bar Constructor >>",
				b != null);
	}
	
	@Test
	public void BarGetImage() {
		Bar b = new Bar();
		
		assertTrue("<< Invalid Image from getImage() >>",
				b.getImage() != null);
	}
	
	// -- Test Blinky
	/**
	 * Blinky Tests:
	 * - BlinkyConstructor - constructs Blinky and tests if it's not null
	 * - BlinkyChasePacNyan - tests if Blinky moves closer to PacNyan to attack
	 */
	
	@Test
	public void BlinkyConstructor() {
		Blinky b = new Blinky();
		
		assertTrue("<< Invalid Blinky Constructor >>",
				b != null);
	}
	
	@Test
	public void BlinkyChasePacNyan() {
		Blinky b = new Blinky();
		PacNyan pac = new PacNyan();
		ActorWorld w = new ActorWorld();
		
		int bInitX = 1;
		int bInitY = 1;
		int pacInitX = 2;
		int pacInitY = 1;
		
		w.add(b, new Location(bInitX, bInitY));
		w.add(pac, new Location(pacInitX, pacInitY));
		
		b.act();
		
		assertTrue("<< Blinky does not chase PacNyan >>",
				Math.abs(bInitX - pacInitX) > Math.abs(b.getX() - pacInitX)
				|| Math.abs(bInitY - pacInitY) > Math.abs(b.getY() - pacInitY));
	}
	
	// -- Test Clyde
	/**
	 * Clyde Tests:
	 * - ClydeConstructor - constructs Clyde and tests if it's not null
	 * - ClydeRandomMove - tests if Clyde moves when it acts
	 */
	
	@Test
	public void ClydeConstructor() {
		Clyde c = new Clyde();
		
		assertTrue("<< Invalid Clyde Constructor >>",
				c != null);
	}
	
	@Test
	public void ClydeChasePacNyan() {
		Clyde c = new Clyde();
		ActorWorld w = new ActorWorld();
		
		int cInitX = 1;
		int cInitY = 1;
		
		w.add(c, new Location(cInitX, cInitY));		
		c.act();
		
		assertTrue("<< Clyde does not move >>",
				cInitX != c.getX() || cInitY != c.getY());
				
	}

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
	 * - InkyConstructor - constructs Inky and tests if not null
	 * - InkyChasesPacNyanWhenFar - tests if Inky moves toward PacNyan when far away
	 * - InkyMovesWhenCloseToPacNyan - tests if Inky moves if close to PacNyan
	 */
	
	@Test
	public void InkyConstructor() {
		Inky i = new Inky();
		
		assertTrue("<< Invalid Inky Constructor >>",
				i != null);
	}
	
	@Test
	public void InkyChasesPacNyanWhenFar() {
		Inky i = new Inky();
		PacNyan pac = new PacNyan();
		ActorWorld w = new ActorWorld();
		
		int iInitX = 1;
		int iInitY = 1;
		int pacInitX = 2;
		int pacInitY = 1;
		
		w.add(i, new Location(iInitX, iInitY));
		w.add(pac, new Location(pacInitX, pacInitY));
		
		i.act();
		
		assertTrue("<< Inky does not chase PacNyan when far away >>",
				Math.abs(iInitX - pacInitX) > Math.abs(i.getX() - pacInitX)
				|| Math.abs(iInitY - pacInitY) > Math.abs(i.getY() - pacInitY));
	}
	
	@Test
	public void InkyMovesWhenCloseToPacNyan() {
		Inky i = new Inky();
		PacNyan pac = new PacNyan();
		ActorWorld w = new ActorWorld();
		
		int iInitX = 1;
		int iInitY = 1;
		int pacInitX = 2;
		int pacInitY = 1;
		
		w.add(i, new Location(iInitX, iInitY));
		w.add(pac, new Location(pacInitX, pacInitY));
		
		i.act();
		
		assertTrue("<< Inky does not move >>",
				iInitX != i.getX() || iInitY != i.getY());
	}
	
	// -- Test MazeActor
	/**
	 * MazeActor Tests:
	 * - MazeActorConstructor - constructs MazeActor and tests if not null
	 * - MazeActorCanMoveUp - compares returned value with known value
	 * - MazeActorCanMoveDown - compares returned value with known value	 
	 * - MazeActorCanMoveLeft - compares returned value with known value
	 * - MazeActorCanMoveRight - compares returned value with known value
	 * - MazeActorCanMovePlaceHolder - compares returned value with known value
	 * - MazeActorIsHorizontallyCenteredFalse - compares returned value with known value
	 * - MazeActorIsHorizontallyCenteredTrue - compares returned value with known value
	 * - MazeActorIsVerticallyCenteredFalse - compares returned value with known value
	 * - MazeActorIsVerticallyCenteredTrue - compares returned value with known value
	 * - MazeActorGetHorizImage - tests whether it's null
	 * - MazeActorGetVertImage - tests whether it's null
	 */
	
	@Test
	public void MazeActorConstructor() {
		MazeActor m = new PacNyan();
		
		assertTrue("<< Invalid MazeActor Constructor >>",
				m != null);
	}
	
	@Test
	public void MazeActorCanMoveUp() {
		MazeActor m = new PacNyan();
		ActorWorld a = new ActorWorld();
		
		a.add(m, new Location(1, 1));
		
		assertTrue("<< Invalid output for canMove(up) method >>",
				m.canMove("up") == false);
	}
	
	@Test
	public void MazeActorCanMoveDown() {
		MazeActor m = new PacNyan();
		ActorWorld a = new ActorWorld();
		
		a.add(m, new Location(1, 1));
		
		assertTrue("<< Invalid output for canMove(down) method >>",
				m.canMove("down") == true);
	}
	
	@Test
	public void MazeActorCanMoveLeft() {
		MazeActor m = new PacNyan();
		ActorWorld a = new ActorWorld();
		
		a.add(m, new Location(1, 1));
		
		assertTrue("<< Invalid output for canMove(left) method >>",
				m.canMove("left") == false);
	}
	
	@Test
	public void MazeActorCanMoveRight() {
		MazeActor m = new PacNyan();
		ActorWorld a = new ActorWorld();
		
		a.add(m, new Location(1, 1));
		
		assertTrue("<< Invalid output for canMove(right) method >>",
				m.canMove("right") == false);
	}
	
	@Test
	public void MazeActorCanMovePlaceholder() {
		MazeActor m = new PacNyan();
		ActorWorld a = new ActorWorld();
		
		a.add(m, new Location(1, 1));
		
		assertTrue("<< Invalid output for canMove(-) method >>",
				m.canMove("-") == false);
	}
	
	@Test
	public void MazeActorIsHorizontallyCenteredFalse() {
		MazeActor m = new PacNyan();
		ActorWorld a = new ActorWorld();
		
		a.addObject(m, 44, 45);
		
		assertTrue("<< Invalid output for horizontally centered >>",
				m.isHorizontallyCentered() == false);
	}
	
	@Test
	public void MazeActorIsHorizontallyCenteredTrue() {
		MazeActor m = new PacNyan();
		ActorWorld a = new ActorWorld();
		
		a.addObject(m, 45, 45);
		
		assertTrue("<< Invalid output for horizontally centered >>",
				m.isHorizontallyCentered() == true);
	}
	
	@Test
	public void MazeActorIsVerticallyCenteredFalse() {
		MazeActor m = new PacNyan();
		ActorWorld a = new ActorWorld();
		
		a.addObject(m, 45, 44);
		
		assertTrue("<< Invalid output for horizontally centered >>",
				m.isVerticallyCentered() == false);
	}
	
	@Test
	public void MazeActorIsVerticallyCenteredTrue() {
		MazeActor m = new PacNyan();
		ActorWorld a = new ActorWorld();
		
		a.addObject(m, 45, 45);
		
		assertTrue("<< Invalid output for horizontally centered >>",
				m.isVerticallyCentered() == true);
	}
	
	@Test
	public void MazeActorGetHorizImage() {
		MazeActor m = new PacNyan();
		
		assertTrue("<< Invalid horizontal image >>",
				m.getHorizImage(m.getImage()) != null);
	}
	
	@Test
	public void MazeActorGetVertImage() {
		MazeActor m = new PacNyan();
		
		assertTrue("<< Invalid vertical image >>",
				m.getVertImage(m.getImage()) != null);
	}
	
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
	 * - PacNyanChangeScore - TODO
	 */

	@Test
	public void PacNyanConstructor() {
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
		
		int pinkyInitX = 1;
		int pinkyInitY = 1;
		int pacInitX = 2;
		int pacInitY = 1;
		
		w.add(pinky, new Location(pinkyInitX, pinkyInitY));
		w.add(pac, new Location(pacInitX, pacInitY));
		
		pinky.act();
		
		assertTrue("<< Pinky does not chase PacNyan >>",
				Math.abs(pinkyInitX - pacInitX) > Math.abs(pinky.getX() - pacInitX)
				|| Math.abs(pinkyInitY - pacInitY) > Math.abs(pinky.getY() - pacInitY));
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
