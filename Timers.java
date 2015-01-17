import java.util.Random;

/**
 * This class contains all of the timers to schedule different events
 * The timers are based off of a counter that runs in the game loop the whole time
 * @author Jeremy
 *
 */
public class Timers {
	static final int LENGTH_OF_GAME = 30*60;
	static final int ONE_SECOND = 60;
	static final int UPPER_BOUND = 9;
	static final int LOWER_BOUND = 7;
	public void dummy() {

	}
	public boolean isTimeForEnemy(int counter) {
		if (counter%(ONE_SECOND/2) == 0)
			return true;
		return false;
	}

	public boolean isTimeForEarth (int counter) {
		return counter == LENGTH_OF_GAME;
	}

	public boolean swarmDeployDelay(int counter) {
		return counter%ONE_SECOND==0;
	}

	public boolean tenSecond(int counter) {
		return counter == 2*ONE_SECOND;
	}

	public boolean isTimeForBread(int counter, Random myRandom)	 {
		return counter%ONE_SECOND==0 && myRandom.nextInt(UPPER_BOUND)>LOWER_BOUND;
	}

}
