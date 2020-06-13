package Proyecto1.DatosParty.Boxes;
import Proyecto1.DatosParty.DataStructures.Stack.Stack;
import Proyecto1.DatosParty.Events.Event;
import Proyecto1.DatosParty.Player;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
/** Class of implementing the green box, it has the capacity to trigger an event from the event stack.*/

public class YellowBox extends Box {
    private String message;

    //  //  //  //  //  //  //  //  //  //               METHODS                 //  //  //  //  //  //  //  //  //  //


    public YellowBox(int id) {
        Box.id = id;
        this.tag = "yellow";
    }

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
        gc.setFill(Color.valueOf("#dae028"));
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
            gc.setLineWidth(5);
            gc.strokeRect(x, y, this.height, this.width);
            gc.setLineWidth(1);
            gc.strokeText(new StringBuilder().append(this.excelId).toString(), x + 6, y + (this.width) / 2 + 2);
            this.isHilighted = false;
        }
    }

    public YellowBox() {
        this.tag = "yellow";
    }

    /**
     * Constructor 2 of the class: For just instantiating the class.
     */


    @Override
    public void iteract(Player player) throws Exception {
        Stack<Event> events = Event.getEventStack();
        events.peek().interact(player);
        events.pop();

        super.iteract(player);
    }

    @Override
    public String getMessage(Player player) {
        return new StringBuilder().append(player.nickname).append(" triggered: ").append(Event.getEventStack().peek().toString()).toString();

    }


    /**
     * Method for printing the box in the run panel in order to check the correct behavior of the table.
     *
     * @return the color of the box.
     */
    @Override
    public String toString() {
        return "YellowBox{" +
                "excelId=" + excelId +
                '}';
    }
}
