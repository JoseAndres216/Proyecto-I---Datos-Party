package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class for the gift coins event
 */
public class GiftCoins extends Event {

    public GiftCoins() {
        this.tag = "Gift coins";
    }

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

    /**
     * Method to start the minigame
     *
     * @param afected list of players
      */
    @Override
    public void interact(Player afected) {

        SimpleLinkedList<Player> players = Game.otherPlayers(afected);

        int n = afected.getCoins() + 1;
        int coinsToWin;
        switch (players.len()) {
            case 1:
                coinsToWin = this.randomCoins(true, n);
                afected.modifyCoins(false, coinsToWin);
                players.accessNode(0).modifyCoins(true, coinsToWin);
                Game.getInstance().getEventDisplay().setText(afected.nickname + " gifted " + (coinsToWin));
                break;
            case 2:
                coinsToWin = this.randomCoins(true,n);
                afected.modifyCoins(false, coinsToWin);
                players.accessNode(0).modifyCoins(true, coinsToWin / 2);
                players.accessNode(1).modifyCoins(true, coinsToWin / 2);
                Game.getInstance().getEventDisplay().setText(afected.nickname + " gifted " + (coinsToWin / 2));
                break;
            case 3:
                coinsToWin = this.randomCoins(false,n);
                afected.modifyCoins(false, coinsToWin);
                players.accessNode(0).modifyCoins(true, coinsToWin / 3);
                players.accessNode(1).modifyCoins(true, coinsToWin / 3);
                players.accessNode(2).modifyCoins(true, coinsToWin / 3);
                Game.getInstance().getEventDisplay().setText(afected.nickname + " gifted " + (coinsToWin / 3));
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

