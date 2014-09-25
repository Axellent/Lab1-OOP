package Discount;

import java.util.Calendar;
import source.Purchase;

public class Xpercent extends Discount {
    
    double precent;
    
    public Xpercent(double precent, Calendar expirationDate, String description){
        super(expirationDate, description);
        this.precent = precent;
        
    }
    
    @Override
    public void getDiscount(Purchase purchase){
        
    }
}
