package functions;

import classes.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Consolle {

    public static void scnResearchSeller(Map<Product, Integer> map) throws Exception {
        Scanner scanner = new Scanner(System.in);
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
                    e. Torna alla scehrmata precedente""");
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
                checkIfEmptyMap(researchKindOfProduct(map, scanner.nextLine()));
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmationEndTask(map, scanner.nextInt());
                break;

            case 2:
                System.out.println("Seleziona il produttore che desideri cercare:");
                checkIfEmptyMap(researchProducer(map, scanner.nextLine()));
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmationEndTask(map, scanner.nextInt());
                break;
            case 3:
                System.out.println("Seleziona il modello che desideri cercare:");
                checkIfEmptyMap(researchModel(map, scanner.nextLine()));
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmationEndTask(map, scanner.nextInt());
                break;
            case 4:
                System.out.println("Seleziona l'ID del prodotto che desideri cercare:");
                checkIfEmptyMap(researchID(map, scanner.nextInt()));
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmationEndTask(map, scanner.nextInt());
                break;

            case 5:
                System.out.println("Seleziona il prezzo d'acquisto del prodotto che desideri cercare:");
                checkIfEmptyMap(researchPurchasePrice(map, scanner.nextDouble()));
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmationEndTask(map, scanner.nextInt());
                break;

            case 6:
                System.out.println("Seleziona il prezzo di vendita del prodotto che desideri cercare:");
                checkIfEmptyMap(researchSellPrice(map, scanner.nextDouble()));
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmationEndTask(map, scanner.nextInt());
                break;

            case 7:
                System.out.println("Seleziona il range di prezzo di acquisto dei prodotti che desideri cercare: \nDigita il prezzo minimo che desideri cercare: ");
                double minPurchasePrice = scanner.nextDouble();
                System.out.println("Digita il prezzo massimo che desideri cercare: ");
                double maxPurchasePrice = scanner.nextDouble();
                checkIfEmptyMap(researchPurchasePriceInRange(map, minPurchasePrice, maxPurchasePrice));
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmationEndTask(map, scanner.nextInt());
                break;

            case 8:
                System.out.println("Seleziona il range di prezzo di vendita dei prodotti che desideri cercare: \nDigita il prezzo minimo che desideri cercare: ");
                double minSellPrice = scanner.nextDouble();
                System.out.println("Digita il prezzo massimo che desideri cercare: ");
                double maxSellPrice = scanner.nextDouble();
                checkIfEmptyMap(researchSellPriceInRange(map, minSellPrice, maxSellPrice));
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmationEndTask(map, scanner.nextInt());
                break;
        }
    }

    public static void scnResearchClient(Map<Product, Integer> map) throws Exception {
        Scanner scanner = new Scanner(System.in);
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
                    e. Torna alla scehrmata precedente""");
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
                checkIfEmptyMap(researchKindOfProduct(map, scanner.nextLine()));
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmationEndTask(map, scanner.nextInt());
                break;

            case 2:
                System.out.println("Seleziona il produttore che desideri cercare:");
                checkIfEmptyMap(researchProducer(map, scanner.nextLine()));
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmationEndTask(map, scanner.nextInt());
                break;
            case 3:
                System.out.println("Seleziona il modello che desideri cercare:");
                checkIfEmptyMap(researchModel(map, scanner.nextLine()));
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmationEndTask(map, scanner.nextInt());
                break;
            case 4:
                System.out.println("Seleziona l'ID del prodotto che desideri cercare:");
                checkIfEmptyMap(researchID(map, scanner.nextInt()));
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmationEndTask(map, scanner.nextInt());
                break;

            case 5:
                System.out.println("Seleziona il prezzo del prodotto che desideri cercare:");
                checkIfEmptyMap(researchSellPrice(map, scanner.nextDouble()));
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmationEndTask(map, scanner.nextInt());
                break;

            case 6:
                System.out.println("Seleziona il range di prezzo dei prodotti che desideri cercare: \nDigita il prezzo minimo che desideri cercare: ");
                double minSellPrice = scanner.nextDouble();
                System.out.println("Digita il prezzo massimo che desideri cercare: ");
                double maxSellPrice = scanner.nextDouble();
                checkIfEmptyMap(researchSellPriceInRange(map, minSellPrice, maxSellPrice));
                System.out.println("Vuoi continuare a cercare? \n0. Sì   1. No");
                askConfirmationEndTask(map, scanner.nextInt());
                break;

        }
    }

    public static void askConfirmationEndTask(Map<Product, Integer> map, int choice) throws Exception {

        switch (choice) {
            case 0:
                scnResearchSeller(map);
                break;
            case 1:
                break;
        }
    }

    public static void checkIfEmptyMap(Map<Product, Integer> map) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException();
        }
        try {
            printElements(map);
        } catch (IllegalArgumentException e) {
            System.out.println("Non è stato trovato nessun elemento corrispondente.\n");
        }
    }

    public static boolean checkIfPriceIsInRange(double maxLimit, double minLimit, double checkPrice) {

        return minLimit <= checkPrice && checkPrice <= maxLimit;
    }

    public static void printElements(Map<Product, Integer> map) {
        for (Product item : map.keySet()) {
            System.out.println(item.toStringExtended() + "\nQuantity: " + map.get(item) + "\n \n");
        }
    }

    public static Map<Product, Integer> researchKindOfProduct(Map<Product, Integer> map, String input) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : map.keySet()) {
            if (item.getArticle().equalsIgnoreCase(input)) {
                filteredMap.put(item, map.get(item));
            }
        }

        return filteredMap;
    }

    public static Map<Product, Integer> researchProducer(Map<Product, Integer> map, String input) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : map.keySet()) {
            if (item.getProducer().equalsIgnoreCase(input)) {
                filteredMap.put(item, map.get(item));
            }
        }
        return filteredMap;
    }

    public static Map<Product, Integer> researchModel(Map<Product, Integer> map, String input) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : map.keySet()) {
            if (item.getModel().equalsIgnoreCase(input)) {
                filteredMap.put(item, map.get(item));
            }
        }

        return filteredMap;
    }

    public static Map<Product, Integer> researchID(Map<Product, Integer> map, int input) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : map.keySet()) {
            if (item.getId() == input) {
                filteredMap.put(item, map.get(item));
            }
        }
        return filteredMap;
    }

    public static Map<Product, Integer> researchSellPrice(Map<Product, Integer> map, double input) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : map.keySet()) {
            if (item.getSellPrice() == input) {
                filteredMap.put(item, map.get(item));
            }
        }

        return filteredMap;
    }

    public static Map<Product, Integer> researchPurchasePrice(Map<Product, Integer> map, double input) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : map.keySet()) {
            if (item.getPurchasePrice() == input) {
                filteredMap.put(item, map.get(item));
            }
        }

        return filteredMap;
    }

    public static Map<Product, Integer> researchPurchasePriceInRange(Map<Product, Integer> map, double minLimit, double maxLimit) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : map.keySet()) {
            if (checkIfPriceIsInRange(maxLimit, minLimit, item.getPurchasePrice())) {
                filteredMap.put(item, map.get(item));
            }
        }
        return filteredMap;
    }

    public static Map<Product, Integer> researchSellPriceInRange(Map<Product, Integer> map, double minLimit, double maxLimit) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : map.keySet()) {
            if (checkIfPriceIsInRange(maxLimit, minLimit, item.getSellPrice())) {
                filteredMap.put(item, map.get(item));
            }
        }
        return filteredMap;
    }
}