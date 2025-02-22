public class HandTester
{
    public static void main(String[] args)
    {
        /**
        *   Create a Hand and a Shoe. 
        * 
        *   Can you draw cards from the shoe and add them to the hand?
        *   Does the size of the Shoe work correctly?
        *   Do all of the Hand methods work correctly when interacting with the Shoe
        */ 
        Shoe s = new Shoe(6);
        Hand h1 = new Hand(s);
        System.out.println("\nShoe remaining: " + s.cardsRemaining());
        System.out.println("Cards Drawn");
        h1.drawCard();
        h1.drawCard();
        System.out.println("\nShoe remaining: " + s.cardsRemaining());
        System.out.println("\n" + h1.toString());
        System.out.println("Blackjack: " + h1.isBlackjack());
        System.out.println("Bust: " + h1.isBust());
        System.out.println(h1.getSum());
        
        h1.clear();
        System.out.println("\nShoe remaining: " + s.cardsRemaining());
        System.out.println("Cards Drawn");
        h1.drawCard();
        h1.drawCard();
        System.out.println("\nShoe remaining: " + s.cardsRemaining());
        System.out.println("\n" + h1.toString());
        System.out.println("Blackjack: " + h1.isBlackjack());
        System.out.println("Bust: " + h1.isBust());
        System.out.println(h1.getSum());
        
        h1.clear();
        System.out.println("\nShoe remaining: " + s.cardsRemaining());
        System.out.println("Cards Drawn");
        h1.drawCard();
        h1.drawCard();
        h1.drawCard();
        h1.drawCard();
        System.out.println("\nShoe remaining: " + s.cardsRemaining());
        System.out.println("\n" + h1.toString());
        System.out.println("Blackjack: " + h1.isBlackjack());
        System.out.println("Bust: " + h1.isBust());
        System.out.println(h1.getSum());
        
        h1.clear();
        System.out.println("\nShoe remaining: " + s.cardsRemaining());
        System.out.println("Cards Drawn");
        h1.drawCard();
        h1.drawCard();
        System.out.println("\nShoe remaining: " + s.cardsRemaining());
        System.out.println("\n" + h1.toString());
        System.out.println("Blackjack: " + h1.isBlackjack());
        System.out.println("Bust: " + h1.isBust());
        System.out.println(h1.getSum());
        
        h1.clear();
        System.out.println("\nShoe remaining: " + s.cardsRemaining());
        System.out.println("Cards Drawn");
        h1.drawCard();
        h1.drawCard();
        System.out.println("\nShoe remaining: " + s.cardsRemaining());
        System.out.println("\n" + h1.toString());
        System.out.println("Blackjack: " + h1.isBlackjack());
        System.out.println("Bust: " + h1.isBust());
        System.out.println(h1.getSum());
        
        h1.clear();
        System.out.println("\nShoe remaining: " + s.cardsRemaining());
        System.out.println("Cards Drawn");
        h1.drawCard();
        h1.drawCard();
        h1.drawCard();
        h1.drawCard();
        System.out.println("\nShoe remaining: " + s.cardsRemaining());
        System.out.println("\n" + h1.toString());
        System.out.println("Blackjack: " + h1.isBlackjack());
        System.out.println("Bust: " + h1.isBust());
        System.out.println(h1.getSum());
    }
}
