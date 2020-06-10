package Proyecto1.DatosParty.GUI.Windows.Minigames;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Events.Event;
import Proyecto1.DatosParty.Player;

import java.io.IOException;

public  abstract class Minigame extends Event {

    @Override
    public void interact(SimpleLinkedList<Player> players) {

    }

    public abstract void play(SimpleLinkedList<Player> players) throws IOException;
}
