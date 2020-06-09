package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.IOException;

public class Player {
    private final int playernumber;
    private final int minigamepoints;
    public final String nickname;
    //Reference of the main table
    public MotherList<Box> actualList;
    //Configurations for the location of the player on table
    protected Phase actualPhase; // actual phase of the player from A B C D to MainPhase.
    protected int actualBox; //Index of the box (zero-based index of the phase) ej: player could be phase C, box 8
    //Values of the player.
    private int coins;
    private int stars;
    private MotherList<Box> mainListReference; // list to move trough

    /**
     * Constructor of the class player
     *
     * @param playerNumber integer number between 1 and 4, order given by rolling dices
     * @param nickname     string for the name that the user selected.
     */
    public Player(int playerNumber, String nickname) {
        //Settings for game
        this.coins = 10;
        this.stars = 1;
        this.minigamepoints = 0;
        //Ubication on the table
        this.actualPhase = Table.getInstance().mainPhase; //null means that player is in main table.
        this.actualList = Table.getInstance().mainPhase.phaseList;
        this.mainListReference = Table.getInstance().mainPhase.phaseList; //should be the main table list.
        this.actualBox = 0;
        //Identification
        this.nickname = nickname;
        this.playernumber = playerNumber;
    }

    public int getCoins() {
        return coins;
    }

    public int getStars() {
        return stars;
    }

    public int getPlayernumber() {
        return playernumber;
    }

    public int getMinigamepoints() {
        return minigamepoints;
    }

    public Phase getActualPhase() {
        return actualPhase;
    }

    public MotherList<Box> getMainListReference() {
        return mainListReference;
    }

    public int getActualBox() {
        return actualBox;
    }

    public MotherList<Box> getActualList() {
        return actualList;
    }

    public void MoveTo(Phase newPhase, int actualBox) throws Exception {
        System.out.println(this.nickname + " changed position ");
        System.out.println("Actual: (" + this.actualPhase + ", " + this.actualBox + ")");
        System.out.println("New: (" + newPhase + ", " + actualBox + ")");

        this.actualPhase = newPhase;
        this.actualBox = actualBox;
        this.actualPhase.getPhaselist().accessNode(this.actualBox).placePlayer(this);

    }

    /**
     * mediante una verificacion >< determina la fase segun el numero de id, basado en el excel.
     *
     * @param box
     */
    public void MoveTo(int boxExcelid) throws Exception {
        Phase phase = null;
        int index;
        if (boxExcelid <= 35) {
            phase = Table.getInstance().mainPhase;
            index = boxExcelid;
        } else if (boxExcelid >= 36 && boxExcelid <= 45) {
            phase = Table.getInstance().phaseA;
            index = boxExcelid - 36;
        } else if (boxExcelid >= 46 && boxExcelid <= 55) {
            phase = Table.getInstance().phaseB;
            index = boxExcelid - 46;
        } else if (boxExcelid >= 56 && boxExcelid <= 65) {
            phase = Table.getInstance().phaseC;
            index = boxExcelid - 56;
        } else {
            phase = Table.getInstance().phaseD;
            index = boxExcelid - 66;
        }

        MoveTo(phase, index);
    }


    /**
     * Method for modifying the stars of the player
     *
     * @param gain   true if earns stars, false if looses
     * @param amount amount of stars to earn.
     */
    public void modifyStars(boolean gain, int amount) throws IOException {

        if (gain) {
            String update = " more stars.";
            System.out.println(this.nickname + " has: " + amount + update);
            this.stars += amount;
        } else {
            if (this.stars - amount < 0) {
                throw new IOException(this.nickname + " hasnt enought stars.");
            }
            String update = " less stars.";
            this.stars -= amount;
            System.out.println(this.nickname + " has: " + amount + update);
        }
    }

    /**
     * Method for modifying the coins of the player
     *
     * @param gain   true if earns coins, false if looses
     * @param amount amount of coins to earn.
     */
    public void modifyCoins(boolean gain, int amount) throws IOException {
        String update = " more coins.";
        if (gain) {
            this.coins += amount;
            System.out.println(this.nickname + " has " + amount + update);
        } else {
            if (this.coins - amount < 0) {
                throw new IOException(this.nickname + " hasnt enought coins.");
            }
            update = " less coins.";
            this.coins -= amount;
            System.out.println(this.nickname + " has " + amount + update);

        }
    }

    /**
     * @param posicionesDisponibles cantidad de casillas disponibles para avanzar
     * @param startPoint            punto desde el cual se recorre la lista (principal)
     * @return
     * @throws Exception
     */
    public SimpleLinkedList<Box> calcPossibleMoves(int posicionesDisponibles) throws Exception {

        SimpleLinkedList<Box> posibles = new SimpleLinkedList<>();
        Phase faseRecorrida = this.actualPhase;
        int i = this.actualBox;

        while (posicionesDisponibles != 1) {//recorre el tablero principal, y se evalua el tipo de casilla que aparece

            if (faseRecorrida.isTable) {
                if (faseRecorrida.getPhaseListElement(i).isIntersection) {//caso en que el nodo es de tipo interseccion

                    int largoFase = faseRecorrida.getPhaseListElement(i).getPhase().getPhaselist().len();

                    if ((posicionesDisponibles) > (largoFase)) {
                        //si el numero de casillas dentro de la fase es menor a la cantidad que hay que avanzar, la ignora y ya.
                        System.out.println("Skipped phase: " + faseRecorrida.getPhaseListElement(i).toString());
                        i++;
                    } else {
                        //si la cantidad de casillas para avanzar el menor o igual a la de la fase, se agrega la casilla que se tiene, se sigue con el
                        //contador i para seguir recorriendo el main table.

                        posibles.insertLast(faseRecorrida.getPhaseListElement(i).getPhase().getPhaselist().accessNode(posicionesDisponibles - 1));
                    }
                }
            }

            else {
                int cantidadPorDelante = (faseRecorrida.phaseList.len()-1) - actualBox;
                if(cantidadPorDelante >= posicionesDisponibles){
                    posibles.insertLast(faseRecorrida.getPhaseListElement(actualBox+posicionesDisponibles));
                    break;
                }
                else{
                    i = this.actualPhase.exitPoint;
                    faseRecorrida = Table.getInstance().getMainPhase();
                    posicionesDisponibles = (posicionesDisponibles-(cantidadPorDelante+1));
                }
            }
            i++;
            posicionesDisponibles--;
        }

        if(faseRecorrida.isTable) {
            posibles.insertLast(faseRecorrida.getPhaselist().accessNode(i + 1)); // inserta el elemento en el que la posicion llega a 0 en el mainTable
        }
        return posibles;
    }

    /**
     * Se lanzan los dados, y se resaltan las casillas resultantes
     * y se envia la lista al controller de la ventana que se usa para elegir
     * una casilla
     *
     * @param result
     * @throws Exception
     * @return
     */
    public SimpleLinkedList<Box> RollDices() throws Exception {
        SimpleLinkedList<Box> possibles = this.calcPossibleMoves(12);
        System.out.println(possibles.toString());
        return possibles;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playernumber=" + playernumber +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public void drawPlayer(Canvas canvas) throws Exception {

        // Get the grapics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //set the color
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);

        //Draw the figure
        gc.fillOval((double) this.actualPhase.getPhaselist().accessNode(this.getActualBox()).getX(), (double) this.actualPhase.getPhaselist().accessNode(this.getActualBox()).getY(), 10, 10);
    }

}


