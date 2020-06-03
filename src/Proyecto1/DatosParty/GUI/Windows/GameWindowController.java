package Proyecto1.DatosParty.GUI.Windows;

import Proyecto1.DatosParty.Table;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameWindowController {
    @FXML
    Button exitButton;

    @FXML
    Canvas canvas;

    @FXML
    Button startButton;

    public void drawPhases(Event event) throws Exception {
        Table.getInstance().drawPhase(canvas);
    }

    public void pressedExitbutton(Event event) throws Exception {
        Stage stage = (Stage) this.exitButton.getScene().getWindow();
        stage.close();
    }
}
