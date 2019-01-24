import java.util.ArrayList;

public class HandEvaluation
	{

		public static void evaluate(ArrayList<Card> hand)
			{
				// sort all cards by suit, check for a possible flush(returns null if it finds nothing)
				ArrayList<Card> possibleFlush = flushFinder(hand);
				//if found a flush,
				if(possibleFlush != null){
//					System.out.println("Found that flush in the main program");
				//	search for a straight in the flush
					System.out.println(possibleFlush.size());
					straightTester(possibleFlush);
				//		if there's a straight,
				//			if the last card in the straight flush is an Ace, == ROYAL FLUSH
				//			else == STRAIGHT FLUSH
				//		else == FLUSH
				}
				
				
				
				
				
				
			}

		
		public static ArrayList<Card> flushFinder(ArrayList<Card> hand){
				System.out.println("Looking for possible flushes...");
				
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
				boolean haveFlush= false;

				for (int i = 0; i < 4; i++) {
					if (suitCounts[i] >= 5) {
						flush = sortSuit[suitCounts[i]];
						String[] suits = { "Spades", "Hearts", "Clubs", "Diamonds" };
						System.out.println("Found flush in " + suits[i]);
						haveFlush = true;
					}
				}
				
				
				//return?
				if(haveFlush){
					//clean up the array and turn into an array list
					System.out.println("Flush");
					System.out.println(flush.length);
					ArrayList<Card> cleanFlush = Deck.cleanUpHandArray(flush);
					System.out.println("CleanFlush");
					System.out.println(cleanFlush.size());
					System.out.println("Returned flush");
					//return the new arrayList version of the flush
					return cleanFlush;
				}else{
					//there's no flush, return null
					System.out.println("No flush found");
					return null;
				}
				
				
				
				
		}
		
		public static void straightTester(ArrayList<Card> hand){
				
//			int repeat = hand.size();
				System.out.println(hand.size());
			for(int i = hand.size(); i > 0; i--){
				System.out.println("Test");
				Card minRecord = new Card(null, null, 15);
				for(int j = 0; j < i; j++){
					if(hand.get(j).getRank() < minRecord.getRank()){
						minRecord = hand.get(j);
					}
					hand.remove(minRecord);
					hand.add(minRecord);
				}
				
			
				System.out.println("sorted flush");
				for(Card c: hand){
					System.out.println(c.getName());
					
				}
				
				
				
				
			}
				
				
		}
		
	}
