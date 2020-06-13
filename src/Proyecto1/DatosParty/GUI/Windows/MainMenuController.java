package Proyecto1.DatosParty.GUI.Windows;

import Proyecto1.DatosParty.GUI.Help.HelpWindowStart;
import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class MainMenuController {
    @FXML
    private Button botonHelp;

    @FXML
    private Button exitButton;

    @FXML
    private Button playButton;

    @FXML
    private TextField entryPlayer1, entryPlayer2, entryPlayer3, entryPlayer4;

    public void pressedHelpButton(Event event) throws Exception {
        System.out.println("Help button pressed on the main menu.");
        HelpWindowStart.getInstance().start(new Stage());
    }

    public void pressedExitbutton(Event event) throws Exception {
        Stage stage = (Stage) this.exitButton.getScene().getWindow();
        stage.close();
    }

    public void pressedPlaybutton(Event event) throws Exception {

        Game.getInstance().getPlayers().emptyList();
        int i = 1;
        if (!entryPlayer1.getText().isEmpty()) {
            Game.getInstance().addPlayer(new Player(i, entryPlayer1.getText()));
            i++;
        }
        if (!entryPlayer2.getText().isEmpty()) {
            Game.getInstance().addPlayer(new Player(i, entryPlayer2.getText()));
            i++;
        }
        if (!entryPlayer3.getText().isEmpty()) {
            Game.getInstance().addPlayer(new Player(i, entryPlayer3.getText()));
            i++;
        }
        if (!entryPlayer4.getText().isEmpty()) {
            Game.getInstance().addPlayer(new Player(i, entryPlayer4.getText()));
            i++;
        }

        if(Game.getInstance().getPlayers().len()>=2){
            Parent gameWindow = FXMLLoader.load(this.getClass().getResource("GameWindow.fxml"));
            Stage stage = (Stage) playButton.getScene().getWindow();
            stage.setScene(new Scene(gameWindow));

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Hey!");
            alert.setHeaderText("Stop, Friendship Police Department!\n\nThis game is developed to be played\nwith friends, please install any social\nnetwork, get some friends and come\nback, OK?");
            alert.showAndWait().ifPresent(reply -> {
                if (reply == ButtonType.OK) {
                }
            });
        }
    }
}
