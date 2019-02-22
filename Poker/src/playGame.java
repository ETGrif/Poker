import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class playGame
	{

		
		static Scanner userInput = new Scanner(System.in);
		public static void main(String[] args)
			{
				System.out.println("Lets play some Poker!(Texas Hold'em)");

				
				
				
				int mPlayers = 3;
				Player[] players = new Player[mPlayers];
				
				//create new deck
				Deck.fillDeck();
				
				//create players
				for(int i = 0; i < players.length; i++){
					boolean human = false;
					if(i == 0){
						human = true;
					}
					String[] names = {"Alex","Andrea","Bobby","Briana","Carl","Cathy","Dean","Denice","Ethan","Ethyl",
							"Fred", "Felisha","Greg","Gienessa", "Hans","Haley","Ian","Isabelle","Jack","Jessica"
							};
					int random = (int)(Math.random()*names.length);
					
					players[i] = new Player(names[random] , human);
				}
				
				
				//deal all players two cards
				for(Player p : players){
					ArrayList<Card> hand = new ArrayList<Card>();
					hand.add(Deck.dealTopCard());
					hand.add(Deck.dealTopCard());
					p.setHand(hand);
				}
				
				//tell player what cards they have
				for (Player p : players) {
					if (p.isHuman()) {
						System.out.println("\n");
						System.out.println(p.getName() + ":");
						
						Card.graphicCards(p.getHand());
					}
				}
				
				
				
				
				//deal in the river
				ArrayList<Card> river = new ArrayList<Card>();
				for(int i = 0; i < 5; i++){
					river.add(Deck.dealTopCard());
				}
							
				
				//print flop
				System.out.println("\n\nThe flop:");
				ArrayList<Card> printRiver = new ArrayList<Card>();
				printRiver.add(river.get(0));
				printRiver.add(river.get(1));
				printRiver.add(river.get(2));
				Card.graphicCards(printRiver);
				
				
				//bet
				String blank;
				blank= userInput.nextLine();
				
				
				//print card
				System.out.println("\n\nThe fourth street:");
				printRiver.add(river.get(3));
				Card.graphicCards(printRiver);
				
				
				//bet
				blank= userInput.nextLine();
				
				
				//print river
				System.out.println("\n\nThe river:");
				Card.graphicCards(river);
				
				
				//bet
				blank= userInput.nextLine();
				
				
				
				
				
				//evaluate each player's hand
				System.out.println("\n\nEvaluating hands...");
				for (Player p : players) {
					ArrayList<Card> hand = HandEvaluation.addArrays(p.getHand(), river);
					p.setBestHand(HandEvaluation.evaluate(hand));

//					System.out.println();
//					System.out.println(p.getName() + ":");
//					System.out.println(p.getBestHand().getLabel());
//					for (Card c : p.getBestHand().getCards()) {
//						System.out.println(c.getName());
//					}
				}

				//print all the hands
				for(Player p: players){
					System.out.println();
					System.out.println(p.getName() + ":");
//					System.out.println(p.getBestHand().getLabel() + ": " + p.getBestHand().getHandRank() + "," + p.getBestHand().getHighestCard());
					System.out.println(p.getBestHand().getLabel());

					Card.graphicCards(p.getBestHand().getCards());
					
				}
				
				
				//reward the winner
				
				//find the best ranks
				ArrayList<Player> sortedPlayers = new ArrayList<Player>();
				for(Player p: players){
					sortedPlayers.add(p);
				}
				Collections.sort(sortedPlayers, new PlayerSorter());
				System.out.println("\n\n");
//				for (int i = 0; i < sortedPlayers.size(); i++) {
//					System.out.println(i +1 + ") " + sortedPlayers.get(i).getName());
//				}
//				
				
				System.out.println(sortedPlayers.get(0).getName() + " is the winner with a " + sortedPlayers.get(0).getBestHand().getLabel());
				
				
				//repeat
				
			}
		
		
		
		
		
	}
