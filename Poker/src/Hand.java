import java.util.ArrayList;
import java.util.Arrays;
public class Hand
	{

		private String label;
		static ArrayList<Card> cards;
		private int handRank;
		
		public Hand(String l, ArrayList<Card> c){
				label = l;
				cards = c;	
				String[] handRanks = {"Royal Flush","Straight Flush","Four of a Kind","Full House","Flush","Stright","Three of a Kinds","Two Pair","Pair","High Card"};
				handRank = Arrays.asList(handRanks).indexOf(l);
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
		
		public static void printCards(){
				
				for(Card c: cards){
					System.out.println(c.getName());
					
				}
				
				
		}
		
		
		
	}
