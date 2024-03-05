package classes;
import products.KindOfProduct;
public class Product {

    private KindOfProduct article;
    private String producer;
    private String model;
    private String id;
    private String description;
    private double display;
    private double storage;
    private double purchasePrice;
    private double sellPrice;
    private int quantity;


    public void setArticle(KindOfProduct article) {
        this.article = article;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setId(String id) {
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public String getId() {
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

    public int getQuantity() {
        return quantity;
    }

    public Product(KindOfProduct article, String producer, String model, String description, String id, double display, double storage, double purchasePrice, double sellPrice, int quantity) {
        this.article = article;
        this.producer = producer;
        this.model = model;
        this.id = id;
        this.description = description;
        this.display = display;
        this.storage = storage;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
    }


    @Override
    public String toString() {
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

}


