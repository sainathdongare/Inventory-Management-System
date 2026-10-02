package in.sd.model;

import java.util.Objects;
import in.sd.exception.InsufficientStockException;

public class Product {
    private final String id ;
    private String name;
    private String productType;
    private double price;
    private int quantity;

     public Product(String id,String name, String productType, double price, int quantity ) {

         if(id == null || id.isBlank()){
          throw new IllegalArgumentException("ID cannot be Null or Empty");
         }
         if(name == null || name.isBlank()) {
             throw new IllegalArgumentException("Name cannot be null or empty");
         }
         if(productType == null || productType.isBlank()) {
             throw new IllegalArgumentException("Product Type cannot be Empty or Null");
         }
         if(price < 0) {
             throw new IllegalArgumentException("Price must be greater than zero");
         }
         if(quantity < 0) {
             throw new IllegalArgumentException("Products must be greater than zero");
         }

         this.id = id;
         this.name = name;
         this.productType = productType;
         this.price = price;
         this.quantity = quantity;
     }

     public void reduceStock(int amount) throws InsufficientStockException {
         if(amount <= 0) {
             throw new IllegalArgumentException("Products must be greater that zero");
         }
         if(amount > quantity) {
            throw new InsufficientStockException("Not enough Stock");
         }
         quantity -= amount;
     }

     public void addStock(int amount) {
         if(amount <= 0) {
             throw new IllegalArgumentException("Products are more than one");
         }
         quantity += amount;
     }

     //Setters
    public void setPrice(double price) {
         if(price < 0) throw new IllegalArgumentException("Set Valid Price");
         this.price = price;
    }

    //Getters
    public String getId() {
         return this.id;
    }

    public String getName() {
         return this.name;
    }

    public String getProductType() {
         return this.productType;
    }

    public double getPrice() {
         return this.price;
    }

    public int getQuantity() {
         return this.quantity;
    }

    //Overridden methods
     @Override
     public boolean equals(Object obj) {
         if(this == obj) return true;
         if(obj == null || getClass() != obj.getClass()) return false;

         Product other = (Product) obj;

         return id.equals(other.id);
     }

     @Override
     public int hashCode() {
         return Objects.hash(id);
     }

     //toString method
     @Override
     public String toString() {
         return "Product{id='" + id + "', name='" + name + "', type='" + productType +
                 "', price=" + price + ", quantity=" + quantity + "}";
     }

}
