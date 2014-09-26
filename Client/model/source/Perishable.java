package source;

import java.util.Date;

public class Perishable extends Product {
    
    public Perishable(Integer EAN, String descr, double price, String expireDate) {
        super(EAN, descr, price);
        this.bestBeforeDate = expireDate;
    }
    
    private String bestBeforeDate;
    
    //Author: Gustav Ernstsson
    public String getBestBeforeDate() {
        return this.bestBeforeDate;
    }

    public void setBestBeforeDate(String newBestBeforeDate) {
        this.bestBeforeDate = newBestBeforeDate;
    }
}
