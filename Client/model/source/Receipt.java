package source;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Receipt{
    
    public void saveReceipt(String receipt){
        try{
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("savedReceipt.txt", true)));
            out.println(receipt);
            out.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String printReceipt(Purchase purchase){
        ProductLine[] productLines = purchase.getAllProductLines();
        
        String receipt = "Receipt\n----------------------\nAntal | Pris | Product\n";
    
        for(int i = 0; i < purchase.getNProductLines(); i++){
            receipt += productLines[i].getAmount() + "      " +
                       productLines[i].getPriceSum() + "   " +
                       productLines[i].getProduct().getName() + "\n";
        }
        
        System.out.println(receipt);
        return receipt;
    }
}
