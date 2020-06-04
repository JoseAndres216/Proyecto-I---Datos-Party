package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Player;

import java.io.IOException;

public class TestingEvents {

    public static void main(String[] args) throws IOException {


        Player jugador1 = new Player(1,"Eduardo");
        Player jugador2 = new Player(2,"Messi");
        Player jugador3 = new Player(3,"Jugador 3");
        Player jugador4 = new Player(4,"Jugador 4");

        SimpleLinkedList<Player> players2 =  new SimpleLinkedList<>();
        players2.insertLast(jugador1);
        players2.insertLast(jugador2);

        SimpleLinkedList<Player> players3 = new SimpleLinkedList<>();
        players3.insertLast(jugador1);
        players3.insertLast(jugador2);
        players3.insertLast(jugador3);


        SimpleLinkedList<Player> players4  = new SimpleLinkedList<>();
        players4.insertLast(jugador1);
        players4.insertLast(jugador2);
        players4.insertLast(jugador3);
        players4.insertLast(jugador4);

        SimpleLinkedList<Player> player1  = new SimpleLinkedList<>();
        player1.insertLast(jugador1);

        SimpleLinkedList<Player> empty = new SimpleLinkedList<>();

        //  events
        Event event = new SwapPlayers();
        Event event2 = new Teleport();


        System.out.println("*****Two players*****");
        event2.interact(player1);
        event.interact(players2);

        //System.out.println("*****Three players*****");
        //event.interact(players3);

        //System.out.println("*****Four players *****");
        //event.interact(players4);

        //System.out.println("*****One player*****");
        //event.interact(player1);

       // System.out.println("*****Empty players*****");
        //event.interact(empty);
    }
}
