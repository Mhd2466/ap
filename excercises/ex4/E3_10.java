package ap.excercises.ex4;

public class E3_10 {
    public class CashRegister {
        private double total;
        private int itemCount;
        private String allPrices; // String to accumulate prices
    
        public CashRegister() {
            total = 0;
            itemCount = 0;
            allPrices = "";
        }
    
        public void addItem(double price) {
            total += price;
            itemCount++;
            // Add the new price to the list of prices
            allPrices = allPrices.concat(String.valueOf(price)).concat("\n");
        }
    
        public double getTotal() {
            return total;
        }
    
        public int getItemCount() {
            return itemCount;
        }
    
        public void printReceipt() {
            System.out.print("Items purchased:\n");
            System.out.print(allPrices);
            System.out.printf("Total: %.2f\n", total);
        }
    }
    
}
