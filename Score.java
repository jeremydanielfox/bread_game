import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Score {
	private Text myScore = new Text("0");
	private int myCount = 0;
	
	Score()	{
		setColor();
	}
	
	Score(int initial) {
		myCount=initial;
		setColor();
	}
	public void increaseScore(int increase) {
		myCount +=increase;
		myScore.setText(Integer.toString(myCount));
	}
	public Text getScore() {
		return myScore;
	}
	public void setScore(int count) {
		myCount = count;
	}
	private void setColor() {
		myScore.setFill(Color.WHITE);
	}
}
