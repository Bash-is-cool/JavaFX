import java.util.*;

/**
 * Dealer runs the game of blackjack. 
 * 
 * @author Alex Silverman
 * @version 1.0.0
 */
public class Dealer
{
    private Shoe s;
    private ArrayList<Player> players;
    private Hand hand;
    private int numPlayers;
    private int bet;
    
    /**
     * Constructor for Dealer.
     * 
     *@param shoe
     */
    public Dealer(Shoe shoe) {
        s = shoe;
        players = new ArrayList<Player>();
        hand = new Hand();
    }
    
    /**
     * gives a card from the shoe to the player
     * of Dealers hand
     */
    public void giveCard(Player p) {
        p.getHand().addCard(s.drawCard());
    }
    
    /**
     * adds a card to the dealers hand
     */
    public void hit() {
        hand.addCard(s.drawCard());
    }
    
    /**
     * Deals the cards in the proper order (players, then dealer)
     */
    public void deal() {
        for(int j = 0; j < 2; j++) {
            for(int i = 0; i < players.size(); i++) {
                giveCard(players.get(i));
            }
            hit();
        }
    }
    
    /**
     * toString for the dealer. Only shows the second card that was
     * dealt to him
     * 
     * @return String
     */
    public String toString() {
        return hand.getHand().get(1).toString() + "\n";
    }
    
    /**
     * Adds a player to the game
     */
    public void addPlayer(Player p) {
        players.add(p);
    }
    
    /**
     * Starts the game by asking the amount of players, name of players
     * how much money each player has, gets their initial bets and starts
     * the round
     */
    public void start() {
        Scanner s = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome to Blackjack! How many players Are Playing?");
        int numPlayers = 0;
        while(true) {
            if(s.hasNextInt()) {
                numPlayers = s.nextInt();
                s.nextLine();
                    if(numPlayers > 0 && numPlayers < 6) {
                        break;
                    } else {
                        System.out.println("Enter a valid number of players (at least one and less than 6)");
                    }
                } else {
                    System.out.println("Invalid input. Please enter an Integer.");
                    s.nextLine();
                }
            this.numPlayers = numPlayers;
        }
        
        for(int i = 0; i < numPlayers; i++) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("What is player " + (i + 1) + "'s name?");
            String name = s.nextLine();
            System.out.println("How much money does " + name + " have? (Need at least $10)");
            System.out.print("$");
            int bankroll = 0;
            z: while(true) {
                if(s.hasNextInt()) {
                    bankroll = s.nextInt();
                    s.nextLine();
                    if(bankroll % 2 == 0 && bankroll >= 10) {
                       break z;
                    } else {
                        System.out.println("Invalid Amount. Enter an integer greater than 10 and that the number % 2 == 0 and less than 2147483640");
                        System.out.print("$");
                    }
                } else {
                    System.out.println("Invalid Amount. Enter an integer greater than 10 and that the number % 2 == 0 and less than 2147483640");
                    System.out.print("$");
                    s.nextLine();
                }
            }
            Player p = new Player(name, bankroll);
            addPlayer(p);
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Let's Play Blackjack!");
        System.out.println("Payout is 3:2");
        sleep(2000);
        playerBet();
    }
    
    /**
     * Plays a round of blackjack. Players can hit, stay, or double
     * (if they can double). Starts dealer round after all players 
     * have gone
     */
    public void round() {
        for(int i = 0; i < players.size(); i++) {
            int cardsGiven = 0;
            Scanner s = new Scanner(System.in);
            y: while(true) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Dealer's Showing " + toString() + "\n");
                System.out.println(players.get(i).getName() + ", what would you like to do?\n");
                System.out.println("Your bet: " + players.get(i).getBet());
                System.out.println("Your Hand:\n" + players.get(i).getHand().toString());
                System.out.println("Total: " + players.get(i).getHand().getSum());
                if(players.get(i).getHand().isBlackjack() == true) {
                    System.out.println("You have Blackjack!");
                    sleep(3000);
                    break y;
                } else if(players.get(i).getHand().isBust() == true) {
                    System.out.println("You busted with " + players.get(i).getHand().getSum());
                    sleep(3000);
                    break y;
                } else if(hand.getHand().get(1).getRank().equalsIgnoreCase("Ace")) {
                    if(hand.isBlackjack()) {
                        System.out.println("Dealer Has Blackjack.");
                        payout();
                    }
                }
                
                if(cardsGiven > 0 && players.get(i).getBet() + players.get(i).getBet() > players.get(i).getBank()) {
                    System.out.println("\t(H)it\t(S)tay");
                } else {
                    System.out.println("\t(H)it\t(S)tay\t(D)ouble");
                }
                
                String choice = s.nextLine().trim();
                
                if(choice.equalsIgnoreCase("H") || choice.equalsIgnoreCase("Hit")) {
                    giveCard(players.get(i));
                    cardsGiven++;
                } else if(choice.equalsIgnoreCase("S") || choice.equalsIgnoreCase("Stay")) {
                    break y;
                } else if(choice.equalsIgnoreCase("D") || choice.equalsIgnoreCase("Double")) {
                    if(cardsGiven == 0 && players.get(i).getBank() >= bet * 2) {
                        players.get(i).doubleMoney();
                        giveCard(players.get(i));
                        System.out.println("Your bet: $" + players.get(i).getBet());
                        System.out.println("Your final hand:\n" + players.get(i).toString());
                        System.out.println("Total: " + players.get(i).getHand().getSum());
                        sleep(3000);
                        break y;
                    } else {
                        System.out.println("Unable to double.");
                        sleep(2000);
                    }
                } else {
                    System.out.println("Invalid Input. Please try again");
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
            }
        }
        dealerRound();
    }
    
