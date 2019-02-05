import java.util.ArrayList;

public class playGame
	{

		public static void main(String[] args)
			{
				System.out.println("Lets play some Poker!(Texas Hold'em)");

				int mPlayers = 3;
				Player[] players = new Player[mPlayers];
				
				//create new deck
				Deck.fillDeck();
				
				//create players
				for(int i = 0; i < players.length; i++){
					players[i] = new Player("Player " + (i +1));
				}
				
				
				//deal all players two cards
				for(Player p : players){
					ArrayList<Card> hand = new ArrayList<Card>();
					hand.add(Deck.dealTopCard());
					hand.add(Deck.dealTopCard());
					p.setHand(hand);
				}
				
				//tell player what cards they have
				for(Player p : players){
					System.out.println("\n");
					System.out.println(p.getName() + ":");
					System.out.println(p.getHand().get(0).getName());
					System.out.println(p.getHand().get(1).getName());
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
				for(Player p: players){
					ArrayList<Card> hand = HandEvaluation.addArrays(p.getHand(), river);
					p.setBestHand(HandEvaluation.evaluate(hand));
					
					System.out.println();
					System.out.println(p.getName() + ":");
					System.out.println(p.getBestHand().getLabel());
					for(Card c: p.getBestHand().getCards()){
						System.out.println(c.getName());
				}
				}
				
				System.out.println("TEST");
				//print all the hands
				for(Player p: players){
					System.out.println();
					System.out.println(p.getName() + ":");
					System.out.println(p.getBestHand().getLabel());
					for(Card c: p.getBestHand().getCards()){
						System.out.println(c.getName());
						
					}
					
					
				}
				
				
				//reward the winner
				
				//repeat
				
			}
		
		
		
		
		
	}
