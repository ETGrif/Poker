import java.util.ArrayList;
public class Player
	{

		private String name;
		private ArrayList<Card> hand;
		private Hand bestHand;
		private int money;
		
		public Player(String n){
				name = n;
		}
		
		
		
		
		public String getName()
			{
				return name;
			}
		public void setName(String name)
			{
				this.name = name;
			}
		public ArrayList<Card> getHand()
			{
				return hand;
			}
		public void setHand(ArrayList<Card> hand)
			{
				this.hand = hand;
			}
		public Hand getBestHand()
			{
				return bestHand;
			}
		public void setBestHand(Hand bestHand)
			{
				this.bestHand = bestHand;
			}
		public int getMoney()
			{
				return money;
			}
		public void setMoney(int money)
			{
				this.money = money;
			}
		
		
		
		
		
	}
