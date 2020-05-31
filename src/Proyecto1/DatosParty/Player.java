package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;

public class Player {

    private int coins;
    private int stars;
    private int playernumber;
    private int minigamepoints;
    //Configurations for the movement of the player
    private Phase actualPhase; // null if main table
    private MotherList<Box> actualList; // list to move trough
    private int actualBox; //Index of the box (zero-based index of the phase) ej: player could be phase C, box 8
    private int SpacesToMove;

    public Player(int playerNumber, Phase actualPhase, int actualBox) {
        this.coins = 0;
        this.stars = 0;
        this.playernumber = playerNumber;
        this.coins = 0;
        this.minigamepoints = 0;
        this.actualPhase = actualPhase; //null means that player is in main table.
        this.actualList = this.actualPhase.phaseList; //should be the main table list.
        this.actualBox = actualBox;
    }

    public SimpleLinkedList calcRoute(int posicionesDisponibles) {
        SimpleLinkedList<Box> posibles = new SimpleLinkedList<>();

        if (this.actualPhase.isTable) {//caso en que se encuentra en el tablero principal
            int i = 0;

            while (i < posicionesDisponibles) {//recorre el tablero principal, y se evalua el tipo de casilla que aparece
                if (this.actualList.accessNode(i).isIntersection) {//caso en que el nodo es de tipo interseccion
                /* Caso en que la solucion esta dentro de la misma fas nueva
                el resultado de la resta dara positivo si la cantidad disponible para avanzar es menor al largo de la fase a la cual
                se acaba de ingresar, por lo tanto una posible solucion esta dentro de esa fase, en la posicion i = posicionesDisponibles-1
                esto por el indice basado en cero
                 */
                    if ((this.actualList.accessNode(i).getPhase().phaseList.len() - (posicionesDisponibles - i)) >= 0) {
                        //se accesa el elemento correspondiente para agregar de la fase dentro de la interseccion:
                        posibles.insertLast(this.actualPhase.getPhaseListElement((posicionesDisponibles - i) - 1));
                        System.out.println("Added box from a phase on index: " + i + " position: " + ((posicionesDisponibles - i) - 1));
                    }
                } else {
                    System.out.println("Box skipped on index " + i + " in main table");

                }
                i++;
            }
            posibles.insertLast(this.actualList.accessNode(i)); // inserta el elemento en el que la posicion llega a 0 en el mainTable
            System.out.println("Added box from the main table on index: " + i);
        }

        return posibles;//sin contar el caso en que el jugador estaba en una fase ya
    }
}
