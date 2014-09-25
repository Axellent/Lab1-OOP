package Discount;

import java.io.Serializable;
import source.Product;
import source.Purchase;

public class XforYifZ extends Discount implements Serializable {
    
    String buyX;
    int forY;
    String ifZ;
    int zAmount;
    
    
    public XforYifZ(){
        buyX = "";
        forY = 1;
        ifZ = "";
        zAmount = 1;
    }
    
    public XforYifZ(String buyX, String ifZ, int forY, int zAmount){
        this.buyX = buyX;
        this.forY = forY;
        this.ifZ = ifZ;    
        this.zAmount = zAmount;
    }
    
    public void setDiscount(String buyX, String ifZ, int forY, int zAmount){
        this.buyX = buyX;
        this.forY = forY;
        this.ifZ = ifZ;    
        this.zAmount = zAmount;
    }
    
    @Override
    public double getDiscount(Purchase purchase) {
        //TODO: Get product X
        //TODO: Get product Z
        
        //TODO: calc x fot Y if Z discount.
        
        return 0.0;
    }
}
