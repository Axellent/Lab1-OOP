package source;

import java.io.Serializable;

//Author: Axel Sigl
public class ProductLine implements Serializable{

    private Product product;
    private int amount;
    private double priceSum;
    
    //Author: Axel Sigl
    public ProductLine(Product newProduct, int newAmount){
        product = newProduct;
        amount = newAmount;
        priceSum = product.getPrice() * amount;
    }

    //Author: Axel Sigl
    public void setAmount(int newAmount){
        amount = newAmount;
    }
    
    //Author: Axel Sigl
    public void setPriceSum(double newPriceSum){
        priceSum = newPriceSum;
    }

    //Author: Axel Sigl
    public void setProduct(Product newProduct){
        product = newProduct;
    }

    //Author: Axel Sigl
    public int getAmount(){
        return amount;
    }
    
    //Author: Axel Sigl
    public double getPriceSum(){
        return priceSum;
    }

    //Author: Axel Sigl
    public Product getProduct() {
        return product;
    }
}
