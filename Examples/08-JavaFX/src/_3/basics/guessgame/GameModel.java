package _3.basics.guessgame;

import java.util.Random;

/**
 * A model class for a guessing game.
 */
public class GameModel {
	// the secret number to guess
	private int secret;
	// the upper bound for secret. This determines how hard the game is.
	private int upperBound;
	// message for the player
	private String message = "";
	
	public GameModel() {
		this(100);
	}
	
	/**
	 * Initialize a guessing game with given upper limit on the secret number.
	 * @param upperBound  the upper limit for the secret number. Must be positive.
	*/
	public GameModel(int upperBound) {
		this.upperBound = upperBound;
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		this.secret = rand.nextInt(upperBound) + 1;
		this.message = String.format("Guess a number between 1 and %d", upperBound);
	}
	
	public String getMessage() {
		return message;
	}
	
	/**
	 * Evaluate a user's guess and set a message to display
	 * @param guess the user's guess
	 * @return true if user guesses the secret number, false otherwise
	 */
	public boolean evaluateGuess(int guess) {
		if (guess < 1 || guess > upperBound) {
			message = String.format("Invalid! The secret is between 1 and %d", upperBound);
			return false;
		}
		if (guess < secret) {
			message = String.format("%d is too small", guess);
			return false;
		}
		if (guess > secret) {
			message = String.format("%d is too large", guess);
			return false;
		}
		message = "Right! You guessed it.";
		return true;
	}
	
	/**
	 * Get the upper bound for the secret.
	 * @return the upperbound on secret number
	 */
	public int getUpperBound() {
		return upperBound;
	}
}
