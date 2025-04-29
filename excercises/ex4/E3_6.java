package ap.excercises.ex4;

public class E3_6 {
public class HallwayLightControl {
    // Represent switch states using two bits of an integer
    private int switches; 

    public HallwayLightControl() {
        switches = 0; // both switches start down
    }

    public int getSwitchState(int switchNum) {
        if (switchNum == 1) {
            return (switches & 1); // Bit 0
        } else if (switchNum == 2) {
            return (switches >> 1) & 1; // Bit 1
        } else {
            throw new IllegalArgumentException("Invalid switch number: " + switchNum);
        }
    }

    public int getLampState() {

        int first = getSwitchState(1);
        int second = getSwitchState(2);
        return (first ^ second); 
    }

    public void toggleSwitch(int switchNum) {
        if (switchNum == 1) {
            switches = switches ^ 1; // Toggle bit 0
        } else if (switchNum == 2) {
            switches = switches ^ 2; // Toggle bit 1
        } else {
            throw new IllegalArgumentException("Invalid switch number: " + switchNum);
        }
    }
}
}