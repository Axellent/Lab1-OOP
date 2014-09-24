package source;

public class Register {
 
    private ProductRegistry productRegistry = new ProductRegistry();
    private DiscountRegistry discountRegistry = new DiscountRegistry();
    private Purchase purchase = new Purchase();

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

    private void createReciept(){
    }

    public void updateRegistries(){
    }
}
