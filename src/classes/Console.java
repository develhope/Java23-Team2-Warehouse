package classes;

import java.util.ArrayList;
import java.util.Scanner;

import static classes.Warehouse.fillUpWarehouse;

public class Console {
    public static void main(String[] args) {
        var warehouse = new Warehouse();
        ArrayList<Cart> carts = new ArrayList<>();
        fillUpWarehouse(warehouse);
        Scanner scanner = new Scanner(System.in);
        scnWelcome(scanner, warehouse);
    }

    public static void scnWelcome(Scanner scanner, Warehouse warehouse) {
        String input;
        int intChoice;
        do {
            System.out.println("Che interfaccia vuoi utilizzare?\n" +
                    "0. Cliente 1. Magaziniere Q. Chiudi il programma");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                return;
            }
            intChoice = Integer.parseInt(input);
        } while ((intChoice < 0) || (intChoice > 1));
        switch (intChoice) {
            case 0 -> scnClient(scanner, warehouse);
            case 1 -> scnWarehouseManagerHome(scanner, warehouse);
        }
    }

    public static void scnClient(Scanner scanner, Warehouse warehouse) {
        String input;
        int intChoice;
        do {
            System.out.println("Che operazione vuoi effettuare?\n" +
                    "0. Visualizzare il catalogo 1. Aggiungere un prodotto al carrello Q. Chiudi il programma");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                return;
            }
            intChoice = Integer.parseInt(input);
        } while ((intChoice < 0) || (intChoice > 1));
        switch (intChoice) {
            case 0 -> warehouse.printStock();
            case 1 -> scnWarehouseManagerHome(scanner, warehouse);
        }
    }

    public static products.KindOfProduct scnProductKindChoice(Scanner scanner) {
        int input;
        do {
            System.out.println("Che tipo di prodotto (usa i numeri)?\n" +
                    "1. Notebook, 2. Tablet, 3. Smartphone");
            input = scanner.nextInt();
            if (input < 1 || input > 3) {
                System.out.println("Scelta non valida\n");
            }
        } while (input < 1 || input > 3);
        return switch (input) {
            case 1 -> products.KindOfProduct.NOTEBOOK;
            case 2 -> products.KindOfProduct.TABLET;
            case 3 -> products.KindOfProduct.SMARTPHONE;
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
    }

    //È un metodo che resta in ascolto e ripropone la possibilità di scelte fino a che non è inserita Q
    public static void scnWarehouseManagerHome(Scanner scanner, Warehouse warehouse) {
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
                    warehouse.printStock();
                    break;
                case 2:
                    scnAddProdToWarehouse(warehouse);
                    break;
            }
        } while (!input.equalsIgnoreCase("q"));
    }

    // Permette all'utente di inserire un prodotto a magazzino tramite un interfaccia da Terminale.
    public static void scnAddProdToWarehouse(Warehouse warehouse) {
        Scanner scanner = new Scanner(System.in);
        products.KindOfProduct article = scnProductKindChoice(scanner);
        System.out.println("Produttore:");
        String producer = scanner.nextLine();
        System.out.println("Modello:");
        String model = scanner.nextLine();
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
        warehouse.addProduct(new Product(article, producer, model, description, display, storage, purchasePrice, sellPrice), quantity);
    }


}
