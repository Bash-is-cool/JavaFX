/**
 * Player for blackjack. they have money and a hand
 * 
 * @author Alex Silverman
 * @version 1.0.0
 */

public class Player
{
    private String name;
    private Hand hand;
    private int money;
    private int bet;
   
    /**
     * Constructor for player. They need money and a name
     *
     * @param String n
     * @param int m
     */
    public Player(String n, int m) {
        name = n;
        money = m;
        hand = new Hand();
        bet = 0;
    }
    
    /**
     * Returns the players hand
     * 
     * @return Hand
     */
    public Hand getHand() {
        return hand;
    }
    
    /**
     * Returns players name
     *
     * @return String
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the players money
     *
     * @return int
     */
    public int getBank() {
        return money;
    }
    
    /**
     * Places a bet for the player
     * 
     * @param int b
     */
    public void placeBet(int b) {
        bet = b;
        money -= b;
    }
    
    /**
     * toString for Player. Has name and money
     *
     * @return String
     */
    public String toString() {
        return "Name: " + name + ", Bankroll: " + money;
    }
    
    /**
     * Returns the players current bet
     *
     * @return int
     */
    public int getBet() {
        return bet;
    }
    
    /**
     * Handles doubling the money
     */
    public void doubleMoney() {
        money -= bet;
        bet *= 2;
    }
    
    /**
     * Adds money to the player if they win
     * 
     * @param int m
     */
    public void addMoney(int m) {
        money += m;
    }
}
