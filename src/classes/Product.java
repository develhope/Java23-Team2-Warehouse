package classes;
import products.KindOfProduct;

import java.util.Objects;

public class Product {

    private KindOfProduct article;
    private String producer;
    private String model;
    private int id;
    private String description;
    private double display;
    private double storage;
    private double purchasePrice;
    private double sellPrice;


    public void setArticle(KindOfProduct article) {
        this.article = article;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDisplay(double display) {
        this.display = display;
    }

    public void setStorage(double storage) {
        this.storage = storage;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getArticle() {
        return article.name();
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getDisplay() {
        return display;
    }

    public double getStorage() {
        return storage;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public Product(KindOfProduct article, String producer, String model, String description, double display, double storage, double purchasePrice, double sellPrice) {
        this.article = article;
        this.producer = producer;
        this.model = model;
        this.id = hashCode();
        this.description = description;
        this.display = display;
        this.storage = storage;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
    }


    public String toStringExtended() {
        return "classes.Product:" + "\n" +
                "Article= " + article.name() + "\n" +
                "Producer= " + producer + '\n' +
                "Model= " + model + '\n' +
                "ID= " + id + '\n' +
                "Display= " + display + "\"\n" +
                "Storage memory= " + storage + " GB\n" +
                "Purchase price= " + purchasePrice + " €\n" +
                "Selling price = " + sellPrice + " €\n" +
                "Description = " + description;
    }

    @Override
    public String toString() {
        return article +
                " Produttore: '" + producer + '\'' +
                ", Modello: " + model + '\'' +
                ", Prezzo: " + sellPrice;
    }



    @Override
    public int hashCode() {
        return Objects.hash(article, producer, model);
    }
}


