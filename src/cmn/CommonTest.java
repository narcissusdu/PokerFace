package cmn;

import MyException.CardInitialException;
import card.Card;
import card.CardSelector;

public class CommonTest {
	public static void main(String[] args) throws CardInitialException{
		
		TestSelectCard();
	}
	public static void	TestSelectCard() throws CardInitialException{
		Card[] cards = new Card[] {new Card(40),new Card(41),new Card(42),new Card(43),new Card(44),new Card(45),new Card(46)};
		CardSelector selector = new CardSelector();
		selector.SelectCard(cards, 5);		
	}
}
