package classes;

import java.util.Map;
import java.util.Scanner;

import static classes.Warehouse.*;

public class Console {
    public static void main(String[] args) {
        var warehouse = new Warehouse();
        fillUpWarehouse(warehouse);
        Scanner scanner = new Scanner(System.in);
        scnWelcome(scanner, warehouse);
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
                    scnAddProdToWarehouse(scanner, warehouse);
                    break;
            }
        } while (!input.equalsIgnoreCase("q"));
    }

    public static void scnResearchSeller(Scanner scanner, Map<Product, Integer> warehouse) throws Exception {
        String input;
        int intChoice;
        do {
            System.out.println("""
                    1.Tipo di Prodotto   \s
                    2.Produttore  \s
                    3.Modello   \s
                    4.ID   \s
                    5.Prezzo d'acquisto  \s
                    6.Prezzo di vendita  \s
                    7.Range di prezzo di acquisto \s
                    8.Range di prezzo di vendita  \s
                    e. Torna alla schermata precedente""");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("e")) {
                return;
            }
            while (!input.matches("[1-8]")) {
                System.out.println("Usa i numeri per effettuare la scelta o 'e' per tornare alla schermata precedente\n");
                input = scanner.nextLine();
            }
            intChoice = Integer.parseInt(input);
        } while (intChoice < 1 || intChoice > 8);
        switch (intChoice) {
            case 1:
                System.out.println("Seleziona il tipo di articolo che desideri cercare:");
                checkIfEmptyMap(researchKindOfProduct(warehouse, scanner.nextLine()));
                askConfirmationEndTaskSeller(warehouse);
                break;

            case 2:
                System.out.println("Seleziona il produttore che desideri cercare:");
                checkIfEmptyMap(researchProducer(warehouse, scanner.nextLine()));
                askConfirmationEndTaskSeller(warehouse);
                break;
            case 3:
                System.out.println("Seleziona il modello che desideri cercare:");
                checkIfEmptyMap(researchModel(warehouse, scanner.nextLine()));
                askConfirmationEndTaskSeller(warehouse);
                break;
            case 4:
                System.out.println("Seleziona l'ID del prodotto che desideri cercare:");
                checkIfEmptyMap(researchID(warehouse, scanner.nextInt()));
                askConfirmationEndTaskSeller(warehouse);
                break;

            case 5:
                System.out.println("Seleziona il prezzo d'acquisto del prodotto che desideri cercare:");
                checkIfEmptyMap(researchPurchasePrice(warehouse, scanner.nextDouble()));
                askConfirmationEndTaskSeller(warehouse);
                break;

            case 6:
                System.out.println("Seleziona il prezzo di vendita del prodotto che desideri cercare:");
                checkIfEmptyMap(researchSellPrice(warehouse, scanner.nextDouble()));
                askConfirmationEndTaskSeller(warehouse);
                break;

            case 7:
                System.out.println("Seleziona il range di prezzo di acquisto dei prodotti che desideri cercare: \nDigita il prezzo minimo che desideri cercare: ");
                double minPurchasePrice = scanner.nextDouble();
                System.out.println("Digita il prezzo massimo che desideri cercare: ");
                double maxPurchasePrice = scanner.nextDouble();
                checkIfEmptyMap(researchPurchasePriceInRange(warehouse, minPurchasePrice, maxPurchasePrice));
                askConfirmationEndTaskSeller(warehouse);
                break;

            case 8:
                System.out.println("Seleziona il range di prezzo di vendita dei prodotti che desideri cercare: \nDigita il prezzo minimo che desideri cercare: ");
                double minSellPrice = scanner.nextDouble();
                System.out.println("Digita il prezzo massimo che desideri cercare: ");
                double maxSellPrice = scanner.nextDouble();
                checkIfEmptyMap(researchSellPriceInRange(warehouse, minSellPrice, maxSellPrice));
                askConfirmationEndTaskSeller(warehouse);
                break;
        }
    }

    public static void scnResearchClient(Scanner scanner, Map<Product, Integer> warehouse) throws Exception {
        String input;
        int intChoice;
        do {
            System.out.println("""
                    1.Tipo di Prodotto   \s
                    2.Produttore  \s
                    3.Modello   \s
                    4.ID   \s
                    5.Prezzo di vendita  \s
                    6.Range di prezzo di vendita  \s
                    e. Torna alla schermata precedente""");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("e")) {
                return;
            }
            while (!input.matches("[1-6]")) {
                System.out.println("Usa i numeri per effettuare la scelta o 'e' per tornare alla schermata precedente\n");
                input = scanner.nextLine();
            }
            intChoice = Integer.parseInt(input);
        } while (intChoice < 1 || intChoice > 6);
        switch (intChoice) {
            case 1:
                System.out.println("Seleziona il tipo di articolo che desideri cercare:");
                checkIfEmptyMap(researchKindOfProduct(warehouse, scanner.nextLine()));
                askConfirmationEndTaskClient(warehouse);
                break;

            case 2:
                System.out.println("Seleziona il produttore che desideri cercare:");
                checkIfEmptyMap(researchProducer(warehouse, scanner.nextLine()));
                askConfirmationEndTaskClient(warehouse);
                break;
            case 3:
                System.out.println("Seleziona il modello che desideri cercare:");
                checkIfEmptyMap(researchModel(warehouse, scanner.nextLine()));
                askConfirmationEndTaskClient(warehouse);
                break;
            case 4:
                System.out.println("Seleziona l'ID del prodotto che desideri cercare:");
                checkIfEmptyMap(researchID(warehouse, scanner.nextInt()));
                askConfirmationEndTaskClient(warehouse);
                break;

            case 5:
                System.out.println("Seleziona il prezzo del prodotto che desideri cercare:");
                checkIfEmptyMap(researchSellPrice(warehouse, scanner.nextDouble()));
                askConfirmationEndTaskClient(warehouse);
                break;

            case 6:
                System.out.println("Seleziona il range di prezzo dei prodotti che desideri cercare: \nDigita il prezzo minimo che desideri cercare: ");
                double minSellPrice = scanner.nextDouble();
                System.out.println("Digita il prezzo massimo che desideri cercare: ");
                double maxSellPrice = scanner.nextDouble();
                checkIfEmptyMap(researchSellPriceInRange(warehouse, minSellPrice, maxSellPrice));
                askConfirmationEndTaskClient(warehouse);
                break;

        }
    }

    // Permette all'utente di inserire un prodotto a magazzino tramite un interfaccia da Terminale.
    public static void scnAddProdToWarehouse(Scanner scanner, Warehouse warehouse) {
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


    public static void askConfirmationEndTaskSeller(Map<Product, Integer> warehouse) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input;
        int choice;
        do {
            System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
            input = scanner.nextLine();
            while (!input.matches("[0-1]")) {
                System.out.println("L'input inserito non corrisponde a una delle scelte offerte.");
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                input = scanner.nextLine();
            }
            choice = Integer.parseInt(input);
        } while (choice < 0 || choice > 1);
        switch (choice) {
            case 0:
                scnResearchSeller(scanner, warehouse);
                break;
            case 1:
                break;
        }
    }

    public static void askConfirmationEndTaskClient(Map<Product, Integer> warehouse) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input;
        int choice;
        do {
            System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
            input = scanner.nextLine();
            while (!input.matches("[0-1]")) {
                System.out.println("L'input inserito non corrisponde a una delle scelte offerte.");
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                input = scanner.nextLine();
            }
            choice = Integer.parseInt(input);
        } while (choice < 0 || choice > 1);
        switch (choice) {
            case 0:
                scnResearchClient(scanner, warehouse);
                break;
            case 1:
                break;
        }
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
}
