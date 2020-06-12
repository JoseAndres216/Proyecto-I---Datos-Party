package Proyecto1.DatosParty.GUI.Windows.Minigames;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Events.Event;
import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class RocketsController extends Minigame{
    private SimpleLinkedList<Player> players = Game.getInstance().getPlayers();
    int points1 = 0, points2 = 0, points3 = 0, points4 = 0;

    @FXML Label lblPlayer1;
    @FXML Label lblPlayer2;
    @FXML Label lblPlayer3;
    @FXML Label lblPlayer4;
    @FXML Label lblWinner1;
    @FXML Label lblWinner2;
    @FXML Label lblWinner3;
    @FXML Label lblWinner4;
    @FXML Button btnPlay;
    @FXML TextField txtPoints1;
    @FXML TextField txtPoints2;
    @FXML TextField txtPoints3;
    @FXML TextField txtPoints4;


    @Override
    public void play(SimpleLinkedList<Player> players) throws IOException, InterruptedException {
        this.players=players;
        for (int i = 0; i < players.len(); i++) {
            players.accessNode(i).setMinigamepoints(0);
        }
        switch(players.len()){
            case 2:
                lblPlayer1.setText(players.accessNode(0).nickname);
                lblPlayer2.setText(players.accessNode(1).nickname);
                lblPlayer3.setText("");
                txtPoints3.setText("");
                lblPlayer4.setText("");
                txtPoints4.setText("");
                break;
            case 3:
                lblPlayer1.setText(players.accessNode(0).nickname);
                lblPlayer2.setText(players.accessNode(1).nickname);
                lblPlayer3.setText(players.accessNode(2).nickname);
                lblPlayer4.setText("");
                txtPoints4.setText("");
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
        if(points1==50 || points2==50 || points3==50 || points4==50){
            btnPlay.setOnKeyReleased(null);
            if(points1==50){
                lblWinner1.setVisible(true);
            } else if(points2==50){
                lblWinner2.setVisible(true);
            } else if(points3==50){
                lblWinner3.setVisible(true);
            } else{
                lblWinner4.setVisible(true);
            }
            finishGame();
        }else{
            if (event.getCode() == KeyCode.Q) {
                points1++;
                players.accessNode(0).setMinigamepoints(points1);
                txtPoints1.setText(""+points1);
            }else if (event.getCode() == KeyCode.R) {
                points2++;
                players.accessNode(1).setMinigamepoints(points2);
                txtPoints2.setText(""+points2);
            } else if (event.getCode() == KeyCode.U && players.len()==3) {
                points3++;
                players.accessNode(2).setMinigamepoints(points3);
                txtPoints3.setText(""+points3);
            } else if (event.getCode() == KeyCode.P && players.len()==4) {
                points4++;
                players.accessNode(3).setMinigamepoints(points4);
                txtPoints4.setText(""+points4);
            }
        }
    }

    private void finishGame() throws IOException {
        int i = 0;
        while(i<players.len()){
            if(players.accessNode(i).getMinigamepoints() == 50){
                players.accessNode(i).setMinigamepoints(4);
            }else{
                players.accessNode(i).setMinigamepoints(2);
            }
            i++;
        }

        Game.getInstance().giveMoney();
    }

    public void btnPlaypressed(){
        for (int i = 0; i < players.len(); i++) {
            players.accessNode(i).setMinigamepoints(0);
        }
        switch(players.len()){
            case 2:
                lblPlayer1.setText(players.accessNode(0).nickname);
                lblPlayer1.setVisible(true);
                txtPoints1.setText(""+0);
                lblPlayer2.setText(players.accessNode(1).nickname);
                lblPlayer2.setVisible(true);
                txtPoints2.setText(""+0);
                break;
            case 3:
                lblPlayer1.setText(players.accessNode(0).nickname);
                lblPlayer1.setVisible(true);
                txtPoints1.setText(""+0);
                lblPlayer2.setText(players.accessNode(1).nickname);
                lblPlayer2.setVisible(true);
                txtPoints2.setText(""+0);
                lblPlayer3.setText(players.accessNode(2).nickname);
                lblPlayer3.setVisible(true);
                txtPoints3.setText(""+0);
                break;
            case 4:
                lblPlayer1.setText(players.accessNode(0).nickname);
                lblPlayer1.setVisible(true);
                txtPoints1.setText(""+0);
                lblPlayer2.setText(players.accessNode(1).nickname);
                lblPlayer2.setVisible(true);
                txtPoints2.setText(""+0);
                lblPlayer3.setText(players.accessNode(2).nickname);
                lblPlayer3.setVisible(true);
                txtPoints3.setText(""+0);
                lblPlayer4.setText(players.accessNode(3).nickname);
                lblPlayer4.setVisible(true);
                txtPoints4.setText(""+0);
                break;

        }
    }

    @Override
    public void interact(Player player) {

    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
