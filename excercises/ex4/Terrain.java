package ap.excercises.ex4;

public class Terrain {
    private double[][] heights;

    public Terrain(double[][] heights) {

        this.heights = new double[heights.length][];
        for (int i = 0; i < heights.length; i++) {
            this.heights[i] = heights[i].clone();
        }
    }

    public void printFloodMap(double waterLevel) {
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (heights[i][j] <= waterLevel) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public double getMinHeight() {
        double min = heights[0][0];
        for (double[] row : heights) {
            for (double h : row) {
                if (h < min) min = h;
            }
        }
        return min;
    }

    public double getMaxHeight() {
        double max = heights[0][0];
        for (double[] row : heights) {
            for (double h : row) {
                if (h > max) max = h;
            }
        }
        return max;
    }
}

