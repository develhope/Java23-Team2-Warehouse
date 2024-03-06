package classes;

import classes.Product;

import java.util.HashSet;
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

    private void updateTotalPrice() {
        double total = 0;
        for (Product a : products) {
            if (a.getSellPrice() <= 0) {
                System.out.println("Price cannot be negative, check the articles values");
                return;
            }
            total += a.getSellPrice();
        }
    }

    @Override
    public String toString() {
        return "In to the cart we have: [" + "products = " + products + ", for a totalPrice=" + totalPrice + "]";
    }

    public void printProductsInCart() {
        if (products.isEmpty()) {
            System.out.println("classes.Cart is empty");
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
        updateTotalPrice();
    }

    public void addToCart(Product product) {
        products.add(product);
        updateTotalPrice();
    }

}
