package card;

import java.util.Comparator;

import cmn.LogUtils;

public class fiveCardsComparator implements Comparator<FiveCards> {

	@Override
	public int compare(FiveCards o1, FiveCards o2) {
		// TODO Auto-generated method stub
		//
		// System.out.println("o1 "+o1.getCardPower()+FiveCards.getCardPowerDesc(o1.getCardPower()));
		// System.out.println("o2 "+o2.getCardPower()+FiveCards.getCardPowerDesc(o2.getCardPower()));
		if (o1.getCardPower() < o2.getCardPower()) {
			return 1;
		} else if (o1.getCardPower() > o2.getCardPower()) {
			return -1;
		} else {
			switch (o1.getCardPower()) {
			case 0:
				return this.compareRoyalFlush(o1, o2);
			case 1:
				return this.compareStraightFlush(o1, o2);
			case 2:
				return this.compareFourOfAKind(o1, o2);
			case 3:
				return this.compareFullHouse(o1, o2);
			case 4:
				return this.compareFlush(o1, o2);
			case 5:
				return this.compareStraight(o1, o2);
			case 6:
				return this.compareThreeOfAKind(o1, o2);
			case 7:
				return this.compareTwoPairs(o1, o2);
			case 8:
				return this.compareOnePair(o1, o2);
			case 9:
				return this.compareHighCard(o1, o2);
			}
		}

		return 0;
	}

	private int compareHighCard(FiveCards o1, FiveCards o2) {
		// max -> min compare each o1 and o2 card pair
		int i;
		int o1CardValue = 0;
		int o2CardValue = 0;

		// System.out.println("compareHighCard");

		i = 4;
		o1CardValue = o1.getACard(i).getValue();
		o2CardValue = o2.getACard(i).getValue();
		if (o1CardValue != o2CardValue) {
			return o1CardValue - o2CardValue;
		}

		i = 3;
		while (i > -1) {
			if (o1.getACard(i).getValue() == o2.getACard(i).getValue()) {
				i--;
			} else {
				return o1.getACard(i).getValue() - o2.getACard(i).getValue();
			}
		}
		return 0;
	}

	private int compareOnePair(FiveCards o1, FiveCards o2) {
		// AABCD ABBCD ABCCD ABCDD
		int o1CardValue[] = new int[4];
		int o2CardValue[] = new int[4];
		// System.out.println("compareOnePair");
		if (o1.getACard(0).getValue() == o1.getACard(1).getValue()) {
			// case 1 AABCD:
			o1CardValue[0] = o1.getACard(0).getValue();
			o1CardValue[1] = o1.getACard(4).getValue();
			o1CardValue[2] = o1.getACard(3).getValue();
			o1CardValue[3] = o1.getACard(2).getValue();
		} else if (o1.getACard(1).getValue() == o1.getACard(2).getValue()) {
			// case 2 ABBCD
			o1CardValue[0] = o1.getACard(1).getValue();
			o1CardValue[1] = o1.getACard(4).getValue();
			o1CardValue[2] = o1.getACard(3).getValue();
			o1CardValue[3] = o1.getACard(0).getValue();

		} else if (o1.getACard(2).getValue() == o1.getACard(3).getValue()) {
			// case 3 ABCCD
			o1CardValue[0] = o1.getACard(2).getValue();
			o1CardValue[1] = o1.getACard(4).getValue();
			o1CardValue[2] = o1.getACard(1).getValue();
			o1CardValue[3] = o1.getACard(0).getValue();
		} else {
			// case 4 ABCDD
			o1CardValue[0] = o1.getACard(4).getValue();
			o1CardValue[1] = o1.getACard(2).getValue();
			o1CardValue[2] = o1.getACard(1).getValue();
			o1CardValue[3] = o1.getACard(0).getValue();
		}

		if (o2.getACard(0).getValue() == o2.getACard(1).getValue()) {
			// case 1 AABCD:
			o2CardValue[0] = o2.getACard(0).getValue();
			o2CardValue[1] = o2.getACard(4).getValue();
			o2CardValue[2] = o2.getACard(3).getValue();
			o2CardValue[3] = o2.getACard(2).getValue();
		} else if (o2.getACard(1).getValue() == o2.getACard(2).getValue()) {
			// case 2 ABBCD
			o2CardValue[0] = o2.getACard(1).getValue();
			o2CardValue[1] = o2.getACard(4).getValue();
			o2CardValue[2] = o2.getACard(3).getValue();
			o2CardValue[3] = o2.getACard(0).getValue();

		} else if (o2.getACard(2).getValue() == o2.getACard(3).getValue()) {
			// case 3 ABCCD
			o2CardValue[0] = o2.getACard(2).getValue();
			o2CardValue[1] = o2.getACard(4).getValue();
			o2CardValue[2] = o2.getACard(1).getValue();
			o2CardValue[3] = o2.getACard(0).getValue();
		} else {
			// case 4 ABCDD
			o2CardValue[0] = o2.getACard(4).getValue();
			o2CardValue[1] = o2.getACard(2).getValue();
			o2CardValue[2] = o2.getACard(1).getValue();
			o2CardValue[3] = o2.getACard(0).getValue();
		}

		for (int i = 0; i < o1CardValue.length; i++) {
			if (o1CardValue[i] != o2CardValue[i]) {
				return o1CardValue[i] - o2CardValue[i];
			}
		}

		return 0;
	}

