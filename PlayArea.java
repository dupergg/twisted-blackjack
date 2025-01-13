// region Imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
// endregion

public class PlayArea extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("PlayArea.fxml"));

		    Scene scene = new Scene(root); // attach scene graph to scene
			
		    stage.setTitle("Twisted Blackjack"); // displayed in window's title bar
			stage.getIcons().add(new Image("/images/icon.png")); // adds icon to top left of title bar
		    stage.setScene(scene); // attach scene to stage
		    stage.show(); // display the stage
			stage.setResizable(false); // prevents the user from resizing the window
	}
	
	public static void main(String[] args) {
	      launch(args); 
	}
}