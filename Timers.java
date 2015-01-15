/**
 * This class contains all of the timers to schedule different events
 * The timers are based off of a counter that runs in the game loop the whole time
 * @author Jeremy
 *
 */
public class Timers {

	/**
	 * Return true every three seconds
	 * @param counter
	 * @return
	 */
	public void dummy() {
		
	}
	public boolean isTimeForEnemy(int counter) {
		//how to use num frames per second?
		if (counter%30 == 0)
			return true;
		return false;
	}
	
	public boolean isTimeForEarth (int counter) {
		// set for 60 seconds
		return counter == 10*60;
	}
	
	public boolean swarmDeployDelay(int counter) {
		return counter%60==0;
	}
	
	public boolean tenSecond(int counter) {
		return counter == 2*60;
	}

}
