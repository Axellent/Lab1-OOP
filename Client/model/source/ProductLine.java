package source;

public class ProductLine {
    /**
     * @attribute
     */
    private Product product;

    /**
     * @attribute
     */
    private int amount;

    /**
     * @attribute
     */
    private double priceSum;
    
    public ProductLine(Product newProduct, int newAmount, double newPriceSum){
        product = newProduct;
        amount = newAmount;
        priceSum = newPriceSum;
    }

    public void setAmount(int newAmount){
        amount = newAmount;
    }
    
    public void setPriceSum(double newPriceSum){
        priceSum = newPriceSum;
    }

    public void setProduct(Product newProduct){
        product = newProduct;
    }

    public int getAmount(){
        return amount;
    }
    
    public double getPriceSum(){
        return priceSum;
    }

    public Product getProduct() {
        return product;
    }
}
