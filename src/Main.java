import classes.Product;
import classes.Warehouse;
import products.KindOfProduct;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.addProduct(new Product(KindOfProduct.NOTEBOOK, "Apple", "XR", "tr", 2.3, 2, 1000, 1250), 10);
        warehouse.addProduct(new Product(KindOfProduct.NOTEBOOK, "Apple", "XR", "tr", 2.3, 2, 1000, 1250), 8);
        warehouse.createCart("Cart1");
        warehouse.scnHome();
    }

}
