
import java.util.*;

public class Hand
{
    ArrayList<Card> hand;
    Shoe shoe;
    
    /**
     * Constructs a Hand which initalizes an ArrayList<Card>
     */
    public Hand(Shoe s) {
        hand = new ArrayList<Card>();
        shoe = s;
    }
    
    /**
     * Adds all the cards together and checks for aces. aces will only change
     * if the sum is greater than 21
     * 
     * @return int sum
     */
    public int getSum() {
        int sum = 0;
        int aceCount = 0;
        for(Card c : hand) {
            sum += c.getValue();
            if(c.getRank().equalsIgnoreCase("Ace")) {
                aceCount++;
            }
        }
        
        for(Card c : hand) {
            if(sum > 21 && aceCount > 0) {
                c.setValue(1);
                sum -= 10;
            }
        }
        return sum;
    }
    
    /**
     * Returns the number of cards in the hand.
     * 
     * @return int hand.size()
     */
    public int getNumCards() {
        return hand.size();
    }
    
    /**
     * Checks the requirements for a blackjack (2 cards and sum is 21)
     * 
     * @return boolean isBlackjack
     */
    public boolean isBlackjack() {
        if(getNumCards() == 2 && getSum() == 21)
            return true;
        else
            return false;
    }
    
    /**
     * Clears all cards from the hand so new cards can be dealt
     */
    public void clear() {
        hand.clear();
    }
    
    /**
     * Returns the ArrayList hand for use in other classes
     * 
     * @return ArrayList<Card> hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    /**
     * Adds a card to the hand
     */
    public void addCard(Card c) {
        hand.add(c);
    }
    
    /**
     * Checks to see if the hand busts (hand > 21)
     * 
     * @return boolean isBust
     */
    public boolean isBust() {
        if(getSum() > 21) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * The toString for the hand.
     * 
     * @return String result
     */
    public String toString() {
        String result = "";
        for(Card c : hand) {
            result += c.toString2() + "\n";
        }
        return result;
    }
    
    public void drawCard() {
        addCard(shoe.drawCard());
    }
}
