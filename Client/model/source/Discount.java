package source;

import java.io.Serializable;
import java.util.Calendar;
import source.Purchase;

public abstract class Discount implements Serializable{
    //Variable

    /**
     * @attribute
     */
    private String description;

    /**
     * @attribute
     */
    private Calendar expirationDate;
    
    //Functions
    
    public Discount(Calendar expirationDate, String description){
        this.expirationDate = expirationDate;
        this.description = description;
    }
    
    public abstract void getDiscount(Purchase purchase);

    public void setdescr(String description) {
        this.description = description; 
    }

    public String getDescr() {
        return description;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }
}
