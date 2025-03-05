package ap.practice1;



import java.util.ArrayList;
import java.util.Scanner;
    
    class DataSet {
        private ArrayList<Double> values;
    
        public DataSet() {
            values = new ArrayList<>();
        }
    
        public void add(double value) {
            values.add(value);
        }
    
        public double getAverage() {
            if (values.isEmpty()) return 0;
            double sum = 0;
            for (double val : values) {
                sum += val;
            }
            return sum / values.size();
        }
    
        public double getSmallest() {
            if (values.isEmpty()) return Double.NaN;
            double min = values.get(0);
            for (double val : values) {
                if (val < min) {
                    min = val;
                }
            }
            return min;
        }
    
        public double getLargest() {
            if (values.isEmpty()) return Double.NaN;
            double max = values.get(0);
            for (double val : values) {
                if (val > max) {
                    max = val;
                }
            }
            return max;
        }
    
        public double getRange() {
            return getLargest() - getSmallest();
        }
    }
    
    public class E65 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            DataSet dataSet = new DataSet();
    
            System.out.println("Enter floating-point values separated by spaces:");
            String input = scanner.nextLine();
            String[] numbers = input.split(" ");
    
            for (String num : numbers) {
                try {
                    double value = Double.parseDouble(num);
                    dataSet.add(value);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + num + " (ignored)");
                }
            }
    
            System.out.println("Average: " + dataSet.getAverage());
            System.out.println("Smallest: " + dataSet.getSmallest());
            System.out.println("Largest: " + dataSet.getLargest());
            System.out.println("Range: " + dataSet.getRange());
    
            scanner.close();
        }
    }//I used AI for understanding some parts of this code like class , some methodes and scanner.close() :)
    