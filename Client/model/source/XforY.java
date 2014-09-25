package Discount;

import java.io.Serializable;
import source.ProductLine;
import source.Purchase;

public class XforY extends Discount implements Serializable{

    private String productName;
    private int buyX;
    private int forY;
    
    public XforY(){
        buyX = 1;
        forY = 1;
    }
    
    public XforY(int buyX, int forY, String productName){
        this.productName = productName;
        if(buyX > forY){
            this.buyX = forY;
        }
        else{
            this.buyX = buyX;
        }
        this.forY = forY;
    }
    
    @Override
    public double getDiscount(Purchase purchase) {
        //TODO: Get product X
        int amount = 1;
        int totalDiscountTimes = (int)Math.floor(amount / buyX);
        
        for(int i = 0; i < totalDiscountTimes; i++) {
            amount -= (buyX - forY);
        }
        
        return amount; //TODO Calc X for Y discount
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
