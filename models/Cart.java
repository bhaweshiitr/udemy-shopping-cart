package models;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items = new ArrayList<Item>();

    //Constructor
    public Cart(){
        this.items = new ArrayList<Item>();
    }

    // Getters
    public Item getItem(int index) {
        return new Item(items.get(index));
    }

    //Setters
    public void setItem(int index , Item item){
        this.items.set(index, new Item(item));
    }


   /**
    * Name: add
    * @param item
    * @return boolean
    *
    * Inside the function:
    *   1. Adds an item to the cart if it wasn't already added.
    */
    public boolean add(Item item){
        if(this.items.contains(item)){
            return false;
        }
        this.items.add(item);
        return true;
    }

 
 
  
   /**
    * Name: remove
    * @param name
    *
    * Inside the function:
    *   1. Removes the item that matches the name passed in.
    */
    public void remove(String name){
        if(this.items.isEmpty()){
            throw new IllegalStateException("cannot remove from an empty cart");
        }
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equals(name)){
                items.remove(i);
            }
        }
    }

 
 
  
   /**
    *  Name: checkout
    *  @return (String)
    *
    *  Inside the function:
    *   1. Calculates the subtotal (price before tax).
    *   2. Calculates the tax (assume tax is 13%).
    *   3. Calculates total: subtotal + tax
    *   4. Returns a String that resembles a receipt. See below.
    */
    public String checkout(){
        if(this.items.isEmpty()){
            throw new IllegalStateException("cannot checkout an empty cart");
        }
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total+=items.get(i).getPrice();
        }
        double tax = total*(0.13);
        String temp = "";
        temp+=  "\tRECEIPT\n\n" +
                "\tSubtotal: $" + total + "\n" +
                "\tTax: $" + tax + "\n" +
                "\tTotal: $" + (total+tax )+ "\n";
        return temp;
    }

    public String toString(){
        String temp = "";
        for (int i = 0; i < items.size(); i++) {
            temp+=items.get(i).toString();
            temp+="\n";
        }
        return temp;
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }
    
}