	private int compareTwoPairs(FiveCards o1, FiveCards o2) {
		// AABBC AABCC ABBCC
		// compare order int[0] int [1] int[2];
		int o1CardValue[] = new int[3];
		int o2CardValue[] = new int[3];
		LogUtils.debug("compareTwoPairs");
		if (o1.getACard(4).getValue() != o1.getACard(3).getValue()) {
			// case 1 AABBC:
			o1CardValue[0] = o1.getACard(2).getValue();
			o1CardValue[1] = o1.getACard(0).getValue();
			o1CardValue[2] = o1.getACard(4).getValue();
		} else if (o1.getACard(2).getValue() != o1.getACard(3).getValue()) {
			// case 2 AABCC
			o1CardValue[0] = o1.getACard(4).getValue();
			o1CardValue[1] = o1.getACard(0).getValue();
			o1CardValue[2] = o1.getACard(2).getValue();

		} else {
			// case 3 ABBCC
			o1CardValue[0] = o1.getACard(4).getValue();
			o1CardValue[1] = o1.getACard(1).getValue();
			o1CardValue[2] = o1.getACard(0).getValue();
		}

		if (o2.getACard(4).getValue() != o2.getACard(3).getValue()) {
			// case 1 AABBC:
			o2CardValue[0] = o2.getACard(2).getValue();
			o2CardValue[1] = o2.getACard(0).getValue();
			o2CardValue[2] = o2.getACard(4).getValue();
		} else if (o2.getACard(2).getValue() != o2.getACard(3).getValue()) {
			// case 2 AABCC
			o2CardValue[0] = o2.getACard(4).getValue();
			o2CardValue[1] = o2.getACard(0).getValue();
			o2CardValue[2] = o2.getACard(2).getValue();

		} else {
			// case 3 ABBCC
			o2CardValue[0] = o2.getACard(4).getValue();
			o2CardValue[1] = o2.getACard(1).getValue();
			o2CardValue[2] = o2.getACard(0).getValue();
		}

		for (int i = 0; i < o1CardValue.length; i++) {
			if (o1CardValue[i] != o2CardValue[i]) {
				return o1CardValue[i] - o2CardValue[i];
			}
		}

		return 0;
	}

