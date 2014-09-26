package source;

import java.io.BufferedReader;

import java.io.FileReader;

import java.util.Scanner;

//Author: Axel Sigl
public class Register {
 
    private ProductRegistry productRegistry = new ProductRegistry();
    private DiscountRegistry discountRegistry = new DiscountRegistry();
    private Purchase purchase = new Purchase();
    private Purchase[] allPurchases = new Purchase[100];
    private SavePurchase savedPurchase = new SavePurchase();
    Receipt receipt = new Receipt();
    
    private int nPurchases;
    
    //Author: Axel Sigl
    public void loadProductRegistry(){
        try{
            Scanner reader1 = new Scanner(new BufferedReader(new FileReader("Produkter.txt"))).useDelimiter("\t"); 
            
            reader1.nextLine();
            
            while(reader1.hasNextLine()){
                productRegistry.addProduct(productRegistry.readFromProductFile(reader1));
            }
            reader1.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Author: Axel Sigl
    public void loadPurchases(){
        allPurchases = savedPurchase.getPurchases();
    }
    
    //Author: Axel Sigl
    public void resetPurchases(){
        allPurchases = new Purchase[100];
        savedPurchase.savePurchase(allPurchases);
        nPurchases = 0;
    }

    //Author: Axel Sigl
    public void scanProduct(Product product, int amount){
        for(int i = 0; i < amount; i++){
            purchase.addProduct(product);
        }
    }

    //Author: Axel Sigl
    public void remProductFromLine(ProductLine line, int amount){
        for(int i = 0; i < amount; i++){
            purchase.remProduct(line.getProduct().getDescr());
        }
    }

    //Author: Axel Sigl
    public void cancelPurchase(){
        purchase = new Purchase();
        System.out.println("Purchase canceled");
    }
    
    //Author: Axel Sigl
    public void finishPurchase(){
        
        discountRegistry.calcDiscount(purchase);
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter discount code(enter 0 to quit): ");
            String input = scanner.next();
            if(input.equalsIgnoreCase("0")) break;
            discountRegistry.calcDiscount(purchase, input);
        }
        
        allPurchases[nPurchases] = purchase;
        nPurchases++;
        
        savedPurchase.savePurchase(allPurchases);
        createReceipt();
        
        purchase = new Purchase();
    }

    //Author: Axel Sigl
    private void createReceipt(){
        String savedReceipt = receipt.printReceipt(purchase);
        receipt.saveReceipt(savedReceipt);
    }
    
    //Author: Axel Sigl
    public void setTotalPurchases(int newTotalPurchases){
        nPurchases = newTotalPurchases;
    }
    
    //Author: Axel Sigl
    public ProductRegistry getProductRegistry(){
        return productRegistry;
    }
    
    //Author: Axel Sigl
    public DiscountRegistry getDiscountRegistry(){
        return discountRegistry;
    }
    
    //Author: Axel Sigl
    public int getTotalPurchases(){
        return nPurchases;
    }
    
    //Author: Axel Sigl
    public Purchase getPurchase(){
        return purchase;
    }
    
    //Author: Axel Sigl
    public Purchase[] getPurchases(){
        return allPurchases;
    }
    
    //Author: Axel Sigl
    public SavePurchase getSavedPurchase(){
        return savedPurchase;
    }
}
