import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * This is the class for the score, which is placed at the top of the screen and update 
 * every time an enemy dies
 * @author Jeremy
 *
 */
public class Score {
	private Text myScore = new Text("Score:   0");
	private int myCount = 0;
	static final int TRANSLATE_X = 100;
	static final int TRANSLATE_Y = 50;

	Score()	{
		setColor();
	}

	Score(int initial) {
		myCount=initial;
		setColor();
		setTranslate();
	}
	public void increaseScore(int increase) {
		myCount +=increase;
		myScore.setText("Score:   " + Integer.toString(myCount));
	}
	public Text getScore() {
		return myScore;
	}
	public void setScore(int count) {
		myCount = count;
	}
	private void setColor() {
		myScore.setFill(Color.YELLOW);
		myScore.setTranslateX(TRANSLATE_X);
		myScore.setTranslateY(TRANSLATE_Y);
	}

	private void setTranslate() {
		myScore.setTranslateX(TRANSLATE_X);
		myScore.setTranslateY(TRANSLATE_Y);
	}
}
