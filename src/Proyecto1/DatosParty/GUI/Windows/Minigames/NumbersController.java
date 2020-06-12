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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class NumbersController extends Application {
    int player = 0;
    int theNumber = (int) (Math.random()*((9-0)+1))+0;
    private SimpleLinkedList<Player> players = Game.getInstance().getPlayers();
    private Player num1, num2, num3, num4, num5, num6, num7, num8, num9, num0;
    private int numCard1;

    @FXML Label lblsecretNumber;
    @FXML Button btnNum1;
    @FXML Button btnNum2;
    @FXML Button btnNum3;
    @FXML Button btnNum4;
    @FXML Button btnNum5;
    @FXML Button btnNum6;
    @FXML Button btnNum7;
    @FXML Button btnNum8;
    @FXML Button btnNum9;
    @FXML Button btnNum0;

    public void play(SimpleLinkedList<Player> players) throws IOException {
        for (int i = 0; i < players.len()-1; i++) {
            players.accessNode(i).setMinigamepoints(0);
        }
        this.players = players;
    }

    public void btnNum1pressed() throws IOException {
        num1 = players.accessNode(player);
        btnNum1.setDisable(true);
        isNextplayer();
    }
    public void btnNum2pressed() throws IOException {
        num2 = players.accessNode(player);
        btnNum2.setDisable(true);
        isNextplayer();
    }
    public void btnNum3pressed() throws IOException {
        num3 = players.accessNode(player);
        btnNum3.setDisable(true);
        isNextplayer();
    }
    public void btnNum4pressed() throws IOException {
        num4 = players.accessNode(player);
        btnNum4.setDisable(true);
        isNextplayer();
    }
    public void btnNum5pressed() throws IOException {
        num5 = players.accessNode(player);
        btnNum5.setDisable(true);
        isNextplayer();
    }
    public void btnNum6pressed() throws IOException {
        num6 = players.accessNode(player);
        btnNum6.setDisable(true);
        isNextplayer();
    }
    public void btnNum7pressed() throws IOException {
        num7 = players.accessNode(player);
        btnNum7.setDisable(true);
        isNextplayer();
    }
    public void btnNum8pressed() throws IOException {
        num8 = players.accessNode(player);
        btnNum8.setDisable(true);
        isNextplayer();
    }
    public void btnNum9pressed() throws IOException {
        num9 = players.accessNode(player);
        btnNum9.setDisable(true);
        isNextplayer();
    }
    public void btnNum0pressed() throws IOException {
        num0 = players.accessNode(player);
        btnNum0.setDisable(true);
        isNextplayer();
    }



    public void isNextplayer() throws IOException {
        if(this.player<players.len()-1){
            this.player++;
        }
        else{
            btnNum1.setDisable(true);
            btnNum2.setDisable(true);
            btnNum3.setDisable(true);
            btnNum4.setDisable(true);
            btnNum5.setDisable(true);
            btnNum6.setDisable(true);
            btnNum7.setDisable(true);
            btnNum8.setDisable(true);
            btnNum9.setDisable(true);
            btnNum0.setDisable(true);
            finishGame();
        }
    }

    public void finishGame() throws IOException {
        lblsecretNumber.setText(""+theNumber);
        int points = 4;
        switch(this.theNumber){
            case 1:
                if(num1!=null){
                    num1.setMinigamepoints(points);
                    points--;
                }
                if(num2!=null){
                    num2.setMinigamepoints(points);
                    points--;
                }
                if(num3!=null){
                    num3.setMinigamepoints(points);
                    points--;
                }
                if(num4!=null){
                    num4.setMinigamepoints(points);
                    points--;
                }
                if(num5!=null){
                    num5.setMinigamepoints(points);
                    points--;
                }
                if(num6!=null){
                    num6.setMinigamepoints(points);
                    points--;
                }
                if(num7!=null){
                    num7.setMinigamepoints(points);
                    points--;
                }
                if(num8!=null){
                    num8.setMinigamepoints(points);
                    points--;
                }
                if(num9!=null){
                    num9.setMinigamepoints(points);
                    points--;
                }
                if(num0!=null){
                    num0.setMinigamepoints(points);
                    points--;
                }
                break;
            case 2:
                if(num2!=null){
                    num2.setMinigamepoints(points);
                    points--;
                }
                if(num1!=null || num3!=null){
                    if(num1!=null){
                        num1.setMinigamepoints(points);
                    }
                    if(num3!=null){
                        num3.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num4!=null){
                    num4.setMinigamepoints(points);
                    points--;
                }
                if(num5!=null){
                    num5.setMinigamepoints(points);
                    points--;
                }
                if(num6!=null){
                    num6.setMinigamepoints(points);
                    points--;
                }
                if(num7!=null){
                    num7.setMinigamepoints(points);
                    points--;
                }
                if(num8!=null){
                    num8.setMinigamepoints(points);
                    points--;
                }
                if(num9!=null){
                    num9.setMinigamepoints(points);
                    points--;
                }
                if(num0!=null) {
                    num0.setMinigamepoints(points);
                    points--;
                }
                break;

            case 3:
                if(num3!=null){
                    num3.setMinigamepoints(points);
                    points--;
                }
                if(num2!=null || num4!=null){
                    if(num2!=null){
                        num2.setMinigamepoints(points);
                    }
                    if(num4!=null){
                        num4.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num1!=null || num5!=null){
                    if(num1!=null){
                        num1.setMinigamepoints(points);
                    }
                    if(num5!=null){
                        num5.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num6!=null) {
                    num6.setMinigamepoints(points);
                    points--;
                }
                if(num7!=null) {
                    num7.setMinigamepoints(points);
                    points--;
                }
                if(num8!=null) {
                    num8.setMinigamepoints(points);
                    points--;
                }
                if(num9!=null) {
                    num9.setMinigamepoints(points);
                    points--;
                }
                if(num0!=null) {
                    num0.setMinigamepoints(points);
                    points--;
                }
                break;
            case 4:
                if(num4!=null){
                    num4.setMinigamepoints(points);
                    points--;
                }
                if(num3!=null || num5!=null){
                    if(num3!=null){
                        num3.setMinigamepoints(points);
                    }
                    if(num5!=null){
                        num5.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num2!=null || num6!=null){
                    if(num2!=null){
                        num2.setMinigamepoints(points);
                    }
                    if(num6!=null){
                        num6.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num1!=null || num7!=null){
                    if(num1!=null){
                        num1.setMinigamepoints(points);
                    }
                    if(num7!=null){
                        num7.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num8!=null) {
                    num8.setMinigamepoints(points);
                    points--;
                }
                if(num9!=null) {
                    num9.setMinigamepoints(points);
                    points--;
                }
                if(num0!=null) {
                    num0.setMinigamepoints(points);
                    points--;
                }
                break;

            case 5:
                if(num5!=null){
                    num5.setMinigamepoints(points);
                    points--;
                }
                if(num4!=null || num6!=null){
                    if(num4!=null){
                        num4.setMinigamepoints(points);
                    }
                    if(num6!=null){
                        num6.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num3!=null || num7!=null){
                    if(num3!=null){
                        num3.setMinigamepoints(points);
                    }
                    if(num7!=null){
                        num7.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num2!=null || num8!=null){
                    if(num2!=null){
                        num2.setMinigamepoints(points);
                    }
                    if(num8!=null){
                        num8.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num1!=null || num9!=null){
                    if(num1!=null){
                        num1.setMinigamepoints(points);
                    }
                    if(num9!=null){
                        num9.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num0!=null) {
                    num0.setMinigamepoints(points);
                    points--;
                }
                break;

            case 6:
                if(num6!=null){
                    num6.setMinigamepoints(points);
                    points--;
                }
                if(num5!=null || num7!=null){
                    if(num5!=null){
                        num5.setMinigamepoints(points);
                    }
                    if(num7!=null){
                        num7.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num4!=null || num8!=null){
                    if(num4!=null){
                        num4.setMinigamepoints(points);
                    }
                    if(num8!=null){
                        num8.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num3!=null || num9!=null){
                    if(num3!=null){
                        num3.setMinigamepoints(points);
                    }
                    if(num9!=null){
                        num9.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num2!= null || num0!=null){
                    if(num2!=null) {
                        num2.setMinigamepoints(points);
                        points--;
                    }
                    if(num0!=null) {
                        num0.setMinigamepoints(points);
                        points--;
                    }
                }
                if(num1!=null) {
                    num1.setMinigamepoints(points);
                    points--;
                }
                break;

            case 7:
                if(num7!=null){
                    num7.setMinigamepoints(points);
                    points--;
                }
                if(num6!=null || num8!=null){
                    if(num6!=null){
                        num6.setMinigamepoints(points);
                    }
                    if(num8!=null){
                        num8.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num5!=null || num9!=null){
                    if(num5!=null){
                        num5.setMinigamepoints(points);
                    }
                    if(num9!=null){
                        num9.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num4!=null || num0!=null){
                    if(num4!=null){
                        num4.setMinigamepoints(points);
                    }
                    if(num0!=null){
                        num0.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num3!=null) {
                    num3.setMinigamepoints(points);
                    points--;
                }
                if(num2!=null) {
                    num2.setMinigamepoints(points);
                    points--;
                }
                if(num1!=null) {
                    num1.setMinigamepoints(points);
                    points--;
                }
                break;

            case 8:
                if(num8!=null){
                    num8.setMinigamepoints(points);
                    points--;
                }
                if(num7!=null || num9!=null){
                    if(num7!=null){
                        num7.setMinigamepoints(points);
                    }
                    if(num9!=null){
                        num9.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num6!=null || num0!=null){
                    if(num6!=null){
                        num6.setMinigamepoints(points);
                    }
                    if(num0!=null){
                        num0.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num5!=null) {
                    num5.setMinigamepoints(points);
                    points--;
                }
                if(num4!=null) {
                    num4.setMinigamepoints(points);
                    points--;
                }
                if(num3!=null) {
                    num3.setMinigamepoints(points);
                    points--;
                }
                if(num2!=null) {
                    num2.setMinigamepoints(points);
                    points--;
                }
                if(num1!=null) {
                    num1.setMinigamepoints(points);
                    points--;
                }
                break;

            case 9:
                if(num9!=null){
                    num9.setMinigamepoints(points);
                    points--;
                }
                if(num8!=null || num0!=null){
                    if(num8!=null){
                        num8.setMinigamepoints(points);
                    }
                    if(num0!=null){
                        num0.setMinigamepoints(points);
                        points--;
                    }
                    points--;
                }
                if(num7!=null){
                    num7.setMinigamepoints(points);
                    points--;
                }
                if(num6!=null){
                    num6.setMinigamepoints(points);
                    points--;
                }
                if(num5!=null){
                    num5.setMinigamepoints(points);
                    points--;
                }
                if(num4!=null){
                    num4.setMinigamepoints(points);
                    points--;
                }
                if(num3!=null){
                    num3.setMinigamepoints(points);
                    points--;
                }
                if(num2!=null){
                    num2.setMinigamepoints(points);
                    points--;
                }
                if(num1!=null) {
                    num1.setMinigamepoints(points);
                    points--;
                }
                break;
            case 0:
                if(num0!=null){
                    num0.setMinigamepoints(points);
                    points--;
                }
                if(num9!=null){
                    num9.setMinigamepoints(points);
                    points--;
                }
                if(num8!=null){
                    num8.setMinigamepoints(points);
                    points--;
                }
                if(num7!=null){
                    num7.setMinigamepoints(points);
                    points--;
                }
                if(num6!=null){
                    num6.setMinigamepoints(points);
                    points--;
                }
                if(num5!=null){
                    num5.setMinigamepoints(points);
                    points--;
                }
                if(num4!=null){
                    num4.setMinigamepoints(points);
                    points--;
                }
                if(num3!=null){
                    num3.setMinigamepoints(points);
                    points--;
                }
                if(num2!=null){
                    num2.setMinigamepoints(points);
                    points--;
                }
                if(num1!=null){
                    num1.setMinigamepoints(points);
                    points--;
                }
                break;
        }
        System.out.println("El numero secreto fue: " + this.theNumber);
        for (int i = 0; i < players.len(); i++) {
            System.out.println(players.accessNode(i).nickname + " puntuo: " + players.accessNode(i).getMinigamepoints());
        }
        Game.getInstance().giveMoney();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Numbers.fxml"));
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setTitle("Datos Party!");
        primaryStage.setScene(new Scene(root));
        primaryStage.resizableProperty().setValue(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setFullScreen(false);
        primaryStage.show();
    }
}
