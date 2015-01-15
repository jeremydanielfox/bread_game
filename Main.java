import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	private static final int NUM_FRAMES_PER_SECOND = 60;
	private BreadFirstSearch myGame;


	/**
	 * Set things up at the beginning
	 */
	@Override
	public void start(Stage stage) {
	stage.setTitle("Welcome to Bread First Search!");
//		Menu myMenu = new Menu();
//		Scene scene = myMenu.init(stage, 500,500);
//		stage.setScene(scene);
//		stage.show();
//		
	SplashPage current = new SplashPage();
	current.setup(stage);
//		Text myLabel = new Text(50,50,"test");
//		//myLabel.setLayoutX(100);
//		Button btn = new Button();
//		btn.setText("Click if you are Bready");
//		btn.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				loadBreadFirstSearch(primaryStage);
//			}
//		});
//
//		Group root = new Group();
//		root.getChildren().add(btn);
//		root.getChildren().add(myLabel);
//
//		Scene scene = new Scene(root, 500, 500);
//
//		primaryStage.setTitle("Welcome to Bread First Search!");
//		primaryStage.setScene(scene);
//		primaryStage.show();

	}

	/**
	 * @param stage
	 */
	public void loadBreadFirstSearch(Stage stage) {
		stage.setTitle("Bread First Search");
		//create the game
		myGame = new BreadFirstSearch();
		Scene scene = myGame.init(stage, 500, 500);
		stage.setScene(scene);
		//stage.show();

		//setup the game's loop
		KeyFrame frame = myGame.start(NUM_FRAMES_PER_SECOND);
		Timeline animation = new Timeline();
		animation.setCycleCount(Animation.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
