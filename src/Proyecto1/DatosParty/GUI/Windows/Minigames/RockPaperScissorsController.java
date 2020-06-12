package Proyecto1.DatosParty.GUI.Windows.Minigames;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Events.Event;
import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;


public class RockPaperScissorsController extends Minigame {
    @FXML
    Label Player1;
    @FXML
    Button Rock1;
    @FXML
    Button Paper1;
    @FXML
    Button Scissors1;
    @FXML
    Label Player2;
    @FXML
    Button Rock2;
    @FXML
    Button Paper2;
    @FXML
    Button Scissors2;
    @FXML
    Label Result;
    public String player1_result = "choose";
    public String player2_result = "choose";
    public boolean isPlayer1_choosing = true;
    public boolean isPlayer2_choosing = true;
    public boolean EndGame = false;
    private Player player1, player2;


    @Override
    public void play(SimpleLinkedList<Player> players) throws IOException {
        System.out.println(players.accessNode(0) + " and " + players.accessNode(1) + "\n" +
                "are playing Rock Paper Scissors");
        player1 = players.accessNode(0);
        player2 = players.accessNode(1);
        //Player1.setText(player1.nickname);
    }

    public void Rock1Pressed(KeyEvent event1) throws IOException {
        if (event1.getCode() == KeyCode.Q) {
            player1_result = "rock";
            isPlayer1_choosing = false;
            Rock1.setDisable(true);
            Paper1.setDisable(true);
            Scissors1.setDisable(true);
            System.out.println(player1_result);
            Waiting();
        }
    }

    public void Paper1Pressed(KeyEvent event2) throws IOException{
        if (event2.getCode() == KeyCode.W) {
            player1_result = "paper";
            isPlayer1_choosing = false;
            Rock1.setDisable(true);
            Paper1.setDisable(true);
            Scissors1.setDisable(true);
            System.out.println(player1_result);
            Waiting();
        }
    }

    public void Scissors1Pressed(KeyEvent event3) throws IOException {
        if (event3.getCode() == KeyCode.E) {
            player1_result = "scissors";
            isPlayer1_choosing = false;
            Rock1.setDisable(true);
            Paper1.setDisable(true);
            Scissors1.setDisable(true);
            Waiting();
        }

    }

    public void Rock2Pressed(KeyEvent event4) throws IOException {
        if (event4.getCode() == KeyCode.I) {
            player2_result = "rock";
            isPlayer2_choosing = false;
            Rock2.setDisable(true);
            Paper2.setDisable(true);
            Scissors2.setDisable(true);
            Waiting();
        }
    }

    public void Paper2Pressed(KeyEvent event5) throws IOException {
        if (event5.getCode() == KeyCode.O) {
            player2_result = "paper";
            isPlayer2_choosing = false;
            Rock2.setDisable(true);
            Paper2.setDisable(true);
            Scissors2.setDisable(true);
            Waiting();
        }
    }

    public void Scissors2Pressed(KeyEvent event6) throws IOException {
        if (event6.getCode() == KeyCode.P) {
            player2_result = "scissors";
            isPlayer2_choosing = false;
            Rock2.setDisable(true);
            Paper2.setDisable(true);
            Scissors2.setDisable(true);
            Waiting();
        }
    }


    public void Waiting() throws IOException {
        if (isPlayer1_choosing == true && isPlayer2_choosing == false) {
            Result.setText("Waiting for player1");
        }
        if (isPlayer1_choosing == false && isPlayer2_choosing == true) {
            Result.setText("Waiting for player2");
        }
        else{
            finishGame();
        }
    }


