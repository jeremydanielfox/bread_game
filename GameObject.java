import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;



public class GameObject extends Circle {
	protected int SPEED;
	protected int SIZE;
	protected Color COLOR;
	protected boolean IS_DEAD = false;
	protected boolean IS_INVINCIBLE = false;
	protected int ID;
	
	public GameObject() {
		
	}
	
	public int getSpeed() {
		return SPEED;
	}
	
	public boolean isDead() {
		return IS_DEAD;
	}
	
	public void toggleInvincibility() {
		if (this.IS_INVINCIBLE)
			this.removeInvincible();
		else
			this.makeInvincible();
	}
	
	public boolean isInvincible() {
		return IS_INVINCIBLE;
	}
	
	public void makeInvincible() {
		IS_INVINCIBLE = true;
	}
	
	public void removeInvincible() {
		IS_INVINCIBLE = false;
	}
	
	public void kill() {
		IS_DEAD = true;
	}
	
	public Point2D getLocation() {
		return new Point2D((float) this.getCenterX(),(float) this.getCenterY());
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int id) {
		ID = id;
	}
	
}
