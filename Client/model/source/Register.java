package source;

public class Register {
    /**
     * @attribute
     */
    private ProductRegistry productRegistry;

    /**
     * @attribute
     */
    private DiscountRegistry discountRegistry;
    
    private Purchase purchase;

    public void scanProduct(Product product){
        purchase.addProduct(product);
    }

    public void remProductFromLine(ProductLine line, int amount) {
        for(int i = 0; i < amount; i++){
            purchase.remProduct(line.getProduct().getName());
        }
    }

    public void finishPurchase() {
    }

    public void cancelPurchase() {
    }

    private void createReciept() {
    }

    public void updateRegistries() {
    }
}
