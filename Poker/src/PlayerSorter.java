import java.util.Comparator;

public class PlayerSorter implements Comparator<Player>
	{

		public int compare(Player p1, Player p2)
			{
				
				if(p1.getBestHand().getHandRank() == p2.getBestHand().getHandRank()){
					if(p1.getBestHand().getHighestCard() < p2.getBestHand().getHighestCard()){
						return 1;
					}else{
						return -1;
					}
				}else if (p1.getBestHand().getHandRank() < p2.getBestHand().getHandRank()) {
					return 1;
				} else {
					return -1;
				}

			}

	}