// region Imports
import java.io.IOException;
import java.util.ArrayList;

// import Character.Dealer;
// import Character.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
// endregion

public class PlayAreaController {

// region variables
    private int betAmount;

    // ArrayList Object and creator method for current player
    private ArrayList<String> currPlayer = new ArrayList<String>();
    // method is called in the initialize method
    private void arrayListCreator() {
        currPlayer.add("Player 1");
        currPlayer.add("Player 2");
        currPlayer.add("Player 3");
        currPlayer.add("Dealer");
    }
    private int arrayIterator = 0;
    
    private boolean hitPressed = false;
    private boolean gameStarted = false;

    // Object creation
    CardInitialize cardInit = new CardInitialize();
    Dealer dealer = new Dealer();
    Player playerOne = new Player("playerOne", dealer);
    Player playerTwo = new Player("playerTwo", dealer);
    Player playerThree = new Player("playerThree", dealer);

    // test declaration, change to a for loop initializing the images
    // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
    Image dealerCardTestImage = new Image("images\\cards\\AceOfClubs.png");

    // private ListView<Card> cListView = cardInit.getCardListView();
// endregion

// region FXML Objects
    @FXML
    private GridPane playAreaGridPane;

    @FXML
    private TextField betTextField;

    @FXML
    private TextField currentBetTextField;

    @FXML
    private Text currentPlayerText;

    @FXML
    private Button startButton;

    @FXML
    private HBox middleHBox;

    @FXML
    private Text playerOneHealthText;

    @FXML
    private Text playerOneBetText;

    @FXML
    private Text playerTwoHealthText;

    @FXML
    private Text playerTwoBetText;

    @FXML
    private Text playerThreeHealthText;

    @FXML
    private Text playerThreeBetText;

    @FXML
    private ImageView dealerCard;

    @FXML
    private ImageView deckImage;
// endregion

    @FXML
    void startButtonPressed(ActionEvent event) {
        gameStarted = true;

        startButton.setVisible(false);

        dealerCard.setVisible(true);
        deckImage.setVisible(true);

        playerOneHealthText.setVisible(true);
        playerTwoHealthText.setVisible(true);
        playerThreeHealthText.setVisible(true);

        playerOneBetText.setVisible(true);
        playerTwoBetText.setVisible(true);
        playerThreeBetText.setVisible(true);

        hitPressed = true;
        while (hitPressed) {
            dealer.shuffle();
            currentPlayerText.setText(currPlayer.set(arrayIterator, currPlayer.get(arrayIterator)));
            arrayIterator++;
            hitPressed = false;
        }
    }

    @FXML
    void hitButtonPressed(ActionEvent event) {
        if (gameStarted) {
            if (currentPlayerText.getText() == "Player 1") {
                playerOne.hit();
                playerOneBetText.setText("Bet: " + betAmount + " Hand Total: " + playerOne.handTotal);
            }

            if (currentPlayerText.getText() == "Player 2") {
                playerTwo.hit();
                playerTwoBetText.setText("Bet: " + betAmount + " Hand Total: " + playerTwo.handTotal);
            }

            if (currentPlayerText.getText() == "Player 3") {
                playerThree.hit();
                playerThreeBetText.setText("Bet: " + betAmount + " Hand Total: " + playerThree.handTotal);
            }
        }
    }

    @FXML
    void standButtonPressed(ActionEvent event) {
        if (gameStarted) {
            hitPressed = true;

            while (hitPressed) {
                if (arrayIterator >= currPlayer.size()) {
                    arrayIterator = 0;
                }
                currentPlayerText.setText(currPlayer.set(arrayIterator, currPlayer.get(arrayIterator)));
                arrayIterator++;
                hitPressed = false;
            }
        }
    }

    @FXML
    void betButtonPressed(ActionEvent event) {
        try {
            betAmount = Integer.parseInt(betTextField.getText());
            betTextField.setText("0");

            currentBetTextField.setText(Integer.toString(betAmount));

            if (currentPlayerText.getText() == "Player 1") {
                playerOne.setBet(betAmount);
                playerOneBetText.setText("Bet: " + betAmount + " Hand Total: " + playerOne.handTotal);
                // System.out.println("Player One's Bet: " + playerOne.getBet()); // test code :)
            }

            if (currentPlayerText.getText() == "Player 2") {
                playerTwo.setBet(betAmount);
                playerTwoBetText.setText("Bet: " + betAmount + " Hand Total: " + playerTwo.handTotal);
                // System.out.println("Player Two's Bet: " + playerTwo.getBet()); // test code :)
            }

            if (currentPlayerText.getText() == "Player 3") {
                playerThree.setBet(betAmount);
                playerThreeBetText.setText("Bet: " + betAmount + " Hand Total: " + playerThree.handTotal);
                // System.out.println("Player Three's Bet: " + playerThree.getBet()); // test code :)
            }
        } catch (NumberFormatException e) {
            betTextField.setText("Enter a number.");
            betTextField.selectAll();
            betTextField.requestFocus();
        }
    }

    @FXML
    void backButtonPressed(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        // switches back to start screen
        root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        arrayListCreator();
        currentPlayerText.setText("Press Start");

        // FXML visibility
        deckImage.setVisible(false);
        dealerCard.setVisible(false);

        startButton.setVisible(true);

        playerOneHealthText.setVisible(false);
        playerTwoHealthText.setVisible(false);
        playerThreeHealthText.setVisible(false);

        playerOneBetText.setVisible(false);
        playerTwoBetText.setVisible(false);
        playerThreeBetText.setVisible(false);

        // player related code (currently has test values)
        playerOne.modifyHealth(20);
        playerOneHealthText.setText("Player 1: Health: " + playerOne.getHealth() + "/20");
        playerTwo.modifyHealth(19); // currently testing with 19, should be 20
        playerTwoHealthText.setText("Player 2: Health " + playerTwo.getHealth() + "/20");
        playerThree.modifyHealth(18); // currently testing with 18, should be 20
        playerThreeHealthText.setText("Player 3: Health: " + playerThree.getHealth() + "/20");

        playerOne.initializeHand();
        playerTwo.initializeHand();
        playerThree.initializeHand();

        playerOne.setBet(0);
        playerTwo.setBet(0);
        playerThree.setBet(0);

        // dealer related code
        dealer.initializeHand();
        dealer.shuffle();
        dealerCard.setImage(dealerCardTestImage); // test

        // test (that doesnt work)
        // cardInit.initializeCards();
    }
}