import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class GameObject extends Circle {
	protected int SPEED;
	protected int SIZE;
	protected Color COLOR;
	protected boolean IS_DEAD = false;
	protected int ID;
	
	public GameObject() {
		
	}
	
	public int getSpeed() {
		return SPEED;
	}
	
	public boolean isDead() {
		return IS_DEAD;
	}
	
	public void kill() {
		IS_DEAD = true;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int id) {
		ID = id;
	}
	
}
