package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.DataStructures.SimpleLinkedList.SimpleLinkedList;

import java.io.IOException;

public class Player {
    //Values of the player.
    private int coins;
    private int stars;
    private final int playernumber;
    private final int minigamepoints;
    private final String nickname;
    //Configurations for the location of the player on table
    private Phase actualPhase; // actual phase of the player from A B C D to MainPhase.
    private final MotherList<Box> actualList; // list to move trough
    private int actualBox; //Index of the box (zero-based index of the phase) ej: player could be phase C, box 8

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

    public MotherList<Box> getActualList() {
        return actualList;
    }

    public int getActualBox() {
        return actualBox;
    }

    public MotherList<Box> getMainTableList() {
        return mainTableList;
    }

    //Reference of the main table
    public MotherList<Box> mainTableList;

    public void MoveTo(Phase newPhase, int actualBox) throws Exception {
        System.out.println(this.nickname + " changed position ");
        System.out.println("Actual: (" + this.actualPhase +", " + this.actualBox+ ")");
        System.out.println("New: (" + newPhase +", " + actualBox+ ")");

        this.actualPhase =  newPhase;
        this.actualBox = actualBox;
        this.actualPhase.getPhaselist().accessNode(this.actualBox).placePlayer(this);

    }

    /**
     * mediante una verificacion >< determina la fase segun el numero de id, basado en el excel.
     *
     * @param box
     */
    public void MoveTo(int boxExcelid){
        Phase phase = null;
        if(boxExcelid<=35){
            phase = Table.getInstance().mainPhase;
        }else if(boxExcelid>=36 && boxExcelid<=45){
            phase = Table.getInstance().phaseA;
        }else if(boxExcelid>=46 && boxExcelid<=55) {
            phase = Table.getInstance().phaseB;
        }else if(boxExcelid>=56 && boxExcelid<=65) {
            phase = Table.getInstance().phaseC;
        }else {
            phase = Table.getInstance().phaseD;
        }
    }


    /**
     * Method for modifying the stars of the player
     * @param gain true if earns stars, false if looses
     * @param amount amount of stars to earn.
     */
    public void modifyStars(boolean gain, int amount) throws IOException {

        if(gain){
            String update = " more stars.";
            System.out.println(this.nickname + " has: " + amount+ update);
            this.stars += amount;
        }

        else{
            if(this.stars - amount <0){
                throw  new IOException(this.nickname  + " hasnt enought stars.");
            }
            String update = " less stars.";
            this.stars-= amount;
            System.out.println(this.nickname + " has: " + amount+ update);
        }
    }
    /**
     * Method for modifying the coins of the player
     * @param gain true if earns coins, false if looses
     * @param amount amount of coins to earn.
     */
    public void modifyCoins(boolean gain, int amount) throws IOException {
        String update = " more coins.";
        if(gain){
            this.coins += amount;
            System.out.println(this.nickname  + " has " + amount+ update);
        }
        else{
            if(this.coins - amount <0){
                throw  new IOException(this.nickname + " hasnt enought coins.");
            }
            update = " less coins.";
            this.coins-= amount;
            System.out.println(this.nickname + " has " + amount+ update);

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
        this.coins = 10;
        this.stars = 1;
        this.minigamepoints = 0;
        //Ubication on the table
        this.actualPhase = Table.getInstance().mainPhase; //null means that player is in main table.
        this.mainTableList = Table.getInstance().mainPhase.phaseList;
        this.actualList = this.actualPhase.phaseList; //should be the main table list.
        this.actualBox = 0;
        //Identification
        this.nickname = nickname;
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

    public SimpleLinkedList<Box> calcPossibleMovesInMain(int posicionesDisponibles, int startPoint) throws Exception {
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
                    }
                }

                i++;
            }
            posibles.insertLast(this.mainTableList.accessNode(i)); // inserta el elemento en el que la posicion llega a 0 en el mainTable
        return posibles;
    }

    /**
     * Se lanzan los dados, y se resaltan las casillas resultantes
     * y se envia la lista al controller de la ventana que se usa para elegir
     * una casilla
     * @param result
     * @throws Exception
     */
    public void RollDices(int result) throws Exception {
        SimpleLinkedList<Box> posibles = this.calcPossibleMoves(result);

    }
    @Override
    public String toString() {
       return "Player: " + nickname + ", ID: " + this.playernumber;

    }

}


