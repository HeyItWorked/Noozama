package group7.noozama.dso;

import io.realm.RealmObject;

public class Product extends RealmObject {

    //product information
    private String name;
    private String id;
    private String description;
    private double price;
    private String label;
    //variables used for when the product goes on sale
    private boolean onSale=false;
    private double regularPrice;

    public Product() {}

    public Product(String name, String id, String description, double price, String label) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.price = price;
        this.label = label;
    }

    //getters for the product information
    public String getName(){ return name; }
    public String getID(){ return id; }
    public String getDescription(){ return description; }
    public double getPrice(){ return price; }
    public String getLabel() { return label; }
    public boolean getSaleStatus(){ return onSale; }
    public double getRegularPrice(){ return regularPrice; }

    //setters for the product information
    public void setName(String n){ name=n; }
    public void setID(String i){ id=i; }
    public void setDescription(String d){ description=d; }
    public void setPrice(double p){ price=p; }
    public void setLabel(String l){ label=l; }
    public void setSaleStatus(boolean s){ onSale=s; }
    public void setRegularPrice(){ regularPrice=this.getPrice(); }

    //lists item as on sale if not already on sale
    public void startSale(double salePrice){
        if(!this.getSaleStatus()){
            this.setRegularPrice();
            this.setPrice(salePrice);
            this.setSaleStatus(true);
        }
    }

    //takes the item off sale and returns price to normal
    public void endSale(){
        if(this.getSaleStatus()){
            this.setPrice(this.getRegularPrice());
            this.setSaleStatus(false);
        }
    }


}
