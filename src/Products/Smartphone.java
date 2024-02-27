package Products;

import Enums.KindOfProduct;
import Enums.Models;
import Enums.Productors;

public class Smartphone extends Product {
    public Smartphone(Productors produttore, Models modello, double display, double memoria, double acquistoPrezzo, double venditaPrezzo, String descrizione, String id) {
        super(KindOfProduct.SMARTPHONE, produttore, modello, display, memoria, acquistoPrezzo, venditaPrezzo, descrizione, id = "S");
        switch (produttore) {
            case NOKIA -> {
                this.id = id.concat("01");
                switch (modello) {
                    case T20 -> this.id = this.id.concat("01");
                    case B3310 -> this.id.concat("02");
                }

            }
            case SAMSUNG -> {
                this.id = id.concat("02");
                switch (modello) {
                    case S7 -> this.id = this.id.concat("01");
                    case GALAXY20 -> this.id = this.id.concat("02");
                }
            }
            case ALIENWARE -> {
                this.id = id.concat("03");
                switch (modello) {
                    case M15 -> this.id = this.id.concat("01");
                    case M18 -> this.id = this.id.concat("02");
                }
            }
            case APPLE -> {
                this.id = id.concat("04");
                switch (modello) {
                    case IPAD10 -> this.id = this.id.concat("01");
                    case IPHONE30 -> this.id = this.id.concat("02");
                }
            }
        }
    }
}

