package classes;

import java.util.Map;
import java.util.HashMap;

public class Cart {
    private final Map<Product, Integer> products = new HashMap<>();
    private double totalPrice;


    public Cart() {
        totalPrice = 0;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    private void updateTotalPrice() {
        double total = 0;
        for (Map.Entry<Product, Integer> a : products.entrySet()) {
            if (a.getKey().getSellPrice() <= 0) {
                return;
            }
            total += a.getKey().getSellPrice() * a.getValue();
            totalPrice = total;
        }
    }

    @Override
    public String toString() {
        return "In to the cart we have: [" + "products = " + products + ", for a totalPrice=" + totalPrice + "]";
    }

    public void printProductsInCart() {
        if (products.isEmpty()) {
            System.out.println("Il carrello è vuoto");
            return;
        }
        System.out.println("Nel carrello abbiamo: ");
        for (Map.Entry<Product, Integer> a : products.entrySet()) {
            System.out.println("   - n\u00B0" + a.getValue() + " " + a.getKey());
        }
        System.out.println("Per un totale di spesa di: " + totalPrice);
    }

    public void emptyCart() {
        products.clear();
    }

    public void removeFromCart(Product product, int quantity) {
        if (products.isEmpty()) {
            System.out.println("Il carrello è vuoto");
            return;
        }
        if (products.get(product) == null) {
            System.out.println("Prodotto non presente nel carrello");
            return;
        }

        if (products.get(product) <= quantity) {
            products.remove(product);
            System.out.println("Prodotto rimosso dal carrello");
        } else if (products.get(product) > quantity) {
            Integer temp = products.get(product) - quantity;
            products.put(product, temp);
            System.out.println("Quantità nel carrello aggiornata");
        }
        updateTotalPrice();
    }

    public void addToCart(Product product, int quantity) {
        products.put(product, quantity);
        updateTotalPrice();
    }

    public void addToCart(Product product, int quantity, Warehouse warehouse) {
        int availableQuantity = warehouse.checkStock(product);
        // Controlla se la quantità richiesta è disponibile nel magazzino
        if (availableQuantity >= quantity) {
            products.put(product, quantity);
            updateTotalPrice();
            System.out.println("Prodotto aggiunto al carrello");
        } else {
            System.out.println("Prodotto non disponibile in quantità sufficiente nel magazzino");
        }
    }

}
