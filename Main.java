import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This is the main class for the Bread First Search Game
 * 
 * @author Jeremy
 *
 */
public class Main extends Application {

	/**
	 * Send to Splash Page
	 */

	public void start(Stage stage) {
		stage.setTitle("Welcome to Bread First Search!");
		SplashPage mySplashPage = new SplashPage();
		mySplashPage.setup(stage);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
