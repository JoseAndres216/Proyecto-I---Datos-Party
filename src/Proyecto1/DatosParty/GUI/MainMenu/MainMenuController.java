package Proyecto1.DatosParty.GUI.MainMenu;

import Proyecto1.DatosParty.GUI.Help.HelpWindowStart;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MainMenuController {
    @FXML
    private Button botonHelp;

    @FXML
    private Button exitButton;

    public void pressedHelpButton(Event event) throws Exception {
        System.out.println("Help button pressed on the main menu.");
        HelpWindowStart.getInstance().start(new Stage());
    }
}
