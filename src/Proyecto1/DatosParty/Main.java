package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.SimpleLinkedList.SimpleLinkedList;

public class Main {

    public static void main(String[] args) {
        Table tablero = new Table();
        SimpleLinkedList<Box> faseA = new SimpleLinkedList<>();

        System.out.println(tablero.generatePhases(faseA, 10, 5, 1));
    }
}
