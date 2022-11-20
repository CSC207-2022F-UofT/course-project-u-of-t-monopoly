package tutorial;

public class Bank {


//
    public Bank() {

    }

    public void MortgageProperty(Player player, Properties properties) {
        player.addMoney(properties.getMortgageValue());
        for (Building b : properties.getBuildingsConstructed()) {
            player.addMoney(b.getPrice() / 2);
        }
        properties.removeBuildings();

    }

    public void GiveMoneyToPlayer(Player p, int Amount) {
        p.addMoney(Amount);
    }

    public void TaxPlayer(Player p, int Tax) {
        p.loseMoney(Tax);
    }

    public boolean mediator(Player p, int transactionAmount) {
        return p.getMoney() >= transactionAmount;
    }

}
