package Proyecto1.DatosParty.Observer;

import Proyecto1.DatosParty.Boxes.Box;

/**
 * Concrete observer, controls if a box is occupied by two players at the same time.
 */
public class BoxObserver extends Observer {
    public BoxObserver(Box observable) {
        this.subject = observable;
        this.subject.attach(this);
    }


    public void update() {
        System.out.println(this.subject.getState());

        // aca va el codigo para verificar si la casilla esta o no ocupada y actuar como corresponda


    }
}
