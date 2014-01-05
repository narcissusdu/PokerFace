package card;

import java.util.ArrayList;

public class CardProcessor {
	private static fiveCardsComparator comparator;
	private static FiveCards knownCards;
	public static int smallerCount;
	public static int largerCount;
	public static int equalCount;
	public static int[] powerArray;

	// public static int i = 0;

	public void Reset(FiveCards fc) {
		// i=0;
		smallerCount = 0;
		largerCount = 0;
		equalCount = 0;
		this.knownCards = fc;
		this.comparator = new fiveCardsComparator();
		this.powerArray = new int[10];
		for (int i = 0; i < 10; i++)
			this.powerArray[i] = 0;
	}

	public void ShowResult() {
		System.out.println("total count: "
				+ (smallerCount + largerCount + equalCount));
		// System.out.println("smaller count: " + smallerCount);
		// System.out.println("equal count: " + equalCount);
		// System.out.println("larger count: " + largerCount);
		System.out
				.println("winning hand :"
						+ ((double) smallerCount / (smallerCount + equalCount + largerCount)));
		for (int i = 0; i < 10; i++)
			System.out.println("" + this.powerArray[i] + "\tof\t"
					+ FiveCards.getCardPowerDesc(i));
	}

	// public void Process(ArrayList<Card> cardList) {
	// for (int i = 0; i < cardList.size(); i++) {
	// System.out.print(i);
	// cardList.get(i).showCard();
	// }
	// System.out.println(++i);
	// System.out.println();
	//
	// };

	public void Process(ArrayList<Card> cardList) {

		// i++;
		FiveCards fc = new FiveCards(cardList);

		int cmpResult = this.comparator.compare(knownCards, fc);

		this.powerArray[fc.getCardPower()]++;

		if (cmpResult > 0) {
			// fc.showCards();
			smallerCount++;
		} else if (cmpResult == 0)
			equalCount++;
		else
			largerCount++;

	};
}
