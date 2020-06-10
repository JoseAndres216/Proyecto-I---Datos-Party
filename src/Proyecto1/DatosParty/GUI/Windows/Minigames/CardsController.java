package Proyecto1.DatosParty.GUI.Windows.Minigames;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Events.Event;
import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class CardsController extends Minigame{
    int player = 0;
    private SimpleLinkedList<Player> players = Game.getInstance().getPlayers();
    private Player card1, card2, card3, card4;
    private int numCard1, numCard2, numCard3, numCard4;

    @FXML Button btnChoose1;
    @FXML Button btnChoose2;
    @FXML Button btnChoose3;
    @FXML Button btnChoose4;

    @Override
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

    public void btnChoose1pressed() throws IOException {
        card1 = players.accessNode(this.player);
        btnChoose1.setDisable(true);
        isNextplayer();
    }
    public void btnChoose2pressed() throws IOException {
        card2 = players.accessNode(this.player);
        btnChoose2.setDisable(true);
        isNextplayer();
    }
    public void btnChoose3pressed() throws IOException {
        card3 = players.accessNode(this.player);
        btnChoose3.setDisable(true);
        isNextplayer();
    }
    public void btnChoose4pressed() throws IOException {
        card4 = players.accessNode(this.player);
        btnChoose4.setDisable(true);
        isNextplayer();
    }

    public void isNextplayer() throws IOException {
        if(this.player<players.len()-1){
            this.player++;
        }
        else{
            btnChoose1.setDisable(true);
            btnChoose2.setDisable(true);
            btnChoose3.setDisable(true);
            btnChoose4.setDisable(true);
            mixCards();
            finishGame();
        }
    }

    public void finishGame() throws IOException {
        if(card1!=null){
            card1.setMinigamepoints(numCard1);
        }

        if (card2 != null) {
            card2.setMinigamepoints(numCard2);
        }

        if(card3!=null){
            card3.setMinigamepoints(numCard3);
        }

        if(card4!=null){
            card4.setMinigamepoints(numCard4);
        }
        Game.getInstance().giveMoney();
    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
