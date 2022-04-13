package Cards;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a deck of playing-cards.
 * @jasonzmiller
 */
public class Deck {

    /**
     * A reference to an ArrayList of Card objects.
     * Stores the deck of cards.
     */
    protected ArrayList<Card> cards;

    /**
     * Constructs a standard 52-card deck.
     */
    public Deck(){
        cards = new ArrayList<>();
        // for each suit
        for (int i = 0; i < STANDARD_DECK[0].length; i++){
            // for each value
            for (int j = 0; j < STANDARD_DECK[1].length; j++){
                // create a card of this suit with this value
                cards.add(new Card(STANDARD_DECK[1][j], STANDARD_DECK[0][i]));
            }
        }
    }

    /**
     * Shuffles the cards in this deck.
     * The shuffle works as follows:
     *  - choose two random cards in the deck and swap them
     *  - do as many swaps as there are double amount of cards in the deck
     */
    public void shuffle(){
        Random randomGenerator = new Random();
        int firstCardIndex, secondCardIndex;
        Card temp;
        for (int i = 0; i < cards.size() * 2; i++){
            // get two random index values
            firstCardIndex = randomGenerator.nextInt(cards.size());
            secondCardIndex = randomGenerator.nextInt(cards.size());
            // swap the cards at those index values
            temp = cards.get(firstCardIndex);
            cards.set(firstCardIndex, cards.get(secondCardIndex));
            cards.set(secondCardIndex, temp);
        }
    }

    /**
     * Adds a new card to this deck.
     * @param newCard - a card to be added to this deck.
     */
    public void addCard(Card newCard){
        cards.add(newCard);
    }

    /**
     * Removes the first card in the deck and returns it.
     * @return A reference to the card that was removed.
     */
    public Card removeCard(){
        return cards.remove(0);
    }

    /**
     * Sorts the deck by the values of the cards. Does not sort for suit.
     * Uses a bubble-sort algorithm.
     */
    public void sortByValue(){
        Card temp;
        for (int i = cards.size() - 1; i >= 0; i--){
            for (int j = 0; j <= i - 1; j++){
                if (getPrecedence(cards.get(j).getValue()) > getPrecedence(cards.get(j + 1).getValue())){
                    temp = cards.get(j);
                    cards.set(j, cards.get(j + 1));
                    cards.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Returns the card from the deck at a specified index
     * @param index A specified index.
     * @return A reference to a card at a specified index.
     */
    public Card getCardAtIndex(int index){
        return cards.get(index);
    }

    /**
     * Returns the number of cards in the deck.
     * @return An integer specifying how many cards are in the deck.
     */
    public int getNumberOfCards(){
        return cards.size();
    }

    /**
     * Prints every card in the deck.
     * @return A String literal of every card in the deck.
     */
    @Override
    public String toString(){
        String str = "";
        for (int i = 0; i < cards.size(); i++){
            str += cards.get(i) + "\n";
        }
        return str;
    }

    /**
     * A helper method to establish precedence for sorting the cards by value.
     * Arranges number-cards by their numeric values, then face cards as Jack, Queen, King, Ace.
     * @param value - the value of the card.
     * @return An integer literal representing the precedence of this card value.
     */
    private int getPrecedence(String value){
        // note: break statements not needed due to return statements
        switch (value) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "Jack":
                return 11;
            case "Queen":
                return 12;
            case "King":
                return 13;
            case "Ace":
                return 14;
            default:
                return 0;
        }
    }

    /**
     * Stores the suits and values for a standard deck of playing-cards.
     */
    private final String[][] STANDARD_DECK = {  {"Clubs", "Diamonds", "Hearts", "Spades"},
                                                {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}  };
}
