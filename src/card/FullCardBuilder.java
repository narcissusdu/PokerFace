package card;

import java.util.ArrayList;

public class FullCardBuilder {
	public void ProcessCards(ArrayList<Card> riverCards,
			ArrayList<Card> knownCards) throws Exception {

		ArrayList<Card> cardCache = new ArrayList<Card>();
		for (int i = 1; i <= 52; i++)
			cardCache.add(new Card(i));

		ArrayList<Integer> intList = new ArrayList<Integer>();

		ArrayList<Card> cardList = new ArrayList<Card>();
		cardList.addAll(riverCards);
		cardList.addAll(knownCards);

		CardSelector cs = new CardSelector();
		FiveCards myBiggestFiveCards = cs.SelectMax5Cards(cardList);
		CardProcessor cp = new CardProcessor(myBiggestFiveCards);

		for (int i = 0; i < riverCards.size(); i++)
			intList.add(riverCards.get(i).getIndex());

		for (int i = 0; i < knownCards.size(); i++)
			intList.add(knownCards.get(i).getIndex());

		FiveCards fiveCardsBuilt;
		for (int i = 1; i < 53; i++) {
			if (intList.contains(i))
				continue;
			cardList.set(5, cardCache.get(i - 1));
			for (int j = 1; j < 53; j++) {
				if (intList.contains(j) || i == j)
					continue;
				cardList.set(6, cardCache.get(j - 1));
				fiveCardsBuilt = cs.SelectMax5Cards(cardList);
				cp.Process(fiveCardsBuilt);
			}
		}
		cp.ShowResult();
	}

}
