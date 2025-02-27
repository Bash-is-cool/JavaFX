public class Player
{
    private String name;
    private Hand hand;
    private int money;
    private int bet;
   
    public Player(String n, int m) {
        name = n;
        money = m;
        hand = new Hand();
        bet = 0;
    }
    
    public Hand getHand() {
        return hand;
    }
    
    public String getName() {
        return name;
    }
    
    public int getBank() {
        return money;
    }
    
    public void placeBet(int b) {
        bet = b;
        money -= b;
    }
    
    public String toString() {
        return "Name: " + name + ", Bankroll: " + money;
    }
    
    public int getBet() {
        return bet;
    }
    
    public void doubleMoney() {
        money -= bet;
        bet *= 2;
    }
    
    public void addMoney(int m) {
        money += m;
    }
}
