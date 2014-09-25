package source;

public class Register {
 
    private ProductRegistry productRegistry = new ProductRegistry();
    private DiscountRegistry discountRegistry = new DiscountRegistry();
    private Purchase purchase = new Purchase();
    Receipt receipt = new Receipt();

    public void scanProduct(Product product, int amount){
        for(int i = 0; i < amount; i++){
            purchase.addProduct(product);
        }
    }

    public void remProductFromLine(ProductLine line, int amount) {
        for(int i = 0; i < amount; i++){
            purchase.remProduct(line.getProduct().getName());
        }
    }

    public void cancelPurchase(){
        purchase = new Purchase();
        System.out.println("Purchase canceled");
    }
    
    public void finishPurchase(){
        SavePurchase savedPurchase = new SavePurchase();
        
        savedPurchase.savePurchase(purchase);
        createReceipt();
    }

    private void createReceipt(){
        String savedReceipt = receipt.printReceipt(purchase);
        receipt.saveReceipt(savedReceipt);
    }

    public void updateRegistries(){
    }
}
