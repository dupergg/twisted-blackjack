// region Imports
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
// endregion

public class StartScreenController {

    PlayAreaController pController = new PlayAreaController();
    
// region StartScreen.fxml methods
    @FXML
    void exitButton(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void playButton(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        // switches scene to the play area
        root = FXMLLoader.load(getClass().getResource("PlayArea.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
// endregion
}
