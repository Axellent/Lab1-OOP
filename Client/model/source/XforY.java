package Discount;

import java.io.Serializable;
import java.util.Calendar;
import source.ProductLine;
import source.Purchase;

public class XforY extends Discount implements Serializable{

    private String productName;
    private int buyX;
    private int forY;
    
    public XforY(int buyX, int forY, String productName, Calendar expirationDate, String description){
        super(expirationDate, description);
        this.productName = productName;
        if(buyX > 0 && forY > 0){
            if(buyX > forY){
                this.buyX = forY;
            }
            else{
                this.buyX = buyX;
            }
            this.forY = forY;
        }
        else{
            this.buyX = 1;
            this.forY = 1;
        }
    }
    
    @Override
    public void getDiscount(Purchase purchase) {
        ProductLine product = purchase.getProductLine(productName);
        if(product != null){
            int amount = product.getAmount();
            int totalDiscountTimes = (int)Math.floor(amount / buyX);

            amount -= (buyX - forY) * totalDiscountTimes;
            
            product.setPriceSum(product.getProduct().getPrice() * amount); 
        }
    }
    
    public void setDiscount(int buyX, int forY, String productName){
        this.productName = productName;
        if(buyX > 0 && forY > 0){
            if(buyX > forY){
                this.buyX = forY;
            }
            else{
                this.buyX = buyX;
            }
            this.forY = forY;
        }
        else{
            this.buyX = 1;
            this.forY = 1;
        }
    }
}
