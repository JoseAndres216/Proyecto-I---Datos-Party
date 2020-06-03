package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Player;

import java.io.IOException;

public class StealStar extends Event{

    @Override
    public void interact(SimpleLinkedList<Player> players) throws IOException {

        if(players.len() > 2){
            throw new IOException("The list can't have more than two players");
        }

        Player winnerOfCoins = players.accessNode(0);
        Player losesCoins = players.accessNode(1);

        winnerOfCoins.modifyCoins(true, 1);
        losesCoins.modifyCoins(false,1);
    }
}
