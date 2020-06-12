package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Phase;
import Proyecto1.DatosParty.Player;

/**
 * Class for the swap players minigame
 */
public class SwapPlayers extends Event{
    public SwapPlayers() {
        this.tag = "Swap players";
    }


    /**
     * Method to start the event.
     *
     * @param player1 list of players
     */
    @Override
    public void interact(Player player1) {
        Player player2 = Game.getRandomPlayer(player1);

        Phase phaseP1 = player1.getActualPhase();
        int boxP1 = player1.getActualBoxIndex();

        Phase phaseP2 = player2.getActualPhase();
        int boxP2 = player2.getActualBoxIndex();

        //swap
        player2.MoveTo(phaseP1, boxP1);
        player1.MoveTo(phaseP2, boxP2);

    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
