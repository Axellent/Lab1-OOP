package source;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.PrintWriter;

import java.util.Scanner;

//Author: Axel Sigl
public class SavePurchase{
    
    FileOutputStream outSaveFile;
    FileInputStream inSaveFile;
    ObjectOutputStream save;
    ObjectInputStream restore;
    
    //Author: Axel Sigl
    public SavePurchase(){
        try{
            outSaveFile = new FileOutputStream("savedPurchase.sav");
            inSaveFile = new FileInputStream("savedPurchase.sav");
            save = new ObjectOutputStream(outSaveFile);
            restore = new ObjectInputStream(inSaveFile);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Author: Axel Sigl
    public Purchase[] getPurchases(){
        try{
            return (Purchase[]) restore.readObject();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    //Author: Axel Sigl
    public void savePurchase(Purchase[] purchase){
        try{
            save.writeObject(purchase);    
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Author: Axel Sigl
    public int saveNPurchases(int nPurchases){
        try{
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("AntalKop.txt", true)));
            
            out.println(nPurchases);
            out.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    //Author: Axel Sigl
    public int loadNPurchases(){
        try{
            Scanner in = new Scanner(new BufferedReader(new FileReader("AntalKop.txt")));
            
            int nPurchases = in.nextInt();
            in.close();
            return nPurchases;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;        
    }
}