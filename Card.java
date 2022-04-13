package Cards;

/**
 * Represents a card in a deck of playing-cards.
 * @author jasonzmiller
 */
public class Card {

    /**
     * A reference to a String literal.
     * Used to store the value of this card.
     * Value can be:
     *  - 2 - 10
     *  - jack
     *  - queen
     *  - king
     *  - ace
     */
    private String value;

    /**
     * A reference to a String literal.
     * Used to store the suit of this card.
     * Suit can be:
     *  - clubs
     *  - diamonds
     *  - hearts
     *  - spades
     */
    private String suit;

    /**
     * Constructs a new Card with a specified value and suit.
     * @param value - a String literal specifying the value of the card.
     * @param suit - a String literal specifying the suit of the card.
     */
    public Card(String value, String suit){
        this.value = value;
        this.suit = suit;
    }

    /**
     * Returns the value of this card.
     * @return A String literal specifying the value of this card.
     */
    public String getValue(){
        return value;
    }

    /**
     * Sets the value of this card.
     * Value can be:
     *  - 2 - 10
     *  - jack
     *  - queen
     *  - king
     *  - ace
     * @param value - a String literal specifying the value to be changed to.
     */
    public void setValue(String value){
        this.value = value;
    }

    /**
     * Returns the suit of this card.
     * @return A String literal specifying the suit of this card.
     */
    public String getSuit(){
        return suit;
    }

    /**
     * Sets the suit of this card.
     * Suit can be:
     *  - clubs
     *  - diamonds
     *  - hearts
     *  - spades
     * @param suit - a String literal specifying the suit to be changed to.
     */
    public void setSuit(String suit){
        this.suit = suit;
    }

    /**
     * Returns a description of this card.
     * Specifies the value and the suit.
     * Example formatted description: "ace of spaces"
     * @return A String literal specifying the details of this card.
     */
    @Override
    public String toString(){
        return "(" + value + ", " + suit + ")";
    }
}
