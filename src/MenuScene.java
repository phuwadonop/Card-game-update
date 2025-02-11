import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class MenuScene {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane stackpane;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button playButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button howtoButton;

    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void openHowtoScene (ActionEvent event) throws IOException {
        
        Parent howtoplayParent = FXMLLoader.load(getClass().getResource("HowtoplayScene.fxml"));
        Scene howtoplayScene = new Scene(howtoplayParent);


        Stage window =  (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(howtoplayScene);
        window.setTitle("How to Play");
        window.show();
        
    }

    @FXML
    void gotoGameScene (ActionEvent event) throws IOException {
        
        Parent gameParent = FXMLLoader.load(getClass().getResource("Scene.fxml"));
        Scene gameScene = new Scene(gameParent);


        Stage window =  (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(gameScene);
        window.setTitle("Slave");
        window.show();
    }

    @FXML
    void initialize() {
        assert stackpane != null : "fx:id=\"stackpane\" was not injected: check your FXML file 'MenuScene.fxml'.";
        assert anchorpane != null : "fx:id=\"anchorpane\" was not injected: check your FXML file 'MenuScene.fxml'.";
        assert playButton != null : "fx:id=\"playButton\" was not injected: check your FXML file 'MenuScene.fxml'.";

    }
}
