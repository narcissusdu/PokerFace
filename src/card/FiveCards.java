package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FiveCards {

	private List<Card> cardsOf5;
	private int totalCardNum;
	private boolean sortedFlag;
	private int cardPower;

	public FiveCards() {
		cardPower = -1;
		sortedFlag = false;
		totalCardNum = 0;
		cardsOf5 = new ArrayList<Card>();
	}
	
	public void cleanCard(){
		cardPower = -1;
		sortedFlag = false;
		totalCardNum = 0;
		cardsOf5 = new ArrayList<Card>();
	}

	public Card getACard(int index) {
		if (index < 0 || index >= this.totalCardNum) {
			System.out.println("[ERROR]卡片索引超出数组范围");
			return null;
		}
		return this.cardsOf5.get(index);
	}

	public boolean withdrawCard(int index) {
		if (index < 0 || index >= this.totalCardNum) {
			System.out.println("[ERROR]卡片索引超出数组范围");
			return false;
		}
		cardsOf5.remove(index);
		this.setSortedFlag(false);
		this.totalCardNum--;
		return false;
	}

	public boolean addCard(Card card) {
		if (this.totalCardNum == 5) {
			System.out.println("[ERROR]手牌已满，放弃纸牌");
			return false;
		} else {
			this.cardsOf5.add(card);
			this.totalCardNum++;
			this.setSortedFlag(false);
			if (this.totalCardNum == 5) {
				Collections.sort(cardsOf5, new singleCardComparator());
				this.setSortedFlag(true);
				this.cardPower = this.getSuitCardPower();
			}
			return true;
		}
	}

	/*
	 * 输入一手牌，判断牌型是什么
	 */
	public int getSuitCardPower() {
		if (this.isHandCardFull() == false) {
			return -1;
		}
		if (true == isRoyalFlush(this)) {
			return 0;
		} else if (true == isStraightFlush(this)) {
			return 1;
		} else if (true == isFourOfAKind(this)) {
			return 2;
		} else if (true == isFullHouse(this)) {
			return 3;
		} else if (true == isFlush(this)) {
			return 4;
		} else if (true == isStraight(this)) {
			return 5;
		} else if (true == isThreeOfAKind(this)) {
			return 6;
		} else if (true == isTwoPairs(this)) {
			return 7;
		} else if (true == isOnePair(this)) {
			return 8;
		} else if (true == isHighCard(this)) {
			return 9;
		}
		return -1;
	}

	/*
	 * AKQJ10五张组成，并且这5张牌花色相同
	 */
	static public boolean isRoyalFlush(FiveCards fiveCards) {
		if (fiveCards.getACard(0).getCardValue() == 10
				&& fiveCards.getACard(4).getCardValue() == 1
				&& isStraightFlush(fiveCards) == true) {
			return true;
		}
		return false;
	}

	/*
	 * 同花顺(straight flush）：由五张连张同花色的牌组成
	 */
	static public boolean isStraightFlush(FiveCards fiveCards) {
		if (isFlush(fiveCards) == true && isStraight(fiveCards)) {
			return true;
		}
		return false;
	}

	/*
	 * 4条（four of a kind）
	 */
	static public boolean isFourOfAKind(FiveCards fiveCards) {
		int value[] = new int[5];
		for (int i = 0; i < 5; i++) {
			value[i] = fiveCards.getACard(i).getCardValue();
		}

		if ((value[1] == value[2] && value[1] == value[3])
				&& (value[1] == value[0] || value[3] == value[4])) {
			return true;
		}
		return false;
	}

	/*
	 * 满堂红（full house）（又称“葫芦”）：3张同点值加上另外一对
	 */
	static public boolean isFullHouse(FiveCards fiveCards) {

		int value[] = new int[5];
		for (int i = 0; i < 5; i++) {
			value[i] = fiveCards.getACard(i).getCardValue();
		}

		if ((value[0] == value[1] && value[3] == value[4])
				&& (value[2] == value[1] || value[2] == value[3])) {
			return true;
		}
		return false;
	}

	/*
	 * 同花（flush）：5张牌花色相同，但是不成顺子（straight）：
	 */
	static public boolean isFlush(FiveCards fiveCards) {
		int pattern[] = new int[5];
		for (int i = 0; i < 5; i++) {
			pattern[i] = fiveCards.getACard(i).getCardPattern();
		}
		if (pattern[0] == pattern[1] && pattern[0] == pattern[2]
				&& pattern[0] == pattern[3] && pattern[0] == pattern[4]) {
			return true;
		}
		return false;
	}

	/*
	 * 顺子（straight）：五张牌连张
	 */
	static public boolean isStraight(FiveCards fiveCards) {
		int value[] = new int[5];
		int pattern[] = new int[5];
		for (int i = 0; i < 5; i++) {
			value[i] = fiveCards.getACard(i).getCardValue();
			pattern[i] = fiveCards.getACard(i).getCardPattern();
		}
		/*
		 * 判断是否是顺子：
		 * 1. 是否是不带A的顺子：
		 *    相间两张牌的值差是1；
		 * 2. 带A的顺子：
		 *	  第一张是2，则2,3,4,5，A
		 *    第一张是10 则10，J，Q，K，A
		 */
		
		if(value[2]-value[1]==1 && value[3]-value[2]==1){
			if(value[4]==1){
				if((value[0]!=2)&&(value[0]!=10)){
					return false;
				}
			}else{
				if((value[1]-value[0]!=1)&&(value[4]-value[3]!=1)){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/*
	 * 3条（three of a kind）：三张牌点值相同，
	 */
	static public boolean isThreeOfAKind(FiveCards fiveCards) {
		int value[] = new int[5];
		for (int i = 0; i < 5; i++) {
			value[i] = fiveCards.getACard(i).getCardValue();
		}
		if(value[0]==value[1] && value[1]==value[2] && value[2]!=value[3] && value[3]!=value[4]){
			return true;
		}else
		if(value[0]!=value[1] && value[1]==value[2] && value[2]==value[3] && value[3]!=value[4]){
			return true;
		}else
		if(value[0]!=value[1] && value[1]!=value[2] && value[2]==value[3] && value[3]==value[4]){
			return true;
		}
		return false;
	}

	/*
	 * 两对（two pairs）：两对加上一个杂牌
	 */
	static public boolean isTwoPairs(FiveCards fiveCards) {
		int value[] = new int[5];
		for (int i = 0; i < 5; i++) {
			value[i] = fiveCards.getACard(i).getCardValue();
		}
		if(value[0]==value[1] && value[1]!=value[2] && value[2]==value[3] && value[3]!=value[4]){
			return true;
		}else
		if(value[0]==value[1] && value[1]!=value[2] && value[2]!=value[3] && value[3]==value[4]){
			return true;
		}else
		if(value[0]!=value[1] && value[1]==value[2] && value[2]!=value[3] && value[3]==value[4]){
			return true;
		}
		return false;
	}

	/*
	 * 一对（one pair）：一对加上三张杂牌
	 */
	static public boolean isOnePair(FiveCards fiveCards) {
		int value[] = new int[5];
		for (int i = 0; i < 5; i++) {
			value[i] = fiveCards.getACard(i).getCardValue();
		}
		if(value[0]==value[1] && value[1]!=value[2] && value[2]!=value[3] && value[3]!=value[4]){
			return true;
		}else
		if(value[0]!=value[1] && value[1]==value[2] && value[2]!=value[3] && value[3]!=value[4]){
			return true;
		}else
		if(value[0]!=value[1] && value[1]!=value[2] && value[2]==value[3] && value[3]!=value[4]){
			return true;
		}else
		if(value[0]!=value[1] && value[1]!=value[2] && value[2]!=value[3] && value[3]==value[4]){
			return true;
		}		
		return false;
	}

	/*
	 * 高牌（high card）：非以上的牌
	 */
	static public boolean isHighCard(FiveCards fiveCards) {
		return true;
	}

	/*
	 * 返回具体牌型的名字
	 */
	static public String getCardPowerDesc(int power) {
		String PowerName[] = { "[Royal Flush]", "[Straight Flush]",
				"[Four of A Kind]", "[Full House]", "[Flush]", "[Straight]",
				"[Three of A Kind]", "[Two Pairs]", "[One Pair]", "[High Card]" };

		if (power == -1) {
			return "[还未成一套牌]";
		}

		return PowerName[power];
	}

	public boolean isSortedFlag() {
		return sortedFlag;
	}

	public void setSortedFlag(boolean sortedFlag) {
		this.sortedFlag = sortedFlag;
	}

	public boolean isHandCardFull() {
		return this.totalCardNum == 5;
	}

	public int getTotalCardNum() {
		return this.totalCardNum;
	}

	public void showCars() {
		System.out.println("================================");
		for (Card c : this.cardsOf5) {
			c.showCard();
			System.out.print(",");
		}
		System.out.println("\n================================");
	}

	/**
	 * @return the cardPower
	 */
	public int getCardPower() {
		return cardPower;
	}
}
