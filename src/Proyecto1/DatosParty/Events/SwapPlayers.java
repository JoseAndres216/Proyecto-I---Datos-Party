package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Phase;
import Proyecto1.DatosParty.Player;
import Proyecto1.DatosParty.Table;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class SwapPlayers extends Event{

    public Phase phasePicker(){
        Phase generated = null;
        int randomInt =  ThreadLocalRandom.current().nextInt(0, 5);
        switch (randomInt){
            case 0:
                generated = Table.getInstance().getPhaseA();
                break;
            case 1:
                generated = Table.getInstance().getPhaseB();
                break;
            case 2:
                generated = Table.getInstance().getPhaseC();
                break;
            case 3:
                generated = Table.getInstance().getPhaseD();
                break;
            case 4:
                generated = Table.getInstance().getMainPhase();
                break;
            default:
                System.out.println("Something went wrong generating the phase");
        }
        return generated;
    }
    @Override
    public void interact(SimpleLinkedList<Player> players) throws IOException {
        if(players.len() != 2){
            throw new IOException("The list must only contain 1 player.");
        }
        Player player1 = players.accessNode(0);
        Player player2 = players.accessNode(1);


        Phase phaseP1 = player1.getActualPhase();
        int   boxP1   = player1.getActualBox();

        Phase phaseP2 = player2.getActualPhase();
        int   boxP2   =   player2.getActualBox();

        player1.MoveTo(phaseP2,boxP2);
        player2.MoveTo(phaseP1,boxP1);

    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
