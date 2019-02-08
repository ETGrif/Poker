import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Hand
	{

		private String label;
		private ArrayList<Card> cards;
		private int handRank;
		private int highestCard;
		
		public Hand(String l, ArrayList<Card> c){
				label = l;
				cards = c;	
				String[] handRanks = {"Royal Flush","Straight Flush","Four of a Kind","Full House","Flush","Straight","Three of a Kind","Two Pair","Pair","High Card"};
				handRank = 10 - Arrays.asList(handRanks).indexOf(l);
				
				
				highestCard = cards.get(cards.size()-1).getRank();

				
				
		}

		public String getLabel()
			{
				return label;
			}

		public void setLabel(String label)
			{
				this.label = label;
			}

		public ArrayList<Card> getCards()
			{
				return cards;
			}

		public void setCards(ArrayList<Card> cards)
			{
				this.cards = cards;
			}

		public int getHandRank()
			{
				return handRank;
			}

		public void setHandRank(int handRank)
			{
				this.handRank = handRank;
			}

		public int getHighestCard()
			{
				return highestCard;
			}

		public void setHighestCard(int highestCard)
			{
				this.highestCard = highestCard;
			}
		
		
		
	}
