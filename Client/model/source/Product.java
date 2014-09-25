package source;

import java.io.Serializable;

public class Product implements Serializable{
    /**
     * @attribute
     */
    private Integer EAN;
    
    private String name;

    /**
     * @attribute
     */
    private String descr;

    /**
     * @attribute
     */
    private double price;

    public Integer getEAN() {
        return 0;
    }
    
    public String getName(){
        return "";
    }

    public String getDescr() {
        return "";
    }

    public double getPrice() {
        return 0;
    }

    public void setEAN(Integer newEAN) {
    }
    
    public void setName(String newName) {
    }

    public void setDescr(String newDescr) {
    }

    public void setPrice(double newPrice) {
    }
}
