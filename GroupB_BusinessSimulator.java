public class GroupB_BusinessSimulator {

 
    public static double calculateSubtotal(double price, int quantity,
                                            int threshold, double discountValue,
                                            boolean isPercentage) {
        double subtotal = price*quantity;

        if (quantity >= threshold) {
            if (isPercentage) {
                subtotal = subtotal - (subtotal * discountValue);
            } else {
                subtotal = subtotal - discountValue;
            }
        }

        return subtotal;
    }
    
    public static String buildNote(int quantity, int threshold, boolean neverDiscounted,
                                    boolean isPercentage, double discountValue) {
        if (neverDiscounted) {
            return "no discount \u2014 never discounted";
        }
        if (quantity >= threshold) {
            if (isPercentage) {
                return (int) Math.round(discountValue * 100) + "% discount applied";
            } else {
                return "UGX " + String.format("%.0f", discountValue) + " off applied";
            }
        } else {
            return "no discount \u2014 fewer than " + threshold;
        }
    }

    public static void printReceipt(String[] items, int[] quantities,
                                     double[] subtotals, String[] notes) {

        System.out.println("\n==== RECEIPT ====");

        double grandTotal = 0;

        for (int i = 0; i < items.length; i++) {
            System.out.printf(
                "%-16s x%-3d = UGX %-10.2f (%s)%n",
                items[i],
                quantities[i],
                subtotals[i],
                notes[i]
            );
            grandTotal += subtotals[i];
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("TOTAL            = UGX %.2f%n", grandTotal);
    }

    public static void main(String[] args) {


        String[] items = {
            "Rice (plate)",
            "Chicken (piece)",
            "Chapati",
            "Soda"
        };

        double[] prices = {
            3500.00,
            12000.00,
            1000.00,
            2500.00
        };
 
        System.out.println("==== KAMPALA CORNER CAFE ====");

        for (int i = 0; i < items.length; i++) {
            System.out.printf(
                "%d. %-16s UGX %.2f%n",
                i + 1,
                items[i],
                prices[i]
            );
        }


        int[] quantities = {
            3,   
            2,   
            2,   
            6    
        };


        int[] thresholds = {
            4,                  
            Integer.MAX_VALUE,  
            3,                  
            6                   
        };

        double[] discountValues = {
            0.05,   
            0.0,    
            500.0,  
            0.10    
        };

        boolean[] isPercentage = {
            true,   
            false,  
            false,  
            true    
        };

        boolean[] neverDiscounted = {
            false,  
            true,   
            false,  
            false   
        };


        double[] subtotals = new double[items.length];
        String[] notes = new String[items.length];

        for (int i = 0; i < items.length; i++) {

            subtotals[i] = calculateSubtotal(
                prices[i],
                quantities[i],
                thresholds[i],
                discountValues[i],
                isPercentage[i]
            );

            notes[i] = buildNote(
                quantities[i],
                thresholds[i],
                neverDiscounted[i],
                isPercentage[i],
                discountValues[i]
            );
        }


        printReceipt(
            items,
            quantities,
            subtotals,
            notes
        );
    }
}