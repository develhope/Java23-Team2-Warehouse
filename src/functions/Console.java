package functions;

import classes.Product;


import java.util.Map;
import java.util.Scanner;

import static classes.Warehouse.*;

public class Console {

    public static void scnResearchSeller(Map<Product, Integer> warehouse) throws Exception {
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

    public static void scnResearchClient(Map<Product, Integer> warehouse) throws Exception {
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
                scnResearchSeller(warehouse);
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
                scnResearchClient(warehouse);
                break;
            case 1:
                break;
        }
    }
}