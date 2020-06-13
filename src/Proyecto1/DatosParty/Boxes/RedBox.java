package Proyecto1.DatosParty.Boxes;

import Proyecto1.DatosParty.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/** Class of implementing the red box, it has the hability to take 10 coins from a player, when placed on it.
 *
 */
public class RedBox extends Box {

    //  //  //  //  //  //  //  //  //  //               METHODS                 //  //  //  //  //  //  //  //  //  //


    public RedBox(int id) {
        Box.id = id;this.tag = "red";

    }

     public RedBox() {
         this.tag = "red";
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
        gc.setFill(Color.valueOf("#bf3124"));

        gc.setStroke(Color.BLACK);

        //Draw the rectangle
        // gc.strokeRect(x, y, this.height, this.width);
        gc.fillRect(x, y, this.height, this.width);

        StringBuilder id = new StringBuilder();
        id.append(this.excelId);
        gc.setFill(Color.BLACK);
        gc.fillText((id.toString()), 10, 150);

        if (this.hasStar) {
            Image star = new Image("Proyecto1/DatosParty/GUI/Resources/images/star.png");
            gc.drawImage(star, x, y);
        }
        if (this.isHilighted) {
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(5);
            gc.strokeRect(x, y, this.height, this.width);
            gc.setLineWidth(1);
            gc.strokeText(new StringBuilder().append(this.excelId).toString(), x + 6, y + (this.width) / 2 + 2);
            this.isHilighted = false;
        }
    }

    @Override
    public void iteract(Player player) throws Exception {
        super.iteract(player);
        player.modifyCoins(false, 10);
    }

    @Override
    public String getMessage(Player player) {
        return new StringBuilder().append(player.nickname).append(" loses 10 coins.").toString();
    }

    /**
     * Method for printing the box in the run panel in order to check the correct behavior of the table.
     *
     * @return the color of the box.
     */
    @Override
    public String toString() {
        return "RedBox{" +
                "excelId=" + excelId +

                '}';
    }
}
