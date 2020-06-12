package Proyecto1.DatosParty.Boxes;


import Proyecto1.DatosParty.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GreenBox extends Box {

    //  //  //  //  //  //  //  //  //  //               METHODS                 //  //  //  //  //  //  //  //  //  //

    /**
     * Constructor 1 of the class: for creating an instantiation of the class whit it's respective ID.
     * @param id
     */
    public GreenBox(int id) {
        Box.id = id;
        this.tag = "green";
    }

    public GreenBox() {
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

        // Get the grapics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //set the color
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLACK);
        //Draw the rectangle
        gc.strokeRect(x, y, this.height, this.width);
        gc.fillRect(x, y, this.height, this.width);
        StringBuilder id = new StringBuilder();
        id.append(this.excelId);
        gc.setFill(Color.BLACK);
        gc.fillText((id.toString()), 10, 150);

        if(this.hasStar){
            gc.setFill(Color.WHITE);
            gc.setStroke(Color.WHITE);
            gc.strokeOval(x+13,y+13,10, 10);
            gc.setFill(Color.WHITE);
        }
    }

    @Override
    public void iteract(Player player) {
        player.modifyCoins(true, 10);
        super.iteract(player);

    }

    @Override
    public String getMessage(Player player) {
        return " wins 10 coins.";
    }


    /**
     * Method for printing the box in the run panel in order to check the correct behavior of the table.
     *
     * @return the color of the box.
     */
    @Override
    public String toString() {
        return "GreenBox{" +
                "excelId=" + excelId +

                '}';
    }
}

