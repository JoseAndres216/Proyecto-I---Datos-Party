package Proyecto1.DatosParty.GUI.Windows.Minigames;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Events.Event;
import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.IOException;

public class VowelsController extends Minigame{
    private int option = (int) (Math.random()*((9-0)+1))+0;
    private SimpleLinkedList<Player> players = Game.getInstance().getPlayers();
    private SimpleLinkedList<Player> num12 = new SimpleLinkedList<>(), num14 = new SimpleLinkedList<>(), num15 = new SimpleLinkedList<>(), num16 = new SimpleLinkedList<>(), num17 = new SimpleLinkedList<>(), num18 = new SimpleLinkedList<>(), num19= new SimpleLinkedList<>(), num22 = new SimpleLinkedList<>(), num52 = new SimpleLinkedList<>(), num53 = new SimpleLinkedList<>();
    private int player = 0;
    private Timeline timeline;

    @FXML Label lblQuote;
    @FXML Label lblAuthor;
    @FXML Button btnNum12;
    @FXML Button btnNum14;
    @FXML Button btnNum15;
    @FXML Button btnNum16;
    @FXML Button btnNum17;
    @FXML Button btnNum18;
    @FXML Button btnNum19;
    @FXML Button btnNum22;
    @FXML Button btnNum52;
    @FXML Button btnNum53;
    @FXML Button btnGo;


    @Override
    public void play(SimpleLinkedList<Player> players) throws IOException, InterruptedException {
        this.players = players;
    }

    private void chooseAndshowQoute() throws InterruptedException {
        switch (option){
            case 0:
                lblQuote.setText('"'+"The first rule of Fight Club is: You do not talk about Fight Club"+'"');
                lblAuthor.setText("Fight Club");
                timeline = new Timeline(
                        new KeyFrame(Duration.seconds(1), e -> {
                            lblQuote.setText("");
                            lblAuthor.setText("");
                        })
                );
                timeline.play();
                break;
            case 1:
                lblQuote.setText('"'+"Get your stinking paws off me, you damned dirty ape!"+'"');
                lblAuthor.setText("Planet of Apes");
                timeline = new Timeline(
                        new KeyFrame(Duration.seconds(0.8), e -> {
                            lblQuote.setText("");
                            lblAuthor.setText("");
                        })
                );
                timeline.play();
                break;
            case 2:
                lblQuote.setText('"'+"They may take our lives, but they'll never take our freedom!"+'"');
                lblAuthor.setText("Braveheart");
                timeline = new Timeline(
                        new KeyFrame(Duration.seconds(1), e -> {
                            lblQuote.setText("");
                            lblAuthor.setText("");
                        })
                );
                timeline.play();
                break;
            case 3:
                lblQuote.setText('"'+"Keep your friends close, but your enemies closer"+'"');
                lblAuthor.setText("The Godfather, Part II");
                timeline = new Timeline(
                        new KeyFrame(Duration.seconds(0.8), e -> {
                            lblQuote.setText("");
                            lblAuthor.setText("");
                        })
                );
                timeline.play();
                break;
            case 4:
                lblQuote.setText('"'+"My name is Maximus Decimus Meridius, commander of the Armies of the North, General of the Felix Legions and loyal servant to the true emperor, Marcus Aurelius"+'"');
                lblAuthor.setText("Gladiator");
                timeline = new Timeline(
                        new KeyFrame(Duration.seconds(3), e -> {
                            lblQuote.setText("");
                            lblAuthor.setText("");
                        })
                );
                timeline.play();
                break;
            case 5:
                lblQuote.setText('"'+"I mean, funny like I'm a clown? Do I amuse you?"+'"');
                lblAuthor.setText("Goodfellas");
                timeline = new Timeline(
                        new KeyFrame(Duration.seconds(0.8), e -> {
                            lblQuote.setText("");
                            lblAuthor.setText("");
                        })
                );
                timeline.play();
                break;
            case 6:
                lblQuote.setText('"'+"Hello. My name is Inigo Montoya. You killed my father. Prepare to die"+'"');
                lblAuthor.setText("The Princess Bride");
                timeline = new Timeline(
                        new KeyFrame(Duration.seconds(1.2), e -> {
                            lblQuote.setText("");
                            lblAuthor.setText("");
                        })
                );
                timeline.play();
                break;
            case 7:
                lblQuote.setText('"'+"You're gonna need a bigger boat"+'"');
                lblAuthor.setText("Jaws");
                timeline = new Timeline(
                        new KeyFrame(Duration.seconds(0.5), e -> {
                            lblQuote.setText("");
                            lblAuthor.setText("");
                        })
                );
                timeline.play();
                break;
            case 8:
                lblQuote.setText('"'+"If you let my daughter go now, that'll be the end of it. I will not look for you, I will not pursue you. But if you don't, I will look for you, I will find you, and I will kill you"+'"');
                lblAuthor.setText("Taken");
                timeline = new Timeline(
                        new KeyFrame(Duration.seconds(3), e -> {
                            lblQuote.setText("");
                            lblAuthor.setText("");
                        })
                );
                timeline.play();
                break;
            case 9:
                lblQuote.setText('"'+"Roads? Where we're going we don't need roads"+'"');
                lblAuthor.setText("Back to future");
                timeline = new Timeline(
                        new KeyFrame(Duration.seconds(0.8), e -> {
                            lblQuote.setText("");
                            lblAuthor.setText("");
                        })
                );
                timeline.play();
                break;
        }
        btnNum12.setDisable(false);
        btnNum14.setDisable(false);
        btnNum15.setDisable(false);
        btnNum16.setDisable(false);
        btnNum17.setDisable(false);
        btnNum18.setDisable(false);
        btnNum19.setDisable(false);
        btnNum22.setDisable(false);
        btnNum52.setDisable(false);
        btnNum53.setDisable(false);
    }

