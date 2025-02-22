import java.util.*;


/**
 * Creates a virtual shoe like the one used in blackjack
 * 
 * @author Alex Silverman
 * @version 1.0.0
 */
public class Shoe extends Deck
{
    private ArrayList<Card> shoe;
    private int numDecks;
    
    /**
     *Creates a shoe with a given number of decks 
     */
    public Shoe(int d) {
        numDecks = d;
        shoe = new ArrayList<Card>();
        for(int i = 0; i < d; i++){
            Deck deck = new Deck();
            shoe.addAll(deck.getDeck());
        }
        shuffle();
        shuffle();
    }
    
    /**
     * the to string for shoe 
     * 
     * @return String result
     */
    public String toString() {
        String result = "";
        for(int i = 0; i < shoe.size(); i++) {
            result += shoe.get(i) + "\n";
        }
        return result;
    }
    
    /**
     * Gets the shoe
     * 
     * @return ArrayList<Card>
     */
    public ArrayList<Card> getShoe() {
        return shoe;
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
     * Perfectly shuffles the deck
     */
    public void faro() {
        List<Card> firstHalf = new ArrayList<Card>(shoe.subList(0, shoe.size() / 2));
        List<Card> secondHalf = new ArrayList<Card>(shoe.subList(shoe.size() / 2, shoe.size()));
        shoe.clear();
        for(int i = 0; i < firstHalf.size(); i++) {
            shoe.add(firstHalf.get(i));
            shoe.add(secondHalf.get(i));
        }
    }
    
    /**
     * Cuts the deck at a random spot in the deck
     */
    public void cut() {
        int rand = 1 + (int)(Math.random() * cardsRemaining());
        List<Card> front = new ArrayList<Card>(shoe.subList(rand, shoe.size()));
        List<Card> back = new ArrayList<>(shoe.subList(0, rand));
        shoe.clear();
        shoe.addAll(front);
        shoe.addAll(back);
    }
    
    /**
     * Draws a card from the shoe
     */
    public Card drawCard() {
        return shoe.remove(shoe.size() - 1);
    }
    
    /**
     * Retrieves all the cards and reshuffles 
     */
    public void reset() {
        shoe.clear();
        Shoe ts = new Shoe(numDecks);
        shoe = ts.getShoe();
    }
    
    /**
     * gets number of cards left in the shoe
     * 
     * @return int
     */
    public int cardsRemaining() {
        return shoe.size();
    }
    
    
    /**
     * Sees if there is enough cards to play another hand
     */
    public void checkShoe() {
        if(cardsRemaining() < 20) {
            System.out.println("Not enough Cards to play. Reseting the shoe");
            reset();
        }
    }
}
