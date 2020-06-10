package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;

import java.util.concurrent.ThreadLocalRandom;

public class StealCoins extends Event {


    public StealCoins() {
        this.tag = "Steal coins";
    }

    private int generateRandomInt() {
        int max = 10;
        int min = 2;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Method for stealing coins to a random player
     *
     * @param winnerOfCoins first player of list, steals coins to the second
     */
    @Override
    public void interact(Player winnerOfCoins) {
        Player losesCoins = Game.getRandomPlayer(winnerOfCoins);
        //generate the random int of coins to gain/lose

        int coins = ThreadLocalRandom.current().nextInt(0, winnerOfCoins.getCoins());


        winnerOfCoins.modifyCoins(true, coins);
        losesCoins.modifyCoins(false, coins);
    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
