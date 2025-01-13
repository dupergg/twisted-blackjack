import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class CardImageCell extends ListCell<Card> {
    // NOTE: may not work as this is not the controller, not sure
    @FXML
    private HBox middleHBox;

    private ImageView cardImage = new ImageView();

    public CardImageCell() {
        middleHBox.setAlignment(Pos.CENTER);

        cardImage.setPreserveRatio(true);
        cardImage.setFitHeight(50.0);
        middleHBox.getChildren().add(cardImage);

        setPrefWidth(USE_PREF_SIZE);
    }
}
