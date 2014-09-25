package Discount;

import source.Purchase;

public class Xpercent extends Discount {
    
    double precent;
    
    public Xpercent(){
        
    }
    
    @Override
    public double getDiscount(Purchase purchase){
        return 0.0; // TODO Calc percent dicount
    }
}
