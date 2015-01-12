import javafx.geometry.Point2D;
import javafx.scene.paint.Color;


public class AdvancedEnemy extends GameObject {
	private Point2D Destination;
	private Point2D Velocity;
	
	AdvancedEnemy(Point2D start) {
		SPEED = 3;
		SIZE = 10;
		COLOR = Color.CYAN;
		setRadius(SIZE);
		setCenterX( (int) start.getX());
		setCenterY( (int) start.getY());
		setFill(COLOR);
	}
	
	AdvancedEnemy(Point2D start, Point2D destination) {
		SPEED = 10;
		SIZE = 10;
		COLOR = Color.CYAN;
		setRadius(SIZE);
		setCenterX( (int) start.getX());
		setCenterY( (int) start.getY());
		setFill(COLOR);
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
		double ratio = ((double) SPEED) / distance;
		Velocity = new Point2D((float) (ratio*deltaX),(float) (ratio*deltaY));
	}
}
