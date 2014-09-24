package source;

public class Purchase{

    private double totalPrice = 0;
    private int nProductLines = 0;
    
    private ProductLine[] productLines = new ProductLine[100];

    private void addProduct(Product product, int i){
        if(productLines[i] == null){
            productLines[i] = new ProductLine(product, 1);
            nProductLines++;
        }
        else if(productLines[i].getProduct().equals(product)){
            productLines[i].setAmount(productLines[i].getAmount() + 1);
            productLines[i].setPriceSum(productLines[i].getPriceSum() + product.getPrice());
        }
        else{
            addProduct(product, i + 1);
        }
    }
    
    public void addProduct(Product product){
        addProduct(product, 0);
    }
    
    public void remProduct(String productName){
        boolean delete = false;
        
        for(int i = 0; i < nProductLines; i++){
            if(delete){
                productLines[i] = productLines[i+1];
            }
            
            else if(productName == productLines[i].getProduct().getName()){
                productLines[i].setAmount(productLines[i].getAmount() - 1);
                productLines[i].setPriceSum(productLines[i].getPriceSum() - productLines[i].getProduct().getPrice());
                
                if(productLines[i].getAmount() <= 0){
                    productLines[i] = null;
                    nProductLines--;
                    delete = true;
                }
            }
        }
    }

    public void finishPurchase(){
    }
    
    public ProductLine getProductLine(String productName){
        for(int i = 0; i < nProductLines; i++){
            if(productName == productLines[i].getProduct().getName()){
                return productLines[i];
            }
        }
        return null;
    }
}
