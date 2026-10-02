package in.sd.model;

public class OrderItem {

    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        if(product == null) {
         throw new IllegalArgumentException("Product should not be empty");
        }
        if(quantity <= 0) {
            throw new IllegalArgumentException("Items should not be less than zero");
        }
        this.product =  product;
        this.quantity = quantity;
    }

    //Getters
    public double getSubTotal() {
        return product.getPrice()*quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "OrderItem{Product='"+product+"', Quantity='"+quantity+"'}";
    }

}
