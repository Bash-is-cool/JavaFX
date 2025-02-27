import java.util.*;

 class Game
{
    public static void main(String[] args)
    {
        // Start here!
        Shoe shoe = new Shoe(6);
        Dealer d = new Dealer(shoe);
        d.start();
    }
}
