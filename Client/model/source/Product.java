package source;

import java.io.Serializable;

public class Product implements Serializable{
    private Integer EAN;
    private String descr;
    private double price;

    public Product(Integer EAN, String descr, double price) {
        this.EAN = EAN;
        this.descr = descr;
        this.price = price;
    }
    
    public Product() {
    }

    //Author: Gustav Ernstsson
    public Integer getEAN() {
        return EAN;
    }

    //Author: Gustav Ernstsson
    public String getDescr() {
        return descr;
    }

    //Author: Gustav Ernstsson
    public double getPrice() {
        return price;
    }

    //Author: Gustav Ernstsson
    public void setEAN(Integer newEAN) {
        EAN = newEAN;
    }

    //Author: Gustav Ernstsson
    public void setDescr(String newDescr) {
        descr = newDescr;
    }

    //Author: Gustav Ernstsson
    public void setPrice(double newPrice) {
        price = newPrice;
    }
}
