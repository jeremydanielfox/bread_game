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
		setTranslate();
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
		myScore.setTranslateX(100);
		myScore.setTranslateY(50);
	}
	
	private void setTranslate() {
		myScore.setTranslateX(100);
		myScore.setTranslateY(50);
	}
}
