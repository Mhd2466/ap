package ap.excercises.ex4;

import ap.excercises.ex4.E3_4.HallwayLightControl;

public class E3_5 {

    public static void main(String[] args) {
        HallwayLightControl circuit = new HallwayLightControl();//need E3.4 

        
        System.out.println("Initial State:");
        printStates(circuit, 0, 0, 0);

        // Toggle first switch (up)
        circuit.toggleFirstSwitch();
        System.out.println("\nAfter toggling first switch:");
        printStates(circuit, 1, 0, 1);

        // Toggle second switch (up)
        circuit.toggleSecondSwitch();
        System.out.println("\nAfter toggling second switch:");
        printStates(circuit, 1, 1, 0);

        // Toggle first switch (down)
        circuit.toggleFirstSwitch();
        System.out.println("\nAfter toggling first switch again:");
        printStates(circuit, 0, 1, 1);

        
        circuit.toggleSecondSwitch();
        System.out.println("\nAfter toggling second switch again:");
        printStates(circuit, 0, 0, 0);
    }


    

    private static void printStates(HallwayLightControl circuit, int expectedFirst, int expectedSecond, int expectedLamp) {
        System.out.println("First Switch: actual = " + circuit.getFirstSwitchState() + ", expected = " + expectedFirst);
        System.out.println("Second Switch: actual = " + circuit.getSecondSwitchState() + ", expected = " + expectedSecond);
        System.out.println("Lamp: actual = " + circuit.getLampState() + ", expected = " + expectedLamp);
    }
}


