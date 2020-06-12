package Proyecto1.DatosParty.Events;

import Proyecto1.DatosParty.DataStructures.Stack.Stack;
import org.junit.Test;

import static org.junit.Assert.*;

public class EventTest {

    @Test
    public void getEventStack(){
        Stack<Event>  stackPrueba = Event.getEventStack();
        System.out.println(stackPrueba);
    }
}