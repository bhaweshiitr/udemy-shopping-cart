package models;

public class Item {
    private String name ;
    private double price ;

    //Constructor
    public Item(String name , double price){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name can not be null/Blank");
        }
        if(price<0){
            throw new IllegalArgumentException("The price can not be less than 0 ");
        }
        this.name = name;
        this.price = price;

    }

    //Copy Constructor
    public Item(Item source){
        this.name = source.name;
        this.price = source.price;
    }

    // Getters
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }


    // Setters
    public void setName(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name can not be null/Blank");
        }
        this.name = name;
    }
    public void setPrice(double price){
        if(price<0){
            throw new IllegalArgumentException("The price can not be less than 0 ");
        }
        this.price = price ;
    }


    // Methods
    public String toString(){
        return name + ": $" + price + " ";
    }

    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(!(obj instanceof Item)){
            return false;
        }
        Item item = (Item)obj;
        return this.name.equals(item.name) && this.price==item.price;
    }

  
}
