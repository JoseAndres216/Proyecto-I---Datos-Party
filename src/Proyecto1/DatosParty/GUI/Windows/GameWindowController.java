package Proyecto1.DatosParty.GUI.Windows;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;
import Proyecto1.DatosParty.Table;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;

public class GameWindowController {
    @FXML
    Button exitButton;

    @FXML
    Canvas canvas;

    @FXML
    Button startButton;

    public void drawPhases(Event event) throws Exception {
        Table.getInstance().drawTable(canvas);
        Table.getInstance().drawTable(canvas);
        Table.getInstance().drawPlayers(canvas, Game.getInstance().getPlayers());
    }

    public void pressedExitbutton(Event event) throws Exception {
        Game.getInstance().getPlayers().accessNode(0).RollDices();
        //Stage stage = (Stage) this.exitButton.getScene().getWindow();
        //stage.close();
    }

    /**
     * Metodo para preguntarle al usuario cual casilla quiere. Y depende del resultado se
     * llama el metodo MoveTo con el id de la casilla
     * @param lista posibles casillas
     * @param player jugador, para obtener el nickname y esas cosas
     * @return algo salio mal
     */
    public void askMove(SimpleLinkedList<Box> lista, Player player){
        Box choise = null;
        switch (lista.len()){
            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            default:

                throw new IllegalArgumentException("Unexpected value");
        }



    }

    /*
    public void changeTominigame() throws IOException {
        Parent gameWindow = FXMLLoader.load(this.getClass().getResource("MinigameWindow.fxml"));
        Stage stage = (Stage) canvas.getScene().getWindow();
        stage.setScene(new Scene(gameWindow));
    }

     */

}
