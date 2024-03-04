import org.junit.Test;
import products.Product;
import products.kindOfProduct;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<Product> products;

    public Warehouse() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product findProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null; // Ritorna null se il prodotto non viene trovato
    }

    @Test
    public void main() {
        // Esempio di utilizzo
        Warehouse warehouse = new Warehouse();

        // Aggiungi alcuni prodotti al magazzino
        warehouse.addProduct(new Product(kindOfProduct.TABLET, "Apple", "iPad", "Tablet with iOS", "123", 10.5, 256, 799.99, 999.99));
        warehouse.addProduct(new Product(kindOfProduct.SMARTPHONE, "Samsung", "Galaxy S20", "Smartphone with Android", "456", 6.2, 128, 999.99, 1199.99));

        //Intera lista dei prodotti
        List<Product> productList = warehouse.getProducts();
        for (Product product : productList) {
            System.out.println(product);

            // Trova un prodotto per ID
            Product foundProduct = warehouse.findProductById("123");
            if (foundProduct != null) {
                System.out.println("Product found: " + foundProduct);
            } else {
                System.out.println("Product not found.");
            }
        }
    }
}

