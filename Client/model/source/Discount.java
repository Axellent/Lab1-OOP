package Discount;

import java.io.Serializable;
import java.util.Calendar;
import source.Purchase;

public abstract class Discount implements Serializable{
    //Variable
    /**
     * @attribute
     */
    private String discountCode;

    /**
     * @attribute
     */
    private String description;

    /**
     * @attribute
     */
    private Calendar expirationDate;
    
    //Functions
    
    public abstract double getDiscount(Purchase purchase);

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

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

}
