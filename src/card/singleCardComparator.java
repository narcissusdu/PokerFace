package card;

import java.util.Comparator;

/**
 * �����˿��ƴ�С�ȽϽӿ�ʵ��
 * �Ƚ�ʱ��ֻ�Ƚ�����ֵ��С
 * 
 */

public class singleCardComparator implements Comparator<Card> {

	public int compare(Card card_A, Card card_B) {
		int a = (card_A.getCardValue()==1)?14:card_A.getCardValue();
		int b = (card_B.getCardValue()==1)?14:card_B.getCardValue();
		
		int result = a-b;
/*    		
 		//  ��������Ƶ���һ�£���ô�Ƚ������ƵĻ�ɫ��ͨ�������Ƚϣ�
 		if (result == 0){
			result = -(card_A.getCardIndex() - card_B.getCardIndex());
		}
*/
		return result;
	}
}
