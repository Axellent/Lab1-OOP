package Discount;

import java.io.Serializable;
import java.util.Calendar;
import source.ProductLine;
import source.Purchase;

public class XforYifZ extends Discount implements Serializable {
    
    String buyX;
    double forY;
    String ifZ;
    
    
    public XforYifZ(String buyX, String ifZ, int forY, Calendar expirationDate, String description){
        super(expirationDate, description);
        this.buyX = buyX;
        this.forY = forY;
        this.ifZ = ifZ;
    }
    
    public void setDiscount(String buyX, String ifZ, int forY, int zAmount){
        
        this.buyX = buyX;
        this.forY = forY;
        this.ifZ = ifZ;
    }
    
    @Override
    public void getDiscount(Purchase purchase) {
        ProductLine x = purchase.getProductLine(buyX);
        ProductLine z = purchase.getProductLine(ifZ);
        
        if(x != null && z != null){
            double price = x.getPriceSum();
            int xAmount = x.getAmount();
            int zAmount = z.getAmount();
            if(xAmount == zAmount){
                price = xAmount * forY;
            }
            else if(xAmount < zAmount){
                price = xAmount * forY;
            }
            else if(xAmount > zAmount){
                price = (zAmount * forY) + ((xAmount - zAmount) * x.getProduct().getPrice());
            }
            x.setPriceSum(price);
        }
    }
}
