package Cards;

/**
 * Tests the Deck and Hand classes.
 */
public class DeckAndHandTester {

    /**
     * Begins the program that tests the Deck and Hand classes.
     * @param args A reference to a String array of command-line arguments.
     */
    public static void main(String[] args){
        Deck deck = new Deck();
        System.out.println("Original deck\n" + deck + "\n");
        deck.shuffle();
        System.out.println("Shuffled deck\n" + deck + "\n");
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();
        for (int i = 0; i < 5; i++){
            hand1.addCard(deck.removeCard());
            hand2.addCard(deck.removeCard());
        }
        System.out.println("Deck after dealing\n" + deck + "\n");
        System.out.println("Hand 1:\n" + hand1 + "\n");
        System.out.println("Hand 2:\n" + hand2 + "\n");
        hand1.sortByValue();
        hand2.sortByValue();
        System.out.println("Hand 1 after sorting:\n" + hand1 + "\n");
        System.out.println("Hand 2 after sorting:\n" + hand2 + "\n");
        System.out.println("Hand 1 value: " + hand1.getHandValue());
        System.out.println("Hand 2 value: " + hand2.getHandValue());
    }
}
