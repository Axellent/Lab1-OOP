package source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//Author: Gustav Ernstsson
public class ProductRegistry {
    private Integer totalProducts = 0;
    private static List<Product> registry = new ArrayList<Product>();

    //Author: Axel Sigl
    public Product readFromProductFile(Scanner reader){
        reader.useLocale(Locale.US);
        
        int ean = reader.nextInt();
        String descr = reader.next();
        double price = reader.nextDouble();
        
        reader.next();
        
        return new Product(ean, descr, price);
    }

    //Author: Gustav Ernstsson
    public Product getProductFromReg(Integer EAN) {
        Product product = new Product();
        for(Product p : registry){
            if(p.getEAN().equals(EAN)){
                return p;
            }
            else{
                product = null;
            }
        }
        return product;
    }

    //Author: Gustav Ernstsson
    public void delProductFromReg(Product product) {
            for(Product p : registry){
                if(p.equals(product)){
                    registry.remove(product);
                }
            }
    }
    
    //Author Gustav Ernstsson
    public void addProduct(Product product){
        registry.add(product);
        totalProducts++;
    }
}
