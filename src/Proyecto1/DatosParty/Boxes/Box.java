//1 Metodo sin JavaDOC

package Proyecto1.DatosParty.Boxes;

import Proyecto1.DatosParty.Game;
import Proyecto1.DatosParty.Observer.Observable;
import Proyecto1.DatosParty.Observer.Observer;
import Proyecto1.DatosParty.Phase;
import Proyecto1.DatosParty.Player;
import javafx.scene.canvas.Canvas;

/**
 * This class is the base for all the other boxes.
 */
public abstract class Box extends Observable {

    //  //  //  //  //  //  //  //  //  //              ATRIBUTES                //  //  //  //  //  //  //  //  //  //

    protected boolean busy = false;
    public static int id;
    protected int excelId;
    protected Observer observer;
    protected String tag;
    public boolean isIntersection = false;
    protected int x;
    protected int y;
    protected int height = 32;
    protected int width = 32;
    protected boolean hasStar;
    protected boolean isHilighted = false;
    private Player actualPlayer = null;
    private String phaseTag;
    //  //  //  //  //  //  //  //  //  //               METHODS                 //  //  //  //  //  //  //  //  //  //

    /**
     * Setters and getters of the class.
     * @param hasStar, true if the box has an star, false if not.
     */
    public void setHasStar(boolean hasStar) {
        this.hasStar = hasStar;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) { this.y = y; }

    public Phase getPhase() { return null; }

     @Override
    public String toString() {
        return "Box{" +
                "excelId=" + excelId +
                "Color=" + this.tag +
                '}';
    }

     public int getIdNumber(){return this.id;}

    /**
     * Constructor 1 of the class: for creating an instantiation of the class whit it's respective ID.
     * @param id idenfitication of the box.
     */
     public Box(int id){
        this.id = id;
    }

    /**
     * Constructor 2 of the class: For just instantiating the class.
     */
    public Box(){

    }

    /**
     * Method for the observer pattern
     *
     * @return true if the box has a player, false if not.
     */
    @Override
    public boolean getState() {
        return this.busy;
    }

    public void setState(boolean newState) {
        this.busy = newState;
    }

    public int getExcelId() {
        return excelId;
    }

    public void setExcelId(int excelId) {
        this.excelId = excelId;

        if (this.excelId <= 35) {
            this.phaseTag = "Main Phase";

        } else if (this.excelId >= 36 && this.excelId <= 45) {
            this.phaseTag = "Phase A";

        } else if (this.excelId >= 46 && this.excelId <= 55) {
            this.phaseTag = "Phase B";

        } else if (this.excelId >= 56 && this.excelId <= 65) {
            this.phaseTag = "Phase C";

        } else {
            this.phaseTag = "Phase D";

        }
    }

    /**
     * Method for attaching a observer to the box
     *
     * @param observer observer object
     */
    @Override
    public void attach(Observer observer) {
        this.observer = observer;
    }

    public void notifyObserver(Player player1, Player player2) {


    }

    /**
     * Method for drawing the box on the canvas.
     *
     * @param x      postion of the up left corner on x axis
     * @param y      postion of the up left corner on y axis
     * @param canvas canvas for drawing the boxes
     */
    public void draw(int x, int y, Canvas canvas) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method for positioning the player on the position of a respective box.
     * @param player    player that's going to be placed on the box.
     */
    public void placePlayer(Player player) {
        if (this.actualPlayer == null) {
            this.actualPlayer = player;
            this.busy = true;
        } else {
            System.out.println("Start a minigame between:" + "\n" + player.nickname + " and " + this.actualPlayer.nickname);
            /*
             */
        }
    }

    public void removePlayer() {
        this.actualPlayer = null;
        this.busy = false;
    }

    public void iteract(Player player) throws Exception {
        if (this.hasStar) {
            if (player.getCoins() >= 5) {
                player.modifyCoins(false, 5);
                player.modifyStars(true, 1);
                this.hasStar = false;
                Game.getInstance().getEventDisplay().setText(player.nickname + " got the star!!!");
                Game.getInstance().generateStar();
            }
        }
    }

    public abstract String getMessage(Player player);

    public String getTag() {

        return this.tag + " on " + this.phaseTag;
    }

    void spawnStar() {
        this.hasStar = true;
    }

    public void highlight() {
        this.isHilighted = true;
    }
}
