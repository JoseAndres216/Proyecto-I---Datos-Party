package Proyecto1.DatosParty.Boxes;

import Proyecto1.DatosParty.Observer.Observable;
import Proyecto1.DatosParty.Observer.Observer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This class is the base for all the other boxes
 */
public abstract class Box extends Observable {
    protected boolean busy;
    protected static int id;
    protected Observer observer;
    protected String tag;
    public Color bodyColor;

    //settings for the graphic representation of box
    private int height = 50;
    private int width = 50;

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

        // Get the grapics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //set the color
        gc.setFill(bodyColor);

        //Draw the rectangle
        gc.strokeRect(x, y, this.height, this.width);

    }
}
