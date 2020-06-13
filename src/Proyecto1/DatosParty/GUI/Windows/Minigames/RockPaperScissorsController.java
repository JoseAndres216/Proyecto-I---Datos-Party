package Proyecto1.DatosParty.GUI.Windows.Minigames;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class RockPaperScissorsController extends Application {
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
    public boolean isPlayer2_choosing = false;
    public boolean EndGame = false;
    private Player player1, player2;

    private static RockPaperScissorsController instance = null;

    public void play(SimpleLinkedList<Player> players) throws IOException {
        System.out.println(players.accessNode(0) + " and " + players.accessNode(1) + "\n" +
                "are playing Rock Paper Scissors");
        this.player1 = players.accessNode(0);
        this.player2 = players.accessNode(1);

        String player1_nickname = players.accessNode(0).nickname;
        String player2_nickname = players.accessNode(1).nickname;

        Player1.setText(player1_nickname);
        Player2.setText(player2_nickname);

        this.Waiting();
    }

    public void Rock1Pressed(KeyEvent event1) throws IOException {
        if (event1.getCode() == KeyCode.Q && isPlayer1_choosing) {

            player1_result = "rock";
            System.out.println(player1_result);

            isPlayer1_choosing = false;
            isPlayer2_choosing = true;

            Paper1.setDisable(true);
            Scissors1.setDisable(true);


            Waiting();

        }
    }

    public void Paper1Pressed(KeyEvent event2) throws IOException {
        if (event2.getCode() == KeyCode.W && isPlayer1_choosing) {
            player1_result = "paper";
            System.out.println(player1_result);

            isPlayer1_choosing = false;
            isPlayer2_choosing = true;

            Rock1.setDisable(true);
            Scissors1.setDisable(true);

            Waiting();
        }
    }

    public void Scissors1Pressed(KeyEvent event3) throws IOException {
        if (event3.getCode() == KeyCode.E && isPlayer1_choosing) {
            player1_result = "scissors";
            System.out.println(player1_result);

            isPlayer1_choosing = false;
            isPlayer2_choosing = true;

            Rock1.setDisable(true);
            Paper1.setDisable(true);

            Waiting();
        }

    }

    public void Rock2Pressed(KeyEvent event4) throws IOException {
        if (event4.getCode() == KeyCode.I && isPlayer2_choosing) {
            player2_result = "rock";
            isPlayer2_choosing = false;
            Paper2.setDisable(true);

            System.out.println(player2_result);
            Scissors2.setDisable(true);
            Waiting();
        }
    }

    public void Paper2Pressed(KeyEvent event5) throws IOException {
        if (event5.getCode() == KeyCode.O && isPlayer2_choosing) {
            player2_result = "paper";
            isPlayer2_choosing = false;
            Rock2.setDisable(true);
            Scissors2.setDisable(true);
            System.out.println(player2_result);
            Waiting();
        }
    }

    public void Scissors2Pressed(KeyEvent event6) throws IOException {
        if (event6.getCode() == KeyCode.P && isPlayer2_choosing) {
            player2_result = "scissors";
            isPlayer2_choosing = false;
            Rock2.setDisable(true);
            Paper2.setDisable(true);
            System.out.println(player2_result);
            Waiting();
        }
    }


    public void Waiting() throws IOException {
        if (isPlayer1_choosing && !isPlayer2_choosing) {
            Result.setText("Waiting for player1");
        }
        if (!isPlayer1_choosing && isPlayer2_choosing) {
            Result.setText("Waiting for player2");
        } else {
            finishGame();
        }
    }


    public void finishGame() throws IOException {
        if (player1_result.equals("rock") && player2_result.equals("rock")) {
            Result.setText("You both choose ROCK.Try again");
            Paper1.setDisable(false);
            Scissors1.setDisable(false);
            Paper2.setDisable(false);
            Scissors2.setDisable(false);
            isPlayer1_choosing = true;
            isPlayer2_choosing = true;

        }
        if (player1_result.equals("paper") && player2_result.equals("paper")) {
            Result.setText("You both choose PAPER.Try again");
            Paper1.setDisable(false);
            Scissors1.setDisable(false);
            Paper2.setDisable(false);
            Scissors2.setDisable(false);
            isPlayer1_choosing = true;
            isPlayer2_choosing = true;
        }
        if (player1_result.equals("scissors") && player2_result.equals("scissors")) {
            Result.setText("You both choose SCISSORS.Try again");
            Rock1.setDisable(false);
            Paper1.setDisable(false);
            Rock2.setDisable(false);
            Paper2.setDisable(false);
            isPlayer1_choosing = true;
            isPlayer2_choosing = true;

        }

        if (player1_result.equals("rock") && player2_result.equals("paper")) {
            Result.setText("player2.nickname + Wins!");
            try {
                player1.setMinigamepoints(0);
                player2.setMinigamepoints(4);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            EndGame = true;
        }
        if (player1_result.equals("rock") && player2_result.equals("scissors")) {

            try {
                player1.setMinigamepoints(4);
                player2.setMinigamepoints(5);
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
            Result.setText("player1.nickname + Wins!");
            EndGame = true;
        }
        if (player1_result.equals("paper") && player2_result.equals("rock")) {
            Result.setText("player1.nickname + Wins!");

            try {
                player1.setMinigamepoints(4);
                player2.setMinigamepoints(5);
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
            EndGame = true;
        }
        if (player1_result.equals("paper") && player2_result.equals("scissors")) {
            Result.setText("player2.nickname + Wins!");

            try {
                player1.setMinigamepoints(5);
                player2.setMinigamepoints(4);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            EndGame = true;
        }
        if (player1_result.equals("scissors") && player2_result.equals("rock")) {
            Result.setText("player2.nickname + Wins!");
            try {

                player1.setMinigamepoints(5);
                player2.setMinigamepoints(4);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            EndGame = true;
        }
        if (player1_result.equals("scissors") && player2_result.equals("paper")) {
            Result.setText("player1.nickname + Wins!");
            try {
                player1.setMinigamepoints(4);
                player2.setMinigamepoints(5);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            EndGame = true;
        }
        if (this.EndGame) {
            Game.getInstance().giveMoney();
            Stage stage = (Stage) this.Player1.getScene().getWindow();
            stage.close();
        }
    }


    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource("RockPaperScissors.fxml"));
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setTitle("Datos Party!");
        primaryStage.setScene(new Scene(root));
        primaryStage.resizableProperty().setValue(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setFullScreen(false);
        primaryStage.show();
    }

    public void startMinigame(SimpleLinkedList<Player> players) throws Exception {
        this.start(new Stage());
        this.play(players);
    }

    public synchronized static RockPaperScissorsController getInstance() {
        if (instance == null) {
            instance = new RockPaperScissorsController();
        }
        return instance;
    }
}

