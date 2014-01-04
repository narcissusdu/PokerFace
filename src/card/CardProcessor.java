package card;

import java.util.ArrayList;

public class CardProcessor {
	public static int i = 0;
	public void Process(ArrayList<Card> cardList){
		for(int i =0;i<cardList.size();i++){
			System.out.print(i);
			cardList.get(i).showCard();
		}		
		System.out.println(++i);
		System.out.println();
		
	};
}
