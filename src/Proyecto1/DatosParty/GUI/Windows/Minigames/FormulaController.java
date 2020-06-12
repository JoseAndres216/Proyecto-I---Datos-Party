package Proyecto1.DatosParty.GUI.Windows.Minigames;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Events.Event;
import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class FormulaController extends Minigame{
    private SimpleLinkedList<Player> players = Game.getInstance().getPlayers();
    int position1 = 0, position2 = 0, position3 = 0, position4 = 0;

    @FXML Label lblPlayer1;
    @FXML Label lblPlayer2;
    @FXML Label lblPlayer3;
    @FXML Label lblPlayer4;
    @FXML Label lblWinner1;
    @FXML Label lblWinner2;
    @FXML Label lblWinner3;
    @FXML Label lblWinner4;
    @FXML Button btnPlay;
    @FXML ImageView imgCar1;
    @FXML ImageView imgCar2;
    @FXML ImageView imgCar3;
    @FXML ImageView imgCar4;


    @Override
    public void play(SimpleLinkedList<Player> players) throws IOException, InterruptedException {
        this.players = players;

        for (int i = 0; i < players.len(); i++) {
            players.accessNode(i).setMinigamepoints(0);
        }
        switch(players.len()){
            case 2:
                lblPlayer1.setText(players.accessNode(0).nickname);
                lblPlayer2.setText(players.accessNode(1).nickname);
                lblPlayer3.setText("");
                lblPlayer4.setText("");
                break;
            case 3:
                lblPlayer1.setText(players.accessNode(0).nickname);
                lblPlayer2.setText(players.accessNode(1).nickname);
                lblPlayer3.setText(players.accessNode(2).nickname);
                lblPlayer4.setText("");
                break;
            case 4:
                lblPlayer1.setText(players.accessNode(0).nickname);
                lblPlayer2.setText(players.accessNode(1).nickname);
                lblPlayer3.setText(players.accessNode(2).nickname);
                lblPlayer4.setText(players.accessNode(3).nickname);
                break;

        }
    }

    public void keyPressed(KeyEvent event) throws IOException {
        if(position1==860 || position2==860 || position3==860 || position4==860){
            btnPlay.setOnKeyReleased(null);
            if(position1==860){
                lblWinner1.setVisible(true);
            } else if(position2==860){
                lblWinner2.setVisible(true);
            } else if(position3==860){
                lblWinner3.setVisible(true);
            } else{
                lblWinner4.setVisible(true);
            }
            finishGame();
        }else{
            if (event.getCode() == KeyCode.Q) {
                position1+=10;
                players.accessNode(0).setMinigamepoints(position1);
                imgCar1.setX(position1);
            }else if (event.getCode() == KeyCode.R) {
                position2+=10;
                players.accessNode(1).setMinigamepoints(position2);
                imgCar2.setX(position2);
            } else if (event.getCode() == KeyCode.U && players.len()==3) {
                position3+=10;
                players.accessNode(2).setMinigamepoints(position3);
                imgCar3.setX(position3);
            } else if (event.getCode() == KeyCode.P && players.len()==4) {
                position4+=10;
                players.accessNode(3).setMinigamepoints(position4);
                imgCar4.setX(position4);
            }
        }
    }

    public void btnPlaypressed(){
        this.players = players;

        for (int i = 0; i < players.len(); i++) {
            players.accessNode(i).setMinigamepoints(0);
        }
        switch(players.len()){
            case 2:
                lblPlayer1.setText(players.accessNode(0).nickname);
                lblPlayer1.setVisible(true);
                lblPlayer2.setText(players.accessNode(1).nickname);
                lblPlayer2.setVisible(true);
                lblPlayer3.setText("");
                lblPlayer4.setText("");
                break;
            case 3:
                lblPlayer1.setText(players.accessNode(0).nickname);
                lblPlayer1.setVisible(true);
                lblPlayer2.setText(players.accessNode(1).nickname);
                lblPlayer2.setVisible(true);
                lblPlayer3.setText(players.accessNode(2).nickname);
                lblPlayer3.setVisible(true);
                lblPlayer4.setText("");
                break;
            case 4:
                lblPlayer1.setText(players.accessNode(0).nickname);
                lblPlayer1.setVisible(true);
                lblPlayer2.setText(players.accessNode(1).nickname);
                lblPlayer2.setVisible(true);
                lblPlayer3.setText(players.accessNode(2).nickname);
                lblPlayer3.setVisible(true);
                lblPlayer4.setText(players.accessNode(3).nickname);
                lblPlayer4.setVisible(true);
                break;

        }
    }

    private void finishGame() throws IOException {
        int i = 0;
        while(i<players.len()){
            if(players.accessNode(i).getMinigamepoints() == 860){
                players.accessNode(i).setMinigamepoints(4);
            }else{
                players.accessNode(i).setMinigamepoints(2);
            }
            i++;
        }

        Game.getInstance().giveMoney();
    }

    @Override
    public void interact(Player player) {

    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
