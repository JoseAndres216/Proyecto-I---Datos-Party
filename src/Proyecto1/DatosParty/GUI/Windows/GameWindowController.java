package Proyecto1.DatosParty.GUI.Windows;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.GUI.Inputs.IOManager;
import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;
import Proyecto1.DatosParty.Table;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class GameWindowController {
    @FXML
    Button exitButton;

    @FXML
    Canvas canvas;

    @FXML
    Button startButton;

    @FXML
    ListView eventDisplayer;


    public void drawPhases(Event event) throws Exception {
        Table.getInstance().setCanvas(canvas);

        Table.getInstance().drawTable();
        Table.getInstance().drawPlayers();

        SimpleLinkedList<Player> players = Game.getInstance().getPlayers();
        for (int i = 0; i < players.len(); i++) {
            players.accessNode(i).setEventDisplay(this.eventDisplayer);
        }

        Game.getInstance().setEventDisplay(this.eventDisplayer);

        if (!IOManager.getInstance().isStarted()) {
            IOManager.getInstance().start(new Stage());
        }
    }

    public void pressedExitbutton(Event event) throws Exception {
        Game.getInstance().startMinigame();
    }
}
