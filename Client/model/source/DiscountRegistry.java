package Discount;

import java.util.Map;
import java.util.Calendar;
import java.util.TreeMap;
import source.Purchase;

public class DiscountRegistry {
    /**
     * @attribute
     */
    private Map<String,Discount> discount;
    private Map<String,String> productCode;
    
    public DiscountRegistry(){
        discount = new TreeMap<>();
        productCode = new TreeMap<>();
    }

    public double getDiscount(String code, Purchase purchase) {
        Discount tempDiscount;
        tempDiscount = discount.get(code);
        if(tempDiscount == null){
            tempDiscount = discount.get(productCode.get(code));
        }
        if(tempDiscount != null){
            if(Calendar.getInstance().before(tempDiscount.getExpirationDate())){
                return tempDiscount.getDiscount(purchase);
            }
        }
        return -1;
    }


    public void addDiscount(String code, Discount discount) {
        this.discount.put(code, discount);
    }
    
    public void addDiscount(String code, Discount discount, String productName){
        productCode.put(productName, code);
        addDiscount(code, discount);
    }

    public void delDiscount(String code) {
        
    }
}
