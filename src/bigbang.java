
import card.Card;
import card.CardSet;
import card.FiveCards;




public class bigbang {

	private static FiveCards fiveCard_1;

	/**
	 * @param args
	 * @throws Exception
	 *             all started with the big bang
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub 0x03
	//	CardSet cardSet = new CardSet();
	//	cardSet.getRandomCard().showCard();
	//	System.out.println("\n");
	//	cardSet.getRandomCard().showCard();
	//	System.out.println("\n");
//		cardSet.showCardSet();
//		cardSet.washCard();
/*		System.out.println("**************************\n");
		cardSet.getFristCard().showCard();
		System.out.println("**************************\n");
		cardSet.getFristCard().showCard();	
		System.out.println("**************************\n");
		cardSet.showCardSet();
		System.out.println("**************************\n");*/
		/*
		fiveCard_1 = new FiveCards();
		fiveCard_1.addCard(cardSet.getFristCard());
		fiveCard_1.addCard(cardSet.getFristCard());
		fiveCard_1.addCard(cardSet.getFristCard());
		fiveCard_1.addCard(cardSet.getFristCard());
		fiveCard_1.addCard(cardSet.getFristCard());
		fiveCard_1.showCars();		
		System.out.println(FiveCards.getCardPowerDesc(fiveCard_1.getCardPower()));
*/		
		
		int count[] = new int[10];
		
		for(int i = 0;i<10;i++){
			count[i] = 0;
		}
		
		for( int i=0;i<1;i++){
			CardSet cardSet = new CardSet();
			cardSet.washCard();
			fiveCard_1 = new FiveCards();			
			
			fiveCard_1.addCard(new Card(52));
			fiveCard_1.addCard(new Card(51));
			fiveCard_1.addCard(new Card(50));
			fiveCard_1.addCard(new Card(49));
			fiveCard_1.addCard(new Card(40));             
			count[fiveCard_1.getCardPower()]++;
			
			fiveCard_1.cleanCard();
			fiveCard_1.addCard(new Card(52));
			fiveCard_1.addCard(new Card(51));
			fiveCard_1.addCard(new Card(50));
			fiveCard_1.addCard(new Card(49));
			fiveCard_1.addCard(new Card(48));             
			count[fiveCard_1.getCardPower()]++;
			
			fiveCard_1.cleanCard();
			fiveCard_1.addCard(new Card(10));
			fiveCard_1.addCard(new Card(23));
			fiveCard_1.addCard(new Card(36));
			fiveCard_1.addCard(new Card(49));
			fiveCard_1.addCard(new Card(48));             
			count[fiveCard_1.getCardPower()]++;
			
			fiveCard_1.cleanCard();
			fiveCard_1.addCard(new Card(10));
			fiveCard_1.addCard(new Card(23));
			fiveCard_1.addCard(new Card(36));
			fiveCard_1.addCard(new Card(35));
			fiveCard_1.addCard(new Card(48));             
			count[fiveCard_1.getCardPower()]++;
			
			fiveCard_1.cleanCard();
			fiveCard_1.addCard(new Card(5));
			fiveCard_1.addCard(new Card(2));
			fiveCard_1.addCard(new Card(3));
			fiveCard_1.addCard(new Card(17));
			fiveCard_1.addCard(new Card(6));             
			count[fiveCard_1.getCardPower()]++;
			
			fiveCard_1.cleanCard();
			fiveCard_1.addCard(new Card(7));
			fiveCard_1.addCard(new Card(2));
			fiveCard_1.addCard(new Card(3));
			fiveCard_1.addCard(new Card(4));
			fiveCard_1.addCard(new Card(6));             
			count[fiveCard_1.getCardPower()]++;
			
			fiveCard_1.cleanCard();
			fiveCard_1.addCard(new Card(1));
			fiveCard_1.addCard(new Card(14));
			fiveCard_1.addCard(new Card(27));
			fiveCard_1.addCard(new Card(4));
			fiveCard_1.addCard(new Card(6));             
			count[fiveCard_1.getCardPower()]++;
			
			fiveCard_1.cleanCard();
			fiveCard_1.addCard(new Card(1));
			fiveCard_1.addCard(new Card(14));
			fiveCard_1.addCard(new Card(23));
			fiveCard_1.addCard(new Card(4));
			fiveCard_1.addCard(new Card(17));             
			count[fiveCard_1.getCardPower()]++;
			
			fiveCard_1.cleanCard();
			fiveCard_1.addCard(new Card(1));
			fiveCard_1.addCard(new Card(4));
			fiveCard_1.addCard(new Card(23));
			fiveCard_1.addCard(new Card(5));
			fiveCard_1.addCard(new Card(17));             
			count[fiveCard_1.getCardPower()]++;
			
			fiveCard_1.cleanCard();
			fiveCard_1.addCard(new Card(1));
			fiveCard_1.addCard(new Card(2));
			fiveCard_1.addCard(new Card(23));
			fiveCard_1.addCard(new Card(5));
			fiveCard_1.addCard(new Card(17));             
			count[fiveCard_1.getCardPower()]++;
			
			fiveCard_1.showCars();
			System.out.println(FiveCards.getCardPowerDesc(fiveCard_1.getCardPower()));
		}
		
		for(int i = 0;i<10;i++){
			System.out.println(FiveCards.getCardPowerDesc(i)+"["+count[i]+"]");
		}

	}
}
