public class ShoeTester
{
    public static void main(String[] args)
    {
        // Start here!
        Shoe s = new Shoe(2);
        
        // Prints 2 decks in the shoe, pre shuffled
        System.out.println(s.toString());
        System.out.println(s.cardsRemaining());
        
        // Draws card
        Card c1 = s.drawCard();
        System.out.println("\n\n" + s.cardsRemaining());
        System.out.println("\n\nCard Drawn:");
        System.out.println("\n" + c1.toString());
        
        // Prints 2 after card is taken
        System.out.println("\n\nRest of the Deck: ");
        System.out.println(s.toString());
        
        // retrieves all the cards and re shufffles
        System.out.println("\n\nReset deck: ");
        s.reset();
        System.out.println(s.toString());
        System.out.println(s.cardsRemaining());
        
        // Takes all cards out of the shoe
        while(s.cardsRemaining() > 0) {
            Card c = s.drawCard();
            System.out.println("\n\n" + c);
        }
        
        // Checks to make sure the shoe is empty
        System.out.println("\n" + s.cardsRemaining());
        
        // Checks to see if there is enough cards to draw
        s.checkShoe();
        
        System.out.println(s);
        
        // Sees if shoe is reset
        Card c2 = s.drawCard();
        System.out.println("\n\n" + c2 + "\n\n");
        
        System.out.println(s);
        
        s.reset();
        System.out.println(s.toString());
        s.cut();
        System.out.println("\n\n" + s.toString());
    }
}
