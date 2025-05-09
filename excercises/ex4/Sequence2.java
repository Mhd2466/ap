package ap.excercises.ex4;

import java.util.ArrayList;

public class Sequence2 {
    private ArrayList<Integer> values;

    public Sequence2() {
        values = new ArrayList<Integer>();
    }

    public void add(int n) {
        values.add(n);
    }

    public String toString() {
        return values.toString();
    }

    public Sequence2 append(Sequence2 other) {
        Sequence2 result = new Sequence2();

        // Add elements from this sequence
        for (int value : this.values) {
            result.add(value);
        }

        // Add elements from the other sequence
        for (int value : other.values) {
            result.add(value);
        }

        return result;
    }
}

