package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;

public class Player {
    //Values of the player.
    private int coins;
    private int stars;
    private int playernumber;
    private int minigamepoints;
    private String nikname;
    //Configurations for the location of the player on table
    private Phase actualPhase; // actual phase of the player from A B C D to MainPhase.
    private MotherList<Box> actualList; // list to move trough
    private int actualBox; //Index of the box (zero-based index of the phase) ej: player could be phase C, box 8
    public MotherList<Box> mainTableList;

    /**
     * Method for modifying the stars of the player
     * @param gain true if earns stars, false if looses
     * @param amount amount of stars to earn.
     */
    public void modifyStars(boolean gain, int amount) {
        if(gain){
            this.stars += amount;
        }
        else{
            this.stars-= amount;
        }
    }


    /**
     * Constructor of the class player
     *
     * @param playerNumber integer number between 1 and 4, order given by rolling dices
        @param nickname string for the name that the user selected.
     */
    public Player(int playerNumber, String nickname) {
        //Settings for game
        this.coins = 0;
        this.stars = 0;
        this.coins = 0;
        this.minigamepoints = 0;
        //Ubication on the table
        this.actualPhase = Table.getInstance().mainPhase; //null means that player is in main table.
        this.mainTableList = Table.getInstance().mainPhase.phaseList;
        this.actualList = this.actualPhase.phaseList; //should be the main table list.
        this.actualBox = 0;
        //Identification
        this.nikname = nickname;
        this.playernumber = playerNumber;
    }

    /**
     * Method for calculating al possible routes for the player to move from a phase
     *
     * @param posicionesDisponibles integer amount of spaces allowed to move, given by the dices
     * @return simple list, with all possible boxes to move
     */
    public SimpleLinkedList calcPossibleMoves(int posicionesDisponibles) throws Exception {
        SimpleLinkedList<Box> posibles = new SimpleLinkedList<>();
        int indiceParaRecorrer = this.actualBox;
        //si esta en fase A B C
        if (!this.actualPhase.isTable) {
            //cantidad de casillas por delante del jugador
            int spacesInPhase = ((this.actualList.len()-1 - this.actualBox) - posicionesDisponibles);

            //es mayor la cantidad de posiciones que hay que avanzar que las que hay disponibles
            if (spacesInPhase < 0) {
                posibles = this.calcPossibleMovesInMain(posicionesDisponibles - (this.actualList.len()-1 - this.actualBox), this.actualPhase.getExitPoint());
            }
            else if (spacesInPhase == 0) {
                //significa que la cantidad de elementos para recorrer restantes, era la cantidad exacta del final, se agrega la ultima casilla
                posibles.insertLast(this.actualList.getTail().getData());
                System.out.println("Added the last of the actual phase");
            }
            else {
                System.out.println("Added the element on the index (Phase): " + (this.actualBox + posicionesDisponibles));
                posibles.insertLast(this.actualPhase.getPhaseListElement(this.actualBox + posicionesDisponibles));
            }
        }
        else if(this.actualPhase.isTable || this.actualPhase.isPhaseD){
                posibles = this.calcPossibleMovesInMain(posicionesDisponibles,this.actualPhase.getExitPoint());
        }
        return posibles;
     }

    public SimpleLinkedList calcPossibleMovesInMain(int posicionesDisponibles, int startPoint) throws Exception {
            SimpleLinkedList<Box> posibles = new SimpleLinkedList<>();
            int i = startPoint;
            int finishPoint = startPoint + posicionesDisponibles;
            while (i < finishPoint-1) {//recorre el tablero principal, y se evalua el tipo de casilla que aparece
                if (this.mainTableList.accessNode(i).isIntersection) {//caso en que el nodo es de tipo interseccion
                /* Caso en que la solucion esta dentro de la misma fas nueva
                el resultado de la resta dara positivo si la cantidad disponible para avanzar es menor al largo de la fase a la cual
                se acaba de ingresar, por lo tanto una posible solucion esta dentro de esa fase, en la posicion i = posicionesDisponibles-1
                esto por el indice basado en cero
                 */
                    if ((this.mainTableList.accessNode(i).getPhase().phaseList.len() - (posicionesDisponibles - i)) >= 0) {
                        //se accesa el elemento correspondiente para agregar de la fase dentro de la interseccion:
                        posibles.insertLast(this.mainTableList.accessNode((posicionesDisponibles+startPoint - i)-2));

                        System.out.println("Added box from a phase on index: " + i + " position: " + ((posicionesDisponibles+startPoint - i)-2) +
                                "\n Remaining moves: " + (posicionesDisponibles+startPoint-i));
                    }
                } else {
                    System.out.println("Box skipped on index " + i + " in main table" +
                            "\n Remaining moves: " + (posicionesDisponibles+startPoint-i));
                }
                i++;
            }
            posibles.insertLast(this.mainTableList.accessNode(i)); // inserta el elemento en el que la posicion llega a 0 en el mainTable
            System.out.println("Added box from the main table on index: " + i
                    + "\n Remaining moves: " + (posicionesDisponibles-i));

        return posibles;
    }

    @Override
    public String toString() {
       return "Player: " + nikname + ", ID: " + this.playernumber;

    }
}


