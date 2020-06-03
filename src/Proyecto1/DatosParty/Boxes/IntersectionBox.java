package Proyecto1.DatosParty.Boxes;

import Proyecto1.DatosParty.DataStructures.BaseModels.MotherList;
import Proyecto1.DatosParty.Phase;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class IntersectionBox extends Box {

    public Phase phase;

    public IntersectionBox() {
    }

    public void draw(int x, int y, Canvas canvas) {

        // Get the grapics context of the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //set the color
        gc.setFill(Color.WHITE);

        gc.setStroke(Color.BLACK);

        //Draw the rectangle
        gc.strokeRect(x, y, this.height, this.width);
        gc.fillRect(x, y, this.height, this.width);
    }


    public IntersectionBox(Phase phase, int id) {
        this.phase = phase;
        this.isIntersection = true;
        Box.id = id;
    }

    public MotherList<Box> getList() {
        return this.phase.phaseList;
    }

    @Override
    public Phase getPhase() {
        return this.phase;
    }

    @Override
    public String toString() {
        return "Blanco";
    }
}
