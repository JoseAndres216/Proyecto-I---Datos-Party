package Proyecto1.DatosParty.Boxes;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GreenBox extends Box {
    public GreenBox(int id) {
        Box.id = id;
    }

    public GreenBox() {
    }

    public void draw(int x, int y, Canvas canvas) {

        // Get the grapics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //set the color
        gc.setFill(Color.GREEN);

        gc.setStroke(Color.BLACK);

        //Draw the rectangle
        gc.strokeRect(x, y, this.height, this.width);
        gc.fillRect(x, y, this.height, this.width);
    }

    @Override
    public String toString() {
        return "Verde";
    }
}

