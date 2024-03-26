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

    private void updateTotalPrice() throws Exception {
        double total = 0;
        for (Map.Entry<Product, Integer> a : products.entrySet()) {
            if (a.getKey().getSellPrice() <= 0) {
                throw new Exception("Negative price value");
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

    public void removeFromCart(Product product, int quantity) throws Exception {
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

    public void addToCart(Product product, int quantity) throws Exception {
        products.put(product, quantity);
        updateTotalPrice();
    }


    public void updateCartQuantity(Product product, int quantity, Warehouse warehouse) throws Exception {
        int availableQuantity = warehouse.checkStock(product);
        if (availableQuantity >= quantity) {
            if (products.containsKey(product)) {
                products.put(product, quantity);
            } else {
                System.out.println("Il prodotto non è presente nel carrello. Impossibile aggiornare la quantità.");
                return;
            }
            updateTotalPrice();
            System.out.println("Prodotto aggiunto al carrello");
        } else {
            System.out.println("Prodotto non disponibile in quantità sufficiente nel magazzino");
        }
    }

    public Cart addToCartById(int productId, int quantity, Warehouse warehouse) throws Exception {
        Product productToAdd = null;
        for (Map.Entry<Product, Integer> entry : warehouse.getStock().entrySet()) {
            if (entry.getKey().getId() == productId) {
                productToAdd = entry.getKey();
                break;
            }
        }

        if (productToAdd == null) {
            System.out.println("Prodotto con ID " + productId + " non trovato nel magazzino.");
            return this;
        }

        // Verifica se la quantità richiesta è disponibile nel magazzino
        int availableQuantity = warehouse.checkStock(productToAdd);
        if (availableQuantity < quantity) {
            System.out.println("Quantità richiesta non disponibile nel magazzino.");
            return this;
        }

        // Aggiunge il prodotto al carrello
        if (products.containsKey(productToAdd)) {
            int updatedQuantity = products.get(productToAdd) + quantity;
            products.put(productToAdd, updatedQuantity);
        } else {
            products.put(productToAdd, quantity);
        }

        warehouse.removeProduct(productToAdd, quantity);
        updateTotalPrice();
        return this;
    }

    public void removeItemFromCartById(int id, Warehouse warehouse) throws Exception {
        // Verifica se il prodotto è presente nel carrello
        Product productToRemove = null;
        for (Product product : products.keySet()) {
            if (product.getId() == id) {
                productToRemove = product;
                break;
            }
        }

        // Verifica se è stato trovato un prodotto da rimuovere
        if (productToRemove != null) {
            int quantityToRemove = products.get(productToRemove);
            products.remove(productToRemove);
            warehouse.addProduct(productToRemove, quantityToRemove);
            updateTotalPrice();
            System.out.println("Prodotto rimosso dal carrello e ripristinato nel magazzino");
        } else {
            System.out.println("Prodotto non trovato nel carrello");
        }
    }

}
