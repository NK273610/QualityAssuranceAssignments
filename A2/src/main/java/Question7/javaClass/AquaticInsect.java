package Question7.javaClass;

import Question7.javaInterface.MoveAntennae;
import Question7.javaInterface.Swim;

public class AquaticInsect implements Swim, MoveAntennae {


    public void MoveAntennae() {

        System.out.println("Sploosh!");
    }

    public void Swim() {

        System.out.println("Moving my antennae underwater!");

    }
}
