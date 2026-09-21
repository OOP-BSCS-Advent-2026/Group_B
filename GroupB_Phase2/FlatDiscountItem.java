public class FlatDiscountItem extends Item {
    private int threshold;
    private double flatAmount;

    public FlatDiscountItem(String name, double price,
                             int threshold, double flatAmount) {
        super(name, price);
        this.threshold = threshold;
        this.flatAmount = flatAmount;
    }

    @Override
    public double calculateTotal(int quantity) {
        double subtotal = super.calculateTotal(quantity);
        if (quantity >= threshold) {
            subtotal = Math.max(0, subtotal - flatAmount);
        }
        return subtotal;
    }

    @Override
    public String getNote(int quantity) {
        if (quantity >= threshold) {
            return "UGX " + String.format("%.0f", flatAmount) + " off applied";
        }
        return "no discount \u2014 fewer than " + threshold;
    }
}
