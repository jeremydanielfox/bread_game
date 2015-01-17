import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
/**
 * This class contains the Advanced Enemy, which is the enemy that follows the player on screen
 * this enemy is used in level two
 * @author Jeremy
 *
 */

public class AdvancedEnemy extends GameObject {
	private Point2D Destination;
	private Point2D Velocity;
	static final int ADVANCED_ENEMY_SPEED = 3;
	static final int ADVANCED_ENEMY_SIZE = 30;
	
	private Image img = new Image("Images/advancedEnemy.png");
	AdvancedEnemy() {
		setSpeedAndSize(ADVANCED_ENEMY_SPEED,ADVANCED_ENEMY_SIZE);
		setImage(img);
		setupImage();
		
	}
	AdvancedEnemy(Point2D start) {
		setSpeedSizeImageXY(ADVANCED_ENEMY_SPEED,ADVANCED_ENEMY_SIZE,img,(int) start.getX(),(int) start.getY());
	}
	
	AdvancedEnemy(Point2D start, Point2D destination) {
		setSpeedSizeImageXY(ADVANCED_ENEMY_SPEED,ADVANCED_ENEMY_SIZE,img,(int) start.getX(),(int) start.getY());
		Destination = destination;
	}
	
	public void setDestination(Point2D destination) {
		Destination = destination;
	}
	
	public Point2D getDestination() {
		return Destination;
	}
	
	public Point2D getVelocity() {
		setVelocity();
		return Velocity;
	}
	/**
	 * Use trigonometric ratios and the properties of similar triangles to calculate 
	 * the appropriate x and y components of a velocity that has the magnitude of the
	 * SPEED component
	 */
	private void setVelocity() {
		Point2D CurrentLocation = this.getLocation();
		double distance = CurrentLocation.distance(Destination);
		double deltaX = Destination.getX() - CurrentLocation.getX();
		double deltaY = Destination.getY() - CurrentLocation.getY();
		double ratio = ((double) getSpeed()) / distance;
		Velocity = new Point2D((float) (ratio*deltaX),(float) (ratio*deltaY));
	}
	public void moveAdvancedEnemy(AdvancedEnemy current) {
		Point2D velocity = current.getVelocity();
		current.setCenterX(current.getCenterX() + velocity.getX());
		current.setCenterY(current.getCenterY() + velocity.getY());
	}
}
