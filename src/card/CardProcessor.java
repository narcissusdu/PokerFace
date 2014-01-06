package card;

public class CardProcessor {

	private fiveCardsComparator comparator;
	private FiveCards knownCards;
	private int smallerCount;
	private int largerCount;
	private int equalCount;
	private int[] powerArray;

	// public static int i = 0;

	public CardProcessor(FiveCards fc) {
		// i=0;
		smallerCount = 0;
		largerCount = 0;
		equalCount = 0;
		knownCards = fc;
		comparator = new fiveCardsComparator();
		powerArray = new int[10];
		for (int i = 0; i < 10; i++)
			powerArray[i] = 0;
	}

	public void ShowResult() {
		this.knownCards.showCards();
		System.out.println("total count: "
				+ (smallerCount + largerCount + equalCount));
		// System.out.println("smaller count: " + smallerCount);
		// System.out.println("equal count: " + equalCount);
		// System.out.println("larger count: " + largerCount);
		System.out
				.println("winning hand :"
						+ ((double) smallerCount / (smallerCount + equalCount + largerCount)));
		for (int i = 0; i < 10; i++)
			System.out.println("" + powerArray[i] + "\tof\t"
					+ FiveCards.getCardPowerDesc(i));
	}

	public void Process(FiveCards fc) {

		int cmpResult = comparator.compare(knownCards, fc);

		powerArray[fc.getCardPower()]++;

		if (cmpResult > 0) {
			// fc.showCards();
			smallerCount++;
		} else if (cmpResult == 0)
			equalCount++;
		else
			largerCount++;

	};
}
