package source;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

//Author: Axel Sigl
public class Receipt{
    
    //Author: Axel Sigl
    public void saveReceipt(String receipt){
        try{
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("savedReceipt.txt", true)));
            out.println(receipt);
            out.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Author: Axel Sigl
    public String printReceipt(Purchase purchase){
        ProductLine[] productLines = purchase.getAllProductLines();
        
        String receipt = "Kvitto\n----------------------\nAntal | Pris | Product\n";
    
        for(int i = 0; i < purchase.getNProductLines(); i++){
            receipt += productLines[i].getAmount() + "      " +
                       productLines[i].getPriceSum() + "   " +
                       productLines[i].getProduct().getDescr() + "\n";
        }
        
        receipt += "Summa att betala:" + purchase.getTotalPrice() + "kr\n";
        
        System.out.println(receipt);
        return receipt;
    }
}
