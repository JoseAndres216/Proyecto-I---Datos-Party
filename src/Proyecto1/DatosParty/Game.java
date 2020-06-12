package Proyecto1.DatosParty;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import javafx.scene.control.ListView;

import java.io.IOException;

public class Game {
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
        int random = player.getPlayernumber();
        Player randomPlayer = Game.getInstance().getPlayers().accessNode(0);

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
