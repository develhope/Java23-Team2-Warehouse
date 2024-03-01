import java.util.ArrayList;

public class Cart {
    private final ArrayList<Products> products = new ArrayList<>();
    private Double totalPrice;

    public Cart(ArrayList<Products> products) {
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public Double getTotalPrice() {
        return totalPrice * 1.22;
    }

    public void setTotalPrice() {

    }

    @Override
    public String toString() {
        return "In to the cart we have [" +
                "products = " + products +
                ", for a totalPrice=" + totalPrice +
                "]";
    }

    public void emptyCart() {
        products.clear();
    }

    public void removeProduc(int index) {
        products.remove(index);
    }

    public void addProduct(Products product) {
        products.add(product);
    }

}
