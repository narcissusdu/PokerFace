package card;

import java.util.ArrayList;

public class CardSelector {
	public CardSelector(){}
	public void SelectCard(Card[] cards, int count) {
		if (count > cards.length)
			return;
		// Card[] resultCards = new Card[count];
		int[] pointers = new int[count];
		for (int tmp = 0; tmp < count; tmp++)
			pointers[tmp] = tmp;

		int workPointer = count - 1;
		do {
			Process(cards, pointers);
			int lastPointer = workPointer;
			workPointer = getcurrentWorkPointer(cards.length,pointers);
			pointers[workPointer]++;
			if(lastPointer>workPointer)
				for(int i = workPointer+1;i<count;i++)
					pointers[i]=pointers[i-1]+1;			
		} while (pointers[0] != cards.length - count);
		Process(cards, pointers);
		// return resultCards;
	}

	private int getcurrentWorkPointer(int arrayLength, int[] pointers) {
		int workPointer =pointers.length-1 ;
		if(pointers[workPointer] < arrayLength-1)
			return workPointer;
		for(;pointers[workPointer-1]==pointers[workPointer]-1;workPointer--);
		return workPointer-1;
	}

	public void Process(Card[] cards, int[] pointers) {
		ArrayList<Card> cardList = new ArrayList<Card>();
		for (int i = 0; i < pointers.length; i++) {
			cardList.add(cards[pointers[i]]);
		}

		CardProcessor cardProcessor = new CardProcessor();
		cardProcessor.Process(cardList);
	}
}
