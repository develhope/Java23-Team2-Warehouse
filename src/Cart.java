import java.util.ArrayList;

public class Cart {
    private final ArrayList<Product> products = new ArrayList<>();
    private Double totalPrice;

    public Cart(ArrayList<Product> products) {
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Double getTotalPrice() {
        return totalPrice * 1.22;
    }

    private void setTotalPrice() {
// Qui si settera il prezzo totale in base alla quantità di prodotti aggiunti al carrello.
    }

    @Override
    public String toString() {
        return "In to the cart we have [" + "products = " + products + ", for a totalPrice=" + totalPrice + "]";
    }

    public void emptyCart() {
        products.clear();
    }

    public void removeFromCart(int index) {
        products.remove(index);
    }

    public void addToCart(Product product) {
        products.add(product);
    }

}
