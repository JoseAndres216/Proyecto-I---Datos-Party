package Proyecto1.DatosParty;

import Proyecto1.DatosParty.DataStructures.Nodes.SimpleNode;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.GUI.Inputs.IOManager;
import Proyecto1.DatosParty.GUI.Windows.Minigames.*;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Game extends Application {
    private static Game instance = null;
    private SimpleLinkedList<Player> players = new SimpleLinkedList<>();
    private Table gameTable;
    private int cantidadRondas = 10;
    private int playedRounds = 1;
    private Label eventDisplay;
    private Label roundCounter;
    private Label positions;
    SimpleLinkedList<Player> OrderedPlayerList;
    private Game() {
        this.gameTable = Table.getInstance();
        OrderedPlayerList = this.players;

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

        while (player == randomPlayer) {
            randomInt = ThreadLocalRandom.current().nextInt(len);
            randomPlayer = Game.getInstance().getPlayers().accessNode(randomInt);
        }
        return randomPlayer;
    }

    synchronized static public Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public SimpleLinkedList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.insertLast(player);
    }

    public void setRounds(int amount) {
        this.cantidadRondas = amount;
    }

    @Override
    public String toString() {
        return "Instancia de clase Game";
    }

    public void giveMoney() throws IOException {
        for (int i = 0; i <= players.len() - 1; i++) {
            if (players.accessNode(i).getMinigamepoints() == 4) {
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

    public Label getEventDisplay() {
        if (this.eventDisplay != null) {
            return this.eventDisplay;
        } else {
            throw new IllegalStateException("The instance of event Display still null");
        }
    }

    public void setEventDisplay(Label eventDisplay) {
        this.eventDisplay = eventDisplay;
    }

    public void generateStar() {
        int boxId = (int) (Math.random() * ((77 - 0) + 1)) + 0;
        System.out.println(boxId);
        Phase phase;
        if (boxId <= 35) {
            phase = Table.getInstance().mainPhase;
        } else if (boxId >= 36 && boxId <= 45) {
            phase = Table.getInstance().phaseA;
            boxId = boxId - 36;
        } else if (boxId >= 46 && boxId <= 55) {
            phase = Table.getInstance().phaseB;
            boxId = boxId - 46;
        } else if (boxId >= 56 && boxId <= 65) {
            phase = Table.getInstance().phaseC;
            boxId = boxId - 56;
        } else {
            phase = Table.getInstance().phaseD;
            boxId = boxId - 66;
        }

        phase.getPhaselist().accessNode(boxId).setHasStar(true);
    }

    public void updatePlayers() {
        //sort the list
        for (SimpleNode<Player> first = OrderedPlayerList.getHead(); first.getNext() != null; first = first.getNext()) {
            SimpleNode<Player> smaller = first;
            SimpleNode<Player> temp = smaller.getNext();
            while (temp != null) {
                //if(temp.getData().compareTo(smaller.getData())<0){
                if (temp.getData().getStars() > smaller.getData().getStars()) {
                    smaller = temp;
                } else if (temp.getData().getStars() == smaller.getData().getStars()) {
                    if (temp.getData().getCoins() > smaller.getData().getCoins()) {
                        smaller = temp;
                    } else if (temp.getData().getCoins() == smaller.getData().getCoins()) {
                    }
                }
                temp = temp.getNext();
                OrderedPlayerList.swap(first, smaller);
            }
        }
        int counter = 1;
        StringBuilder toAdd = new StringBuilder();
        toAdd.append("Positions Table: ").append("\nPlayer     Coins     Stars").append("\n");
        for (SimpleNode<Player> first = OrderedPlayerList.getHead(); first != null; first = first.getNext()) {
            toAdd.append(counter).append("- ").append(first.getData().nickname).append("          ").append(first.getData().getCoins()).append("     ").append(first.getData().getStars()).append("\n");
            counter++;
        }
        this.positions.setText(toAdd.toString());
    }

    public void nextRound() throws Throwable {
        if (this.playedRounds == this.cantidadRondas) {
            this.updatePlayers();
            System.out.println("Finished game");
            System.out.println("Winner winner chicken dinner: " + OrderedPlayerList.getHead().getData().nickname);

            Stage escena = (Stage) (this.getEventDisplay().getScene().getWindow());
            escena.close();
            IOManager.getInstance().close();
            return;
        }
        this.playedRounds++;

        //this.start(new Stage());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        int option = (int) (Math.random() * ((6 - 1) + 1)) + 1;
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
                VowelsController vowels = new VowelsController();
                vowels.start(primaryStage);
                break;
            default:
                throw new IllegalArgumentException("No minigame to play");
        }
    }

    public void setRoundCounter(Label roundCounter) {
        this.roundCounter = roundCounter;
        this.roundCounter.setText("1/" + this.cantidadRondas);
    }

    public void setPositionsTable(Label positions) {
        this.positions = positions;
    }
}
