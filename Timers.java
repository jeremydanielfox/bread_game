import java.util.Random;

/**
 * This class contains all of the timers to schedule different events
 * The timers are based off of a counter that runs in the game loop the whole time
 * @author Jeremy
 *
 */
public class Timers {
private int LENGTH_OF_GAME = 60*60;
private int ONE_SECOND = 60;
	/**
	 * Return true every three seconds
	 * @param counter
	 * @return
	 */
	public void dummy() {
		
	}
	public boolean isTimeForEnemy(int counter) {
		//how to use num frames per second?
		if (counter%(ONE_SECOND/2) == 0)
			return true;
		return false;
	}
	
	public boolean isTimeForEarth (int counter) {
		// set for 60 seconds
		return counter == LENGTH_OF_GAME;
	}
	
	public boolean swarmDeployDelay(int counter) {
		return counter%ONE_SECOND==0;
	}
	
	public boolean tenSecond(int counter) {
		return counter == 2*ONE_SECOND;
	}
	
	public boolean isTimeForBread(int counter, Random myRandom)	 {
		return counter%ONE_SECOND==0 && myRandom.nextInt(9)>7;
	}

}
