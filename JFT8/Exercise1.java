package JFT8;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * You have been asked to develop a new computer game called, Card Busters!!!
There are two players playing the game. Both players are given seven cards each.
Here are the values of player one’s cards.
10,6,8,9,7,12,7
Here are the values of player two’s cards.
7,6,9,5,2,8,11
There are seven rounds in the game. Each round, the value of the players’ cards for
that particular round are compared to see who has the highest valued card. The
player with the highest value card wins the round.
For example, in round 1, player one will play a card with a value of 10. Player two will
play a card with a value of 7. Player one wins the round.
If both cards have the same value, it is a tie.
At the end of the game (after seven rounds), the program should determine which
player has won the game overall (won the most rounds) or if the game has ended in a
tie.
Save the program as Exercise1.java.
 */

public class Exercise1 {

    public static void main(String[] args) {
        CardBusters cb = new CardBusters(2, 7);
        int [] p1Cards = {10,6,8,9,7,12,7};
        int [] p2Cards = {7,6,9,5,2,8,11};
        cb.players.get(0).generateCardsFromArray(p1Cards);
        cb.players.get(1).generateCardsFromArray(p2Cards);
        String repeated = new String(new char[20]).replace("\0", "*");
        String header = repeated + " CardBuster Game " + repeated;
        System.out.println(header + "\n");
        
        cb.startGame();

        System.out.println("Goodbye!");

    }
    
}

class Player {
    public String name;
    public ArrayList<Card> cards = new ArrayList<>();
    public int score;

    public Player(String player_name){
        this.name = player_name;
    }

    public void generateCardsFromArray(int [] values){
        for (int card_value : values){
            Card c = new Card(card_value);
            this.cards.add(c);
        }
    }
}

class Card {

    public int value;

    public Card(int card_value){
        this.value = card_value;
    }
}

class CardBusters {

    public int num_players;
    public int cards;
    public ArrayList<Player> players = new ArrayList<>();

    public CardBusters(int players_qtd, int cards_qty) {
    
        this.num_players = players_qtd;
        this.cards = cards_qty;

        while (this.num_players < 2){
            Scanner scanner = new Scanner(System.in);
            System.out.println("The minimum number of players is 2.");
            System.out.println("Please enter the number of players again.");
            int inputPlayers = scanner.nextInt();
            this.num_players = inputPlayers;
            scanner.close();
        }

        for (int i = 0; i < this.num_players; i++){
            String name = "Player" + (i +1);
            Player p = new Player(name);
            p.score = 0;
            this.players.add(p);
        }
    }

    public void givingCards(int [] cards_values){
        for (Player p : this.players){
            p.generateCardsFromArray(cards_values);
        }
    }

    public void startGame(){
        int indexOfWinner = -1;

        for (int i = 0; i < this.cards; i++){
            int indexOfRoundWinner = -1;
            int maxRoundValue = Integer.MIN_VALUE;
            int [] round = new int[this.num_players];

            for (Player p : this.players){
                Card currentCard = p.cards.get(i);
                round[this.players.indexOf(p)] = currentCard.value;
            }

            for (int j = 0; j < round.length; j++) {
                if (round[j] > maxRoundValue) {
                    maxRoundValue = round[j];
                    indexOfRoundWinner = j;
                } else if (round[j] == maxRoundValue) {
                    indexOfRoundWinner = -1;
                }
            }
            
            if (indexOfRoundWinner != -1){
                this.players.get(indexOfRoundWinner).score++;
                System.out.println("Round " + i + ": " + formattingString(round) + "The winner of this round was: " + this.players.get(indexOfRoundWinner).name + ".\n");
            } else {
                System.out.println("Round " + i + ": " + formattingString(round) + "This round resulted in a tie.\n");
            }

            
        }
        int greaterScore = -1;
        for (Player p : this.players){
            if (p.score > greaterScore){
                greaterScore = p.score;
                indexOfWinner = this.players.indexOf(p);
            } else if (p.score == greaterScore){
                indexOfWinner = -1;
            }
        }

        if (indexOfWinner != -1){
            System.out.println("The Winner is " + this.players.get(indexOfWinner).name + " with " + this.players.get(indexOfWinner).score + "pts.\n");
        } else {
            System.out.println("This game resulted in a tie.\n");
        }


    }

    private String formattingString(int [] round){
        String log = "";
        for (Player p : this.players){
            if (this.players.toArray().length > 2){
                if (this.players.indexOf(p) < this.players.toArray().length -2) {
                    log += p.name + " revealed the card " + round[this.players.indexOf(p)] + ", ";
                } else if (this.players.indexOf(p) == this.players.toArray().length -2) {
                    log += p.name + " revealed the card " + round[this.players.indexOf(p)] + " and ";
                } else if (this.players.indexOf(p) == this.players.toArray().length -1) {
                    log += p.name + " revealed the card " + round[this.players.indexOf(p)] + ". ";
                }
            } else {
                if (this.players.indexOf(p) == this.players.toArray().length -2) {
                    log += p.name + " revealed the card " + round[this.players.indexOf(p)] + " and ";
                } else if (this.players.indexOf(p) == this.players.toArray().length -1) {
                    log += p.name + " revealed the card " + round[this.players.indexOf(p)] + ". ";    
                }
            }
        }
        return log;
    }
}