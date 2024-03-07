package classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    public void scnProdConstructor() {
        products.KindOfProduct article = products.KindOfProduct.SMARTPHONE;
        String producer, model, id, description;
        double display, storage, purchasePrice, sellPrice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Che tipo di prodotto vuoi aggiungere?\n" +
                "1. Notebook, 2. Tablet, 3. Smartphone");
        int intChoice = scanner.nextInt();
        switch (intChoice) {
            case 1:
                article = products.KindOfProduct.NOTEBOOK;
                break;
            case 2:
                article = products.KindOfProduct.TABLET;
                break;
            case 3:
                article = products.KindOfProduct.SMARTPHONE;
                break;
            default:
                System.out.println("Scelta errata, reinizializzare la creazione.");
        }
        System.out.println("Produttore:");
        producer = scanner.nextLine();
        System.out.println("Modello:");
        model = scanner.nextLine();
        System.out.println("Id:");
        id = scanner.nextLine();
        System.out.println("Descrizione:");
        description = scanner.nextLine();
        System.out.println("Dimensione display (in numeri):");
        display = scanner.nextDouble();
        System.out.println("Taglia di memoria (in numeri):");
        storage = scanner.nextDouble();
        System.out.println("Prezzo di acquisto (in numeri):");
        purchasePrice = scanner.nextDouble();
        System.out.println("Prezzo di vendita (in numeri):");
        sellPrice = scanner.nextDouble();
        System.out.println("Quantità da aggiungere in magazzino (in numeri):");
        int quantity = scanner.nextInt();
        Product scnProd = new Product(article, producer, model, description, id, display, storage, purchasePrice, sellPrice);
        stock.put(scnProd, quantity);
    }
}

