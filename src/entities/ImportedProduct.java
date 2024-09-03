package entities;

public class ImportedProduct extends Product{

    private double customFee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, Double price, double customFee) {
        super(name, price);
        this.customFee = customFee;
    }

    public double getCustomFee() {
        return customFee;
    }

    public void setCustomFee(double customFee) {
        this.customFee = customFee;
    }

    public double totalPrice(){
        return super.getPrice() + customFee;
    }

    @Override
    public String toString() {
        return getName() + " $" + totalPrice() + " (Custom fee: $" + customFee + ")";
    }

}
