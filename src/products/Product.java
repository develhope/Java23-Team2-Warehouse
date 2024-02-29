package products;

import enums.KindOfProduct;
import enums.Models;
import enums.Producers;

public class Product {

    private KindOfProduct article;

    public KindOfProduct getArticle() {
        return article;
    }

    public void setArticle(KindOfProduct article) {
        this.article = article;
    }

    private Producers producer;

    public Producers getProducer() {
        return producer;
    }

    public void setProducer(Producers producer) {
        this.producer = producer;
    }

    private Models model;

    public Models getModel() {
        return model;
    }

    public void setModel(Models model) {
        this.model = model;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    private double display;

    public void setDisplay(double display) {
        this.display = display;
    }

    public double getDisplay() {
        return display;
    }

    private double storage;

    public void setStorage(double storage) {
        this.storage = storage;
    }

    public double getStorage() {
        return storage;
    }

    private double purchasePrice;

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    private double sellPrice;

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public Product(KindOfProduct article, Producers producer, Models model, String id, String description, double display, double storage, double purchasePrice, double sellPrice) {
        this.article = article;
        this.producer = producer;
        this.model = model;
        this.id = id;
        this.description = description;
        this.display = display;
        this.storage = storage;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return "Product:" + "\n" +
                "Article= " + article + "\n" +
                "Producer= " + producer + '\n' +
                "Model= " + model + '\n' +
                "ID= " + id + '\n' +
                "Display= " + display + "\n" +
                "Storage memory= " + storage + "\n" +
                "Purchase price= " + purchasePrice + "\n" +
                "Selling price = " + sellPrice + "\n" +
                "Description = " + description;
    }

}


