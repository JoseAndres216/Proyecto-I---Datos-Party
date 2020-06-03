package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Player;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class StealCoins extends Event {


    private int generateRandomInt(){
        int max = 10;
        int min = 2;
        return ThreadLocalRandom.current().nextInt(min, max +1);
    }
    /**
     * Method for stealing coins to a random player
     * @param players first player of list, steals coins to the second
     * @throws IOException the list only must have two players
     */
    @Override
    public void interact(SimpleLinkedList<Player> players) throws IOException {
        if(players.len() > 2){
            throw new IOException("The list can't have more than two players");

        }
        //generate the random int of coins to gain/lose
        int coins = generateRandomInt();
        Player winnerOfCoins = players.accessNode(0);
        Player losesCoins = players.accessNode(1);

        winnerOfCoins.modifyCoins(true, coins);
        losesCoins.modifyCoins(false,coins);
    }
}
