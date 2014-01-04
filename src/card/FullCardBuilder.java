package card;

import java.util.ArrayList;
import java.util.Arrays;

import MyException.CardInitialException;

public class FullCardBuilder {
	public FullCardBuilder(){}
	
	//public final int maxCards = 7;
	
	public void ProcessCards(Card[] riverCards,Card[] knownCards) throws CardInitialException{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		Card[] targetCards= new Card[7];
		ArrayList<Card> cardList = new ArrayList<Card>(Arrays.asList(riverCards));
		cardList.add(null);
		cardList.add(null);
		
		CardSelector cs = new CardSelector(); 
		
		for(int i=0;i<riverCards.length;i++)
			intList.add(riverCards[i].getCardIndex());			
		
		for(int i=0;i<knownCards.length;i++)
			intList.add(knownCards[i].getCardIndex());
		
		for(int i=1;i<52;i++){
			if(intList.contains(i))
				continue;
			cardList.set(5, new Card(i));
			for(int j=i+1;j<53;j++){
				if(intList.contains(j))
					continue;
				cardList.set(6, new Card(j));
				cs.SelectCard(cardList.toArray(targetCards), 5);
			}			
		}
	}
}
