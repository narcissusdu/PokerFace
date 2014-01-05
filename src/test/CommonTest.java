package test;

import MyException.CardInitialException;
import card.Card;
import card.CardSelector;
import card.CardSet;
import card.FiveCards;
import card.FullCardBuilder;
import card.fiveCardsComparator;

public class CommonTest {
	public static void main(String[] args) throws Exception{
		
		//TestSelectCard();
		//TestBuildCard();
		//TestFiveCardsComparator();
		//Test
	}	
	
	private static void TestFiveCardsComparator() throws Exception {
		//
		CardSet cardSet = new CardSet();
		cardSet.washCard();
		FiveCards fiveCard1 = new FiveCards();
		FiveCards fiveCard2 = new FiveCards();
		fiveCard1.addCard(cardSet.getRandomCard());
		fiveCard1.addCard(cardSet.getRandomCard());
		fiveCard1.addCard(cardSet.getRandomCard());
		fiveCard1.addCard(cardSet.getRandomCard());
		fiveCard1.addCard(cardSet.getRandomCard());
		
		fiveCard2.addCard(cardSet.getRandomCard());
		fiveCard2.addCard(cardSet.getRandomCard());
		fiveCard2.addCard(cardSet.getRandomCard());
		fiveCard2.addCard(cardSet.getRandomCard());
		fiveCard2.addCard(cardSet.getRandomCard());
		
		
		fiveCard1.showCars();
		fiveCard2.showCars();
		
		System.out.println(new fiveCardsComparator().compare(fiveCard1, fiveCard2));
		
	}
	
	private static void TestBuildCard() throws CardInitialException {
		Card[] riverCards = new Card[] {new Card(40),new Card(41),new Card(42),new Card(43),new Card(44)};
		Card[] knownCards = new Card[] {new Card(45),new Card(46)};
		FullCardBuilder fcb = new FullCardBuilder();
		fcb.ProcessCards(riverCards, knownCards);
		//20790 answers
	}

	public static void	TestSelectCard() throws CardInitialException{
		Card[] cards = new Card[] {new Card(40),new Card(41),new Card(42),new Card(43),new Card(44),new Card(45),new Card(46)};
		CardSelector selector = new CardSelector();
		selector.SelectCard(cards, 5);
		//21 answers
	}
	
	
	
}
