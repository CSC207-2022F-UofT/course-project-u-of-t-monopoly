package tutorial;

import javax.lang.model.type.UnionType;
import java.util.ArrayList;
import java.util.List;

public class Properties {

    // entity Properties
    private String name;
    private Integer price;
    
    private Integer rent;
    private boolean utilities;
    private String color;
    private Integer mortgageValue;
    private List<Building> buildingsConstructed;

    private Player Owner;


    public Properties(String name, Integer price, Integer rent, boolean utilities, String color, Integer mortgageValue) {
        this.name = name;
        this.price = price;
        this.rent  = rent;
        this.utilities = utilities;
        this.color = color;
        this.mortgageValue = mortgageValue;
        this.buildingsConstructed = new ArrayList<>();
        this.Owner = null;
    }

    public int getPrice(){
        // this returns the total price of this property (since the prices are all set to be private
        // in case it might be modified) if a player decide to trade this property.
        Integer result = this.price;
        for (Building building : this.buildingsConstructed) {
            result = result + building.getPrice();
        }
        return result;
    }

    public int getRent(){
        // this returns the total rent of this property. When a player need to pay rent, call this
        // method to get the rent amount.
        Integer result = this.rent;
        for (Building building : this.buildingsConstructed) {
            result = result + building.getRent();
        }
        return result;
    }

    public String getColor(){
        return this.color;
    }
    
    public int getMortgageValue(){
        // call this method when property is being mortgaging.
        return this.mortgageValue;
    }
    
    public List<Building> getBuildingsConstructed(){
        // other classes may need this method.
        return this.buildingsConstructed;
    }

    public boolean OwnedByPlayer(){
        return this.Owner != null;
    }

    public int numBuildings(){
        return this.buildingsConstructed.size();
    }

    public void resetOwner(Player p) {
        // call this method when a property's owner is changed
        this.Owner = p;
    }
    
    public void resetOwner() {
        // call this method when a property is mortgaged.
        this.Owner = null;
    }

    public void buildHouse(House h) {
        // call this method to build a house, note that utilities cannot be improved
        if (!this.utilities){
            this.buildingsConstructed.add(h);}
    }

    public void buildHotel(Hotel ho) {
        // call this method to build a hotel, note that utilities cannot be improved
        if (!this.utilities){
        this.buildingsConstructed.add(ho);}
    }

    public void removeBuilding(){
        // when a property is mortgaged, call this method to clear all buildings on this property.
        this.buildingsConstructed = new ArrayList<>();
    }


}
