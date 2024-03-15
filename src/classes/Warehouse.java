package classes;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<Product, Integer> stock;

    public Warehouse() {
        this.stock = new HashMap<>();
    }

    //Aggiunge una determinata quantità di un prodotto specificato al magazzino.
    public void addProduct(Product product, int quantity) {
        if (stock.containsKey(product)) {
            int currentQuantity = stock.get(product);
            stock.put(product, currentQuantity + quantity);
        } else {
            stock.put(product, quantity);
        }
    }

    //Rimuove una determinata quantità di un prodotto specificato dal magazzino.
    public void removeProduct(Product product, int quantity) {
        if (stock.containsKey(product)) {
            int currentQuantity = stock.get(product);
            if (currentQuantity <= quantity) {
                stock.remove(product);
            } else {
                stock.put(product, currentQuantity - quantity);
            }
        } else {
            System.out.println("Prodotto: " + product + " non trovato in magazzino.");
        }
    }

    //restituisce la quantità disponibile di un prodotto specificato nel magazzino.

    public int checkStock(Product product) {
        return stock.getOrDefault(product, 0);
    }

    //Stampa magazzino
    public void printStock() {
        System.out.println("Inventario del magazzino:");
        for (Map.Entry<Product, Integer> entry : stock.entrySet()) {
            System.out.println("Prodotto: " + entry.getKey() + ", Quantità: " + entry.getValue());
        }
    }

}

