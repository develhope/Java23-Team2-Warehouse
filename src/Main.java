import Enums.Models;
import Enums.Producers;
import Products.Notebook;
import Products.Smartphone;
import Products.Tablet;

public class Main {

    public static void main(String[] args) {
        Tablet tablet= new Tablet(Producers.SAMSUNG, Models.S7,15,50,125,270,"","");
        Smartphone cell = new Smartphone(Producers.APPLE, Models.IPHONE30,15,50,125,270,"","");
        Notebook pc = new Notebook(Producers.ALIENWARE, Models.M15,15,50,125,270,"","");
        System.out.println(tablet.getDescription());
        System.out.println();
        System.out.println();
        System.out.println(cell.getDescription());
        System.out.println();
        System.out.println();
        System.out.println(pc.getDescription());
    }

}

