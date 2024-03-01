import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Cart {
    private final Set<Product> products = new HashSet<Product>();
    private Double totalPrice;

    public Cart(ArrayList<Product> products) {
    }

    public Set<Product> getProducts() {
        return products;giit
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
