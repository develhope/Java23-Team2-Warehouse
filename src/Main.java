import classes.Cart;
import classes.Product;
import classes.Warehouse;
import products.KindOfProduct;

public class Main {

    public static void main(String[] args) {
        Product product = new Product(KindOfProduct.NOTEBOOK, "Apple", "XR", "tr", "dsd", 2.3, 2, 1000, 1250);
        Product product2 = new Product(KindOfProduct.NOTEBOOK, "Apple", "XR", "tr", "dsd", 2.3, 2, 1000, 1250);
//        Cart cartTest = new Cart();
//        cartTest.addToCart(product, 5);
//        cartTest.removeFromCart(product, 2);
//        cartTest.printProductsInCart();
//        cartTest.removeFromCart(product2, 3);
//        cartTest.removeFromCart(product, 2);
//        cartTest.removeFromCart(product, 2);
//        cartTest.printProductsInCart();
        Warehouse warehouse = new Warehouse();
        warehouse.addProduct(product, 10);
        warehouse.addProduct(product2, 8);
        warehouse.scnHome();

    }

}
