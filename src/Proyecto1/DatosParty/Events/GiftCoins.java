package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Player;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class GiftCoins extends Event {

    public int randomCoins(boolean pair, int max) {
        int randomN = ThreadLocalRandom.current().nextInt(2, max);
        if (pair) {
            while (randomN % 2 != 0) {
                randomN = ThreadLocalRandom.current().nextInt(2, max);
            }
        } else {
            while (randomN % 3 != 0) {
                randomN = ThreadLocalRandom.current().nextInt(2, max);
            }

        }
        return randomN;
    }

    @Override
    public void interact(SimpleLinkedList<Player> players) throws IOException {
        if ((players.len() < 2) || (players.len() > 4)) {
            throw new IOException("List of players must have 2-4 players");
        }
        Player afected = players.accessNode(0);
        int n = afected.getCoins()+1;
        int coinsToWin;
        switch (players.len()) {
            case 2:
                coinsToWin = this.randomCoins(true,n);
                afected.modifyCoins(false, coinsToWin);
                players.accessNode(1).modifyCoins(true, coinsToWin);
                break;
            case 3:
                coinsToWin = this.randomCoins(true,n);
                afected.modifyCoins(false, coinsToWin);
                players.accessNode(1).modifyCoins(true, coinsToWin / 2);
                players.accessNode(1).modifyCoins(true, coinsToWin / 2);
                break;
            case 4:
                coinsToWin = this.randomCoins(false,n);
                afected.modifyCoins(false, coinsToWin);
                players.accessNode(1).modifyCoins(true, coinsToWin / 3);
                players.accessNode(2).modifyCoins(true, coinsToWin / 3);
                players.accessNode(3).modifyCoins(true, coinsToWin / 3);
                break;

            default:
                System.out.println("something went wrong with GiftCoins event.");
        }
    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}

