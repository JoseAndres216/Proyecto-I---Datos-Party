package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.Boxes.GreenBox;
import Proyecto1.DatosParty.Boxes.RedBox;
import Proyecto1.DatosParty.Boxes.YellowBox;
import Proyecto1.DatosParty.CircularDoubleList.CircularDoubleList;
import Proyecto1.DatosParty.DoubleLinkedList.DoubleLinkedList;
import Proyecto1.DatosParty.MotherList.MotherList;
import Proyecto1.DatosParty.SimpleLinkedList.SimpleLinkedList;

import java.util.concurrent.ThreadLocalRandom;

public class Table {
    private SimpleLinkedList<Box> faseA, faseB;
    private DoubleLinkedList<Box> faseC;
    private CircularDoubleList<Box> faseD;

    /**
     * @param list
     * @param green
     * @param red
     * @param yellow
     * @return
     */
    public MotherList generatePhases(MotherList list, int green, int red, int yellow) {
        int counter = 1;
        while (green != 0 || red != 0 || yellow != 0) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
            System.out.println("Numero random: " + randomNum);
            switch (randomNum) {
                case 0:
                    if (green != 0) {
                        list.insertLast(new GreenBox());
                        green--;

                    }
                    break;
                case 1:
                    if (yellow != 0) {
                        list.insertLast(new YellowBox());
                        yellow--;
                    }
                    break;
                case 2:
                    if (red != 0) {
                        list.insertLast(new RedBox());
                        red--;
                    }
                    break;

            }
            counter++;

        }
        System.out.println("Iteraciones: " + counter);
        System.out.println("Cantidad de elementos: " + list.len());
        return list;

    }


}

