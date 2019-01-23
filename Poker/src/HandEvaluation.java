import java.util.ArrayList;

public class HandEvaluation
	{

		public static void evaluate(ArrayList<Card> hand)
			{
				// sort all cards by suit, check for a possible flush
				flushFinder(hand);
				//search for a straight in the flush
				//	if there's a straight,
				//		if the last card in the straight flush is an Ace, == ROYAL FLUSH
				//		else == STRAIGHT FLUSH
				//	else == FLUSH
				
				
				
				
				
				
				
			}

		
		public static void flushFinder(ArrayList<Card> hand){
				//sort into arrays by suit
				int[] suitCounts = { 0, 0, 0, 0 };
				Card[][] sortSuit = new Card[7][7];
				for (Card c : hand) {
					String suit = c.getSuit();
					int s = 0;
					switch (suit)
						{
						case "Spades":
							s = 0;
							break;
						case "Hearts":
							s = 1;
							break;
						case "Clubs":
							s = 2;
							break;
						case "Diamonds":
							s = 3;
						}
					sortSuit[s][suitCounts[s]] = c;
					suitCounts[s]++;
				}
				
				//test print counts
				System.out.println("Spades:" + suitCounts[0]);
				System.out.println("Hearts:" + suitCounts[1]);
				System.out.println("Clubs:" + suitCounts[2]);
				System.out.println("Diamonds:" + suitCounts[3]);

				
				//check for flush
				Card[] flush = new Card[7];
				boolean haveFlush = false;

				for (int i = 0; i < 4; i++) {
					if (suitCounts[i] >= 5) {
						flush = sortSuit[suitCounts[i]];
						String[] suits = { "Spades", "Hearts", "Clubs", "Diamonds" };
						System.out.println("Found flush in " + suits[i]);
					}
				}
				
				
				//return?
				if(haveFlush){
					//clean up the array and turn into an array list
//					return flush;
				}else{
					//there's no flush, return null
//					return null;
				}
				
				
				
				
		}
		
		
		
	}
