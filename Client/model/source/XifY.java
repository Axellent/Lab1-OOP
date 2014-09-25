package Discount;

import java.io.Serializable;
import java.util.Calendar;
import source.ProductLine;
import source.Purchase;

public class XifY extends Discount implements Serializable{
    
    String getX;
    String ifY;
    
    public XifY(String getX, String ifY, Calendar expirationDate, String description){
        super(expirationDate, description);
        this.getX = getX;
        this.ifY = ifY;
    }
    
    public void setDiscount(String getX, String ifY){
        this.getX = getX;
        this.ifY = ifY;
    }
    
    @Override
    public void getDiscount(Purchase purcahse){
        ProductLine x = purcahse.getProductLine(getX);
        ProductLine y = purcahse.getProductLine(ifY);
        
       
        
        if(y != null && x != null){
            double price = x.getPriceSum();
            int xAmount = x.getAmount();
            int yAmount = y.getAmount();
            
            if(xAmount == yAmount){
                price = 0.0;
            }
            else if(xAmount < yAmount){
                price = 0.0;
            }
            else if(xAmount > yAmount){
                price = (x.getProduct().getPrice() * xAmount) - (x.getProduct().getPrice() * yAmount);
            }
            x.setPriceSum(price);
        }
    }
}
