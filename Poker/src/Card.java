
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

	String getSuit() {
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

	String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private int getRank() {
		return rank;
	}

	private void setRank(int rank) {
		this.rank = rank;
	}
	
	
	
	
	
	
	
	
	
	
}
