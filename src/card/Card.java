package card;

public class Card {
	private final static String[] valueShowStyle = { null, "A", "1", "2", "3",
			"4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	private final static String[] patternShowStyle = { "��", "��", "÷", "��" };

	private int index; // �����˿��Ƶ�����
	private int value; // �˿��Ƶ���ֵ
	private int pattern; // �˿��ƵĻ�ɫ

	public Card(int index) throws Exception {
		/*
		 * һ������52�ţ����մ�A��K����"��"��"��"��˳���������� index �������е�������
		 */
		if (index > 52 || index < 1)
			throw new Exception(
					"index should be in {1 ,..., 52}, but now it is " + index);
		this.index = index;
		this.value = (index - 1) % 13 + 1;
		this.pattern = (index - 1) / 13;
	}

	public Card(int pattern, int value) throws Exception {
		if (pattern > 3 || pattern < 0 || value > 13 || value < 1)
			throw new Exception(
					"pattern should be in {1,...,4} and value should be in {1 ,..., 13}, but now they are "
							+ pattern + " and " + value);
		this.pattern = pattern;
		this.value = value;
		this.index = value + pattern * 13;
	}

	public int getIndex() {
		return this.index;
	}

	public int getValue() {
		return this.value == 1 ? 14 : this.value;

	}

	public int getFaceValue() {
		return this.value;
	}

	public int getPattern() {
		return this.pattern;
	}

	/**
	 * @return ���ر����ƵĻ�ɫ������
	 */
	public String getCardString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		sb.append(patternShowStyle[this.getPattern()]);
		sb.append(valueShowStyle[this.getFaceValue()]);
		sb.append(']');
		return sb.toString();
	}

	public void showCard() {
		System.out.print(this.getCardString());
	}

}
