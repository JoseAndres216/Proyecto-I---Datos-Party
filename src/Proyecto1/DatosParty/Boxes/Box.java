package Proyecto1.DatosParty.Boxes;

import java.util.Observer;

public abstract class Box {
    private boolean busy;
    private Observer observer;
    private static int id = 0;


    Box(){
        id ++;
    }


}
