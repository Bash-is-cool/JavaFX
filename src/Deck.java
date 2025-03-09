import java.util.*;

/**
 * Creates a standard 52 card deck of Cards. (Does not include Jokers)
 * 
 * @author Alex Silverman
 * @version 1.0.0
 */

public class Deck
{
    private ArrayList<Card> cards;
   
   
    /**
    * Deck() creates a Standard deck of 52 cards. Ace is one but holds the value
    * of 11
    */
    public Deck() {
        cards = new ArrayList<Card>();
        for(int i = 0; i < 4; i++) {
            if(i == 0) {
                for(int j = 1; j < 14; j++) {
                    if(j == 1)
                        cards.add(new Card("♠", "Ace"));
                    else if(j == 11)
                        cards.add(new Card("♠", "Jack"));
                    else if(j == 12)
                        cards.add(new Card("♠", "Queen"));
                    else if(j == 13)
                        cards.add(new Card("♠", "King"));
                    else 
                        cards.add(new Card("♠", String.valueOf(j)));
                }
            } else if(i == 1) {
                for(int j = 1; j < 14; j++) {
                    if(j == 1)
                        cards.add(new Card("♦", "Ace"));
                    else if(j == 11)
                        cards.add(new Card("♦", "Jack"));
                    else if(j == 12)
                        cards.add(new Card("♦", "Queen"));
                    else if(j == 13)
                        cards.add(new Card("♦", "King"));
                    else 
                        cards.add(new Card("♦", String.valueOf(j)));
                }
            } else if(i == 2) {
                for(int j = 13; j > 0; j--) {
                    if(j == 1)
                        cards.add(new Card("♣", "Ace"));
                    else if(j == 11)
                        cards.add(new Card("♣", "Jack"));
                    else if(j == 12)
                        cards.add(new Card("♣", "Queen"));
                    else if(j == 13)
                        cards.add(new Card("♣", "King"));
                    else 
                        cards.add(new Card("♣", String.valueOf(j)));
                }
            } else if(i == 3) {
                for(int j = 13; j > 0; j--) {
                    if(j == 1)
                        cards.add(new Card("♥", "Ace"));
                    else if(j == 11)
                        cards.add(new Card("♥", "Jack"));
                    else if(j == 12)
                        cards.add(new Card("♥", "Queen"));
                    else if(j == 13)
                        cards.add(new Card("♥", "King"));
                    else 
                        cards.add(new Card("♥", String.valueOf(j)));
                }
            }
        }
    }
   
    /**
     * Perfectly shuffles deck, cuts the deck and repeats this process.
     * makes it so that the deck will almost never be the same
     */
    public void shuffle() {
        faro();
        cut();
        faro();
        cut();
        faro();
    }
   
    /**
    * prints out the cards array
    * 
    * @return String result
    */
    public String toString() {
        String result = "[";
        for(int i = 0; i < cards.size(); i++) {
            result += cards.get(i).toString2() + ", ";
        }
        return result + "]";
    }
    
    /**
     * Perfectly shuffles the deck
     */
    public void faro() {
        List<Card> firstHalf = new ArrayList<Card>(cards.subList(0, cards.size() / 2));
        List<Card> secondHalf = new ArrayList<Card>(cards.subList(cards.size() / 2, cards.size()));
        cards.clear();
        for(int i = 0; i < firstHalf.size(); i++) {
            cards.add(firstHalf.get(i));
            cards.add(secondHalf.get(i));
        }
    }
    
    /**
     * Cuts the deck at a random spot in the deck
     */
    public void cut() {
        int rand = (int)(Math.random() * 53);
        List<Card> front = new ArrayList<Card>(cards.subList(rand, cards.size()));
        List<Card> back = new ArrayList<>(cards.subList(0, rand));
        cards.clear();
        cards.addAll(front);
        cards.addAll(back);
    }
    
    /**
     * Draws a card from the top of the deck and removes that card
     * 
     * @return Card c
     */
    public Card drawCard() {
        return cards.remove(0);
    }
    
    /**
     * Gets are the cards back into the deck
     */
    public void reset() {
        cards.clear();
        Deck tempDeck = new Deck();
        cards = tempDeck.getDeck();
    }
    
    public ArrayList<Card> getDeck() {
        return cards;
    }
}
