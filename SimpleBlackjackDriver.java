package Cards;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A simple game of blackjack in which a single user can play a computer dealer.
 * The computer plays according to standard house rules.
 */
public class SimpleBlackjackDriver {

    /**
     * Starts a simple game of blackjack.
     * @param args A reference to a String array containing command-line arguments.
     */
    public static void main(String[] args){
        // welcome user to the game
        System.out.println("Welcome to the game of blackjack!");
        Scanner mainKeyboard = new Scanner(System.in);
        String input;
        boolean endGame = true, endRound;
        while (endGame){
            endRound = startRound();
            displayWinner(endRound);
            System.out.println("Enter 'yes' to play another round. Enter anything else to end the game.");
            input = mainKeyboard.nextLine();
            if (!input.equalsIgnoreCase("yes")) {
                endGame = false;
            }
        }
        mainKeyboard.close();
    }

    /**
     * Starts round.
     * @return A boolean specifying whether or not the player won.
     */
    public static boolean startRound(){
        Scanner keyboard = new Scanner(System.in);
        // create deck & shuffle it
        Deck deck = new Deck();
        deck.shuffle();
        // create hands for player and for dealer
        Hand player = new Hand();
        Hand dealer = new Hand();
        // deal two cards to the player and dealer, alternating
        for (int i = 0; i < 2; i++){
            player.addCard(deck.removeCard());
            dealer.addCard(deck.removeCard());
        }
        // display cards
        System.out.println("\nPlayer's cards:\n" + player);
        System.out.println("Dealer's showing-card:\n" + dealer.getCardAtIndex(1) + "\n"); // show only second card dealt to dealer
        // if player has 21, end round
        if (player.getHandValue() == 21){
            return true;
        }
        boolean continuePlayerTurn, continueDealerTurn, inputCheck;
        String input = "";
        int numberOfPlayerStands = 0;
        Card newCard;
        while (true) {
            continuePlayerTurn = true;
            // begin player's turn
            while (continuePlayerTurn) {
                inputCheck = false;
                while (!inputCheck) {
                    try {
                        System.out.print("\nPlease enter 'hit' or 'stand': ");
                        input = keyboard.nextLine();
                        if (input.equalsIgnoreCase("hit") || input.equalsIgnoreCase("stand")){
                            inputCheck = true; // will reach here if input is correct
                        }
                        else {
                            System.out.println("Please enter a valid input.");
                        }
                    }
                    catch (InputMismatchException e){
                        System.out.println("Please enter a valid input.");
                    }
                }
                // if user enters 'stand', end turn
                if (input.equalsIgnoreCase("stand")){
                    continuePlayerTurn = false;
                    numberOfPlayerStands++;
                }
                // if user enters 'hit'
                else {
                    newCard = deck.removeCard();
                    player.addCard(newCard);
                    System.out.println("\nYou have drawn a(n) " + newCard);
                    System.out.println("\nPlayer's cards:\n" + player);
                    // if player has 21, end round - return true
                    if (player.getHandValue() == 21){
                        return true;
                    }
                    // if player's cards total more than 21, end round - return false
                    if (player.getHandValue() > 21){
                        System.out.println("\nDealer's cards:\n" + dealer);
                        return false;
                    }
                }
                // if player stands twice, check winner and end round
                if (numberOfPlayerStands > 1){
                    System.out.println("\nPlayer's cards:\n" + player);
                    System.out.println("Dealer's cards:\n" + dealer);
                    if (player.getHandValue() > dealer.getHandValue()){
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
            // begin dealer's turn
            continueDealerTurn = true;
            while (continueDealerTurn){
                if (dealer.getHandValue() <= 16){
                    newCard = deck.removeCard();
                    dealer.addCard(newCard);
                    System.out.println("\nDealer has drawn a(n) " + newCard);
                }
                if (dealer.getHandValue() > 16 && dealer.getHandValue() <= 21){
                    System.out.println("\nDealer stands.");
                    continueDealerTurn = false;
                }
                if (dealer.getHandValue() > 21){
                    System.out.println("\nDealer's cards:\n" + dealer);
                    return true;
                }
            }

        }
    }

    /**
     * Displays the result of the game to standard out.
     * @param endRound A boolean specifying if the player has won.
     */
    private static void displayWinner(boolean endRound){
        if (endRound){
            System.out.println("Congratulations! You won.\n");
        }
        else{
            System.out.println("The dealer has won.\n");
        }
    }
}
