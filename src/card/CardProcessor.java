package card;

import java.util.ArrayList;

public class CardProcessor {
	
	public void Process(ArrayList<Card> cardList){
		System.out.println("------------------------------------");
		for(int i =0;i<cardList.size();i++){
			System.out.print(i);
			cardList.get(i).showCard();
		}
		
	};
}
