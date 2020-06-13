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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class CardsController extends Application {
    private int player = 0;
    private SimpleLinkedList<Player> players = Game.getInstance().getPlayers();
    private Player card1, card2, card3, card4;
    private int numCard1, numCard2, numCard3, numCard4;

    @FXML Button btnChoose1;
    @FXML Button btnChoose2;
    @FXML Button btnChoose3;
    @FXML Button btnChoose4;

    @FXML Label lblCard1;
    @FXML Label lblCard2;
    @FXML Label lblCard3;
    @FXML Label lblCard4;

    @FXML ImageView imgCard1;
    @FXML ImageView imgCard2;
    @FXML ImageView imgCard3;
    @FXML ImageView imgCard4;


    public void play(SimpleLinkedList<Player> players) throws IOException {
        for (int i = 0; i < players.len()-1; i++) {
            players.accessNode(i).setMinigamepoints(0);
        }
        this.players = players;
        mixCards();
    }

    public void mixCards(){
        double option = (Math.random()*((9-0)+1))+0;
        switch((int) option){
            case 0:
                numCard1 =1;
                numCard2 =3;
                numCard3 =4;
                numCard4 =2;
                break;
            case 1:
                numCard1 =4;
                numCard2 =1;
                numCard3 =2;
                numCard4 =3;
                break;
            case 2:
                numCard1 =4;
                numCard2 =1;
                numCard3 =3;
                numCard4 =2;
                break;
            case 3:
                numCard1 =2;
                numCard2 =3;
                numCard3 =4;
                numCard4 =1;
                break;
            case 4:
                numCard1 =1;
                numCard2 =2;
                numCard3 =3;
                numCard4 =4;
                break;
            case 5:
                numCard1 =4;
                numCard2 =2;
                numCard3 =1;
                numCard4 =3;
                break;
            case 6:
                numCard1 =3;
                numCard2 =4;
                numCard3 =2;
                numCard4 =1;
                break;
            case 7:
                numCard1 =3;
                numCard2 =1;
                numCard3 =4;
                numCard4 =2;
                break;
            case 8:
                numCard1 =1;
                numCard2 =2;
                numCard3 =4;
                numCard4 =3;
                break;
            case 9:
                numCard1 =4;
                numCard2 =2;
                numCard3 =3;
                numCard4 =1;
                break;
        }
    }

    public void btnChoose1pressed() throws IOException, InterruptedException {
        card1 = players.accessNode(this.player);
        btnChoose1.setDisable(true);
        isNextplayer();
    }
    public void btnChoose2pressed() throws IOException, InterruptedException {
        card2 = players.accessNode(this.player);
        btnChoose2.setDisable(true);
        isNextplayer();
    }
    public void btnChoose3pressed() throws IOException, InterruptedException {
        card3 = players.accessNode(this.player);
        btnChoose3.setDisable(true);
        isNextplayer();
    }
    public void btnChoose4pressed() throws IOException, InterruptedException {
        card4 = players.accessNode(this.player);
        btnChoose4.setDisable(true);
        isNextplayer();
    }

    public void isNextplayer() throws IOException, InterruptedException {
        if(this.player<players.len()-1){
            this.player++;
        }
        else{
            btnChoose1.setDisable(true);
            btnChoose2.setDisable(true);
            btnChoose3.setDisable(true);
            btnChoose4.setDisable(true);

            mixCards();

            lblCard1.setText(""+numCard1);
            lblCard2.setText(""+numCard2);
            lblCard3.setText(""+numCard3);
            lblCard4.setText(""+numCard4);

            imgCard1.setX(2000);
            imgCard2.setX(2000);
            imgCard3.setX(2000);
            imgCard4.setX(2000);

            finishGame();
        }
    }

    public void finishGame() throws IOException, InterruptedException {
        if(card1!=null){
            card1.setMinigamepoints(numCard1);
        }

        if (card2 != null) {
            card2.setMinigamepoints(numCard2);
        }

        if(card3!=null){
            card3.setMinigamepoints(numCard3);
        }

        if (card4 != null) {
            card4.setMinigamepoints(numCard4);
        }
        Stage stage = (Stage)this.btnChoose1.getScene().getWindow();
        Game.getInstance().giveMoney();
        stage.close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Cards.fxml"));
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setTitle("Datos Party!");
        primaryStage.setScene(new Scene(root));
        primaryStage.resizableProperty().setValue(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setFullScreen(false);
        primaryStage.show();
    }

}
