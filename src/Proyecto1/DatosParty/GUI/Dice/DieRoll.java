package Proyecto1.DatosParty.GUI.Dice;
import java.util.Random;

public class DieRoll {
    int rollNum;
    int sides = 6;

    public void roll(){
        Random random = new Random();
        rollNum = random.nextInt(sides) + 1;
    }
    public int getRoll(){
        return rollNum;
    }
}
