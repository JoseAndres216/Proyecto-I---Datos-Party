package Proyecto1.DatosParty;


import Proyecto1.DatosParty.Boxes.*;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.DataStructures.CircularDoubleList.CircularDoubleList;
import Proyecto1.DatosParty.DataStructures.DoubleLinkedList.DoubleLinkedList;
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
    private SimpleCircularList<Box> table = new SimpleCircularList<>();
    /**
     * @param list   a list for adding the boxes
     * @param green  amount of green boxes
     * @param red    amount of red boxes
     * @param yellow amount of yellow boxes
     * @return a list with all the boxes inside, in a random order.
     */
    public void generatePhases(MotherList list, int green, int red, int yellow, int white) {
        while (green != 0 || red != 0 || yellow != 0 || white != 0) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 4);

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

        }


    }

    /**
     * Method for generating a random box, for creating the main table.
     *
     * @return
     */
    public Box getRandomBox() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
        Box randomBox;
        switch (randomNum) {
            case 0:
                randomBox = new GreenBox();
                break;
            case 1:
                randomBox = new YellowBox();
                break;
            case 2:
                randomBox = new RedBox();
                break;
            case 3:
                randomBox = new WhiteBox();
                break;
            default:
                System.out.println("Algo paso al generar la casilla, el random era: " + randomNum);
                randomBox = new WhiteBox();
        }
        return randomBox;
    }

    //Method for puttin together the phases and the main table.
    public void generateTable() {
        //Fill the phases of the board with random order of boxes
        this.generatePhases(phaseA, 3, 3, 1, 3);
        this.generatePhases(phaseB, 0, 0, 10, 0);
        this.generatePhases(phaseC, 3, 3, 3, 1);
        this.generatePhases(phaseD, 0, 0, 12, 0);

        //Generate the main table, made of 36 boxes with intersections that connect phases
        //and random generated boxes on the other parts of the table.
        for (int i = 0; i < 36; i++) {
            switch (i) {
                case 2:
                    this.table.insertLast(new IntersectionBox(phaseA));
                    break;

                case 11:
                    this.table.insertLast(new IntersectionBox(phaseB));
                    break;

                case 20:
                    this.table.insertLast(new IntersectionBox(phaseC));
                    break;


                default:
                    this.table.insertLast(this.getRandomBox());
                    break;
            }
        }


        System.out.println(this.table);
    }

    /**
     * @param canvas canvas for drawing the boxes
     */
    public void drawPhase(Canvas canvas, MotherList list) {

    }
}


