package classes;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<String, Integer> stock;

    public Warehouse() {
        this.stock = new HashMap<>();
    }

    //Aggiunge una determinata quantità di un prodotto specificato al magazzino.
    public void addProduct(String productId, int quantity) {
        if (stock.containsKey(productId)) {
            int currentQuantity = stock.get(productId);
            stock.put(productId, currentQuantity + quantity);
        } else {
            stock.put(productId, quantity);
        }
    }

    //Rimuove una determinata quantità di un prodotto specificato dal magazzino.
    public void removeProduct(String productId, int quantity) {
        if (stock.containsKey(productId)) {
            int currentQuantity = stock.get(productId);
            if (currentQuantity <= quantity) {
                stock.remove(productId);
            } else {
                stock.put(productId, currentQuantity - quantity);
            }
        } else {
            System.out.println("Prodotto con ID " + productId + " non trovato in magazzino.");
        }
    }

    //restituisce la quantità disponibile di un prodotto specificato nel magazzino.

    public int checkStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }

    //Stampa magazzino
    public void printStock() {
        System.out.println("Inventario del magazzino:");
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println("ID prodotto: " + entry.getKey() + ", Quantità: " + entry.getValue());
        }
    }
}

