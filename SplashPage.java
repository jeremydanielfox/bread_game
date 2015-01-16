import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SplashPage {
	private static final int NUM_FRAMES_PER_SECOND = 60;
	private Stage myStage;
	private BreadFirstSearch myGame;
	public void setup(Stage stage) {
		Group root = new Group();
		myStage = stage;
		setupText(root);
		setupButton(stage,"Click if you are Bready for level one","Level One",150,root);
		setupButton(stage,"Click if you are Bready for level two","Level Two",250,root);
		Scene scene = new Scene(root, 500, 500);
		stage.setTitle("Welcome to Bread First Search!");
		stage.setScene(scene);
		stage.show();
	}
	/**
	 * @return
	 */
	public void setupText(Group root) {
		Text myLabel = new Text(50,50,"Help Madeline make it back to Earth!");
		myLabel.setTranslateX(100);
		myLabel.setTranslateY(50);
		root.getChildren().add(myLabel);
	}
	/**
	 * @param stage
	 * @return
	 */
	public void setupButton(Stage stage, String buttonText,String level,int yCoord, Group root) {
		Button btn = new Button();
		btn.setText(buttonText);
		btn.setTranslateX(70);
		btn.setTranslateY(yCoord);
		btn.setOnAction(new EventHandler<ActionEvent>() {


			public void handle(ActionEvent event) {
				loadBreadFirstSearch(stage,level);
			}
		});
		root.getChildren().add(btn);
	}
	public void loadBreadFirstSearch(Stage stage, String level) {
		stage.setTitle("Bread First Search");

		Timeline animation = new Timeline();
		//create the game
		myGame = new BreadFirstSearch(level,stage,animation);
		Scene scene = myGame.init(stage, 500, 500);
		stage.setScene(scene);
		//stage.show();

		//setup the game's loop
		KeyFrame frame = myGame.start(NUM_FRAMES_PER_SECOND);
		animation.setCycleCount(Animation.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
}
