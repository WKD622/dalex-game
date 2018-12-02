package model;

import java.util.ArrayList;
import java.util.List;

import model.gameobjects.Dalek;
import model.gameobjects.Junk;
import model.gameobjects.PowerUp;
import model.gameobjects.Stone;
import model.gameobjects.Tree;

/**
 * Represent one field on map on which other objects can stay.
 * 
 * @author kuba
 *
 */
public class Field {

	private Coordinates coordinates;
	private List<Dalek> daleks = new ArrayList<>();
	private PowerUp powerUp = null;
	private Junk junk = null;
	private Tree tree = null;
	private Stone stone = null;
	private int numberOfObjects;

	public Field(Coordinates coordinates) {
		this.coordinates = coordinates;
		this.numberOfObjects = 0;
	}

	public List<Dalek> getDaleks() {
		return daleks;
	}

	public PowerUp getPowerUp() {
		if (powerUp == null)
			return null;
		return powerUp;
	}

	/**
	 * Returns numberOfDaleks on this field.
	 * 
	 * @return
	 */
	public int numberOfDaleks() {
		return this.daleks.size();
	}

	/**
	 * returns true if field has PowerUp, otherwise false.
	 * 
	 * @return
	 */
	public boolean hasPowerUp() {
		if (powerUp == null)
			return false;
		return true;
	}

	public void setPowerUp(PowerUp powerUp) {
		this.powerUp = powerUp;
		this.numberOfObjects++;
	}

	/**
	 * Removes PowerUp from this field.
	 */
	public void removePowerUp() {
		this.powerUp = null;
		this.numberOfObjects--;
	}

	public void addDalek(Dalek dalek) {
		daleks.add(dalek);
		this.numberOfObjects++;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	/**
	 * Returns true if there is tree on this field, otherwise false.
	 * 
	 * @return
	 */
	public boolean hasTree() {
		if (this.tree == null)
			return false;
		return true;
	}

	public void setStone(Stone stone) {
		this.stone = stone;
	}

	/**
	 * Returns true if there is stone on this field, otherwise false.
	 * 
	 * @return
	 */
	public boolean hasStone() {
		if (this.stone == null)
			return false;
		return true;
	}

	public void removeDalek(Dalek dalek) {
		getDaleks().remove(dalek);
		this.numberOfObjects--;
	}

	public void removeAllDaleks() {
		this.numberOfObjects -= daleks.size();
		daleks.removeAll(daleks);
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * Returns true it doctor is on this field, otherwise false.
	 * 
	 * @return
	 */
	public boolean hasDoctor() {
		return Game.doctor.getCoordinates().equals(this.coordinates);
	}

	/**
	 * Returns true if there is junk on this field, otherwise false.
	 * 
	 * @return
	 */
	public boolean hasJunk() {
		if (this.junk == null)
			return false;
		return true;
	}

	public void addJunk() {
		this.junk = new Junk(this.coordinates);
		numberOfObjects++;
	}

	public void removeJunk() {
		this.junk = null;
		numberOfObjects--;
	}

	/**
	 * Returns true if collision happend on this field, otherwise false.
	 * 
	 * @return
	 */
	public boolean doesCollisionHappen() {
		if (numberOfObjects > 1)
			return true;
		return false;
	}

	/**
	 * Returns true if there is one or more objects on this field
	 * 
	 * @return
	 */
	public boolean anyObjects() {
		if (Game.doctor.getCoordinates().equals(this.coordinates)) {
			return true;
		} else if (numberOfObjects > 0) {
			return true;
		}
		return false;
	}

}