    public void finishGame() throws IOException {
            if (player1_result == "rock") {
                if (player2_result == "rock") {
                    Result.setText("You both choose ROCK.Try again");
                    Rock1.setDisable(false);
                    Rock2.setDisable(false);
                    Paper1.setDisable(false);
                    Paper2.setDisable(false);
                    Scissors1.setDisable(false);
                    Scissors2.setDisable(false);
                    isPlayer1_choosing = true;
                    isPlayer2_choosing = true;
                }
                if (player2_result == "paper") {
                    Result.setText("player2.nickname + Wins!");
                    Rock1.setDisable(true);
                    Rock2.setDisable(true);
                    Paper1.setDisable(true);
                    Paper2.setDisable(true);
                    Scissors1.setDisable(true);
                    Scissors2.setDisable(true);
                    player1.setMinigamepoints(0);
                    player2.setMinigamepoints(4);
                    EndGame = true;
                }
                if (player2_result == "scissors") {
                    Result.setText("player1.nickname + Wins!");
                    Rock1.setDisable(true);
                    Rock2.setDisable(true);
                    Paper1.setDisable(true);
                    Paper2.setDisable(true);
                    Scissors1.setDisable(true);
                    Scissors2.setDisable(true);
                    player1.setMinigamepoints(4);
                    player2.setMinigamepoints(5);
                    EndGame = true;

                }
            }
            if (player1_result == "paper") {
                if (player2_result == "rock") {
                    Result.setText("player1.nickname + Wins!");
                    Rock1.setDisable(true);
                    Rock2.setDisable(true);
                    Paper1.setDisable(true);
                    Paper2.setDisable(true);
                    Scissors1.setDisable(true);
                    Scissors2.setDisable(true);
                    player1.setMinigamepoints(4);
                    player2.setMinigamepoints(5);
                    EndGame = true;
                }
                if (player2_result == "paper") {
                    Result.setText("You both choose PAPER.Try again");
                    Rock1.setDisable(false);
                    Rock2.setDisable(false);
                    Paper1.setDisable(false);
                    Paper2.setDisable(false);
                    Scissors1.setDisable(false);
                    Scissors2.setDisable(false);
                    //player1.setMinigamepoints(1);
                    //player2.setMinigamepoints(1);
                    isPlayer1_choosing = true;
                    isPlayer2_choosing = true;
                }
                if (player2_result == "scissors") {
                    Result.setText("player2.nickname + Wins!");
                    Rock1.setDisable(true);
                    Rock2.setDisable(true);
                    Paper1.setDisable(true);
                    Paper2.setDisable(true);
                    Scissors1.setDisable(true);
                    Scissors2.setDisable(true);
                    player1.setMinigamepoints(5);
                    player2.setMinigamepoints(4);
                    EndGame = true;
                }

            }
            if (player1_result == "scissors") {
                if (player2_result == "rock") {
                    Result.setText("player2.nickname + Wins!");
                    Rock1.setDisable(true);
                    Rock2.setDisable(true);
                    Paper1.setDisable(true);
                    Paper2.setDisable(true);
                    Scissors1.setDisable(true);
                    Scissors2.setDisable(true);
                    player1.setMinigamepoints(5);
                    player2.setMinigamepoints(4);
                    EndGame = true;

                }
                if (player2_result == "paper") {
                    Result.setText("player1.nickname + Wins!");
                    Rock1.setDisable(true);
                    Rock2.setDisable(true);
                    Paper1.setDisable(true);
                    Paper2.setDisable(true);
                    Scissors1.setDisable(true);
                    Scissors2.setDisable(true);
                    player1.setMinigamepoints(4);
                    player2.setMinigamepoints(5);
                    EndGame = true;

                }
                if (player2_result == "scissors") {
                    Result.setText("You both choose SCISSORS.Try again");
                    Rock1.setDisable(false);
                    Rock2.setDisable(false);
                    Paper1.setDisable(false);
                    Paper2.setDisable(false);
                    Scissors1.setDisable(false);
                    Scissors2.setDisable(false);
                    //player1.setMinigamepoints(1);
                    //player2.setMinigamepoints(1);
                    isPlayer1_choosing = true;
                    isPlayer2_choosing = true;
                }
            }
            Game.getInstance().giveMoney();
        }



    @Override
    public int compareTo(Event o) {
        return 0;
    }

    @Override
    public void interact(Player player) {

    }
}

