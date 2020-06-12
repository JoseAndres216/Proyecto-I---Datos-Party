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
    protected int height = 36;
    protected int width = 36;
    protected boolean hasStar;
    private Player actualPlayer = null;
    //  //  //  //  //  //  //  //  //  //               METHODS                 //  //  //  //  //  //  //  //  //  //

    /**
     * Setters and getters of the class.
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
     * @param id
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

    public int getExcelId() { return excelId; }

    public void setExcelId(int excelId) { this.excelId = excelId; }

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

    public void iteract(Player player){
        if(this.hasStar){
            if(player.getCoins()>=5){
                player.modifyCoins(false, 5);
                player.modifyStars(true, 1);
                this.hasStar = false;
                Game.getInstance().generateStar();
            }
        }
    }

    public abstract String getMessage(Player player);

    public String getTag() {
        return this.tag;
    }

    void spawnStar() {
        this.hasStar = true;
    }
}
