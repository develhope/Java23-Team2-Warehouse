package classes;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        var warehouse = new Warehouse();
        fillUpWarehouse(warehouse);
        scnWarehouseManagerHome(warehouse);
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
    public static void scnWarehouseManagerHome(Warehouse warehouse) {
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
                    System.out.println("\nInserisci un numero tra 1 e 4 o 'q' per uscire.");
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

    public static void fillUpWarehouse(Warehouse warehouse) {
        warehouse.addProduct(new Product(products.KindOfProduct.NOTEBOOK, "Apple", "M1", "tr", 2.3, 2, 1000, 1250), 10);
        warehouse.addProduct(new Product(products.KindOfProduct.NOTEBOOK, "Apple", "M2", "tr", 2.3, 2, 1300, 1850), 6);
        warehouse.addProduct(new Product(products.KindOfProduct.NOTEBOOK, "Asus", "M234", "tr", 2.3, 2, 900, 1450), 8);
        warehouse.addProduct(new Product(products.KindOfProduct.SMARTPHONE, "Apple", "XR", "tr", 2.3, 2, 250, 400), 10);
        warehouse.addProduct(new Product(products.KindOfProduct.SMARTPHONE, "Huawei", "Pro2", "tr", 2.3, 2, 100, 200), 6);
        warehouse.addProduct(new Product(products.KindOfProduct.SMARTPHONE, "Asus", "Pen", "tr", 2.3, 2, 150, 300), 8);
        warehouse.addProduct(new Product(products.KindOfProduct.TABLET, "Apple", "Ipad", "tr", 2.3, 2, 1000, 1250), 10);
        warehouse.addProduct(new Product(products.KindOfProduct.TABLET, "Huawei", "Fire", "tr", 2.3, 2, 300, 400), 6);
        warehouse.addProduct(new Product(products.KindOfProduct.TABLET, "Asus", "Pen", "tr", 2.3, 2, 400, 700), 8);
    }
}
