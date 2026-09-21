public class NoDiscountItem extends Item {
    public NoDiscountItem(String name, double price) {
        super(name, price);
    }


    @Override
    public String getNote(int quantity) {
        return "no discount \u2014 never discounted";
    }
}
