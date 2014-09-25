package source;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Purchase purchase = new Purchase();
        Product product = new Product();
        Receipt receipt = new Receipt();
        String savedReceipt;
        
        purchase.addProduct(product);
        purchase.addProduct(product);
        
        savedReceipt = receipt.printReceipt(purchase);
        receipt.saveReceipt(savedReceipt);
        
        SavePurchase savedPurchase = new SavePurchase();
        
        savedPurchase.savePurchase(purchase);
    }
}
