package test;

import MyException.CardInitialException;
import MyException.cardUsedOutException;
import card.Card;
import card.CardSelector;
import card.CardSet;
import card.FiveCards;
import card.FullCardBuilder;
import card.fiveCardsComparator;

public class CommonTest {
	public static void main(String[] args) throws Exception{
		
		//TestSelectCard();
		TestBuildCard();
		//TestFiveCardsComparator();
//		TestSelect5Cards();
	}	
	
	private static void TestSelect5Cards() throws CardInitialException {
		Card[] cards = new Card[]{new Card(2,1),new Card(2,5),new Card(3,8),new Card(3,5),new Card(2,7),new Card(3,3),new Card(0,13)};
		new CardSelector().Select5MaxCards(cards, 5);
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
		
		
		fiveCard1.showCards();
		fiveCard2.showCards();
		
		System.out.println(new fiveCardsComparator().compare(fiveCard1, fiveCard2));
		
	}
	
	private static void TestBuildCard() throws CardInitialException, cardUsedOutException {
		CardSet cardSet = new CardSet();
		cardSet.washCard();
		
		Card[] riverCards = new Card[] {cardSet.getRandomCard(),cardSet.getRandomCard(),cardSet.getRandomCard(),cardSet.getRandomCard(),cardSet.getRandomCard()};
		Card[] known1Cards = new Card[] {cardSet.getRandomCard(),cardSet.getRandomCard()};
		Card[] known2Cards = new Card[] {cardSet.getRandomCard(),cardSet.getRandomCard()};
		
//		Card[] riverCards = new Card[] {new Card(0,2),new Card(0,3),new Card(0,4),new Card(0,5),new Card(1,7)};
//		Card[] known1Cards = new Card[] {new Card(2,8),new Card(3,9)};			
//		Card[] known2Cards = new Card[] {new Card(40),new Card(41)};	
		
		
		FullCardBuilder fcb = new FullCardBuilder();
		FiveCards fc1 = fcb.ProcessCards(riverCards, known1Cards);

//		FiveCards fc2 = fcb.ProcessCards(riverCards, known2Cards);
		
//		System.out.println(new fiveCardsComparator().compare(fc1, fc2));
		//20790 answers
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		for(int i = 0;i < riverCards.length;i++)
			riverCards[i].showCard();
		System.out.println();
		for(int i = 0;i < known1Cards.length;i++)
			known1Cards[i].showCard();
//		System.out.println();
//		System.out.println();
//		for(int i = 0;i < known2Cards.length;i++)
//			known2Cards[i].showCard();
//		System.out.println();
	}

	public static void	TestSelectCard() throws CardInitialException{
		Card[] cards = new Card[] {new Card(40),new Card(41),new Card(42),new Card(43),new Card(44),new Card(45),new Card(46)};
		CardSelector selector = new CardSelector();
		selector.SelectCard(cards, 5);
		//21 answers
	}
	
	
	
}
