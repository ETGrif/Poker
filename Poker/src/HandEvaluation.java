import java.util.ArrayList;
import java.util.Collections;

public class HandEvaluation
	{

		public static void evaluate(ArrayList<Card> hand)
			{
				
				//ROYAL FLUSH, STRAIGHT FLUSH, and FLUSH
				String found = null;
				// sort all cards by suit, check for a possible flush(returns
				// null if it finds nothing)
				ArrayList<Card> possibleFlush = flushFinder(hand);
				// if found a flush,
				if (possibleFlush != null) {
					// search for a straight in the flush
					ArrayList<Card> straight = straightTester(possibleFlush);
					// --if there's a straight,
					if (straight != null) {
					// if the last card in the straight flush is an Ace, ==
						if (straight.get(4).getRank() == 14) {
					// --------ROYAL FLUSH
							found = "Royal Flush";
						} else {
					// ------else == STRAIGHT FLUSH
							found = "Straight Flush";
						}
					} else {
					// --else == FLUSH
						found = "Flush";

					}
				}

				
				//FOUR OF A KIND
				// if nothing has been found yet, search for pairs
				if (found == null) {
					int[] pairCounts = pairFinder(hand);
					// see if theres a four of a kind
					for (int i = 0; i < 7; i++) {
						if (pairCounts[i] == 4) {
							found = "Four of a Kind";

						}
					}
					
				
					
					
					
					
					
				}
				
				
			System.out.println(found);	
			}

		public static ArrayList<Card> flushFinder(ArrayList<Card> hand)
			{
//				System.out.println("Looking for possible flushes...");

				// sort into arrays by suit
				int[] suitCounts = { 0, 0, 0, 0 };
				Card[][] sortSuit = new Card[hand.size()][hand.size()];
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

				// test print counts
//				System.out.println("Spades:" + suitCounts[0]);
//				System.out.println("Hearts:" + suitCounts[1]);
//				System.out.println("Clubs:" + suitCounts[2]);
//				System.out.println("Diamonds:" + suitCounts[3]);

				// check for flush
				Card[] flush = new Card[hand.size()];
				boolean haveFlush = false;

				for (int i = 0; i < 4; i++) {
					if (suitCounts[i] >= 5) {
						flush = sortSuit[i];
						haveFlush = true;
						
						String[] suits = { "Spades", "Hearts", "Clubs", "Diamonds" };
						System.out.println("Found flush in " + suits[i]);
						
					}
				}

				// return?
				if (haveFlush) {
					// clean up the array and turn into an array list
					ArrayList<Card> cleanFlush = Deck.cleanUpHandArray(flush);
//					System.out.println("Returned flush");
					// return the new arrayList version of the flush
					return cleanFlush;
				} else {
					// there's no flush, return null
//					System.out.println("No flush found");
					return null;
				}

			}

		public static ArrayList<Card> straightTester(ArrayList<Card> hand)
			{

				// sort the flush
				Collections.sort(hand, new CardValueSorter());

//				System.out.println("sorted flush");
//				for (Card c : hand) {
//					System.out.println(c.getName());
//
//				}

				// (remove duplicate cards)

				// find the longest set
				// starting point of set
				int pointer = 0;
				int length = 1;

				for (int i = 0; i < hand.size(); i++) {
					// edge case(don't check the last card + make sure the last
					// thing is 1 if there isn't a straight)
					// System.out.println("Is checking card " + i + " out of "+
					// hand.size());
					if (i < hand.size() - 1) {

						// test if the next card is one more than the current
						// one
						if (hand.get(i).getRank() + 1 == hand.get(i + 1).getRank()) {
							// if the next card IS sequential:

							// System.out.println("Adding onto current length");
							length++;
							// System.out.println(length);
						} else {
							// if the next card is NOT sequential:
							// test if the current streak is >= 5
							if (length >= 5) {
								// leave the loop
								i = hand.size();

							} else {
								// set up for next check
								pointer = i + 1;
								length = 1;
							}
						}

					} else {
						if (length < 5) {
							length = 1;
						}
					}

				}

				// if there's a straight:
				if (length != 1) {
					// actually grab the cards
					ArrayList<Card> straight = new ArrayList<Card>();
					for (int i = 0; i < length; i++) {
						straight.add(hand.get(i + pointer));
					}

					// ----take the highest set, and return it
					if (straight.size() > 5) {
						// if there are 5+ sequential cards,
						int difference = straight.size() - 5;
						for (int i = 0; i < difference; i++) {
							straight.remove(0);
						}

					}

					System.out.println("straight was found");
					for (Card c : straight) {
						System.out.println(c.getName());

					}
					return straight;

				} else {
					// else, return
					System.out.println("No straight found");
					 return null;

				}

			}

		public static int[] pairFinder(ArrayList<Card> hand){
				//sort the hand
				Collections.sort(hand, new CardValueSorter());	
				
				//find pairs
				int previousRank = -1;
				int pointer = -1;
				int[] pairCounts = { 0, 0, 0, 0, 0, 0, 0};
//				Card[][] sortPairs = new Card[hand.size()][4];
				
				//sort into 2D array like the flushFinder
				for(int i = 0; i < hand.size(); i++){
					Card c = hand.get(i);
					if(c.getRank() > previousRank){
						pointer++;
						previousRank = c.getRank();
					}
//					sortPairs[pointer][pairCounts[pointer]] = c;
					pairCounts[pointer]++;
				}
				
				return pairCounts;
				
				
				
				
		}
		
		
		
	}
