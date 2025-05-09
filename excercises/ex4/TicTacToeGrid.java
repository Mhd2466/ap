package ap.excercises.ex4;

public class TicTacToeGrid {
    public static void main(String[] args) {
        String comb = "+--+--+--+";
        String row = "|  |  |  |";

        for (int i = 0; i < 3; i++) {
            System.out.println(comb);
            System.out.println(row);
        }
        System.out.println(comb); // Final bottom line
    }
}
