package card;

import java.util.ArrayList;

public class FullCardBuilder {
	public FullCardBuilder(){}
	
	public final int maxCards = 7;
	
	public void ProcessCards(Card[] riverCards,Card[] knownCards){
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		for(int i=0;i<riverCards.length;i++)
			intList.add(riverCards[i].getCardIndex());			
		
		for(int i=0;i<knownCards.length;i++)
			intList.add(knownCards[i].getCardIndex());
		
		for(int i=1;i<52;i++){
			if(intList.contains(i))
				continue;
			for(int j=i+1;j<53;j++){
				if(intList.contains(j))
					continue;
				
				
			}			
		}
	}
}
