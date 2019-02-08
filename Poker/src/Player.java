import java.util.ArrayList;
public class Player
	{

		private String name;
		boolean isHuman;
		private ArrayList<Card> hand;
		private Hand bestHand;
		private int money;
		
		public Player(String n , boolean h){
				name = n;
				isHuman = h;
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

		public boolean isHuman()
			{
				return isHuman;
			}

		public void setHuman(boolean isHuman)
			{
				this.isHuman = isHuman;
			}
		
		
	}
