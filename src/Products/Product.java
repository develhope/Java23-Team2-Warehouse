package Products;

import Enums.KindOfProduct;
import Enums.Models;
import Enums.Producers;

public class Product {


    public static void main(String[] args) {
    }

    protected String tipo;
    protected String produttore;
    protected String modello;
    protected String id;
    protected double display;
    protected double memoria;
    protected double acquistoPrezzo;
    protected double venditaPrezzo;
    protected String descrizione;


    public Product(KindOfProduct tipo, Producers produttore, Models modello, double display, double memoria, double acquistoPrezzo, double venditaPrezzo, String descrizione, String id) {
        this.tipo= tipo.name();
        this.produttore = produttore.name();
        this.modello = modello.name();
        this.display = display;
        this.memoria = memoria;
        this.id = id;
        this.acquistoPrezzo = acquistoPrezzo;
        this.venditaPrezzo= (this.acquistoPrezzo*1.30)*1.22;
        this.descrizione = descrizione;

    }

    public String getDescription() {

        return "Questo " + tipo + " " + produttore+ " " + modello + " ha uno schermo di " + display + "\" e una memoria di " + memoria + " GB." + descrizione + "\n \n" +
                "Prezzo di acquisto: " + acquistoPrezzo + " €\nPrezzo di vendita: " + venditaPrezzo + " € \n \n" + id;
    }
}


