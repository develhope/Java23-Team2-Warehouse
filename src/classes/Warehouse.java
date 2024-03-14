package classes;

import java.util.*;

public class Warehouse {
    private Map<Product, Integer> stock;
    private Map<String, Cart> carts;

    public Warehouse() {
        this.stock = new HashMap<>();
        this.carts = new HashMap<>();
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
        addProduct(new Product(article, producer, model, description, display, storage, purchasePrice, sellPrice), quantity);
    }

    //È un metodo che resta in ascolto e ripropone la possibilità di scelte fino a che non è inserita Q
    public void scnHome() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            int intChoice;
            do {
                System.out.println("\nChe operazione desideri effettuare:\n" +
                        "1. Stampare i prodotti a magazzino\n" +
                        "2. Aggiungere un prodotto al magazzino\n" +
                        "3. Creare un carrello\n" +
                        "4. Eliminare un Carrello\n" +
                        "5. Ricerca prodotto\n" +
                        // Qui si possono aggiungere le varie scelte mano a mano che vengono sviluppate
                        "q. Esci dal programma");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("q")) {
                    return;
                }
                //Il registro del while va aggiornato facendo si che includa i numeri delle nuove scelte
                while (!input.matches("[1-5]")) {
                    System.out.println("\nInserisci un numero tra 1 e 5 o 'q' per uscire.");
                    input = scanner.nextLine();
                }
                intChoice = Integer.parseInt(input);
                //Anche qui sotto
            } while (intChoice < 1 || intChoice > 5);
            // Allo Switch va aggiunta la gestione dell'aggiunta.
            switch (intChoice) {
                case 1:
                    printStock();
                    break;
                case 2:
                    scnAddProdToWarehouse();
                    break;
                case 3:
                    System.out.println("Che nome vuoi dare al carrello:");
                    String name = scanner.nextLine();
                    createCart(name);
                    break;
                case 4:
                    scnRemoveCart();
                    break;
                case 5:
                    scnResearch();
                    break;
            }
        } while (!input.equalsIgnoreCase("q"));
    }

    public void createCart(String name) {
        if (carts.containsKey(name)) {
            System.out.println("Nome già usato da un altro carrello, carrello non creato");
            return;
        }
        carts.put(name, new Cart());
    }

    public void removeCart(String name) {
        if (!carts.containsKey(name)) {
            System.out.println("Nome del carrello errato");
        }
        carts.remove(name);
    }

    private void scnRemoveCart() {
        if (carts.isEmpty()) {
            System.out.print("Non è presente nessun carrello da eliminare.\n");
            return;
        }
        ArrayList<String> cartsName = new ArrayList<>();

        for (Map.Entry<String, Cart> element : carts.entrySet()) {
            cartsName.add(element.getKey());
        }
        String toPrint = "";
        for (int i = 0; i < cartsName.size(); i++) {
            toPrint = toPrint.concat(i + ". " + cartsName.get(i) + " ");
        }
        int intChoice = -1;
        do {
            System.out.print("Seleziona il carrello che vorresti eliminare:\n" +
                    toPrint + "\n" +
                    "oppure 'w' per tornare indietro\n");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("w")) {
                return;
            }
            while (!input.matches("[0-" + carts.size() + "]")) {
                System.out.print("Seleziona il carrello che vorresti eliminare:\n");
                input = scanner.nextLine();
            }
            intChoice = Integer.parseInt(input);
        } while (intChoice < 0 || intChoice > carts.size());

        carts.remove(cartsName.get(intChoice));
    }

    public void scnResearch() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input;
        int intChoice;
        do {
            System.out.println("Seleziona il criterio di ricerca (usa i numeri):\n" +
                    "1.Produttore   2.Modello    3.ID   e. Torna alla scehrmata precedente");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("e")) {
                return;
            }
            while (!input.matches("[1-3]")) {
                System.out.println("Usa i numeri per effettuare la scelta o 'e' per tornare alla schermata precedente\n");
                input = scanner.nextLine();
            }
            intChoice = Integer.parseInt(input);
        } while (intChoice < 1 || intChoice > 3);
        switch (intChoice) {
            case 1:
                System.out.println("Seleziona il produttore che vuoi cercare:");

                try {
                    printElements(researchProducer(scanner.nextLine()));
                } catch (IllegalArgumentException e) {
                    System.out.println("Non è stato trovato nessun elemento corrispondente.\n");
                }
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmation(scanner.nextInt());
                break;
            case 2:
                System.out.println("Seleziona il modello che vuoi cercare:");
                try {
                    printElements(researchModel(scanner.nextLine()));
                } catch (IllegalArgumentException e) {
                    System.out.println("Non è stato trovato nessun elemento corrispondente.\n");
                }
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmation(scanner.nextInt());
                break;
            case 3:
                System.out.println("Seleziona l'ID del prodotto che vuoi cercare:");
                try {
                    printElements(researchID(scanner.nextLine()));
                } catch (IllegalArgumentException e) {
                    System.out.println("Non è stato trovato nessun elemento corrispondente.\n");
                }
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmation(scanner.nextInt());
                break;
        }
    }

    public boolean checkIfEquals(String productData, String input) {

        boolean result = productData.equalsIgnoreCase(input);

        return result;
    }

    public void printElements(HashMap<Product, Integer> map) {
        for (Product item : map.keySet()) {
            System.out.println(item.toStringExtended() + "\nQuantity: " + map.get(item) + "\n \n");
        }
    }


    public HashMap<Product, Integer> researchProducer(String input)  {
        HashMap<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : stock.keySet()) {
            if (checkIfEquals(item.getProducer(), input)) {
                filteredMap.put(item, stock.get(item));
            }
        }
        if (filteredMap.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return filteredMap;
    }

    public HashMap<Product, Integer> researchModel (String input)  {
        HashMap<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : stock.keySet()) {
            if (checkIfEquals(item.getModel(), input)) {
                filteredMap.put(item, stock.get(item));
            }
        }
        if (filteredMap.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return filteredMap;
    }
    public HashMap<Product, Integer> researchID (String input)  {
        HashMap<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : stock.keySet()) {
            if (checkIfEquals(String.valueOf(item.getId()), input)) {
                filteredMap.put(item, stock.get(item));
            }
        }
        if (filteredMap.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return filteredMap;
    }

    public void askConfirmation(int choice) throws Exception {

        switch (choice) {
            case 0:
                scnResearch();
                break;
            case 1:
                break;
        }
    }
}

