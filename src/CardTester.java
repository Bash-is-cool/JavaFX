public class CardTester
{
    public static void main(String[] args)
    {
        Card c1 = new Card("Hearts", "3");
        System.out.println(c1.getValue());
        System.out.println(c1.getSuit());
        System.out.println(c1.toString());
        Card c2 = new Card("Diamonds", "King");
        System.out.println(c2.getValue());
        System.out.println(c2.getSuit());
        System.out.println(c2.toString());
        Card c3 = new Card("Clubs", "Ace");
        System.out.println(c3.getValue());
        System.out.println(c3.getSuit());
        System.out.println(c3.toString());
        Card c4 = new Card("Spades", "Queen");
        System.out.println(c4.getValue());
        System.out.println(c4.getSuit());
        System.out.println(c4.toString());
    }
}
