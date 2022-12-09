package entity;

import java.util.ArrayList;
import java.util.List;

public class Properties extends TileCanBuy{

    // entity Properties
    private String name;
    private Integer price;

    private Integer rent;
    private String color;
    private Integer mortgageValue;
    private List<Building> buildingsConstructed;

    private Player Owner;


    /**
     * Instantiate a Properties object 
     * @param name the name of the Properties object 
     * @param price the price of the Properties object 
     * @param rent the rent of the Properties object 
     * @param color the colour of the Properties object 
     * @param mortgageValue the mortgageValue of the Properties object 
     */
    public Properties(String name, Integer price, Integer rent, String color, Integer mortgageValue) {
        this.name = name;
        this.price = price;
        this.rent  = rent;
        this.color = color;
        this.mortgageValue = mortgageValue;
        this.buildingsConstructed = new ArrayList<>();
        this.Owner = null;
    }

    /**
     * Return the String of the name for the Properties 
     * @return the name of the Properties 
     */
    @Override
    public String getName(){
        return this.name;
    }

    /**
     * Return the int for the price of the Properties 
     * @return the price 
     */
    @Override
    public int getPrice(){
        // this returns the total price of this property (since the prices are all set to be private
        // in case it might be modified) if a player decide to trade this property.
        Integer result = this.price;
        for (Building building : this.buildingsConstructed) {
            result = result + building.getPrice();
        }
        return result;
    }

    /**
     * Getter method for the rent of a Properties object 
     * @return the int representing the rent
     */
    @Override
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

    /**
     * Getter method for the mortgageValue of the Properties object 
     * @return the int representing the mortgageValue 
     */
    @Override
    public int getMortgageValue(){
        // call this method when property is being mortgaging.
        Integer result = this.mortgageValue;
        for (Building building : this.buildingsConstructed) {
            result = result + building.getMortgageValue();
        }
        return result;
    }

    /**
     * Return the buildingsConstructed on this Properties object 
     * @return the List of buildings built on this Properties object 
     */
    public List<Building> getBuildingsConstructed(){
        // other classes may need this method.
        return this.buildingsConstructed;
    }

    /**
     * Getter method to return the Player object representing the owner 
     * @return the owner of this Properties object 
     */
    @Override
    public Player getOwner(){
        return this.Owner;
    }

    /**
     * Check whether a Properties object is owned by a PLayer 
     * @return true of the Properties object is owned, false otherwise
     */
    public boolean OwnedByPlayer(){
        return this.Owner != null;
    }

    /**
     * Return the number of buildings built on this Properties object
     * @return the size of the this.buildingsContructed 
     */
    public int numBuildings(){
        return this.buildingsConstructed.size();
    }

    /**
     * reset the owner to the inputted Player 
     * @param p the new owner of the Properties object 
     */
    @Override
    public void resetOwner(Player p) {
        // call this method when a property's owner is changed
        this.Owner = p;
    }

    /**
     * Reset the owner of the Properties object to be null (no owner)
     * this is useful when properties are being mortgaged 
     */
    @Override
    public void resetOwner() {
        // call this method when a property is mortgaged.
        this.Owner = null;
        this.removeBuilding();
    }

    /**
     * add a building object to the this.buildingsConstructed list 
     * @param b the new building built on this Property
     */
    public void buildBuilding(Building b) {
        // call this method to build, note that utilities cannot be improved

        this.buildingsConstructed.add(b);
    }

    /**
     * Remove all the buildings from the property
     * this is useful when the property is being mortgaged, and there are no longer buildings
     * attached to it 
     */
    public void removeBuilding(){
        // when a property is mortgaged, call this method to clear all buildings on this property.
        this.buildingsConstructed = new ArrayList<>();
    }


}
