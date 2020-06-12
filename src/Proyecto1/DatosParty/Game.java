package Proyecto1.DatosParty;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.GUI.Windows.Minigames.*;
import javafx.application.Application;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Game extends Application {
    private static Game instance = null;
    private SimpleLinkedList<Player> players = new SimpleLinkedList<>();
    private Table gameTable;
    private int cantidadRondas;
    private ListView eventDisplay;

    public void setEventDisplay(ListView eventDisplay) {
        this.eventDisplay = eventDisplay;
    }

    public static SimpleLinkedList<Player> listWithnoPlayer(Player player) {
        SimpleLinkedList<Player> list = Game.getInstance().getPlayers();
        SimpleLinkedList<Player> newList = new SimpleLinkedList();
        for (int i = 0; i < list.len(); i++) {
            if (list.accessNode(i) != player) {
                newList.insertLast(list.accessNode(i));
            }
        }
        return newList;
    }

    public static Player getRandomPlayer(Player player) {
        int len = Game.getInstance().players.len();
        int randomInt = ThreadLocalRandom.current().nextInt(len);
        Player randomPlayer = Game.getInstance().getPlayers().accessNode(0);

        while (player == randomPlayer){
            randomInt = ThreadLocalRandom.current().nextInt(len);
            randomPlayer = Game.getInstance().getPlayers().accessNode(randomInt);
        }
        return randomPlayer;
    }

    public SimpleLinkedList<Player> getPlayers() {
        return players;
    }

    private Game() {
        this.gameTable = Table.getInstance();
    }

    synchronized static public Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void addPlayer(Player player) {
        this.players.insertLast(player);
    }

    public void setRounds(int amount){
        this.cantidadRondas = amount;
    }
    @Override
    public String toString() {
        return "Instancia de clase Game";
    }

    public void giveMoney() throws IOException {
        for (int i = 0; i <= players.len()-1; i++) {
            if(players.accessNode(i).getMinigamepoints()==4){
                players.accessNode(i).modifyCoins(true, 5);
            } else if (players.accessNode(i).getMinigamepoints() == 3) {
                players.accessNode(i).modifyCoins(true, 3);
            } else if (players.accessNode(i).getMinigamepoints() == 2) {
                players.accessNode(i).modifyCoins(true, 2);
            } else {
                players.accessNode(i).modifyCoins(true, 0);
            }
        }
    }

    public ListView getEventDisplay() {
        if (this.eventDisplay != null) {
            return this.eventDisplay;
        } else {
            throw new IllegalStateException("The instance of event Display still null");
        }
    }

    public void generateStar(){
        int boxId = (int) (Math.random()*((77-0)+1))+0;
        System.out.println(boxId);
        Phase phase;
        if (boxId <= 35) {
            phase = Table.getInstance().mainPhase;
        } else if (boxId >= 36 && boxId <= 45) {
            phase = Table.getInstance().phaseA;
            boxId = boxId-36;
        } else if (boxId >= 46 && boxId <= 55) {
            phase = Table.getInstance().phaseB;
            boxId = boxId-46;
        } else if (boxId >= 56 && boxId <= 65) {
            phase = Table.getInstance().phaseC;
            boxId = boxId-56;
        } else {
            phase = Table.getInstance().phaseD;
            boxId = boxId-66;
        }

        phase.getPhaselist().accessNode(boxId).setHasStar(true);
    }
    public void startMinigame() throws Exception {
        this.start(new Stage());
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        int option = (int) (Math.random()*((6-1)+1))+1;
        switch (option) {
            case 1:
                CardsController cards = new CardsController();
                cards.start(primaryStage);
                break;
            case 2:
                FormulaController formula = new FormulaController();
                formula.start(primaryStage);
                break;
            case 3:
                LuckyStickController luckystick = new LuckyStickController();
                luckystick.start(primaryStage);
                break;
            case 4:
                NumbersController numbers = new NumbersController();
                numbers.start(primaryStage);
                break;
            case 5:
                RocketsController rockets = new RocketsController();
                rockets.start(primaryStage);
                break;
            case 6:
                VowelsController vowels= new VowelsController();
                vowels.start(primaryStage);
                break;
            default:
                throw new IllegalArgumentException("No minigame to play");
        }
    }


    /*
    public SimpleLinkedList<Player> listWithnoPlayer(Player player) throws IOException {
        SimpleLinkedList<Player> list = Game.getInstance().getPlayers();
        SimpleLinkedList<Player> newList = new SimpleLinkedList();
        for (int i = 0; i < list.len(); i++) {
            if(list.accessNode(i)!=player){
                newList.insertLast(list.accessNode(i));
            }
        }
        return newList;
    }
     */
}
