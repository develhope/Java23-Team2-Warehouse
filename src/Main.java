import enums.KindOfProduct;
import enums.Models;
import enums.Producers;
import products.Product;

public class Main {

    public static void main(String[] args) {
        Product tablet = new Product(KindOfProduct.TABLET, Producers.APPLE, Models.IPAD10,"00000","",12,45,2424,124124);
        Product smartphone = new Product(KindOfProduct.NOTEBOOK, Producers.ALIENWARE, Models.GALAXY20,"00000","",12,45,2424,124124);
        Product notebook = new Product(KindOfProduct.SMARTPHONE, Producers.SAMSUNG, Models.M18,"00000","",12,45,2424,124124);
        System.out.println (tablet);
        System.out.println ();
        System.out.println ();
        System.out.println (smartphone);
        System.out.println ();
        System.out.println ();
        System.out.println (notebook);
    }

}
