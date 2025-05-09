package ap.excercises.ex4;

import java.util.ArrayList;

public class Sequence3 {
    private ArrayList<Integer> values;

    public Sequence3() {
        values = new ArrayList<Integer>();
    }

    public void add(int n) {
        values.add(n);
    }

    public String toString() {
        return values.toString();
    }

    public Sequence3 merge(Sequence3 other) {
        Sequence3 result = new Sequence3();

        int size1 = this.values.size();
        int size2 = other.values.size();
        int minSize = Math.min(size1, size2);

        // Alternate elements from both sequences
        for (int i = 0; i < minSize; i++) {
            result.add(this.values.get(i));
            result.add(other.values.get(i));
        }

        // Append remaining elements from the longer sequence
        for (int i = minSize; i < size1; i++) {
            result.add(this.values.get(i));
        }
        for (int i = minSize; i < size2; i++) {
            result.add(other.values.get(i));
        }

        return result;
    }
}
