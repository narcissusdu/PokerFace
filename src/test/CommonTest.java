package test;

import MyException.CardInitialException;
import card.Card;
import card.CardSelector;
import card.FullCardBuilder;

public class CommonTest {
	public static void main(String[] args) throws CardInitialException{
		
		//TestSelectCard();
		TestBuildCard();
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
