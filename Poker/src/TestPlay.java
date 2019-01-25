import java.util.ArrayList;

public class TestPlay
	{

		
		public static void main(String[] args)
			{
				
				Deck.fillDeck();
				ArrayList<Card> deck = Deck.deck;
				ArrayList<Card> hand = new ArrayList<Card>();

				//straight flush test set
				String[] getHand = {"Three of Spades", "Six of Spades" ,"Five of Clubs","Four of Spades","Nine of Spades","Two of Spades","Queen of Hearts"};
				
//				for (int i = 0; i < 7; i++) {
//					hand.add(deck.get(0));
//					deck.remove(0);
//				}
				for(int i = 0; i < getHand.length; i++){
					for(int j = 0; j < deck.size(); j++){
						Card c = deck.get(j);
						if(c.getName().equals(getHand[i])){
							hand.add(c);
							deck.remove(c);
						
						}
					}
					
					
					
				}

				for (Card c : hand) {
					System.out.println(c.getName());
				}

				HandEvaluation.evaluate(hand);
			}
		
}
