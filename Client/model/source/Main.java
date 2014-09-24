package source;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Purchase purchase = new Purchase();
        Product product = new Product();
        purchase.addProduct(product);
        purchase.addProduct(product);
        purchase.remProduct("");
        
        System.out.println(purchase.getProductLine("").getAmount());
    }
}
