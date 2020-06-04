package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import Proyecto1.DatosParty.Player;

import java.io.IOException;

public class TestingEvents {

    public static void main(String[] args) throws IOException {


        Player jugador1 = new Player(1,"Jugador 1");
        Player jugador2 = new Player(2,"Jugador 2");
        Player jugador3 = new Player(3,"Jugador 3");
        Player jugador4 = new Player(4,"Jugador 4");

        SimpleLinkedList<Player> players2 =  new SimpleLinkedList<>();
        players2.insertLast(jugador1);
        players2.insertLast(jugador4);

        SimpleLinkedList<Player> players3 = new SimpleLinkedList<>();
        players3.insertLast(jugador1);
        players3.insertLast(jugador4);
        players3.insertLast(jugador3);


        SimpleLinkedList<Player> players4  = new SimpleLinkedList<>();
        players4.insertLast(jugador1);
        players4.insertLast(jugador4);
        players4.insertLast(jugador3);
        players4.insertLast(jugador2);

        SimpleLinkedList<Player> player1  = new SimpleLinkedList<>();
        player1.insertLast(jugador2);

        SimpleLinkedList<Player> empty = new SimpleLinkedList<>();

        //  events


        System.out.println("*****Two players*****");


        System.out.println("*****Three players*****");


        System.out.println("*****Four players" + "*****");


        System.out.println("*****One player*****");


        System.out.println("*****Empty players*****");

    }
}
