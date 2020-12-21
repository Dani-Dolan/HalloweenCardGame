/*
Halloween Spooktacular Card Game
10/31/2019
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class CardGameHalloween {
    public static void main(String[] args) {
        String[] SUITS= { //declaring suits of cards
                "D", "H", "C", "S"
        };
//Ranks of cards had to be numbers in order to parse
        String[] RANKS = { //declaring rank of card
                "14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2"
        };
        int n= SUITS.length*RANKS.length;//integer n establishes array dimensions for deck
        String[]deck=new String[n];
        for (int i=0;i<RANKS.length;i++){
            for (int j=0;j<SUITS.length;j++){
                deck[SUITS.length*i+j]=RANKS[i]+" "+SUITS[j];
            }
        }
        for (int i=0; i<n;i++) {
//Auto Shuffle
            int r=i+(int)(Math.random()*(n-i));
            String temp=deck[r];deck[r]=deck[i];
            deck[i]=temp;
        }
        ArrayList<String> Deck = new ArrayList<String>();
        for (int i = 0 ;i < deck.length ; i++) {
            Deck.add(deck[i]);
        }
        ArrayList<String> p1Hand = new ArrayList<String>(); //declaring other players hands
        ArrayList<String> p2Hand = new ArrayList<String>();
        ArrayList<String> p3Hand = new ArrayList<String>();
        ArrayList<String> p4Hand = new ArrayList<String>();
        p1Hand = handInt(Deck, p1Hand); //each of players hand from the shuffleddeck
        p2Hand = handInt(Deck, p2Hand);
        p3Hand = handInt(Deck, p3Hand);
        p4Hand = handInt(Deck, p4Hand);
        Scanner input = new Scanner(System.in);
        String jack;
        String ace;
        String nextItem;
        String currentCard;
        System.out.println("\nHi! Lets play a game!");
        System.out.println("Rules of the Halloween Spooktacular Game!:");
        System.out.println("*********************************************");
        System.out.println("1. You must play a card of the same suit or play a card that is one higher than the top card of the discard pile");
                System.out.println("2.If a player pulls an 11 ,which is a Jack, pull two extra cards and type Boo");
                        System.out.println("3.When a player has multiple of the same number or face card they can put all in the discard pile");
                                System.out.println("4.When a player has one card left in their hand they must type pumpkin to continue playing");
        System.out.println("5.Must run out of cards to win the game!");
        System.out.println("**********************************************");
        currentCard = Deck.get(0);
        currentCard = Deck.remove(0);
        while (p1Hand.size() > 0 && p2Hand.size() > 0 && p3Hand.size() > 0 && p4Hand.size() > 0) {
            currentCard = playerTurn1(currentCard, Deck, p1Hand);
        }//end while

//Code to type pumpkin when 1 card is left in hand
        boolean correctInput = false;
//while (!correctInput){
        while (p1Hand.size() == 1){ //when size of hand is one type pumpkin to continue playing
            String userPumpkin = input.nextLine();
            if (userPumpkin.toLowerCase().contains("pumpkin")){
                correctInput = true;
            }else {
                p1Hand.add(Deck.get(0)); //add cards
                Deck.remove(0); //remove card (jack)
            }
        }
    }//end main
    public static String playerTurn1(String currCard, ArrayList<String> Deck, ArrayList<String>
            pHand){
        while (true) {
            Scanner input = new Scanner(System.in);
            String[] currArr = currCard.split(" ");
            int currentNum = Integer.parseInt(currArr[0]);
            System.out.println("Your hand is: ");
            System.out.println(pHand); //hand of player
            System.out.println("");
            System.out.println("The current card is: ");
            System.out.println(currCard); //current cards in hand
            System.out.println("Play the card you want to play (please type exactly as shown above) or type \"add\": ");
            String userCard = input.nextLine();
            if (userCard.equals("add")){ //next lines of code had to be added to add more cards to hand, had to copy and paste so player could add cards to hand more than once in a game

                        pHand.add(Deck.get(0));
                if (Deck.get(0).contains("11")){ //Jack =11 so if draw a Jack then type Boo
                    Deck.remove(0);
                    System.out.println("\n" + pHand);
                    System.out.println("Uh oh! You got an 11 (a Jack). \nType \"Boo\" to get your extra two cards!");
                    String userBoo = input.nextLine();
                    if (userBoo.toLowerCase().contains("boo")){
                        pHand.add(Deck.get(0));
                        Deck.remove(0);
                        pHand.add(Deck.get(0));
                    }//end if
                }//end if
                Deck.remove(0);
                System.out.println("Your hand is: ");
                System.out.println(pHand);
                System.out.println("The current card is: ");
                System.out.println(currCard);
                System.out.println("Play the card you want to play (please type exactly as shown above) or type \"add\": ");
                userCard = input.nextLine();
            }//end if
            if (userCard.equals("add")){
                pHand.add(Deck.get(0));
                if (Deck.get(0).contains("11")){
                    Deck.remove(0);
                    System.out.println("\n" + pHand);
                    System.out.println("Uh oh! You got an 11 (a Jack). \nType \"Boo\" to get your extra two cards!");
                    String userBoo = input.nextLine();
                    if (userBoo.toLowerCase().contains("boo")){
                        pHand.add(Deck.get(0));
                        Deck.remove(0);
                        pHand.add(Deck.get(0));
                    }//end if
                }//end if
                Deck.remove(0);
                System.out.println("Your hand is: ");
                System.out.println(pHand);
                System.out.println("The current card is: ");
                System.out.println(currCard);
                System.out.println("Play the card you want to play (please type exactly as shown above) or type \"add\": ");
                userCard = input.nextLine();
            }//end if
            if (userCard.equals("add")){
                pHand.add(Deck.get(0));
                if (Deck.get(0).contains("11")){
                    Deck.remove(0);
                    System.out.println("\n" + pHand);
                    System.out.println("Uh oh! You got an 11 (a Jack). \nType \"Boo\" to get your extra two cards!");
                    String userBoo = input.nextLine();
                    if (userBoo.toLowerCase().contains("boo")){
                        pHand.add(Deck.get(0));
                        Deck.remove(0);
                        pHand.add(Deck.get(0));
                    }//end if
                }//end if
                Deck.remove(0);
                System.out.println("Your hand is: ");
                System.out.println(pHand);
                System.out.println("The current card is: ");
                System.out.println(currCard);
                System.out.println("Play the card you want to play (please type exactly as shown above) or type \"add\": ");
                userCard = input.nextLine();
            }//end if
            if (userCard.equals("add")){
                pHand.add(Deck.get(0));
                if (Deck.get(0).contains("11")){
                    Deck.remove(0);
                    System.out.println("\n" + pHand);
                    System.out.println("Uh oh! You got an 11 (a Jack). \nType \"Boo\" to get your extra two cards!");
                    String userBoo = input.nextLine();
                    if (userBoo.toLowerCase().contains("boo")){
                        pHand.add(Deck.get(0));
                        Deck.remove(0);
                        pHand.add(Deck.get(0));
                    }//end if
                }//end if
                Deck.remove(0);
                System.out.println("Your hand is: ");
                System.out.println(pHand);
                System.out.println("The current card is: ");
                System.out.println(currCard);
                System.out.println("Play the card you want to play (please type exactly as shown above) or type \"add\": ");
                userCard = input.nextLine();
            }//end if
            if (userCard.equals("add")){
                pHand.add(Deck.get(0));
                if (Deck.get(0).contains("11")){
                    Deck.remove(0);
                    System.out.println("\n" + pHand);
                    System.out.println("Uh oh! You got an 11 (a Jack). \nType \"Boo\" to get your extra two cards!");
                    String userBoo = input.nextLine();
                    if (userBoo.toLowerCase().contains("boo")){
                        pHand.add(Deck.get(0));
                        Deck.remove(0);
                        pHand.add(Deck.get(0));
                    }//end if
                }//end if
                Deck.remove(0);
                System.out.println("Your hand is: ");
                System.out.println(pHand);
                System.out.println("The current card is: ");
                System.out.println(currCard);
                System.out.println("Play the card you want to play (please type exactly as shown above) or type \"add\": ");
                userCard = input.nextLine();
            }//end if
            if (userCard.equals("add")){
                pHand.add(Deck.get(0));
                if (Deck.get(0).contains("11")){
                    Deck.remove(0);
                    System.out.println("\n" + pHand);
                    System.out.println("Uh oh! You got an 11 (a Jack). \nType \"Boo\" to get your extra two cards!");
                    String userBoo = input.nextLine();
                    if (userBoo.toLowerCase().contains("boo")){
                        pHand.add(Deck.get(0));
                        Deck.remove(0);
                        pHand.add(Deck.get(0));
                    }//end if
                }//end if
                Deck.remove(0);
                System.out.println("Your hand is: ");
                System.out.println(pHand);
                System.out.println("The current card is: ");
                System.out.println(currCard);
                System.out.println("Play the card you want to play (please type exactly as shown above) or type \"add\": ");
                userCard = input.nextLine();
            }//end if
            if (userCard.equals("add")){
                pHand.add(Deck.get(0));
                if (Deck.get(0).contains("11")){
                    Deck.remove(0);
                    System.out.println("\n" + pHand);
                    System.out.println("Uh oh! You got an 11 (a Jack). \nType \"Boo\" to get your extra two cards!");
                    String userBoo = input.nextLine();
                    if (userBoo.toLowerCase().contains("boo")){
                        pHand.add(Deck.get(0));
                        Deck.remove(0);
                        pHand.add(Deck.get(0));
                    }//end if
                }//end if
                Deck.remove(0);
                System.out.println("Your hand is: ");
                System.out.println(pHand);
                System.out.println("The current card is: ");
                System.out.println(currCard);
                System.out.println("Play the card you want to play (please type exactly as shown above) or type \"add\": ");
                userCard = input.nextLine();
            }//end if
            if (userCard.equals("add")){
                pHand.add(Deck.get(0));
                if (Deck.get(0).contains("11")){
                    Deck.remove(0);
                    System.out.println("\n" + pHand);
                    System.out.println("Uh oh! You got an 11 (a Jack). \nType \"Boo\" to get your extra two cards!");
                    String userBoo = input.nextLine();
                    if (userBoo.toLowerCase().contains("boo")){
                        pHand.add(Deck.get(0));
                        Deck.remove(0);
                        pHand.add(Deck.get(0));
                    }//end if
                }//end if
                Deck.remove(0);
                System.out.println("Your hand is: ");
                System.out.println(pHand);
                for (String s : Arrays.asList("The current card is: ", currCard, "Play the card you want to play (please type exactly as shown above) or type \"add\": ")) {
                    System.out.println(s);
                }
                userCard = input.nextLine();
            }//end if
            if (userCard.equals("add")){
                pHand.add(Deck.get(0));
                if (Deck.get(0).contains("11")){
                    Deck.remove(0);
                    System.out.println("\n" + pHand);
                    System.out.println("Uh oh! You got an 11 (a Jack). \nType \"Boo\" to get your extra two cards!");
                    String userBoo = input.nextLine();
                    if (userBoo.toLowerCase().contains("boo")){
                        pHand.add(Deck.get(0));
                        Deck.remove(0);
                        pHand.add(Deck.get(0));
                    }//end if
                }//end if
                Deck.remove(0);
                System.out.println("Your hand is: ");
                System.out.println(pHand);
                System.out.println("The current card is: ");
                System.out.println(currCard);
                System.out.println("Play the card you want to play (please type exactly as shown above) or type \"add\": ");
                userCard = input.nextLine();
            }//end if
            String[] userArr = userCard.split(" "); //only lets you play cards that are either same suit or one higher
            int cardVal = Integer.parseInt(userArr[0]);
            if ((cardVal == currentNum + 1) || (currentNum == 14 && cardVal == 2)) {
                try {
                    currCard = pHand.get(pHand.indexOf(userCard));
                    pHand.remove(pHand.indexOf(userCard));
                    return currCard;
                }//end try
                catch(Exception e) {
                    System.out.println("\nError. Must play a card in your hand.\n");
                }//end catch
            }//end if
            else if (userArr[userArr.length-1].equals(currArr[currArr.length-1])) {
                try {
                    currCard = pHand.get(pHand.indexOf(userCard));
                    pHand.remove(pHand.indexOf(userCard));
                    return currCard;
                }//end try
                catch(Exception e) {
                    System.out.println("\nError. Must play a card in your hand.\n");
                }//end catch
            }//end else if
            if ((cardVal == currentNum + 1) || (currentNum == 14 && cardVal == 2)) {
                try {
                    currCard = pHand.get(pHand.indexOf(userCard));
                    pHand.remove(pHand.indexOf(userCard));
                    return currCard;
                }//end try
                catch(Exception e) {
                    System.out.println("\nError. Must play a card in your hand.\n");
                }//end catch
            }//end if
            else if (userArr[userArr.length-1].equals(currArr[currArr.length-1])) {
                try {
                    currCard = pHand.get(pHand.indexOf(userCard));
                    pHand.remove(pHand.indexOf(userCard));
                    return currCard;
                }//end try
                catch(Exception e) {
                    System.out.println("\nError. Must play a card in your hand.\n");
                }//end catch
            }//end else if
        }//end while
    }//end playerTurn1
    public static ArrayList<String> handInt(ArrayList<String> Deck, ArrayList<String> pHand){
        for (int i = 0;i < 7 ;i++ ) {
            pHand.add(Deck.get(0));
            Deck.remove(0);
        }
        return pHand;
    }//end handInt
}//end class
