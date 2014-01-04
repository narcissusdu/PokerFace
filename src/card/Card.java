package card;

import MyException.CardInitialException;

public class Card {
	
	private int cardIndex;			//单张扑克牌的序数 
	private int cardValue;			//扑克牌的面值
	private int cardPattern;		//扑克牌的花色
	private String cardString;		//先使用的扑克牌字符串

	public Card(int index) throws CardInitialException {
		/*
		 * 一副牌有52张，按照从A到K，从"黑"到"方"的顺序依次排列 index 就是排列的序数。
		 */
		if (index > 52 || index < 1) {
			throw new CardInitialException("Card index 应该大于等于1，小于等于52。输入参数是:" + "["
					+ index + "]");
		}
		this.cardIndex = index;
		this.cardValue = (index - 1) % 13 + 1;
		this.cardPattern = (index - 1) / 13;
		this.cardString = getCardString();
	}

	/*******************************************************************/

	/**
	 * @return 返回本张牌的花色和数字
	 */
	private String getCardString() {		
		String cStr = "";

		cStr += "[" + Card.getPattern(this.getCardPattern()) + " ";
		switch (this.cardValue) {
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10: {
			cStr += this.cardValue;
			break;
		}
		case 1: {
			cStr += "A";
			break;
		}
		case 11: {
			cStr += "J";
			break;
		}
		case 12: {
			cStr += "Q";
			break;
		}
		case 13: {
			cStr += "K";
			break;
		}
		}
		/*
		 * if (this.cardValue != 10) { cStr += " "; }
		 */
		cStr += "]";
		return cStr;
	}

	public void showCard() {
		System.out.print(this.cardString);
	}

	/*******************************************************************/
	
	static public String getPattern(int pattern){
		String MARK[] = { "黑", "红", "梅", "方" };
		return MARK[pattern%4];
	}

	public int getCardIndex() {
		return this.cardIndex;
	}

	public int getCardValue() {
		return this.cardValue;
	}

	public int getCardPattern() {
		return this.cardPattern;
	}
}
