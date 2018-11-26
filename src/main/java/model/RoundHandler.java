package model;

import java.util.Map;

import model.gameobjects.Dalek;

/**
 * 
 * @author kuba
 *
 */
public class RoundHandler {
	private int roundScore;
	private int size;
	private CollisionHandler collisionHandler;
	private Map<Coordinates, Field> map;

	/**
	 * Initiales map based on daleksNumber and size of map. Places all objects on
	 * map.
	 * 
	 * @param size
	 * @param daleksNumber
	 */
	public RoundHandler(int size, int daleksNumber) {
		this.size = size;
		placeDaleks(daleksNumber);
	}

	/**
	 * Creates path graph for daleks to find the best way to catch doctor.
	 */
	public Graph createGraph() {
		return null;
		// TODO
	}

	/**
	 * Moves doctor, moves daleks and checks collisions and updates the score
	 */
	public void executeRound() {
		Game.doctor.move();
		for (Map.Entry<Coordinates, Field> entry : map.entrySet()) {
			for (Dalek dalek : entry.getValue().getDaleks()) {
				dalek.setGraph(createGraph());
				dalek.move();
			}
		}
	}

	/**
	 * Places daleks (and in future other objects) on map.
	 * 
	 * @param daleksNumber
	 */
	private void placeDaleks(int daleksNumber) {
		// TODO
		Game.doctor.move();
	}

	/**
	 * Returns roundScore and clears it to prepare for a new round.
	 * 
	 * @return
	 */
	public int getAndClearRoundScore() {
		int score = roundScore;
		this.roundScore = 0;
		return score;
	}

	/**
	 * Returns true if all daleks are dead and false otherwise.
	 * 
	 * @return
	 */
	public boolean areDaleksDead() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Creates new round with copy of it self.
	 * 
	 * @return
	 */
	public RoundHandler roundSnapshot() {
		// TODO
		return null;
	}

	public boolean isDoctorAlive() {
		if (Game.doctor.getHealth() > 0)
			return true;
		return false;
	}

}
