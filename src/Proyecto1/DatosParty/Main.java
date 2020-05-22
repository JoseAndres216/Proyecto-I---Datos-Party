package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.CircularDoubleList.CircularDoubleList;
import Proyecto1.DatosParty.DoubleLinkedList.DoubleLinkedList;
import Proyecto1.DatosParty.MotherList.MotherList;
import Proyecto1.DatosParty.SimpleCircularList.SimpleCircularList;
import Proyecto1.DatosParty.SimpleLinkedList.SimpleLinkedList;

public class Main {

    public static void main(String[] args) {
        SimpleLinkedList<Box> table1 = new SimpleLinkedList<>();

        SimpleLinkedList<Box> faseA = new SimpleLinkedList<>();

        SimpleLinkedList<Box> table2 = new SimpleLinkedList<>();

        SimpleLinkedList<Box> faseB = new SimpleLinkedList<>();

        SimpleLinkedList<Box> table3 = new SimpleLinkedList<>();

        DoubleLinkedList<Box> faseC = new DoubleLinkedList<>();

        SimpleLinkedList<Box> table4 = new SimpleLinkedList<>();

        CircularDoubleList<Box> faseD = new CircularDoubleList<>();


        SimpleLinkedList<MotherList> Tablero = new SimpleLinkedList<>();

        Tablero.insertLast(table1);
        Tablero.insertLast(faseA);
        Tablero.insertLast(table2);
        Tablero.insertLast(faseB);
        Tablero.insertLast(table3);
        Tablero.insertLast(faseC);

        System.out.println(Tablero);



/*
        Tablero.insertFirst( new Box());
        Tablero.insertFirst( new Box());
        Tablero.insertFirst( new Box());
        Tablero.insertFirst( new Box());*/

// [[a,a,a,a],[d,d,d,d,d],[c,c,c,c,c]]



    }
}
