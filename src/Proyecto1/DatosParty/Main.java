package Proyecto1.DatosParty;

import Proyecto1.DatosParty.Boxes.Box;
import Proyecto1.DatosParty.Boxes.GreenBox;
import Proyecto1.DatosParty.CircularDoubleList.CircularDoubleList;
import Proyecto1.DatosParty.DoubleLinkedList.DoubleLinkedList;
import Proyecto1.DatosParty.MotherList.MotherList;
import Proyecto1.DatosParty.Observer.BoxObserver;
import Proyecto1.DatosParty.SimpleCircularList.SimpleCircularList;
import Proyecto1.DatosParty.SimpleLinkedList.SimpleLinkedList;

public class Main {

    public static void main(String[] args) {
        GreenBox casillaPrueba = new GreenBox();
        casillaPrueba.setState(true);

        BoxObserver observerPrueba = new BoxObserver( casillaPrueba);

        casillaPrueba.setState(true);
        casillaPrueba.notifyObserver();

        casillaPrueba.setState(false);
        casillaPrueba.notifyObserver();

    }
}
