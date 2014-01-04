package card;

import MyException.CardInitialException;

public class Card {
	
	private int cardIndex;			//�����˿��Ƶ����� 
	private int cardValue;			//�˿��Ƶ���ֵ
	private int cardPattern;		//�˿��ƵĻ�ɫ
	private String cardString;		//��ʹ�õ��˿����ַ���

	public Card(int index) throws CardInitialException {
		/*
		 * һ������52�ţ����մ�A��K����"��"��"��"��˳���������� index �������е�������
		 */
		if (index > 52 || index < 1) {
			throw new CardInitialException("Card index Ӧ�ô��ڵ���1��С�ڵ���52�����������:" + "["
					+ index + "]");
		}
		this.cardIndex = index;
		this.cardValue = (index - 1) % 13 + 1;
		this.cardPattern = (index - 1) / 13;
		this.cardString = getCardString();
	}

	/*******************************************************************/

	/**
	 * @return ���ر����ƵĻ�ɫ������
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
		String MARK[] = { "��", "��", "÷", "��" };
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
