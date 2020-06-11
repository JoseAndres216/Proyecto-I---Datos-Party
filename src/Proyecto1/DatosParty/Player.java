package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.concurrent.ThreadLocalRandom;

public class Player {
    public final String nickname;
    private final int playernumber;
    //Reference of the main table
    public MotherList<Box> actualList;
    //Configurations for the location of the player on table
    protected Phase actualPhase; // actual phase of the player from A B C D to MainPhase.
    protected int actualBoxIndex; //Index of the box (zero-based index of the phase) ej: player could be phase C, box 8
    private int minigamepoints;

    //Values of the player.
    private int coins;
    private int stars;
    public Color color;
    private MotherList<Box> mainListReference; // list to move trough

    /**
     * Constructor of the class player
     *
     * @param playerNumber integer number between 1 and 4, order given by rolling dices
     * @param nickname     string for the name that the user selected.
     */
    public Player(int playerNumber, String nickname) {
        //Settings for game
        this.coins = 1000;
        this.stars = 1000;
        this.minigamepoints = 0;
        //Ubication on the table
        this.actualPhase = Table.getInstance().phaseD;
        this.actualList = Table.getInstance().phaseD.phaseList;

        this.mainListReference = Table.getInstance().mainPhase.phaseList; //should be the main table list.
        this.actualBoxIndex = 0;
        //Identification
        this.nickname = nickname;
        this.playernumber = playerNumber;

        switch (playerNumber) {
            case 1:
                color = Color.DARKBLUE;
                break;
            case 2:
                color = Color.DARKGREY;
                break;
            case 3:
                color = Color.DARKRED;
                break;
            case 4:
                color = Color.DARKGREEN;

        }
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

    public void setMinigamepoints(int points) {
        this.minigamepoints = points;
    }

    public Phase getActualPhase() {
        return actualPhase;
    }

    public MotherList<Box> getMainListReference() {
        return mainListReference;
    }

    public int getActualBoxIndex() {
        return actualBoxIndex;
    }

    public MotherList<Box> getActualList() {
        return actualList;
    }

    public void MoveTo(Phase newPhase, int actualBox) {

        this.actualPhase = newPhase;
        this.actualBoxIndex = actualBox;

        this.actualPhase.getPhaselist().accessNode(this.actualBoxIndex).placePlayer(this);//FOR GRAPHIC REPRESENTATION
        this.actualPhase.getPhaselist().accessNode(this.actualBoxIndex).iteract(this);//FOR ITERACTIONS WITH THE BOX

        try {
            Table.getInstance().drawTable();
            Table.getInstance().drawPlayers();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * mediante una verificacion >< determina la fase segun el numero de id, basado en el excel.
     *
     * @param box
     */
    public void MoveTo(int boxExcelid) {
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
    public void modifyStars(boolean gain, int amount) {

        if (gain) {
            String update = " more stars.";
            System.out.println(this.nickname + " has: " + amount + update);
            this.stars += amount;
        } else {
            if (this.stars - amount < 0) {
                System.out.println(this.nickname + " hasnt enought stars.");
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
    public void modifyCoins(boolean gain, int amount) {
        String update = " more coins.";
        if (gain) {
            this.coins += amount;
            System.out.println(this.nickname + " earned: " + amount + update);
        } else {
            if (this.coins - amount < 0) {
                System.out.println("Player cant lose that coins " + this.nickname);
                return;
            }
            update = " less coins.";
            System.out.println(this.nickname + " losed: " + amount + update);

            this.coins -= amount;
        }
    }

    /**
     * @param posicionesDisponibles cantidad de casillas disponibles para avanzar
     * @param startPoint            punto desde el cual se recorre la lista (principal)
     * @return
     * @throws Exception
     */
    public SimpleLinkedList<Box> calcPossibleMoves(int posicionesDisponibles) throws Exception {
        System.out.println("Player " + this.nickname + "moving " + posicionesDisponibles + " spaces");
        SimpleLinkedList<Box> posibles = new SimpleLinkedList<>();
        Phase faseRecorrida = this.actualPhase;
        int i = this.actualBoxIndex;

        while (posicionesDisponibles != 1) {//recorre el tablero principal, y se evalua el tipo de casilla que aparece
            if (faseRecorrida.isTable || faseRecorrida.isPhaseD()) {
                if (i == 36 && faseRecorrida.isTable) {
                    System.out.println("se reinicia el contador en la lista simple circular");
                    i = (0);
                }
                if (i == 12 && faseRecorrida.isPhaseD()) {
                    System.out.println("se reinicia el contador en la lista doble circular");
                    i = (0);
                }
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
            } else {
                int cantidadPorDelante = (faseRecorrida.phaseList.len() - 1) - actualBoxIndex;
                if (cantidadPorDelante >= posicionesDisponibles) {
                    posibles.insertLast(faseRecorrida.getPhaseListElement(actualBoxIndex + posicionesDisponibles));
                    break;
                } else {
                    i = this.actualPhase.exitPoint;
                    faseRecorrida = Table.getInstance().getMainPhase();
                    posicionesDisponibles = (posicionesDisponibles - (cantidadPorDelante + 1));
                }
            }

            i++;
            posicionesDisponibles--;
        }

        if (faseRecorrida.isTable) {
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
     * @return
     * @throws Exception
     */
    public SimpleLinkedList<Box> RollDices() throws Exception {
        int dices = ThreadLocalRandom.current().nextInt(13);
        System.out.println(dices);
        SimpleLinkedList<Box> possibles = this.calcPossibleMoves(5);
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
        gc.setFill(this.color);
        gc.setStroke(Color.BLACK);

        //Draw the figure
        gc.fillOval((double) this.actualPhase.getPhaselist().accessNode(this.getActualBoxIndex()).getX(), (double) this.actualPhase.getPhaselist().accessNode(this.getActualBoxIndex()).getY(), 20, 20);
    }

}


