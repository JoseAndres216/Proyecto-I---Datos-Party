package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Player;

import java.io.IOException;

public class StealStar extends Event{

    public StealStar() {
        this.tag = "Steal star";
    }

    /**
     * Method to start the event
     * @param players list of players
     * @throws IOException list must have 2 players
     */
    @Override
    public void interact(SimpleLinkedList<Player> players) throws IOException {

        if(players.len() > 2){
            throw new IOException("The list can't have more than two players");
        }

        Player winnerOfCoins = players.accessNode(0);
        Player losesCoins = players.accessNode(1);

        winnerOfCoins.modifyStars(true, 1);
        losesCoins.modifyStars(false,1);
    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
