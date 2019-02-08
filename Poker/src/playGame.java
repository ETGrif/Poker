import java.util.ArrayList;
import java.util.Collections;

public class playGame
	{

		public static void main(String[] args)
			{
				System.out.println("Lets play some Poker!(Texas Hold'em)");

				int mPlayers = 5;
				Player[] players = new Player[mPlayers];
				
				//create new deck
				Deck.fillDeck();
				
				//create players
				for(int i = 0; i < players.length; i++){
					boolean human = false;
					if(i == 0){
						human = true;
					}
					players[i] = new Player("Player " + (i +1) , human);
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
						System.out.println(p.getHand().get(0).getName());
						System.out.println(p.getHand().get(1).getName());
					}
				}
				
				
				
				
				//deal in the river
				ArrayList<Card> river = new ArrayList<Card>();
				System.out.println("\n\nThe river:");
				for(int i = 0; i < 5; i++){
					river.add(Deck.dealTopCard());
				}
				for(Card c: river){
					System.out.println(c.getName());
				}
				
				
				
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

					for(Card c: p.getBestHand().getCards()){
						System.out.println(c.getName());
						
					}
					
					
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
				
				System.out.println("The winner is " + sortedPlayers.get(0).getName() + " with a " + sortedPlayers.get(0).getBestHand().getLabel());
				
				
				//repeat
				
			}
		
		
		
		
		
	}
