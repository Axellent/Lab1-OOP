package source;

import java.io.Serializable;

//Author: Axel Sigl
public class Purchase implements Serializable{

    private double totalPrice = 0;
    private int nProductLines = 0;
    
    private ProductLine[] productLines = new ProductLine[100];
    
    //Author: Axel Sigl
    private void addProduct(Product product, int i){
        if(productLines[i] == null){
            productLines[i] = new ProductLine(product, 1);
            totalPrice += productLines[i].getProduct().getPrice();
            nProductLines++;
        }
        else if(productLines[i].getProduct().equals(product)){
            productLines[i].setAmount(productLines[i].getAmount() + 1);
            productLines[i].setPriceSum(productLines[i].getPriceSum() + product.getPrice());
            totalPrice += productLines[i].getProduct().getPrice();
        }
        else{
            addProduct(product, i + 1);
        }
    }
    
    //Author: Axel Sigl
    public void addProduct(Product product){
        addProduct(product, 0);
    }
    
    //Author: Axel Sigl
    public void remProduct(String productName){
        boolean delete = false;
        
        for(int i = 0; i < nProductLines; i++){
            if(delete){
                productLines[i] = productLines[i+1];
            }
            
            else if(productName == productLines[i].getProduct().getDescr()){
                
                productLines[i].setAmount(productLines[i].getAmount() - 1);
                productLines[i].setPriceSum(productLines[i].getPriceSum() - productLines[i].getProduct().getPrice());
                totalPrice -= productLines[i].getProduct().getPrice();
                
                if(productLines[i].getAmount() <= 0){
                    productLines[i] = null;
                    nProductLines--;
                    delete = true;
                }
            }
        }
    }
    
    //Author: Axel Sigl
    public void setTotalPrice(double newTotalPrice){
        totalPrice = newTotalPrice;
    }
    
    //Author: Axel Sigl
    public double getTotalPrice(){
        return totalPrice;
    }
    
    //Author: Axel Sigl
    public ProductLine getProductLine(String productName){
        for(int i = 0; i < nProductLines; i++){
            if(productName == productLines[i].getProduct().getDescr()){
                return productLines[i];
            }
        }
        return null;
    }
    
    //Author: Axel Sigl
    public ProductLine[] getAllProductLines(){
        return productLines;
    }
    
    //Author: Axel Sigl
    public int getNProductLines(){
        return nProductLines;
    }
}