    public void btnNum12pressed() throws IOException {
        num12.insertLast(players.accessNode(this.player));
        isNextplayer();
    }
    public void btnNum14pressed() throws IOException {
        num14.insertLast(players.accessNode(player));
        isNextplayer();
    }
    public void btnNum15pressed() throws IOException {
        num15.insertLast(players.accessNode(player));
        isNextplayer();
    }
    public void btnNum16pressed() throws IOException {
        num16.insertLast(players.accessNode(player));
        isNextplayer();
    }
    public void btnNum17pressed() throws IOException {
        num17.insertLast(players.accessNode(player));
        isNextplayer();
    }
    public void btnNum18pressed() throws IOException {
        num18.insertLast(players.accessNode(player));
        isNextplayer();
    }
    public void btnNum19pressed() throws IOException {
        num19.insertLast(players.accessNode(player));
        isNextplayer();
    }
    public void btnNum22pressed() throws IOException {
        num22.insertLast(players.accessNode(player));
        isNextplayer();
    }
    public void btnNum52pressed() throws IOException {
        num52.insertLast(players.accessNode(player));
        isNextplayer();
    }
    public void btnNum53pressed() throws IOException {
        num53.insertLast(players.accessNode(player));
        isNextplayer();
    }
    public void btnGopressed() throws InterruptedException {
        btnGo.setDisable(true);
        chooseAndshowQoute();
    }

    public void isNextplayer() throws IOException {
        if(this.player<players.len()-1){
            this.player++;
        }
        else{
            btnNum12.setDisable(true);
            btnNum14.setDisable(true);
            btnNum15.setDisable(true);
            btnNum16.setDisable(true);
            btnNum17.setDisable(true);
            btnNum18.setDisable(true);
            btnNum19.setDisable(true);
            btnNum22.setDisable(true);
            btnNum52.setDisable(true);
            btnNum53.setDisable(true);
            finishGame();
        }
    }

