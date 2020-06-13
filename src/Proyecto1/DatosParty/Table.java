package Proyecto1.DatosParty;


import Proyecto1.DatosParty.Boxes.*;
import Proyecto1.DatosParty.DataStructures.BaseModels.FatherNode;
import Proyecto1.DatosParty.DataStructures.CircularDoubleList.CircularDoubleList;
import Proyecto1.DatosParty.DataStructures.DoubleLinkedList.DoubleLinkedList;
import Proyecto1.DatosParty.DataStructures.SimpleCircularList.SimpleCircularList;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import javafx.scene.canvas.Canvas;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class Table, used for the implementation of the phase A, B, C, D and the main phase.
 */
public class Table {
    //configuration for the singleton.
    private static Table instance = null;
    //Intialization of the Phases, (the main table will not be a phase)
    public Phase phaseA = new Phase(new SimpleLinkedList<Box>(), false, "Phase A");
    public Phase phaseB = new Phase(new SimpleLinkedList<Box>(), false, "Phase B");
    public Phase phaseC = new Phase(new DoubleLinkedList<Box>(), false, "Phase C");
    public Phase phaseD = new Phase(new CircularDoubleList<Box>(), false, "Phase D");
    //UI element, for drawing the table and the players.
    private Canvas canvas;
    //says if theres a star in the phase.
    private boolean isStar = false;

    public void setCanvas(Canvas canvas) throws Exception {
        this.canvas = canvas;
        this.drawTable();
        this.drawPlayers();
    }

    //Intialization of the main table.
    public Phase mainPhase = new Phase(new SimpleCircularList(), true, "Main");

    private Table() {
        this.generateTable();
    }

    public static synchronized Table getInstance() {

        if (instance == null) {
            instance = new Table();
        }
        return instance;
    }

    public Phase getPhaseA() {
        return phaseA;
    }

    public Phase getPhaseB() {
        return phaseB;
    }

    public Phase getPhaseC() {
        return phaseC;
    }

    public Phase getPhaseD() {
        return phaseD;
    }

    public Phase getMainPhase() {
        return mainPhase;
    }

