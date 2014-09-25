package source;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SavePurchase{
    
    FileOutputStream saveFile;
    ObjectOutputStream save;
    
    public SavePurchase(){
        try{
            saveFile = new FileOutputStream("savedPurchase.sav");
            save = new ObjectOutputStream(saveFile);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void savePurchase(Purchase purchase){
        try{
            save.writeObject(purchase);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
