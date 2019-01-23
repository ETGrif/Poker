import java.util.ArrayList;

public class TestPlay
	{

		
		public static void main(String[] args)
			{
				
				Deck.fillDeck();
				ArrayList<Card> deck = Deck.deck;
				ArrayList<Card> hand = new ArrayList<Card>();

				for (int i = 0; i < 7; i++) {
					hand.add(deck.get(0));
					deck.remove(0);
				}

				System.out.println("test");
				for (Card c : hand) {
					System.out.println(c.getName());
				}

				HandEvaluation.evaluate(hand);
			}
}
