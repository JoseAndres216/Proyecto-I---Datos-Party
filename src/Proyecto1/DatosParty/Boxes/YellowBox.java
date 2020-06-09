package Proyecto1.DatosParty.Boxes;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class YellowBox extends Box {

    //  //  //  //  //  //  //  //  //  //               METHODS                 //  //  //  //  //  //  //  //  //  //

    /**
     * Constructor 1 of the class: for creating an instantiation of the class whit it's respective ID.
     * @param id
     */
    public YellowBox(int id) {
        Box.id = id;
    }

    /**
     * Constructor 2 of the class: For just instantiating the class.
     */
    public YellowBox() {
    }

    /**
     * Method for drawing the box on the canvas.
     *
     * @param x      postion of the up left corner on x axis
     * @param y      postion of the up left corner on y axis
     * @param canvas canvas for drawing the boxes
     */
    public void draw(int x, int y, Canvas canvas) {

        // Get the grapics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //set the color
        gc.setFill(Color.YELLOW);
        gc.setStroke(Color.BLACK);

        //Draw the rectangle
        gc.strokeRect(x, y, this.height, this.width);
        gc.fillRect(x, y, this.height, this.width);
    }

    /**
     * Method for printing the box in the run panel in order to check the correct behavior of the table.
     * @return the color of the box.
     */
    @Override
    public String toString() {
        return "Amarillo";
    }
}
