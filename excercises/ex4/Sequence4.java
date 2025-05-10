package ap.excercises.ex4;

import java.util.ArrayList;

public class Sequence4 {
    private ArrayList<Integer> values;

    public Sequence4() {
        values = new ArrayList<Integer>();
    }

    public void add(int n) {
        values.add(n);
    }

    public String toString() {
        return values.toString();
    }

    // Helper to find the length of the sorted prefix
    private int sortedPrefixLength() {
        if (values.isEmpty()) return 0;
        int i = 1;
        while (i < values.size() && values.get(i) >= values.get(i - 1)) {
            i++;
        }
        return i;
    }

    public Sequence4 mergeSorted(Sequence4 other) {
        Sequence4 result = new Sequence4();

        int i = 0, j = 0;
        int thisSorted = this.sortedPrefixLength();
        int otherSorted = other.sortedPrefixLength();

        while (i < thisSorted && j < otherSorted) {
            if (this.values.get(i) <= other.values.get(j)) {
                result.add(this.values.get(i));
                i++;
            } else {
                result.add(other.values.get(j));
                j++;
            }
        }

        // Add remaining elements from this sequence's sorted prefix
        while (i < thisSorted) {
            result.add(this.values.get(i));
            i++;
        }

        // Add remaining elements from other sequence's sorted prefix
        while (j < otherSorted) {
            result.add(other.values.get(j));
            j++;
        }

        return result;
    }
}
