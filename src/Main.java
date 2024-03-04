import classes.Product;
import classes.kindOfProduct;

public class Main {

    public static void main(String[] args) {
        Product product = new Product(kindOfProduct.NOTEBOOK,"Apple","M1","MacM1","001",13,256,1299,1580);
        Product product2 = new Product(kindOfProduct.NOTEBOOK,"Apple","M1","MacM1","002",13,512,1400,1900);

        Cart cart = new Cart();
        cart.addToCart(product);
        cart.printProductsInCart();
        cart.addToCart(product2);
        cart.printProductsInCart();
        cart.removeFromCart(product);
        cart.printProductsInCart();
        cart.emptyCart();
        cart.printProductsInCart();

    }

}
