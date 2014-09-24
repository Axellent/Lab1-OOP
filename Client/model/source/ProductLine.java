package source;

public class ProductLine {

    private Product product;

    private int amount;
    private double priceSum;
    
    public ProductLine(Product newProduct, int newAmount){
        product = newProduct;
        amount = newAmount;
        priceSum = product.getPrice() * amount;
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
