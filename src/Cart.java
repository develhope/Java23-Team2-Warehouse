import classes.Product;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Cart {
    private final Set<Product> products = new HashSet<Product>();
    private Double totalPrice;

    public Cart() {
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    private void setTotalPrice() {
// Qui si settera il prezzo totale in base alla quantità di prodotti aggiunti al carrello.
    }

    @Override
    public String toString() {
        return "In to the cart we have: [" + "products = " + products + ", for a totalPrice=" + totalPrice + "]";
    }

    public void printProductsInCart() {
        if (products.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }
        System.out.println("In to the cart we have: ");
        int i = 0;
        for (Product a : products) {
            System.out.println(i + ") " + a + "/n");
            i++;
        }
    }

    public void emptyCart() {
        products.clear();
    }

    public void removeFromCart(Product product) {
        products.remove(product);
    }

    public void addToCart(Product product) {
        products.add(product);
    }

}
