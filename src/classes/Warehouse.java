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

    // Permette all'utente di inserire un prodotto a magazzino tramite un interfaccia da Terminale.
    public void scnAddProdToWarehouse() {
        Scanner scanner = new Scanner(System.in);
        String input;
        int intChoice;
        do {
            System.out.println("Che tipo di prodotto vuoi aggiungere (usa i numeri)?\n" +
                    "1. Notebook, 2. Tablet, 3. Smartphone, w. Torna alla scehrmata precedente");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("w")) {
                return;
            }
            while (!input.matches("[1-3]")) {
                System.out.println("Usa i numeri per effettuare la scelta o 'w' per tornare alla schermata precedente\n");
                input = scanner.nextLine();
            }
            intChoice = Integer.parseInt(input);
        } while (intChoice < 1 || intChoice > 3);
        products.KindOfProduct article;
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
                return;
        }
        System.out.println("Produttore:");
        String producer = scanner.nextLine();
        System.out.println("Modello:");
        String model = scanner.nextLine();
        System.out.println("Id:");
        String id = scanner.nextLine();
        System.out.println("Descrizione:");
        String description = scanner.nextLine();
        System.out.println("Dimensione display (in numeri):");
        double display = Double.parseDouble(scanner.nextLine());
        System.out.println("Taglia di memoria (in numeri):");
        double storage = Double.parseDouble(scanner.nextLine());
        System.out.println("Prezzo di acquisto (in numeri):");
        double purchasePrice = Double.parseDouble(scanner.nextLine());
        System.out.println("Prezzo di vendita (in numeri):");
        double sellPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("Quantità da aggiungere in magazzino (in numeri):");
        int quantity = Integer.parseInt(scanner.nextLine());
        addProduct(new Product(article, producer, model, description, id, display, storage, purchasePrice, sellPrice), quantity);
    }

    //È un metodo che resta in ascolto e ripropone la possibilità di scelte fino a che non è inserita Q
    public void scnHome() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            int intChoice;
            do {
                System.out.println("\nChe operazione desideri effettuare:\n" +
                        "1. Stampare i prodotti a magazzino\n" +
                        "2. Aggiungere un prodotto al magazzino\n" +
                        // Qui si possono aggiungere le varie scelte mano a mano che vengono sviluppate
                        "q. Esci dal programma");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("q")) {
                    return;
                }
                //Il registro del while va aggiornato facendo si che includa i numeri delle nuove scelte
                while (!input.matches("[1-2]")) {
                    System.out.println("\nInserisci un numero tra 1 e 2 o 'q' per uscire.");
                    input = scanner.nextLine();
                }
                intChoice = Integer.parseInt(input);
                //Anche qui sotto
            } while (intChoice < 1 || intChoice > 2);
            // Allo Switch va aggiunta la gestione dell'aggiunta.
            switch (intChoice) {
                case 1:
                    printStock();
                    break;
                case 2:
                    scnAddProdToWarehouse();
                    break;
            }
        } while (!input.equalsIgnoreCase("q"));
    }
}

