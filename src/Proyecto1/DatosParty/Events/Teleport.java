package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Phase;
import Proyecto1.DatosParty.Player;
import Proyecto1.DatosParty.Table;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Teleport extends Event   {



    public int generateRandomBox(int max){
        return ThreadLocalRandom.current().nextInt(0, max+1);
    }

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
        if(players.len() != 1){
            throw new IOException("The list must only contain 1 player.");
        }
        Phase phase = this.phasePicker();
        int random = generateRandomBox(phase.phaseList.len());
        players.accessNode(0).MoveTo(phase,random);
    }

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}
