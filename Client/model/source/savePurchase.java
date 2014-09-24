package source;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SavePurchase{
    
    FileOutputStream saveFile;
    ObjectOutputStream save;
    private String saveDate;
    private Purchase purchase;
    
    public SavePurchase(){
        try{
            saveFile = new FileOutputStream("saveFile.sav");
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
