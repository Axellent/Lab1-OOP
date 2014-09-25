package Discount;

import java.util.Calendar;
import java.util.Map;
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

    public void calcDiscount(Purchase purchase) {
        for (String key : productCode.keySet()) {
            if(purchase.getProductLine(key) != null){
                Discount tempDis = discount.get(productCode.get(key));
                if(Calendar.getInstance().before(tempDis.getExpirationDate())){
                    tempDis.getDiscount(purchase);
                }
            }
        }
    }
    
    public void calcDiscount(Purchase purchase, String code){
        Discount tempDis = discount.get(code);
        if(Calendar.getInstance().before(tempDis.getExpirationDate())){
            tempDis.getDiscount(purchase);
        }
    }

    public void addDiscount(String code, Discount discount) {
        this.discount.put(code, discount);
    }
    
    public void addDiscount(String code, Discount discount, String productName){
        productCode.put(productName, code);
        addDiscount(code, discount);
    }

    public void delDiscount(String code) {
        discount.remove(code);
        for(Map.Entry key : productCode.entrySet()){
            String Value;
            Value = (String)key.getValue();
            if(Value.equals(code)){
                productCode.remove((String)key.getKey());
            }
        }
    }
}
