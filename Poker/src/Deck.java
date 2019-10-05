import java.util.ArrayList;
import java.util.Collections;

public class Deck
	{
		static ArrayList<Card> deck = new ArrayList<Card>();

		public static void fillDeck()
			{
				deck.clear();
				String[] suits = { "Spades", "Hearts", "Clubs", "Diamonds" };
				String[] values = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
						"Jack", "Queen", "King" };
				for (int s = 0; s < 4; s++) {
					for (int v = 0; v < 13; v++) {
						int rank;
						if (v == 0) {
							rank = 14;
						} else {
							rank = v + 1;
						}
						// System.out.println(v+":"+s);
						Card card = new Card(suits[s], values[v], rank);
						deck.add(card);
					}
				}

				shuffleDeck();

			}

		public static void shuffleDeck()
			{
				Collections.shuffle(deck);
			}

		public static ArrayList<Card> cleanUpHandArray(Card[] dirtyHand)
			{
//				System.out.println("Cleaning hand");
				ArrayList<Card> cleanHand = new ArrayList<Card>();
				for(Card c: dirtyHand){
//					System.out.println("New card checked");
					if(c != null){
//						System.out.println("new card added");
						cleanHand.add(c);
					}
					
					
				}
				
				return cleanHand;
				
				
				
				
				
			}

		public static Card dealTopCard(){
				Card topCard = deck.get(0);
				deck.remove(0);
				return topCard;
				
		}
		
		public static void printCards(ArrayList<Card> hand) {
			String suit;
			String Value;
			String[] Values = {"Two  ","Three","Four ","Five ","Six  ","Seven","Eight","Nine ","Ten  ","Jack ","Queen","King "};
			String[] Suits = {"Spades  ","Hearts  ","Clubs   ","Diamonds"};
			String[] cardPrints = {" ____________","/  XXXXX     ","|  XXXXXXXX  "};
			String[] CardPrintEndCaps = {" ","\\" ,"|"};
			
			
			 for(int i = 0; i < 3; i++) {
				 for(int j = 0; i < hand.size(); j++) {
					 
					 
					 
				 }
				 
			 }
			
			
			
			
		}
		
	}
