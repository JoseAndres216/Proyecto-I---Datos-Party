package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class for the implementation of the player, it allows the sowfware to move, draw and interct with players.
 *
 */
public class Player {

    //Configurations for the location of the player on table
    protected Phase actualPhase; // actual phase of the player from A B C D to MainPhase.
    protected int actualBoxIndex; //Index of the box (zero-based index of the phase) ej: player could be phase C, box 8
    public MotherList<Box> actualList;//actual phase list.
    private MotherList<Box> mainListReference; // list to move trough, always its the mainList

    //Values of the player.
    public final String nickname;
    private final int ID;
    private int minigamepoints;
    private int coins;
    private int stars;

    //Settings for UI
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
        this.coins = 25;
        this.stars = 1;
        this.minigamepoints = 0;

        //Ubication on the table
        this.actualPhase = Table.getInstance().mainPhase;
        this.actualList = Table.getInstance().mainPhase.phaseList;
        this.mainListReference = Table.getInstance().mainPhase.phaseList; //should be the main table list.
        this.actualBoxIndex = 0;

        //Identification
        this.nickname = nickname;
        this.ID = playerNumber;

        //swith for setting the avatar
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

    public int getID() {
        return ID;
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

    public Image getAvatar() {
        return this.avatar;
    }

    public void setEventDisplay(Label eventDisplay) {
        this.eventDisplay = eventDisplay;
    }

    /**
     * Moves a player to a different box
     *
     * @param newPhase  phase to move the player
     * @param actualBox zero-based index of the new box.
     * @throws Exception if the index of the new box, doesnt apply for the new phaese.
     */
    public void MoveTo(Phase newPhase, int actualBox) throws Exception {
        //Eliminates the player from the old box
        this.actualPhase.getPhaselist().accessNode(this.actualBoxIndex).removePlayer();

        //Set the new values of the box.
        this.actualPhase = newPhase;
        this.actualBoxIndex = actualBox;

        //Interacting with the new box
        this.actualPhase.getPhaselist().accessNode(this.actualBoxIndex).placePlayer(this);//FOR GRAPHIC REPRESENTATION AND RULE THAT SAYS ONE PLAYER PER BOX
        this.actualPhase.getPhaselist().accessNode(this.actualBoxIndex).iteract(this);//FOR ITERACTIONS WITH THE BOX

        //Updates the table with the new position
        Table.getInstance().drawTable();
        Table.getInstance().drawPlayers();
        //Uptades the board, because coins and stars could change in the new box.
        Game.getInstance().updatePlayers();


    }

    /**
     * Move the player to a box given its id, which was defined on the prototype of the board, and as the board ist always the same
     * we can assume the values are right.
     *
     * @param boxExcelid id of the new box
     * @throws Exception if the index of the acces() its out of range
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
            String update = " stars.";
            this.eventDisplay.setText((this.nickname + " earned " + amount + update).toUpperCase());
            this.stars += amount;
        } else {
            if (this.stars - amount < 0) {
                this.eventDisplay.setText((this.nickname + " hasnt enought stars.").toUpperCase());
            }
            String update = " stars.";
            this.stars -= amount;
            this.eventDisplay.setText((this.nickname + " losed " + amount + update).toUpperCase());
        }
        Game.getInstance().updatePlayers();
    }

    /**
     * Method for modifying the coins of the player
     *
     * @param gain   true if earns coins, false if looses
     * @param amount amount of coins to earn.
     */
    public void modifyCoins(boolean gain, int amount) {
        String update = " coins.";
        if (gain) {
            this.coins += amount;
            this.eventDisplay.setText((this.nickname + " earned " + amount + update).toUpperCase());
        } else {
            if (this.coins - amount < 0) {
                this.eventDisplay.setText(("Player cant lose that coins " + this.nickname).toUpperCase());
                return;
            }
            update = " coins.";
            this.eventDisplay.setText((this.nickname + " losed " + amount + update).toUpperCase());
            this.coins -= amount;
        }
        Game.getInstance().updatePlayers();
    }

    /**
     * @param avaliableMoves cantidad de casillas disponibles para avanzar
     * @return list with the possible boxes to move.
     * @throws Exception from the list, if the index its out of range, or if the
     * value is unespected, what means that something went wrong
     */
    public SimpleLinkedList<Box> calcPossibleMoves(int avaliableMoves) throws Exception {
        //Simple list for saving the posibilities
        SimpleLinkedList<Box> possibles = new SimpleLinkedList<>();

        //set a temporal reference for avoiding trouble on lost reference.
        Phase tempPhase = this.actualPhase;
        int tempIndex = this.actualBoxIndex;

        //if the phae its the A, B or C phase
        if (!(tempPhase.isTable || tempPhase.isPhaseD())) {
            //If its phase C, this if its used for the backwards movement.
            if (tempPhase.toString() == "Phase C") {
                int cantidadDetras = (actualBoxIndex);
                //case when there is a possible backwards movement.
                if (cantidadDetras >= avaliableMoves) {
                    //checks if the box isnt already on the new list.
                    if (!possibles.is(tempPhase.getPhaseListElement(actualBoxIndex - avaliableMoves))) {
                        possibles.insertLast(tempPhase.getPhaseListElement(actualBoxIndex - avaliableMoves));
                        tempPhase.getPhaseListElement(actualBoxIndex - avaliableMoves).highlight();
                        tempPhase.getPhaseListElement(actualBoxIndex - avaliableMoves).highlight();
                    }
                }
            }
            int avaliableForward = ((tempPhase.phaseList.len() - 1) - actualBoxIndex);
            //In the case of phase A and B, evaluates if the possible move its inside the same phase.
            if (avaliableForward >= avaliableMoves) {
                //safety check of the values of the counter.
                if ((actualBoxIndex + avaliableMoves) > 9 || (actualBoxIndex + avaliableMoves) < 0) {
                    throw new IllegalArgumentException("Value Unespected: " + (actualBoxIndex + avaliableMoves));
                }
                //if the counter is good, checks if the box isnt already added, if not, adds it.
                if (!possibles.is(tempPhase.getPhaseListElement(actualBoxIndex + avaliableMoves))) {
                    possibles.insertLast(tempPhase.getPhaseListElement(actualBoxIndex + avaliableMoves));
                    tempPhase.getPhaseListElement(actualBoxIndex + avaliableMoves).highlight();
                    tempPhase.getPhaseListElement(actualBoxIndex + avaliableMoves).highlight();
                }

            }
            //case in which the result cant be in the phase.
            else {
                //sets the counter to the exit point of the phase, (obtained from the prototype)
                tempIndex = this.actualPhase.exitPoint;
                //changes the temporal reference of the phase, to the main phase
                tempPhase = Table.getInstance().getMainPhase();
                //reduces the possible moves, by calculating the moves that took to get out of the phase.
                avaliableMoves = (avaliableMoves - (avaliableForward + 1));


            }
        }
        //goes box by box checking its phase, this while works on the phase D and the main phase.

        while (avaliableMoves != 1) {
            //if its in the main phase.
            if (tempPhase.isTable) {
                //where dealing with circular list, so have to deal with the counter
                if (tempIndex >= 36) {
                    int excess = tempIndex - 36;
                    tempIndex = excess;
                }
            }
            //if the phase its the phase D
            if (tempPhase.isPhaseD()) {
                //where dealing with circular list, so have to deal with the counter
                if (tempIndex >= 12) {
                    int excess = tempIndex - 12;
                    tempIndex = excess;
                }
                //calculates the result of going backwards on the phase
                int backwardsMoves = actualBoxIndex - avaliableMoves;
                //checks if the result is an positive number
                if (backwardsMoves >= 0) {
                    //checks if the box its already added and if not, adds it.
                    if (!possibles.is(tempPhase.getPhaseListElement(backwardsMoves))) {
                        tempPhase.getPhaseListElement(backwardsMoves).highlight();
                        possibles.insertLast(tempPhase.getPhaseListElement(backwardsMoves));
                    }

                } else {
                    //if the result was a negative number, uses this while to calculate the new index.
                    int j = tempIndex;
                    int backwardsMovesAvaliable = avaliableMoves;
                    while (backwardsMovesAvaliable != 0) {
                        //checks if the index its negative
                        if (j < 0) {
                            //sets the value to the last index of the list
                            j = 11;
                        }
                        j--;
                        backwardsMovesAvaliable--;
                    }
                    //checks if the box with the calculated intex its in the results
                    //if not, adds it.
                    if (!possibles.is(tempPhase.getPhaseListElement(j))) {
                        tempPhase.getPhaseListElement(j).highlight();
                        possibles.insertLast(tempPhase.getPhaseListElement(j));

                    }

                }
            }
            //if the box its an intersection
            if (tempPhase.getPhaseListElement(tempIndex).isIntersection) {//caso en que el nodo es de tipo interseccion
                //gets the len of the list stored inside
                int phaseLenght = tempPhase.getPhaseListElement(tempIndex).getPhase().getPhaselist().len();
                //if the result isnt inside the phase, just skips the phase.
                if ((avaliableMoves) > (phaseLenght)) {
                    tempIndex++;
                } else {
                    //if the result its inside the phase, uses aritmethc calcs to add it, and keeps going throug the main table.
                    //checks if the list already has the box and if the result its inside.
                    if (!possibles.is(tempPhase.getPhaseListElement(tempIndex).getPhase().getPhaselist().accessNode(avaliableMoves - 1))) {
                        tempPhase.getPhaseListElement(tempIndex).getPhase().getPhaselist().accessNode(avaliableMoves - 1).highlight();
                        possibles.insertLast(tempPhase.getPhaseListElement(tempIndex).getPhase().getPhaselist().accessNode(avaliableMoves - 1));
                        tempPhase.getPhaseListElement(tempIndex).getPhase().getPhaselist().accessNode(avaliableMoves - 1);
                    }
                }
            }
            //moves to the next box and discounts the move from the remaining moves.
            tempIndex++;
            avaliableMoves--;
        }
        if (tempPhase.isTable) {
            if (tempIndex >= 36) {
                int exceso = tempIndex - 36;
                tempIndex = exceso;
            }
            if (tempPhase.isPhaseD) {
                if (tempIndex >= 12) {
                    int exceso = tempIndex - 12;
                    tempIndex = exceso;
                }
            }
        }
        if (!possibles.is(tempPhase.getPhaselist().accessNode(tempIndex + 1))) {
            possibles.insertLast(tempPhase.getPhaselist().accessNode(tempIndex + 1));
            tempPhase.getPhaselist().accessNode(tempIndex + 1).highlight();
        }

        return possibles;
    }

    /**
     * Se lanzan los dados, y se resaltan las casillas resultantes
     * y se envia la lista al controller de la ventana que se usa para elegir
     * una casilla
     *
      * @return returns a list with the possible moves after rolling the dices.
     * @throws Exception from the acces() method on list.
     */
    public SimpleLinkedList<Box> rollDices() throws Exception {
        int dices = ThreadLocalRandom.current().nextInt(4, 13);
        this.eventDisplay.setText(this.nickname + " got " + dices + " moves.");
        SimpleLinkedList<Box> possibles = this.calcPossibleMoves(dices);
        return possibles;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playernumber=" + ID +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    /**
     * Method for drawing the player's avatar on the table.
     *
     * @param canvas Canvas from Game instance.
     * @throws Exception from the draw image method.
     */
    public void drawPlayer(Canvas canvas) throws Exception {
        // Get the grapics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //Draw the image.
        gc.drawImage(this.avatar, this.actualPhase.phaseList.accessNode(this.actualBoxIndex).getX(), this.actualPhase.phaseList.accessNode(this.actualBoxIndex).getY());
    }


}


