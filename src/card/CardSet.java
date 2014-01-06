package card;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import MyException.cardUsedOutException;
import cmn.DisorderArray;

public class CardSet {

	private List<Card> allCards = new ArrayList<Card>();
	private int[] cardUsedMap;
	private int totalUsedNum;
	private Random random;

	private int totalCardNum;
	private int[] cardOrder;
	private boolean washedFlag;

	/**
	 * @throws Exception
	 *********************************************/
	public CardSet() throws Exception {

		totalCardNum = 52;
		cardUsedMap = new int[totalCardNum];
		cardOrder = new int[totalCardNum];
		for (int index = 1; index <= totalCardNum; index++) {
			allCards.add(new Card(index));
			cardUsedMap[index - 1] = 0;
			cardOrder[index - 1] = index - 1;
		}
		totalUsedNum = 0;
		random = new Random();
		random.setSeed(new Date().getTime());
		washedFlag = false;
	}

	public void showCardSet() {
		for (int i = 0; i < this.totalCardNum; i++) {
			Card card = (Card) allCards.get(this.cardOrder[i]);
			card.showCard();
			if (this.cardUsedMap[this.cardOrder[i]] == 1) {
				System.out.print("已用");
			} else {
				System.out.print("可用");
			}
			if ((i) % 13 == 12) {
				System.out.print("\n");
			} else {
				System.out.print(" ");
			}
		}
	}

	public void returnACard(Card card) {
		this.cardUsedMap[card.getIndex() - 1] = 0;
		this.totalUsedNum--;
	}

	public Card getRandomCard() throws cardUsedOutException {
		if (this.totalUsedNum == this.totalCardNum) {
			throw new cardUsedOutException();
		}
		do {
			int index = Math.abs(random.nextInt()) % 52;
			// 随机数产生一张牌，如果这张牌没有被使用，则返回这张牌，否则继续循环。
			if (this.cardUsedMap[index] != 1) {
				this.cardUsedMap[index] = 1;
				this.totalUsedNum++;
				return allCards.get(index);
			}
		} while (true);
	}

	public void washCard() {
		if (washedFlag == true) {
			return;
		}
		cardOrder = DisorderArray.Disorder(this.totalCardNum);
		return;
	}

	public Card getFristCard() throws cardUsedOutException {
		if (this.totalUsedNum == this.totalCardNum) {
			throw new cardUsedOutException();
		}
		for (int i = 0; i < this.totalCardNum; i++) {
			if (this.cardUsedMap[this.cardOrder[i]] == 0) {
				this.cardUsedMap[this.cardOrder[i]] = 1;
				this.totalUsedNum--;
				return allCards.get(this.cardOrder[i]);
			}
		}
		return null;
	}
}
