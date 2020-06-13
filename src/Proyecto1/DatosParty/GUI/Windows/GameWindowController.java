package Proyecto1.DatosParty.GUI.Windows;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.GUI.Inputs.IOManager;
import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;
import Proyecto1.DatosParty.Table;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GameWindowController {
    @FXML
    Button exitButton;

    @FXML
    Canvas canvas;

    @FXML
    Button startButton;

    @FXML
    Label eventDisplayer;

    @FXML
    Label roundCounter;

    @FXML
    Label positions;

    @FXML
    Label lblPhaseA;
    @FXML
    Label lblPhaseB;
    @FXML
    Label lblPhaseC;
    @FXML
    Label lblPhaseD;

    public void pressedStart(Event event) throws Exception {
        lblPhaseA.setVisible(true);
        lblPhaseB.setVisible(true);
        lblPhaseC.setVisible(true);
        lblPhaseD.setVisible(true);
        this.exitButton.setStyle("-fx-background-color: #081626; ");
        this.startButton.setVisible(false);
        Table.getInstance().setCanvas(canvas);
        Table.getInstance().drawTable();
        Table.getInstance().drawPlayers();

        SimpleLinkedList<Player> players = Game.getInstance().getPlayers();
        for (int i = 0; i < players.len(); i++) {
            this.eventDisplayer.setAlignment(Pos.CENTER);
            this.eventDisplayer.setWrapText(true);
            players.accessNode(i).setEventDisplay(this.eventDisplayer);
        }

        Game.getInstance().setEventDisplay(this.eventDisplayer);
        Game.getInstance().setRoundCounter(this.roundCounter);
        Game.getInstance().setPositionsTable(this.positions);

        if (!IOManager.getInstance().isStarted()) {
            IOManager.getInstance().start(new Stage());
        }
    }

    public void pressedExitbutton(Event event) throws Throwable {
        Stage stage = (Stage) (this.exitButton.getScene().getWindow());
        stage.close();
        try {
            IOManager.getInstance().close();
        } catch (Exception e) {
            System.out.println("Game Over!");
        }
    }
}
