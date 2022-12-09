package entity;

public abstract class Building{
    // Abstract class Building

    private Integer price;
    private Integer rent;
    private Integer mortgageValue;



    public Building(Integer price, Integer rent, Integer mortgageValue) {
        this.price = price;
        this.rent = rent;
        this.mortgageValue =  mortgageValue;
    }

    public int getPrice(){return this.price;}

    public int getRent(){return this.rent;}

    public int getMortgageValue(){return this.mortgageValue;}
}
