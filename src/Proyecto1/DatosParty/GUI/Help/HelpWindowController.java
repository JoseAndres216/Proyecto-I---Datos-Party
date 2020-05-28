package Proyecto1.DatosParty.GUI.Help;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Controller for the help window fxml file
 */
public class HelpWindowController {

    @FXML
    private Button exitButton;

    @FXML
    private ImageView helpLogo;

    @FXML
    private ImageView daRulesLogo;

    @FXML
    private ImageView keyboardLogo;

    /**
     * Event handler to exit the window when the button is pressed.
     * @param event Event of mouse click
     */
    public void pressedExitButton(Event event) {
        // Get the stage
        Stage stage = (Stage) this.exitButton.getScene().getWindow();
        // close the window
        stage.close();
    }
}
