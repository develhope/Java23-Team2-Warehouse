package classes;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<Product, Integer> stock;

    // Metodo per ottenere la mappa dello stock
    public Map<Product, Integer> getStock() {
        return stock;
    }

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


    public static void checkIfEmptyMap(Map<Product, Integer> originalMap) {
        if (originalMap.isEmpty()) {
            throw new IllegalArgumentException();
        }
        try {
            printFilteredElements(originalMap);
        } catch (IllegalArgumentException e) {
            System.out.println("Non è stato trovato nessun elemento corrispondente.\n");
        }
    }

    public static boolean checkIfPriceIsInRange(double maxLimit, double minLimit, double checkPrice) {
        return minLimit <= checkPrice && checkPrice <= maxLimit;
    }

    public static void printFilteredElements(Map<Product, Integer> map) {  //stampa risultato ricerca
        for (Product item : map.keySet()) {
            System.out.println(item.toStringExtended() + "\nQuantity: " + map.get(item) + "\n \n");
        }
    }

    public static Map<Product, Integer> researchKindOfProduct(Map<Product, Integer> warehouse, String input) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : warehouse.keySet()) {
            if (item.getArticle().equalsIgnoreCase(input)) {
                filteredMap.put(item, warehouse.get(item));
            }
        }
        return filteredMap;
    }

    public static Map<Product, Integer> researchProducer(Map<Product, Integer> warehouse, String input) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : warehouse.keySet()) {
            if (item.getProducer().equalsIgnoreCase(input)) {
                filteredMap.put(item, warehouse.get(item));
            }
        }
        return filteredMap;
    }

    public static Map<Product, Integer> researchModel(Map<Product, Integer> warehouse, String input) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : warehouse.keySet()) {
            if (item.getModel().equalsIgnoreCase(input)) {
                filteredMap.put(item, warehouse.get(item));
            }
        }
        return filteredMap;
    }

    public static Map<Product, Integer> researchID(Map<Product, Integer> warehouse, int input) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : warehouse.keySet()) {
            if (item.getId() == input) {
                filteredMap.put(item, warehouse.get(item));
            }
        }
        return filteredMap;
    }

    public static Map<Product, Integer> researchSellPrice(Map<Product, Integer> warehouse, double input) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : warehouse.keySet()) {
            if (item.getSellPrice() == input) {
                filteredMap.put(item, warehouse.get(item));
            }
        }
        return filteredMap;
    }

    public static Map<Product, Integer> researchPurchasePrice(Map<Product, Integer> warehouse, double input) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : warehouse.keySet()) {
            if (item.getPurchasePrice() == input) {
                filteredMap.put(item, warehouse.get(item));
            }
        }
        return filteredMap;
    }

    public static Map<Product, Integer> researchPurchasePriceInRange(Map<Product, Integer> warehouse, double minLimit, double maxLimit) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : warehouse.keySet()) {
            if (checkIfPriceIsInRange(maxLimit, minLimit, item.getPurchasePrice())) {
                filteredMap.put(item, warehouse.get(item));
            }
        }
        return filteredMap;
    }

    public static Map<Product, Integer> researchSellPriceInRange(Map<Product, Integer> warehouse, double minLimit, double maxLimit) {
        Map<Product, Integer> filteredMap = new HashMap<>();
        for (Product item : warehouse.keySet()) {
            if (checkIfPriceIsInRange(maxLimit, minLimit, item.getSellPrice())) {
                filteredMap.put(item, warehouse.get(item));
            }
        }
        return filteredMap;
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