    private void finishGame() throws IOException {
        switch (option){
            case 0:
                switch (num18.len()){
                    case 1:
                        for (int i = 0; i <num18.len() ; i++) {
                            num18.accessNode(i).setMinigamepoints(4);
                        }
                        break;
                    case 2:
                        for (int i = 0; i <num18.len() ; i++) {
                            num18.accessNode(i).setMinigamepoints(3);
                        }
                        break;
                    case 3:
                        for (int i = 0; i <num18.len() ; i++) {
                            num18.accessNode(i).setMinigamepoints(2);
                        }
                        break;
                    case 4:
                        for (int i = 0; i <num18.len() ; i++) {
                            num18.accessNode(i).setMinigamepoints(1);
                        }
                        break;
                }
                break;
            case 1:
                switch (num15.len()){
                    case 1:
                        for (int i = 0; i <num15.len() ; i++) {
                            num15.accessNode(i).setMinigamepoints(4);
                        }
                        break;
                    case 2:
                        for (int i = 0; i <num15.len() ; i++) {
                            num15.accessNode(i).setMinigamepoints(3);
                        }
                        break;
                    case 3:
                        for (int i = 0; i <num15.len() ; i++) {
                            num15.accessNode(i).setMinigamepoints(2);
                        }
                        break;
                    case 4:
                        for (int i = 0; i <num15.len() ; i++) {
                            num15.accessNode(i).setMinigamepoints(1);
                        }
                        break;
                }
                break;
            case 2:
                switch (num19.len()){
                    case 1:
                        for (int i = 0; i <num19.len() ; i++) {
                            num19.accessNode(i).setMinigamepoints(4);
                        }
                        break;
                    case 2:
                        for (int i = 0; i <num19.len() ; i++) {
                            num19.accessNode(i).setMinigamepoints(3);
                        }
                        break;
                    case 3:
                        for (int i = 0; i <num19.len() ; i++) {
                            num19.accessNode(i).setMinigamepoints(2);
                        }
                        break;
                    case 4:
                        for (int i = 0; i <num19.len() ; i++) {
                            num19.accessNode(i).setMinigamepoints(1);
                        }
                        break;
                }
                break;
            case 3:
                switch (num17.len()){
                    case 1:
                        for (int i = 0; i <num17.len() ; i++) {
                            num17.accessNode(i).setMinigamepoints(4);
                        }
                        break;
                    case 2:
                        for (int i = 0; i <num17.len() ; i++) {
                            num17.accessNode(i).setMinigamepoints(3);
                        }
                        break;
                    case 3:
                        for (int i = 0; i <num17.len() ; i++) {
                            num17.accessNode(i).setMinigamepoints(2);
                        }
                        break;
                    case 4:
                        for (int i = 0; i <num17.len() ; i++) {
                            num17.accessNode(i).setMinigamepoints(1);
                        }
                        break;
                }
                break;
            case 4:
                switch (num52.len()){
                    case 1:
                        for (int i = 0; i <num52.len() ; i++) {
                            num52.accessNode(i).setMinigamepoints(4);
                        }
                        break;
                    case 2:
                        for (int i = 0; i <num52.len() ; i++) {
                            num52.accessNode(i).setMinigamepoints(3);
                        }
                        break;
                    case 3:
                        for (int i = 0; i <num52.len() ; i++) {
                            num52.accessNode(i).setMinigamepoints(2);
                        }
                        break;
                    case 4:
                        for (int i = 0; i <num52.len() ; i++) {
                            num52.accessNode(i).setMinigamepoints(1);
                        }
                        break;
                }
                break;
            case 5:
                switch (num16.len()){
                    case 1:
                        for (int i = 0; i <num16.len() ; i++) {
                            num16.accessNode(i).setMinigamepoints(4);
                        }
                        break;
                    case 2:
                        for (int i = 0; i <num16.len() ; i++) {
                            num16.accessNode(i).setMinigamepoints(3);
                        }
                        break;
                    case 3:
                        for (int i = 0; i <num16.len() ; i++) {
                            num16.accessNode(i).setMinigamepoints(2);
                        }
                        break;
                    case 4:
                        for (int i = 0; i <num16.len() ; i++) {
                            num16.accessNode(i).setMinigamepoints(1);
                        }
                        break;
                }
                break;
            case 6:
                switch (num22.len()){
                    case 1:
                        for (int i = 0; i <num22.len() ; i++) {
                            num22.accessNode(i).setMinigamepoints(4);
                        }
                        break;
                    case 2:
                        for (int i = 0; i <num22.len() ; i++) {
                            num22.accessNode(i).setMinigamepoints(3);
                        }
                        break;
                    case 3:
                        for (int i = 0; i <num22.len() ; i++) {
                            num22.accessNode(i).setMinigamepoints(2);
                        }
                        break;
                    case 4:
                        for (int i = 0; i <num22.len() ; i++) {
                            num22.accessNode(i).setMinigamepoints(1);
                        }
                        break;
                }
                break;
            case 7:
                switch (num12.len()){
                    case 1:
                        for (int i = 0; i <num12.len() ; i++) {
                            num12.accessNode(i).setMinigamepoints(4);
                        }
                        break;
                    case 2:
                        for (int i = 0; i <num12.len() ; i++) {
                            num12.accessNode(i).setMinigamepoints(3);
                        }
                        break;
                    case 3:
                        for (int i = 0; i <num12.len() ; i++) {
                            num12.accessNode(i).setMinigamepoints(2);
                        }
                        break;
                    case 4:
                        for (int i = 0; i <num12.len() ; i++) {
                            num12.accessNode(i).setMinigamepoints(1);
                        }
                        break;
                }
                break;
            case 8:
                switch (num53.len()){
                    case 1:
                        for (int i = 0; i <num53.len() ; i++) {
                            num53.accessNode(i).setMinigamepoints(4);
                        }
                        break;
                    case 2:
                        for (int i = 0; i <num53.len() ; i++) {
                            num53.accessNode(i).setMinigamepoints(3);
                        }
                        break;
                    case 3:
                        for (int i = 0; i <num53.len() ; i++) {
                            num53.accessNode(i).setMinigamepoints(2);
                        }
                        break;
                    case 4:
                        for (int i = 0; i <num53.len() ; i++) {
                            num53.accessNode(i).setMinigamepoints(1);
                        }
                        break;
                }
                break;
            case 9:
                switch (num14.len()){
                    case 1:
                        for (int i = 0; i <num14.len() ; i++) {
                            num14.accessNode(i).setMinigamepoints(4);
                        }
                        break;
                    case 2:
                        for (int i = 0; i <num14.len() ; i++) {
                            num14.accessNode(i).setMinigamepoints(3);
                        }
                        break;
                    case 3:
                        for (int i = 0; i <num14.len() ; i++) {
                            num14.accessNode(i).setMinigamepoints(2);
                        }
                        break;
                    case 4:
                        for (int i = 0; i <num14.len() ; i++) {
                            num14.accessNode(i).setMinigamepoints(1);
                        }
                        break;
                }
                break;
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
