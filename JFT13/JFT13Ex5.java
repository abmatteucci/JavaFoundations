package JFT13;

import java.util.ArrayList;
import java.util.Random;

/*
 * A player is dealt 3 random cards (from a pack of 52) with values ranging from 1-13. The
program should generate the three random cards.
Aces are low in value (1) and Kings are high in value (13). Jokers aren’t played.
The player beats the house if the sum of the 3 cards dealt is less than or equal to 21.
Otherwise, the house wins.
Write a program to simulate the game.
Save your class as JFT13Ex5.java.
 */

public class JFT13Ex5 {

    public static void main(String[] args) {

        CardsPack _cardsPack = new CardsPack();
        _cardsPack.shuffle();
        _cardsPack.startGame();
        
    }
    
}

class Card {

    private static int cardId = -1;
    private int numValue;
    private String value;
    private String symbol;

    public Card(String _symbol, String _value, int _numValue){
        Card.cardId++;
        this.setCardSymbol(_symbol);
        this.setCardValue(_value);
        this.setCardNumValue(_numValue);
    }

    // Statics



    // Getters

    public int getNumValue(){
        return this.numValue;
    }

    public String getCardValue(){
        return this.value;
    }

    public String getCardSymbol(){
        return this.symbol;
    }

    public int getCardId(){
        return Card.cardId;
    }

    // Setters

    public void setCardNumValue(int _numValue){
        this.numValue = _numValue;
    }

    public void setCardValue(String _value){
        this.value = _value;
    }

    public void setCardSymbol(String _symbol){
        this.symbol = _symbol;
    }

    // Methods

    public String toString(){
        return this.getCardValue() + " of " + this.getCardSymbol();
    }

}

class CardsPack {

    public ArrayList<Card> cardsPack;

    public CardsPack(){
        
        ArrayList<Card> cardsPack = new ArrayList<>();

        String [] symbols = {"CLUBS", "HEARTS", "SPADES", "RUMBUS"};
        int [] numValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        String [] values = {"AS", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};

        for (String s : symbols){
            for (int i = 0; i < values.length; i++){
                Card card = new Card(s, values[i], numValues[i]);
                cardsPack.add(card);
            }
        }

        this.cardsPack = cardsPack;

    }

    public void shuffle(){

        ArrayList<Integer> _sortedNumbers = new ArrayList<>();
        ArrayList<Card> _shuffledCards = new ArrayList<>();
        Random rd = new Random();

        if (this.cardsPack.size() > 0){
            System.out.println();
            System.out.printf("Original Cards Pack with: %d%n", this.cardsPack.size());
            while (_shuffledCards.size() < this.cardsPack.size()){
                int _sort = rd.nextInt(this.cardsPack.size() -1);
                if (!_sortedNumbers.contains(_sort)) {
                    _sortedNumbers.add(_sort);
                    _shuffledCards.add(this.cardsPack.get(_sort));
                }
                if (_shuffledCards.size() == 51){
                    for (int i = 1; i < 52; i++){
                        if (!_sortedNumbers.contains(i)){
                            _shuffledCards.add(this.cardsPack.get(i));
                            _sortedNumbers.add(i);
                        }
                    }
                }
                //System.out.printf("Sorted pack size: %d%n", _shuffledCards.size());
            }
            System.out.printf("Shuffled cards pack: %d cards.%n", _shuffledCards.size());
            this.cardsPack = _shuffledCards;
        }
    }

    private ArrayList<Card> hand(){
        ArrayList<Card> _hand = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            Card _card = this.cardsPack.get(i);
            _hand.add(_card);
            this.cardsPack.remove(_card);
        }
        System.out.printf("Remaining cards: %d.%n", this.cardsPack.size());
        return _hand;
    }

    private String getResultMsg(int _points){
        if (_points <= 21){
            return "Victory - You beat the house!";
        } else {
            return "Defeat - house wins!";
        }
    }

    public void startGame(){
        ArrayList<Card> _hand = this.hand();
        int _total = 0;
        for (Card card : _hand){
            System.out.println(card.toString());
            _total += card.getNumValue();
        }
        System.out.printf("Your score is: %d%n", _total);
        System.out.printf("Result - %s%n", getResultMsg(_total));
        
    }

}