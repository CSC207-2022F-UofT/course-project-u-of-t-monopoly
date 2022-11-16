package tutorial;

import javax.lang.model.type.UnionType;
import java.util.ArrayList;
import java.util.List;

public class Properties {

    // entity Properties
    private Integer price;

    private Integer rent;
    private boolean utilities;
    private String color;
    private Integer mortgageValue;
    private List<Building> buildingsConstructed;

    private Player Owner;


    public Properties(Integer price, Integer rent, boolean utilities, String color, Integer mortgageValue) {
        this.price = price;
        this.rent  = rent;
        this.utilities = utilities;
        this.color = color;
        this.mortgageValue = mortgageValue;
        this.buildingsConstructed = new ArrayList<>();
        this.Owner = null;
    }

    public int getPrice(){
        Integer result = this.price;
        for (Building building : this.buildingsConstructed) {
            result = result + building.getPrice();
        }
        return result;
    }

    public int getRent(){
        Integer result = this.rent;
        for (Building building : this.buildingsConstructed) {
            result = result + building.getRent();
        }
        return result;
    }

    public String getColor(){
        return this.color;
    }

    public boolean OwnedByPlayer(){
        return this.Owner != null;
    }

    public int numBuildings(){
        return this.buildingsConstructed.size();
    }

    public void resetOwner(Player p) {
        this.Owner = p;
    }

    public void buildHouse(House h) {
        if (!this.utilities){
            this.buildingsConstructed.add(h);}
    }

    public void buildHotel(Hotel ho) {
        if (!this.utilities){
        this.buildingsConstructed.add(ho);}
    }



}
