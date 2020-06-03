package Proyecto1.DatosParty.Boxes;

import Proyecto1.DatosParty.Observer.Observable;
import Proyecto1.DatosParty.Observer.Observer;
import Proyecto1.DatosParty.Phase;
import javafx.scene.canvas.Canvas;

/**
 * This class is the base for all the other boxes
 */
public abstract class Box extends Observable {

    protected boolean busy;
    public static int id = 0;
    protected Observer observer;
    protected String tag;
    public boolean isIntersection = false;

    //settings for the graphic representation of box
    protected int height = 36;
    protected int width = 36;

    public Box() {
        id++;
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

    /**
     * Method for attaching a observer to the box
     *
     * @param observer observer object
     */
    @Override
    public void attach(Observer observer) {
        this.observer = observer;
    }

    public void notifyObserver() {
        this.observer.update();
    }

    /**
     * Method for drawing the box on the canvas
     *
     * @param x      postion of the up left corner on x axis
     * @param y      postion of the up left corner on y axis
     * @param canvas canvas for drawing the boxes
     */

    public void draw(int x, int y, Canvas canvas) {

    }

    public void iteract(){

    }

    public Phase getPhase() {
        return null;
    }
    public int getIdNumber(){return this.id;}
}
