package Proyecto1.DatosParty;


import Proyecto1.DatosParty.Boxes.*;
import Proyecto1.DatosParty.DataStructures.BaseModels.FatherNode;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.DataStructures.CircularDoubleList.CircularDoubleList;
import Proyecto1.DatosParty.DataStructures.DoubleLinkedList.DoubleLinkedList;
import Proyecto1.DatosParty.DataStructures.Nodes.IntersectionNode;
import Proyecto1.DatosParty.DataStructures.Nodes.JointNode;
import Proyecto1.DatosParty.DataStructures.Nodes.SimpleNode;
import Proyecto1.DatosParty.DataStructures.SimpleCircularList.SimpleCircularList;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import javafx.scene.canvas.Canvas;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class Table
 */
public class Table {
    //Initialization of the phases for generation.
    private SimpleLinkedList<Box> phaseA = new SimpleLinkedList<>(), phaseB = new SimpleLinkedList<>();
    private DoubleLinkedList<Box> phaseC = new DoubleLinkedList<>();
    private CircularDoubleList<Box> phaseD = new CircularDoubleList<>();

    // Initialization of the table
    private SimpleCircularList<FatherNode> table = new SimpleCircularList<>();


    /**
     * @param list   a list for adding the boxes
     * @param green  amount of green boxes
     * @param red    amount of red boxes
     * @param yellow amount of yellow boxes
     * @return a list with all the boxes inside, in a random order.
     */
    public void generatePhases(MotherList list, int green, int red, int yellow, int white) {
        int counter = 1;
        while (green != 0 || red != 0 || yellow != 0 || white != 0) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
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
                case 3:
                    if (white != 0) {
                        list.insertLast(new WhiteBox());
                        white--;
                    }

            }
            counter++;

        }


    }

    public void generateTable() {
        //Generate the main table, made of 36 boxes
        for (int i = 0; i < 36; i++) {
            if (i == 2 || i == 11 || i == 20) {
                this.table.insertLast(new IntersectionNode(new WhiteBox()));
            } else if (i == 7 || i == 16 || i == 25) {
                this.table.insertLast(new JointNode(new WhiteBox()));
            } else {
                this.table.insertLast(new SimpleNode(new WhiteBox()));
            }
        }

        //Generate the phases of the board
        this.generatePhases(phaseA, 3, 3, 1, 3);
        this.generatePhases(phaseB, 0, 0, 10, 0);
        this.generatePhases(phaseC, 3, 3, 3, 1);
        this.generatePhases(phaseD, 0, 0, 12, 0);

        System.out.println(this.table);
        //Connect the table with the phases.
        FatherNode nodo = this.table.getHead();

        nodo = nodo.getNext();

        while (nodo != this.table.getHead()) {

            nodo = nodo.getNext();

        }
    }

    /**
     * @param canvas canvas for drawing the boxes
     */
    public void drawPhase(Canvas canvas, MotherList list) {

    }
}

