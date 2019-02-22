import java.util.ArrayList;
import java.util.Arrays;
public class Card {

	
	private String suit;
	private String value;
	private String name;
	private int rank;
	
	public Card(String s, String v, int r) {
		suit = s;
		value = v;
		rank = r;
		name = value + " of " + suit;

	}

	public String getSuit() {
		return suit;
	}

	private void setSuit(String suit) {
		this.suit = suit;
	}

	private String getValue() {
		return value;
	}

	private void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	private void setRank(int rank) {
		this.rank = rank;
	}
	
	
	public static void graphicCards(ArrayList<Card> hand){
			System.out.print(" ");
			
			
			String[] endCaps = {"______ ","       \\","       |","       |"};

			for(int i = 0; i < 3; i++){
				for(int j = 0; j < hand.size(); j++){
					String suit = addWhiteSpace(hand.get(j).getSuit());
					String rank = addWhiteSpace(hand.get(j).getValue());
					String[] printThings = {"___________","/ "+rank+"    ","| "+suit+" ","|          "};
					
					
					
					
					System.out.print(printThings[i]);
					
					
					
					
					
					
					
				}
				System.out.print(endCaps[i]);
				System.out.println();
				
				
			}
			
	}
	
		public static String addWhiteSpace(String thing)
			{
				String[] strings = { "Spades", "Hearts", "Clubs", "Diamonds",
						"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen",
						"King" };

				int index = Arrays.asList(strings).indexOf(thing);

				String[] printables = { "Spades  ", "Hearts  ", "Clubs   ", "Diamonds",
						"Ace  ", "Two  ", "Three", "Four ", "Five ", "Six  ", "Seven", "Eight", "Nine ", "Ten  ",
						"Jack ", "Queen", "King " };
				
				return printables[index];
				
			}
	
	
	
	
	
	
}
