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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LuckyStickController extends Application {
    private int player = 0;
    private SimpleLinkedList<Player> players = Game.getInstance().getPlayers();
    private Player stick1, stick2, stick3, stick4;
    public int height1 = 250, height2 = 220, height3 = 190, height4 = 160;
    private double option = (Math.random()*((9-0)+1))+0;

    @FXML ImageView imgStick1;
    @FXML ImageView imgStick2;
    @FXML ImageView imgStick3;
    @FXML ImageView imgStick4;
    @FXML ImageView imgHand;
    @FXML Button btnStick1;
    @FXML Button btnStick2;
    @FXML Button btnStick3;
    @FXML Button btnStick4;

    public void play(SimpleLinkedList<Player> players) throws IOException {
        for (int i = 0; i < players.len()-1; i++) {
            players.accessNode(i).setMinigamepoints(0);
        }
        this.players = players;
        asignSticks();
    }

    public void asignSticks(){
        switch((int) option){
            case 0:
                imgStick1.setFitHeight(height1);
                imgStick2.setFitHeight(height3);
                imgStick3.setFitHeight(height2);
                imgStick4.setFitHeight(height4);
                break;
            case 1:
                imgStick1.setFitHeight(height2);
                imgStick2.setFitHeight(height1);
                imgStick3.setFitHeight(height3);
                imgStick4.setFitHeight(height4);
                break;
            case 2:
                imgStick1.setFitHeight(height2);
                imgStick2.setFitHeight(height3);
                imgStick3.setFitHeight(height4);
                imgStick4.setFitHeight(height1);
                break;
            case 3:
                imgStick1.setFitHeight(height1);
                imgStick2.setFitHeight(height2);
                imgStick3.setFitHeight(height3);
                imgStick4.setFitHeight(height4);
                break;
            case 4:
                imgStick1.setFitHeight(height4);
                imgStick2.setFitHeight(height3);
                imgStick3.setFitHeight(height1);
                imgStick4.setFitHeight(height2);
                break;
            case 5:
                imgStick1.setFitHeight(height3);
                imgStick2.setFitHeight(height1);
                imgStick3.setFitHeight(height2);
                imgStick4.setFitHeight(height4);
                break;
            case 6:
                imgStick1.setFitHeight(height3);
                imgStick2.setFitHeight(height2);
                imgStick3.setFitHeight(height4);
                imgStick4.setFitHeight(height1);
                break;
            case 7:
                imgStick1.setFitHeight(height4);
                imgStick2.setFitHeight(height2);
                imgStick3.setFitHeight(height1);
                imgStick4.setFitHeight(height3);
                break;
            case 8:
                imgStick1.setFitHeight(height1);
                imgStick2.setFitHeight(height3);
                imgStick3.setFitHeight(height4);
                imgStick4.setFitHeight(height2);
                break;
            case 9:
                imgStick1.setFitHeight(height2);
                imgStick2.setFitHeight(height3);
                imgStick3.setFitHeight(height1);
                imgStick4.setFitHeight(height4);
                break;
        }
    }

    public void btnStick1pressed() throws IOException {
        stick1 = players.accessNode(this.player);
        btnStick1.setDisable(true);
        System.out.println(1);
        isNextplayer();
    }
    public void btnStick2pressed() throws IOException {
        stick2 = players.accessNode(this.player);
        btnStick2.setDisable(true);
        isNextplayer();
    }
    public void btnStick3pressed() throws IOException {
        stick3 = players.accessNode(this.player);
        btnStick3.setDisable(true);
        isNextplayer();
    }
    public void btnStick4pressed() throws IOException {
        stick4 = players.accessNode(this.player);
        btnStick4.setDisable(true);
        isNextplayer();
    }

    public void isNextplayer() throws IOException {
        if(this.player<players.len()-1){
            this.player++;
        }
        else{
            btnStick1.setDisable(true);
            btnStick2.setDisable(true);
            btnStick3.setDisable(true);
            btnStick4.setDisable(true);
            asignSticks();
            imgHand.setX(3000);
            finishGame();
        }
    }

    public void finishGame() throws IOException {
        switch((int) option){
            case 0:
                if(stick1!=null){
                    stick1.setMinigamepoints(4);
                }
                if(stick2!=null){
                    stick2.setMinigamepoints(2);
                }
                if(stick3!=null){
                    stick3.setMinigamepoints(3);
                }
                if(stick4!=null){
                    stick4.setMinigamepoints(1);
                }
                break;
            case 1:
                if(stick1!=null){
                    stick1.setMinigamepoints(3);
                }
                if(stick2!=null){
                    stick2.setMinigamepoints(4);
                }
                if(stick3!=null){
                    stick3.setMinigamepoints(2);
                }
                if(stick4!=null){
                    stick4.setMinigamepoints(1);
                }
                break;
            case 2:
                if(stick1!=null){
                    stick1.setMinigamepoints(3);
                }
                if(stick2!=null){
                    stick2.setMinigamepoints(2);
                }
                if(stick3!=null){
                    stick3.setMinigamepoints(1);
                }
                if(stick4!=null){
                    stick4.setMinigamepoints(4);
                }
                break;
            case 3:
                if(stick1!=null){
                    stick1.setMinigamepoints(4);
                }
                if(stick2!=null){
                    stick2.setMinigamepoints(3);
                }
                if(stick3!=null){
                    stick3.setMinigamepoints(2);
                }
                if(stick4!=null){
                    stick4.setMinigamepoints(1);
                }
                break;
            case 4:
                if(stick1!=null){
                    stick1.setMinigamepoints(1);
                }
                if(stick2!=null){
                    stick2.setMinigamepoints(2);
                }
                if(stick3!=null){
                    stick3.setMinigamepoints(4);
                }
                if(stick4!=null){
                    stick4.setMinigamepoints(3);
                }
                break;
            case 5:
                if(stick1!=null){
                    stick1.setMinigamepoints(2);
                }
                if(stick2!=null){
                    stick2.setMinigamepoints(4);
                }
                if(stick3!=null){
                    stick3.setMinigamepoints(3);
                }
                if(stick4!=null){
                    stick4.setMinigamepoints(1);
                }
                break;
            case 6:
                if(stick1!=null){
                    stick1.setMinigamepoints(2);
                }
                if(stick2!=null){
                    stick2.setMinigamepoints(3);
                }
                if(stick3!=null){
                    stick3.setMinigamepoints(1);
                }
                if(stick4!=null){
                    stick4.setMinigamepoints(4);
                }
                break;
            case 7:
                if(stick1!=null){
                    stick1.setMinigamepoints(1);
                }
                if(stick2!=null){
                    stick2.setMinigamepoints(3);
                }
                if(stick3!=null){
                    stick3.setMinigamepoints(4);
                }
                if(stick4!=null){
                    stick4.setMinigamepoints(2);
                }
                break;
            case 8:
                if(stick1!=null){
                    stick1.setMinigamepoints(4);
                }
                if(stick2!=null){
                    stick2.setMinigamepoints(2);
                }
                if(stick3!=null){
                    stick3.setMinigamepoints(1);
                }
                if(stick4!=null){
                    stick4.setMinigamepoints(3);
                }
                break;
            case 9:
                if(stick1!=null){
                    stick1.setMinigamepoints(3);
                }
                if(stick2!=null){
                    stick2.setMinigamepoints(2);
                }
                if(stick3!=null){
                    stick3.setMinigamepoints(4);
                }
                if(stick4!=null){
                    stick4.setMinigamepoints(1);
                }
                break;
        }
        Game.getInstance().giveMoney();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LuckyStick.fxml"));
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setTitle("Datos Party!");
        primaryStage.setScene(new Scene(root));
        primaryStage.resizableProperty().setValue(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setFullScreen(false);
        primaryStage.show();
    }
}
