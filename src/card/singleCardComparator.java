package card;

import java.util.Comparator;

/**
 * 单张扑克牌大小比较接口实现
 * 比较时，只比较牌面值大小
 * 
 */

public class singleCardComparator implements Comparator<Card> {

	public int compare(Card card_A, Card card_B) {
		int a = (card_A.getCardValue()==1)?14:card_A.getCardValue();
		int b = (card_B.getCardValue()==1)?14:card_B.getCardValue();
		
		int result = a-b;
/*    		
 		//  如果两张牌点数一致，那么比较两张牌的花色（通过序数比较）
 		if (result == 0){
			result = -(card_A.getCardIndex() - card_B.getCardIndex());
		}
*/
		return result;
	}
}
