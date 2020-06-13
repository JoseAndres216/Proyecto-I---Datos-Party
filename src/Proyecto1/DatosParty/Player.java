package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.concurrent.ThreadLocalRandom;

public class Player {
    public final String nickname;
    private final int playernumber;
    //Reference of the main table
    public MotherList<Box> actualList;
    public Color color;
    //Configurations for the location of the player on table
    protected Phase actualPhase; // actual phase of the player from A B C D to MainPhase.
    protected int actualBoxIndex; //Index of the box (zero-based index of the phase) ej: player could be phase C, box 8
    private int minigamepoints;
    //Values of the player.
    private int coins;
    private int stars;
    private MotherList<Box> mainListReference; // list to move trough
    private Label eventDisplay;
    private Image avatar;

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
        this.actualPhase = Table.getInstance().mainPhase;
        this.actualList = Table.getInstance().mainPhase.phaseList;

        this.mainListReference = Table.getInstance().mainPhase.phaseList; //should be the main table list.
        this.actualBoxIndex = 0;

        //Identification
        this.nickname = nickname;
        this.playernumber = playerNumber;

        switch (playerNumber) {
            case 1:
                this.avatar = new Image("Proyecto1/DatosParty/GUI/Resources/images/p1.png");
                 break;
            case 2:
                this.avatar = new Image("Proyecto1/DatosParty/GUI/Resources/images/p2.png");
                break;
            case 3:
                this.avatar = new Image("Proyecto1/DatosParty/GUI/Resources/images/p3.png");
                break;
            case 4:
                this.avatar = new Image("Proyecto1/DatosParty/GUI/Resources/images/p4.png");

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

    public void MoveTo(Phase newPhase, int actualBox) throws Exception {
        //eliminar el jugador de la casilla, para no dar conflicto con la verificacio de si hay o no dos
        this.actualPhase.getPhaselist().accessNode(this.actualBoxIndex).removePlayer();
        this.actualPhase = newPhase;
        this.actualBoxIndex = actualBox;

        this.actualPhase.getPhaselist().accessNode(this.actualBoxIndex).placePlayer(this);//FOR GRAPHIC REPRESENTATION AND RULE THAT SAYS ONE PLAYER PER BOX
        this.actualPhase.getPhaselist().accessNode(this.actualBoxIndex).iteract(this);//FOR ITERACTIONS WITH THE BOX
        Game.getInstance().updatePlayers();
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
    public void modifyStars(boolean gain, int amount) {
        if (gain) {
            String update = " more stars.";
            //this.eventDisplay.setText(this.nickname + " has: " + amount + update);

            this.stars += amount;
        } else {
            if (this.stars - amount < 0) {
                //this.eventDisplay.setText(this.nickname + " hasnt enought stars.");
            }
            String update = " less stars.";
            this.stars -= amount;
           // this.eventDisplay.setText(this.nickname + " has: " + amount + update);
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
            //this.eventDisplay.setText(this.nickname + " earned: " + amount + update);
        } else {
            if (this.coins - amount < 0) {
                //this.eventDisplay.setText("Player cant lose that coins " + this.nickname);
                return;
            }
            update = " less coins.";
            //this.eventDisplay.setText(this.nickname + " losed: " + amount + update);

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
        SimpleLinkedList<Box> posibles = new SimpleLinkedList<>();
        Phase faseRecorrida = this.actualPhase;
        int i = this.actualBoxIndex;


        if (!(faseRecorrida.isTable || faseRecorrida.isPhaseD())) {

            int cantidadPorDelante = ((faseRecorrida.phaseList.len() - 1) - actualBoxIndex);
            if (cantidadPorDelante >= posicionesDisponibles) {
                if ((actualBoxIndex + posicionesDisponibles) > 9 || (actualBoxIndex + posicionesDisponibles) < 0) {

                    throw new IllegalArgumentException("Value Unespected: " + (actualBoxIndex + posicionesDisponibles));

                }

                posibles.insertLast(faseRecorrida.getPhaseListElement(actualBoxIndex + posicionesDisponibles));
                faseRecorrida.getPhaseListElement(actualBoxIndex + posicionesDisponibles).highlight();
                faseRecorrida.getPhaseListElement(actualBoxIndex + posicionesDisponibles).highlight();

            } else {

                i = this.actualPhase.exitPoint;
                faseRecorrida = Table.getInstance().getMainPhase();
                posicionesDisponibles = (posicionesDisponibles - (cantidadPorDelante + 1));
                //i = (i - (cantidadPorDelante + 1));

            }
        }
        while (posicionesDisponibles != 1) {//recorre el tablero , y se evalua el tipo de casilla que aparece

            if (i >= 36 && faseRecorrida.isTable) {
                int exceso = i - 36;
                i = exceso;
            }
            if (i >= 12 && faseRecorrida.isPhaseD()) {
                int exceso = i - 12;
                i = exceso;

            }
            if (faseRecorrida.getPhaseListElement(i).isIntersection) {//caso en que el nodo es de tipo interseccion

                int largoFase = faseRecorrida.getPhaseListElement(i).getPhase().getPhaselist().len();

                if ((posicionesDisponibles) > (largoFase)) {
                    //si el numero de casillas dentro de la fase es menor a la cantidad que hay que avanzar, la ignora y ya.
                    i++;
                } else {
                    //si la cantidad de casillas para avanzar el menor o igual a la de la fase, se agrega la casilla que se tiene, se sigue con el
                    //contador i para seguir recorriendo el main table.
                    faseRecorrida.getPhaseListElement(i).getPhase().getPhaselist().accessNode(posicionesDisponibles - 1).highlight();
                    posibles.insertLast(faseRecorrida.getPhaseListElement(i).getPhase().getPhaselist().accessNode(posicionesDisponibles - 1));
                    faseRecorrida.getPhaseListElement(i).getPhase().getPhaselist().accessNode(posicionesDisponibles - 1);
                }
            }
            i++;
            posicionesDisponibles--;
        }
        if (faseRecorrida.isTable) {
            if (i >= 36) {
                int exceso = i - 36;
                i = exceso;
            }
            if (faseRecorrida.isPhaseD) {
                if (i >= 12) {
                    int exceso = i - 12;
                    i = exceso;
                }
            }
        }
        posibles.insertLast(faseRecorrida.getPhaselist().accessNode(i + 1));
        faseRecorrida.getPhaselist().accessNode(i + 1).highlight();
        return posibles;
    }

    public void setEventDisplay(Label eventDisplay) {
        this.eventDisplay = eventDisplay;
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
        int dices = ThreadLocalRandom.current().nextInt(4, 13);
        this.eventDisplay.setText(this.nickname + " got " + dices + " moves.");
        SimpleLinkedList<Box> possibles = this.calcPossibleMoves(dices);
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
        // gc.fillOval((double) this.actualPhase.getPhaselist().accessNode(this.getActualBoxIndex()).getX(), (double) this.actualPhase.getPhaselist().accessNode(this.getActualBoxIndex()).getY(), 20, 20);
        gc.drawImage(this.avatar, this.actualPhase.phaseList.accessNode(this.actualBoxIndex).getX(), this.actualPhase.phaseList.accessNode(this.actualBoxIndex).getY());
    }

    public Image getAvatar() {
        return this.avatar;
    }
}


