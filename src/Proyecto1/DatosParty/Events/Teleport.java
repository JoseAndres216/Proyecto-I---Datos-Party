package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Player;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Teleport extends Event   {

    private String tag = "Teleport";

    public int generateRandomBox(int max){
        return ThreadLocalRandom.current().nextInt(0, max+1);
    }

    /**
     * Method for starting the event.
     *
     * @param player List of players
     * @throws IOException must only have one player.
     */
    @Override
    public void interact(Player player) throws Exception {


        int random = generateRandomBox(77);

        player.MoveTo(random);
        Game.getInstance().getEventDisplay().setText(player.nickname + " teleports to: " + player.getActualPhase() + ", " + player.getActualBoxIndex());
    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
