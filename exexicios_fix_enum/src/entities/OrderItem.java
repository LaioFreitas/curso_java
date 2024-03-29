package entities;

public class OrderItem {
    
    private Integer quantity;
    private Double price;
    private Product product;

    public OrderItem() {

    }

    public OrderItem(Integer quantity, Double price, Product product) {

        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public Double subTotal() {
        return price * quantity;
    }

    @Override 
    public String toString() {
        return String.format("%s, %.2f, quantity: %d, subtotal: %.2f\n", product.getName(), product.getPrice(), quantity, subTotal()); 
    }

}