    /**
     * Method for generating a random box, for creating the main table.
     *
     * @return
     */
    public Box getRandomBox(int counterCasillasPrincipal) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
        Box randomBox;
        switch (randomNum) {
            case 0:
                randomBox = new GreenBox(counterCasillasPrincipal);
                break;
            case 1:
                randomBox = new YellowBox(counterCasillasPrincipal);
                break;
            case 2:
                randomBox = new RedBox(counterCasillasPrincipal);
                break;
            case 3:
                randomBox = new WhiteBox(counterCasillasPrincipal);
                break;
            default:
                //throw new IllegalStateException("Algo paso al generar la casilla, el random era: " + randomNum);
                randomBox = new WhiteBox(counterCasillasPrincipal);
        }
        return randomBox;
    }

    //Creating the main table


    /**
     * @param canvas canvas for drawing the boxes
     */
    public void drawTable() throws Exception {
        this.canvas.getGraphicsContext2D().clearRect(0, 0, 1200, 1200);
        if (isStar == false) {
            Game.getInstance().generateStar();
            isStar=true;
        }
        //Generating main table
        int x = 420, y = 140;
        this.mainPhase.getPhaselist().getHead().getData().draw(x, y, canvas);
        this.mainPhase.getPhaselist().getHead().getData().setX(x);
        this.mainPhase.getPhaselist().getHead().getData().setY(y);
        this.mainPhase.getPhaselist().getHead().getData().setExcelId(0);
        FatherNode<Box> node = this.mainPhase.getPhaselist().getHead().getNext();
        for (int i = 1; i <= 35; i++) {
            if (i <= 9) {
                x += 36;
            } else if (i > 9 && i <= 18) {
                y += 36;
            } else if (i > 18 && i <= 27) {
                x -= 36;
            } else if (i > 27 && i <= 35) {
                y -= 36;
            }
            node.getData().setExcelId(i);
            node.getData().draw(x, y, canvas);
            node.getData().setX(x);
            node.getData().setY(y);
            node = node.getNext();
        }

        //Generating of phase A
        x = 492;
        y = 140;
        node = phaseA.getPhaselist().getHead();
        for (int i = 36; i <= 45; i++) {
            if (i <= 38) {
                y -= 36;
            } else if (i > 38 && i <= 43) {
                x += 36;
            } else if (i > 43 && i <= 45) {
                y += 36;
            }
            node.getData().draw(x, y, canvas);
            node.getData().setX(x);
            node.getData().setY(y);
            node.getData().setExcelId(i);
            node = node.getNext();
        }

        //Generating of phase B
        x = 744;
        y = 212;
        node = phaseB.getPhaselist().getHead();
        for (int i = 46; i <= 55; i++) {
            if (i <= 48) {
                x += 36;
            } else if (i > 48 && i <= 53) {
                y += 36;
            } else if (i > 53 && i <= 55) {
                x -= 36;
            }
            node.getData().draw(x, y, canvas);
            node.getData().setX(x);
            node.getData().setY(y);
            node.getData().setExcelId(i);
            node = node.getNext();
        }

        //Generating of phase C
        x = 672;
        y = 464;
        node = phaseC.getPhaselist().getHead();
        for (int i = 56; i <= 65; i++) {
            if (i <= 58) {
                y += 36;
            } else if (i > 58 && i <= 63) {
                x -= 36;
            } else if (i > 63 && i <= 65) {
                y -= 36;
            }
            node.getData().draw(x, y, canvas);
            node.getData().setX(x);
            node.getData().setY(y);
            node.getData().setExcelId(i);
            node = node.getNext();
        }

        x = 528;
        y = 248;
        this.phaseD.getPhaselist().getHead().getData().draw(x, y, canvas);
        this.phaseD.getPhaselist().getHead().getData().setExcelId(66);
        this.phaseD.getPhaselist().getHead().getData().setX(x);
        this.phaseD.getPhaselist().getHead().getData().setY(y);
        node = this.phaseD.getPhaselist().getHead().getNext();
        for (int i = 67; i <= 77; i++) {
            if (i <= 69) {
                x += 36;
            } else if (i > 69 && i <= 72) {
                y += 36;
            } else if (i > 72 && i <= 75) {
                x -= 36;
            } else if (i > 75 && i <= 77) {
                y -= 36;
            }
            node.getData().draw(x, y, canvas);
            node.getData().setX(x);
            node.getData().setY(y);
            node.getData().setExcelId(i);
            node = node.getNext();
        }
    }

    /**
     * Draws all the players' avatar on the table.
     *
     * @throws Exception
     */
    public void drawPlayers() throws Exception {
        SimpleLinkedList<Player> players = Game.getInstance().getPlayers();
        for (int i = 0; i < players.len(); i++) {
            players.accessNode(i).drawPlayer(canvas);
        }
    }

    //Method for puttin together the phases and the main table.
    public void generateTable() {

        //Generate the main table, made of 36 boxes with intersections that connect phases
        //and random generated boxes on the other parts of the table.
        for (int i = 0; i < 36; i++) {
            int counterCasillasPrincipal = 0;
            switch (i) {
                case 2:
                    this.mainPhase.phaseList.insertLast(new IntersectionBox(phaseA,counterCasillasPrincipal));
                    break;

                case 11:
                    this.mainPhase.phaseList.insertLast(new IntersectionBox(phaseB,counterCasillasPrincipal));
                    break;

                case 20:
                    this.mainPhase.phaseList.insertLast(new IntersectionBox(phaseC,counterCasillasPrincipal));
                    break;


                default:
                    this.mainPhase.phaseList.insertLast(this.getRandomBox(counterCasillasPrincipal));
                    break;
            }
            counterCasillasPrincipal++;
        }
        //Setting the phases with the lists
        this.phaseA.config(3,3,1,  3,  7);//exit point esta basado en el modelo del excel
        this.phaseB.config(0,0,10, 0,  16);//exit point esta basado en el modelo del excel
        this.phaseC.config(3,3,3,  1,  25);//exit point esta basado en el modelo del excel
        this.phaseD.config(0, 0, 12, 0, -1);//exit point es -1 porque la fase D no esta conectada de ninguna forma
        this.phaseD.setIsPhaseD(true);
    }
}


