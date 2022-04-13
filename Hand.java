package Cards;

import java.util.ArrayList;

/**
 * Represents a hand of cards. Extends the Deck class.
 * @author jasonzmiller
 */
public class Hand extends Deck {

    /**
     * Constructs a new hand with no cards.
     */
    public Hand(){
        cards = new ArrayList<>();
    }

    /**
     * Returns the value of this hand.
     * If the hand totals to more than 21, any aces are treated as 1's.
     * @return An integer specifying the value of the hand.
     */
    public int getHandValue(){
        int value = 0, numberOfAces = 0;
        for (int i = 0; i < cards.size(); i++){
            value += getCardValue(cards.get(i).getValue());
            if (getCardValue(cards.get(i).getValue()) == 11){
                numberOfAces++;
            }
        }
        if (value > 21 && numberOfAces > 0){
            value -= 10 * numberOfAces;
        }
        return value;
    }

    /**
     * Returns the numeric value of a card.
     * @param value A String representation of the card value.
     * @return An integer specifying the card's numeric value.
     */
    private int getCardValue(String value){
        // note: enhanced "switch" statement
        return switch (value) {
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            case "6" -> 6;
            case "7" -> 7;
            case "8" -> 8;
            case "9" -> 9;
            case "10", "Queen", "Jack", "King" -> 10;
            case "Ace" -> 11;
            default -> 0;
        };
    }
}
