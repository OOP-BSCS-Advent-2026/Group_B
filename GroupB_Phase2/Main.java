public class Main {
    public static void main(String[] args) {

        Item[] items = {
            new PercentDiscountItem("Rice (plate)", 3500.00, 4, 5),
            new NoDiscountItem("Chicken (piece)", 12000.00),
            new FlatDiscountItem("Chapati", 1000.00, 3, 500.0),
            new PercentDiscountItem("Soda", 2500.00, 6, 10)
        };

        int[] quantities = { 3, 2, 2, 6 };

        System.out.println("==== KAMPALA CORNER CAFE ====");
        for (int i = 0; i < items.length; i++) {
            System.out.printf(
                "%d. %-16s UGX %.2f%n",
                i + 1,
                items[i].getName(),
                items[i].getPrice()
            );
        }

        double[] subtotals = new double[items.length];
        String[] notes = new String[items.length];

        for (int i = 0; i < items.length; i++) {
            subtotals[i] = items[i].calculateTotal(quantities[i]);
            notes[i] = items[i].getNote(quantities[i]);
        }

        printReceipt(items, quantities, subtotals, notes);
    }

    public static void printReceipt(Item[] items, int[] quantities,
                                     double[] subtotals, String[] notes) {

        System.out.println("\n==== RECEIPT ====");
        double grandTotal = 0;

        for (int i = 0; i < items.length; i++) {
            System.out.printf(
                "%-16s x%-3d = UGX %-10.2f (%s)%n",
                items[i].getName(),
                quantities[i],
                subtotals[i],
                notes[i]
            );
            grandTotal += subtotals[i];
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("TOTAL            = UGX %.2f%n", grandTotal);
    }
}
