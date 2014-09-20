package source;

public class Discount {
    /**
     * @attribute
     */
    private String discountCode;

    /**
     * @attribute
     */
    private double amount;

    /**
     * @attribute
     */
    private String descr;

    /**
     * @attribute
     */
    private String expirationDate;

    public double getDiscount(String code, ProductLine productLine) {
        return 0;
    }

    public void setDiscount(String newCode, ProductLine newProductLine) {
    }

    public void setdescr(String newDescr) {
    }

    public String getDescr() {
        return "";
    }

    public String getExpirationDate() {
        return "";
    }

    public void setExpirationDate(String newExpirationDate) {
    }

    public String getDiscountCode() {
        return "";
    }

    public void setDiscountCode(String newDiscountCode) {
    }

    public double getAmount() {
        return 0;
    }

    public void setAmount(double newAmount) {
    }
}
