package Proyecto1.DatosParty.Boxes;

import Proyecto1.DatosParty.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class WhiteBox extends Box {

    //  //  //  //  //  //  //  //  //  //               METHODS                 //  //  //  //  //  //  //  //  //  //

    /**
     * Constructor 1 of the class: for creating an instantiation of the class whit it's respective ID.
     *
     * @param id
     */
    public WhiteBox(int id) {
        Box.id = id;
        this.tag = "white";
    }

    public WhiteBox() {
        this.tag = "white";
    }
    /**
     * Constructor 2 of the class: For just instantiating the class.
     */


    /**
     * Method for drawing the box on the canvas.
     *
     * @param x      postion of the up left corner on x axis
     * @param y      postion of the up left corner on y axis
     * @param canvas canvas for drawing the boxes
     */
    public void draw(int x, int y, Canvas canvas) {
        super.draw(x, y, canvas);
        // Get the grapics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //set the color
        gc.setFill(Color.valueOf("#efefef"));
        gc.setStroke(Color.BLACK);

        //Draw the rectangle
        //gc.strokeRect(x, y, this.height, this.width);
        gc.fillRect(x, y, this.height, this.width);


        if (this.hasStar) {

            Image star = new Image("Proyecto1/DatosParty/GUI/Resources/images/star.png");
            gc.drawImage(star, x, y);
        }
        if (this.isHilighted) {
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(3);
            gc.strokeRect(x, y, this.height, this.width);
            this.isHilighted = false;
        }
    }

    @Override
    public void iteract(Player player) {
        super.iteract(player);
    }

    @Override
    public String getMessage(Player player) {
        return " moves to an empty box.";
    }

    /**
     * Method for printing the box in the run panel in order to check the correct behavior of the table.
     *
     * @return the color of the box.
     */
    @Override
    public String toString() {
        return "WhiteBox{" +
                "excelId=" + excelId +

                '}';
    }
}
