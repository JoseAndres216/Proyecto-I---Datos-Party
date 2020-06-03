package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Player;

import java.io.IOException;

public abstract class Event {

    public abstract void interact(SimpleLinkedList<Player> players) throws IOException;
}
