package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.CircularDoubleList.CircularDoubleList;
import Proyecto1.DatosParty.DoubleLinkedList.DoubleLinkedList;
import Proyecto1.DatosParty.MotherList.MotherList;
import Proyecto1.DatosParty.SimpleCircularList.SimpleCircularList;
import Proyecto1.DatosParty.SimpleLinkedList.SimpleLinkedList;

public class Main {

    public static void main(String[] args) {

        /*DoubleLinkedList<Integer> listaDoble = new DoubleLinkedList<>();
        listaDoble.insertFirst(4);
        listaDoble.insertFirst(3);
        listaDoble.insertFirst(2);
        listaDoble.insertFirst(1);


        System.out.println(listaDoble.index(0));
        System.out.println(listaDoble.index(1));
        System.out.println(listaDoble.index(2));
        System.out.println(listaDoble.index(3));



        System.out.println(listaDoble.print());*/

        SimpleCircularList lista = new SimpleCircularList();
        lista.insertLast(5);
        lista.insertLast(8);
        lista.insertLast(55);
        lista.insertLast(88);

        System.out.println(lista.toString());

        System.out.println("Elemento con index negativo: ");
        System.out.println(lista.retrnNodedata(-1) + "\n");

        System.out.println("Elemento con index adecuado: ");
        System.out.println(lista.retrnNodedata(0) + "\n");

        System.out.println("Elemento con index mayor que la extension de la lista: ");
        System.out.println(lista.retrnNodedata(4) + "\n");
    }
}
