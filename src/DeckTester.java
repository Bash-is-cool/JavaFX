public class DeckTester
{
   public static void main(String[] args)
   {
       Deck d = new Deck();
       System.out.println(d);
       
       // Standard shuffle
       d.shuffle();
       System.out.println("\nShuffled Deck: ");
       System.out.println("\n" + d);
       
       // Perfect shuffle without cut
       d.faro();
       System.out.println("\nFaro shuffle: ");
       System.out.println("\n" + d);
       
       //Cuts the deck
       d.cut();
       System.out.println("\nCut Deck: ");
       System.out.println("\n" + d);
       
       //Card draw test
       Card c1 = d.drawCard();
       System.out.println("\nCard Drawn: ");
       System.out.println("\n" + c1);
       
       System.out.println("\nRest of the Deck: ");
       System.out.println("\n" + d);
       
       // Test to reset deck
       d.reset();
       System.out.println("\nReset of the Deck: ");
       System.out.println("\n" + d);
       
       // shuffle the reset deck
       d.shuffle();
       System.out.println("\nShuffled Deck: ");
       System.out.println("\n" + d);
   }
}