    /**
     * Takes a turn for the dealer. Hits until 17
     */
    public void dealerRound() {
        do {
            if(hand.getSum() < 17) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Dealer's Hand:");
                System.out.println(hand.toString());
                System.out.println("Total: " + hand.getSum());
                sleep(2000);
                hit();
            }
        } while(hand.getSum() < 17);
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Dealer's Hand:");
        System.out.println(hand.toString());
        System.out.println("Total: " + hand.getSum());
        sleep(2000);
        payout();
    }
    
    /**
     * Pays the players based on how the round went.
     * If player has Blackjack - 3:2
     * If Player beats Dealer - 2:1
     * If player busts - 0
     * If Dealer beats player - 0
     * 
     */
    public void payout() {
        for(Player p : players) {
            int playerSum = p.getHand().getSum();
            int dealerSum = hand.getSum();
            int bet = p.getBet();
            if(p.getHand().isBlackjack() && !hand.isBlackjack()) {
                int winnings = (int)(bet * 1.5);
                System.out.println(p.getName() + " wins with Blackjack! Payout: $" + winnings);
                p.addMoney(winnings);
                sleep(3000);
            } else if(p.getHand().isBust()) {
                System.out.println(p.getName() + " busted and lost the bet of $" + bet);
                sleep(3000);
            } else if(hand.isBust() || playerSum > dealerSum) {
                int winnings = bet * 2;
                p.addMoney(winnings);
                System.out.println(p.getName() + " wins! Payout: $" + winnings);
                sleep(3000);
            } else if(playerSum == dealerSum) {
                p.addMoney(bet);
                System.out.println(p.getName() + " pushes.");
                sleep(3000);
            } else if(dealerSum > playerSum && !hand.isBust()) {
                System.out.println("Dealer beats " + p.getName());
                sleep(3000);
            }
        }
        playAgain();
    }
    
    /**
     * Sleeps for a given amount of time
     *
     * @param m
     */
    public void sleep(int m) {
        try {
            Thread.sleep(m);
        } catch(Exception ignored) {
            
        }
    }
    
    /**
     * Allows the players to bet. Checks to see if they have enough money
     */
    public void playerBet() {
        Scanner s = new Scanner(System.in);
        for(int i = 0; i < players.size(); i++) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Your Money: " + players.get(i).getBank());
            System.out.print(players.get(i).getName() + ", place a bet.\n$");
            w: while(true) {
                if(s.hasNextInt()) {
                    bet = s.nextInt();
                    s.nextLine();
                    if(bet >= 10 && (bet % 2 == 0 || bet % 5 == 0) && bet <= players.get(i).getBank()) {
                        players.get(i).placeBet(bet);
                        break w;
                    } else {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Please try Again.\n");
                        System.out.println(players.get(i).getName() + ", place a bet.");
                        System.out.print("$");
                    }
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Invalid Input. Please try again");
                    System.out.println("Your Money: " + players.get(i).getBank());
                    System.out.println(players.get(i).getName() + ", place a bet.");
                    System.out.print("$");
                    s.nextLine();
                }
            }
        }
        deal();
        round();
    }
    
    /**
     * Gives the players an option to play again given they have enough money
     */
    public void playAgain() {
        Scanner s = new Scanner(System.in);
        for(int i = 0; i < players.size(); i++) {
            String response = "";
            System.out.print("\033[H\033[2J");
            System.out.flush();
            w: while(true) {
                if(players.get(i).getBank() == 0) {
                    System.out.println("You are out of money. The Casino has asked you to leave.");
                    sleep(2000);
                    players.remove(i);
                    i--;
                    break w;
                }
                System.out.println(players.get(i).getName() + " play again?\n\t(Y)es\t\t(N)o");
                
                if(s.hasNextLine()) {
                    response = s.nextLine();
                    if(response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes")) {
                        System.out.println("Nice!");
                        sleep(2000);
                        break w;
                    } else if(response.equalsIgnoreCase("N") || response.equalsIgnoreCase("no")) {
                        System.out.println("Thanks For Playing!");
                        sleep(2000);
                        players.remove(i);
                        i--;
                        break w;
                    } else {
                        System.out.println("Invalid Input. Please try again");
                    }
                } else {
                    System.out.println("Invalid Input. Please try again");
                }
            }
        }
        if(players.size() != 0) {
            resetHand();
            playerBet();
        } else {
            System.exit(0);
        }
    }
    
    /**
     * clears everybodys hand including the dealer
     */
    public void resetHand() {
        for(int i = 0; i < players.size(); i++) {
            players.get(i).getHand().clear();
        }
        hand.clear();
    }
}
