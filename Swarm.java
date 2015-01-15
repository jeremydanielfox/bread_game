import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;



public class Swarm {
	private List<AdvancedEnemy> mySwarm = new CopyOnWriteArrayList<AdvancedEnemy>();
	private List<AdvancedEnemy> onScreen = new CopyOnWriteArrayList<AdvancedEnemy>();
	private Point2D myStart;
	private Timers t = new Timers();
	private AdvancedEnemy ae = new AdvancedEnemy();

	Swarm(int amount, Point2D start) {
		for (int i=0;i<amount;i++)
			mySwarm.add(new AdvancedEnemy());
		myStart = start;
	}

	public Collection<AdvancedEnemy> getSwarm() {
		return mySwarm;
	}

	public void deployTopLine(Scene myScene, int outsideCounter, Group myRoot) {
		double width= myScene.getWidth();
		double leftBound = width*.25;
		double rightBound = width*.75;
		double topCoord = myScene.getHeight()*.2;
		double interval = calculateInterval(leftBound, rightBound);
		setStart();
		setDestination(topCoord, interval);
		if (this.mySwarm.size() > 0 && t.swarmDeployDelay(outsideCounter)) {
			AdvancedEnemy current = this.mySwarm.remove(this.mySwarm.size()-1);
			onScreen.add(current);
			myRoot.getChildren().add(current);
		}
		moveOnScreenEnemies();
		

	}

	/**
	 * @param leftBound
	 * @param rightBound
	 * @return
	 */
	public double calculateInterval(double leftBound, double rightBound) {
		double amount = 1-this.mySwarm.size();
		double difference = rightBound - leftBound;
		double interval = difference/amount;
		return interval;
	}

	/**
	 * @param topCoord
	 * @param interval
	 */
	public void setDestination(double topCoord, double interval) {
		double counter = .25;
		for (AdvancedEnemy current: mySwarm) {
			current.setDestination(new Point2D(interval,topCoord));
			counter+=interval;
		}
	}

	/**
	 * @param interval
	 */
	public void setStart() {
		for (AdvancedEnemy current: mySwarm) {
			current.setCenterX(myStart.getX());
			current.setCenterY(myStart.getY());
		}
	}

	/**
	 * 
	 */
	public void moveOnScreenEnemies() {
		for (AdvancedEnemy current: this.onScreen)
			ae.moveAdvancedEnemy(current);
	}
}



