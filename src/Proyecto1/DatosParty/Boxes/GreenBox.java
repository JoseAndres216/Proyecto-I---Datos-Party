package Proyecto1.DatosParty.Boxes;


import Proyecto1.DatosParty.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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
        this.tag = "green";
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
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLACK);
        //Draw the rectangle

        gc.fillRect(x, y, this.height, this.width);

        if (this.isHilighted) {
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(5);
            gc.strokeRect(x, y, this.height, this.width);
            gc.setLineWidth(1);
            gc.strokeText(new StringBuilder().append(this.excelId).toString(), x + 6, y + (this.width) / 2 + 2);
            this.isHilighted = false;
        }

        if (this.hasStar) {
            Image star = new Image("Proyecto1/DatosParty/GUI/Resources/images/star.png");
            gc.drawImage(star, x, y);
        }
    }

    @Override
    public void iteract(Player player) throws Exception {
        player.modifyCoins(true, 10);
        super.iteract(player);

    }

    @Override
    public String getMessage(Player player) {
        return new StringBuilder().append(player.nickname).append(" wins 10 coins.").toString();

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