	private int compareThreeOfAKind(FiveCards o1, FiveCards o2) {
		// ABCCC ABBBC AAABC
		// compare order int[0] int [1] int[2];
		int o1CardValue[] = new int[3];
		int o2CardValue[] = new int[3];

		LogUtils.debug("compareThreeOfAKind");

		o1CardValue[0] = o1.getACard(2).getValue();
		if (o1.getACard(0).getValue() == o1CardValue[0]) {
			// case 3;
			o1CardValue[1] = o1.getACard(4).getValue();
			o1CardValue[2] = o1.getACard(3).getValue();
		} else if (o1.getACard(4).getValue() == o1CardValue[0]) {
			// Case 1
			o1CardValue[1] = o1.getACard(1).getValue();
			o1CardValue[2] = o1.getACard(0).getValue();
		} else {
			// Case 2
			o1CardValue[1] = o1.getACard(4).getValue();
			o1CardValue[2] = o1.getACard(0).getValue();
		}

		o2CardValue[0] = o2.getACard(2).getValue();
		if (o2.getACard(0).getValue() == o2CardValue[0]) {
			// case 3;
			o2CardValue[1] = o2.getACard(4).getValue();
			o2CardValue[2] = o2.getACard(3).getValue();
		} else if (o2.getACard(4).getValue() == o2CardValue[0]) {
			// Case 1
			o2CardValue[1] = o2.getACard(1).getValue();
			o2CardValue[2] = o2.getACard(0).getValue();
		} else {
			// Case 2
			o2CardValue[1] = o2.getACard(4).getValue();
			o2CardValue[2] = o2.getACard(0).getValue();
		}

		for (int i = 0; i < o1CardValue.length; i++) {
			if (o1CardValue[i] != o2CardValue[i]) {
				return o1CardValue[i] - o2CardValue[i];
			}
		}
		return 0;
	}

	private int compareStraight(FiveCards o1, FiveCards o2) {
		//
		// compare the minimal card value.
		int o1CardValue = 0;
		int o2CardValue = 0;

		LogUtils.debug("compareStraight");

		if (o1.getACard(0).getFaceValue() == 2
				&& o1.getACard(4).getFaceValue() == 1) {
			o1CardValue = 1;
		} else {
			o1CardValue = o1.getACard(0).getFaceValue();
		}

		if (o2.getACard(0).getFaceValue() == 2
				&& o2.getACard(4).getFaceValue() == 1) {
			o2CardValue = 1;
		} else {
			o2CardValue = o2.getACard(0).getFaceValue();
		}
		return o1CardValue - o2CardValue;
	}

	private int compareFlush(FiveCards o1, FiveCards o2) {
		LogUtils.debug("compareFlush");
		return this.compareHighCard(o1, o2);
	}

	private int compareFullHouse(FiveCards o1, FiveCards o2) {
		LogUtils.debug("compareFullHouse");
		return this.compareThreeOfAKind(o1, o2);
	}

	private int compareFourOfAKind(FiveCards o1, FiveCards o2) {
		// ABBBB or BBBBA
		int o1CardValue = 0;
		int o2CardValue = 0;

		LogUtils.debug("compareFourOfAKind");
		if (o1.getACard(2).getValue() != o2.getACard(2).getValue()) {
			o1CardValue = o1.getACard(2).getValue();
			o2CardValue = o2.getACard(2).getValue();
		} else {

			o1CardValue = (o1.getACard(0).getValue() == o1.getACard(2)
					.getValue() ? o1.getACard(4).getValue() : o1.getACard(0)
					.getValue());

			o2CardValue = (o2.getACard(0).getValue() == o2.getACard(2)
					.getValue() ? o2.getACard(4).getValue() : o2.getACard(0)
					.getValue());
		}
		return o1CardValue - o2CardValue;
	}

	private int compareStraightFlush(FiveCards o1, FiveCards o2) {
		// Straight Flush or Straight:
		// just compare the minimal card.
		LogUtils.debug("compareStraightFlush");
		return this.compareStraight(o1, o2);
	}

	private int compareRoyalFlush(FiveCards o1, FiveCards o2) {
		LogUtils.debug("compareRoyalFlush");
		// all the royal flush cards are even.
		return 0;
	}
}
