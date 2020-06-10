package Proyecto1.DatosParty;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;

import java.io.IOException;

public class Game {
    private static Game instance = null;
    private SimpleLinkedList<Player> players = new SimpleLinkedList<>();
    private Table gameTable;
    private int cantidadRondas;


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
            if(players.accessNode(i).getMinigamepoints()==3){
                players.accessNode(i).modifyCoins(true, 5);
            }else if(players.accessNode(i).getMinigamepoints()==2){
                players.accessNode(i).modifyCoins(true,3);
            }else if(players.accessNode(i).getMinigamepoints()==1){
                players.accessNode(i).modifyCoins(true,2);
            }else{
                players.accessNode(i).modifyCoins(true,0);
            }
        }
    }
}
