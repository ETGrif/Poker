import java.util.ArrayList;
import java.util.Collections;

public class HandEvaluation
	{

		public static void evaluate(ArrayList<Card> hand)
			{

				String found = null;
				ArrayList<Card> foundCards = new ArrayList<Card>();

				// ROYAL FLUSH, STRAIGHT FLUSH, and FLUSH

				// sort all cards by suit, check for a possible flush(returns
				// null if it finds nothing)
				ArrayList<Card> possibleFlush = flushFinder(hand);
				// if found a flush,
				if (possibleFlush != null) {
					// search for a straight in the flush
					ArrayList<Card> straight = straightFinder(possibleFlush);
					// --if there's a straight,
					if (straight != null) {
						// if the last card in the straight flush is an Ace, ==
						if (straight.get(4).getRank() == 14) {
							// --------ROYAL FLUSH
							found = "Royal Flush";
							foundCards = straight;
						} else {
							// ------else == STRAIGHT FLUSH
							found = "Straight Flush";
							foundCards = straight;
						}
					} else {
						// --else == FLUSH
						found = "Flush";
						if (possibleFlush.size() > 5) {
							// if there are 5+ cards, limit it to five
							int difference = possibleFlush.size() - 5;
							for (int i = 0; i < difference; i++) {
								possibleFlush.remove(0);
							}
						}
						foundCards = possibleFlush;

					}
				}
				
				
				
				
				
				
				
				
				// initialize pairs and pairCounts for all the pair logic
				Card[][] pairs = pairFinder(hand);

				int[] pairCounts = new int[pairs.length];
				for (int i = 0; i < pairCounts.length; i++) {
					pairCounts[i] = pairs[i].length;
				}

				
				
				
				// FOUR OF A KIND
				// if nothing has been found yet, search for pairs
				if (found == null) {
					// see if theres a four of a kind
					for (int i = 0; i < pairCounts.length; i++) {
						if (pairCounts[i] == 4) {
							found = "Four of a Kind";
							foundCards = arrayToArrayList(pairs[i]);

						}
					}

				}
				
				
				// FULL HOUSE
				if (found == null) {
					// find the highest pair of two and of three(got index)
					int highestPair = -1;
					int highestPair2 = -1;
					for (int i = 0; i < pairCounts.length; i++) {
						if (pairCounts[i] == 2) {
							highestPair = i;
						} else if (pairCounts[i] == 3) {
							highestPair2 = i;
						}
					}
					
					// if there is one of both, return the cards and FULL HOUSE
					if(highestPair != -1 && highestPair2 != -1){
						found = "Full House";
						foundCards = addArrays(arrayToArrayList(pairs[highestPair]), arrayToArrayList(pairs[highestPair2]));
					}
					
				}

				// STRAIGHT
				if (found == null) {
					ArrayList<Card> straight = straightFinder(hand);
					if (straight != null) {
						found = "Straight";
						foundCards = straight;

					}

				}	
					
				
				
				// THREE OF A KIND
				if (found == null) {
					int highestPair = -1;
					for (int i = 0; i < pairCounts.length; i++) {
						if (pairCounts[i] == 3) {
							highestPair = i;
						}

					}
					if (highestPair != -1) {
						found = "Three of a Kind";
						foundCards = arrayToArrayList(pairs[highestPair]);

					}

				}				
				
				
				
				
				//TWO PAIRS and PAIR
				if (found == null) {

					int highestPair = -1;
					int highestPair2 = -1;
					for (int i = 0; i < pairCounts.length; i++) {
						if (pairCounts[i] == 2) {
							highestPair2 = highestPair;
							highestPair = i;
						}

					}

					if (highestPair2 != -1) {
						found = "Two Pair";
						foundCards = addArrays(arrayToArrayList(pairs[highestPair2]),
								arrayToArrayList(pairs[highestPair]));

					} else if (highestPair != -1) {
						found = "Pair";
						foundCards = arrayToArrayList(pairs[highestPair]);

					}

				}
				
				
				//HIGH CARD
				if(found == null){
					//find highest card
					int record = -1;
					int pointer = -1;
					for(int i = 0; i < hand.size(); i++){
						if(hand.get(i).getRank() > record){
						record = hand.get(i).getRank();
						pointer = i;
						}
					}
					
					found = "High Card";
					foundCards.add(hand.get(pointer));
					
					
					
					
					
				}
				
				
				
				

				System.out.println("\n\n");
				System.out.println("Found a "+ found);
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
				for (Card c : foundCards) {
					System.out.println(c.getName());
				}
			}

		public static ArrayList<Card> flushFinder(ArrayList<Card> hand)
			{
				// System.out.println("Looking for possible flushes...");

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
				// System.out.println("Spades:" + suitCounts[0]);
				// System.out.println("Hearts:" + suitCounts[1]);
				// System.out.println("Clubs:" + suitCounts[2]);
				// System.out.println("Diamonds:" + suitCounts[3]);

				// check for flush
				Card[] flush = new Card[hand.size()];
				boolean haveFlush = false;

				for (int i = 0; i < 4; i++) {
					if (suitCounts[i] >= 5) {
						flush = sortSuit[i];
						haveFlush = true;

//						String[] suits = { "Spades", "Hearts", "Clubs", "Diamonds" };
//						System.out.println("Found flush in " + suits[i]);

					}
				}

				// return?
				if (haveFlush) {
					// clean up the array and turn into an array list
					ArrayList<Card> cleanFlush = Deck.cleanUpHandArray(flush);
					// System.out.println("Returned flush");
					// return the new arrayList version of the flush
					return cleanFlush;
				} else {
					// there's no flush, return null
					// System.out.println("No flush found");
					return null;
				}

			}

		public static ArrayList<Card> straightFinder(ArrayList<Card> hand)
			{

				// sort the flush
				Collections.sort(hand, new CardValueSorter());

				// (remove duplicate cards)
				for (int i = hand.size() - 1; i > 0; i--) {
					if (hand.get(i).getRank() == hand.get(i - 1).getRank()) {
						hand.remove(i);
					}

				}

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
					return straight;

				} else {
					// else, return
					// System.out.println("No straight found");
					return null;

				}

			}

		public static Card[][] pairFinder(ArrayList<Card> hand)
			{
				// sort the hand
				Collections.sort(hand, new CardValueSorter());

				// find pairs
				int previousRank = -1;
				int pointer = -1;
				int[] pairCounts = { 0, 0, 0, 0, 0, 0, 0 };
				Card[][] sortPairs = new Card[hand.size()][4];

				// sort into 2D array like the flushFinder
				for (int i = 0; i < hand.size(); i++) {
					Card c = hand.get(i);
					if (c.getRank() > previousRank) {
						pointer++;
						previousRank = c.getRank();
					}
					sortPairs[pointer][pairCounts[pointer]] = c;
					pairCounts[pointer]++;
				}

				// clean up the array(that way it can encode some more info

				// set up the clean board
				int finalSpot = pointer + pairCounts[pointer];
				Card[][] cleanPairs = new Card[finalSpot][];
				for (int i = 0; i < finalSpot; i++) {
					cleanPairs[i] = new Card[pairCounts[i]];
				}

				// fill the board
				for (int x = 0; x < cleanPairs.length; x++) {
					for (int y = 0; y < cleanPairs[x].length; y++) {
						if (sortPairs[x][y] != null) {
							cleanPairs[x][y] = sortPairs[x][y];

						}

					}

				}

				return cleanPairs;

			}

		public static ArrayList<Card> arrayToArrayList(Card[] hand)
			{
				ArrayList<Card> arrayHand = new ArrayList<Card>();
				for (int i = 0; i < hand.length; i++) {
					arrayHand.add(hand[i]);
				}
				return arrayHand;
			}

		public static ArrayList<Card> addArrays(ArrayList<Card> bundle1, ArrayList<Card> bundle2){
				for(Card c: bundle2){
					bundle1.add(c);
				}
				return bundle1;
		}
	}
