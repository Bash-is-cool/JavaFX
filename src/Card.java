//Don't forget to include Java Docs!!!
/**
 * Creates a card with a Rank(number) and a Suit.
 * 
 * @author Alex Silverman
 * @version 1.0.0
 */

public class Card
{
    private String suit;
    private String rank;
    private int value;
    
    /**
     * Constructs the Card class with the rank and the suit 
     * 
     * @param s
     * @param r
     */
     
    public Card(String s, String r) {
        if(s.equalsIgnoreCase("Spades")) {
            suit = "♠";
        } else if(s.equalsIgnoreCase("Hearts")) {
            suit = "♥";
        } else if(s.equalsIgnoreCase("Diamonds")) {
            suit = "♦";
        } else if(s.equalsIgnoreCase("Clubs")) {
            suit = "♣";
        } else {
            suit = s;
        }
        rank = r;
    }
    
    /**
     * Method to get the rank of the card
     * 
     * @return int rank
     */
     
    public int getValue() {
        if(rank.equalsIgnoreCase("King") || rank.equalsIgnoreCase("Queen") || rank.equalsIgnoreCase("Jack")) {
            value = 10;
        } else if(rank.equalsIgnoreCase("Ace")) {
            value = 11;
        } else {
            value = Integer.parseInt(rank);
        }
        return value;
    }
    
    /**
     * Method to get the suit of the card
     * 
     * @return String suit
     */
     
    public String getSuit() {
        return suit;
    }
    
    /**
     * The toString for a card. 
     * Displays the rank/value and the suit of a given card
     * 
     * @return String result
     */
     
    public String toString() {
        return  rank + " of " + suit + " (value: " + getValue() + ").";
    }
    
    /**
     * The toString for a card (Used for toString of Class Deck. 
     * Displays the rank/value and the suit of a given card
     * 
     * @return String result
     */
    public String toString2() {
        return rank + " of " + suit;
    }
    
    /**
     * returns the rank of the card
     * 
     * @return String rank
     */
    public String getRank() {
        return rank;
    }
    
    
    /**
     * Sets the value of an ace based on the given value n. n has to be 11 
     * or 1
     *
     * @param n
     */
    public void setValue(int n) {
        if(rank.equalsIgnoreCase("Ace") && (n == 1 || n == 1)) {
            value = n;
        }
    }
}
