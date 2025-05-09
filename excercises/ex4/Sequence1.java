package ap.excercises.ex4;

public class Sequence1 {
    private int[] values;

    public Sequence1(int size) {
        values = new int[size];
    }

    public void set(int i, int n) {
        values[i] = n;
    }

    public int get(int i) {
        return values[i];
    }

    public int size() {
        return values.length;
    }

    public boolean equals(Sequence1 other) {
        if (this.size() != other.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) != other.get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean sameValues(Sequence1 other) {
        for (int i = 0; i < this.size(); i++) {
            int current = this.get(i);
            if (!isFirstOccurrence(this, i)) {
                continue;
            }
            if (!contains(other, current)) {
                return false;
            }
        }

        for (int i = 0; i < other.size(); i++) {
            int current = other.get(i);
            if (!isFirstOccurrence(other, i)) {
                continue;
            }
            if (!contains(this, current)) {
                return false;
            }
        }

        return true;
    }

    private boolean isFirstOccurrence(Sequence1 s, int index) {
        int value = s.get(index);
        for (int i = 0; i < index; i++) {
            if (s.get(i) == value) {
                return false;
            }
        }
        return true;
    }

    private boolean contains(Sequence1 s, int value) {
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) == value) {
                return true;
            }
        }
        return false;
    }


    public Sequence1 sum(Sequence1 other) {
        int maxLength = Math.max(this.size(), other.size());
        Sequence1 result = new Sequence1(maxLength);

        for (int i = 0; i < maxLength; i++) {
            int val1 = (i < this.size()) ? this.get(i) : 0;
            int val2 = (i < other.size()) ? other.get(i) : 0;
            result.set(i, val1 + val2);
        }

        return result;
    }
}

