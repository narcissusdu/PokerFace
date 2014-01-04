package MyException;

public class cardUsedOutException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 0x00002L;

	public String getMessage(){
		return "这副牌已经用光了";
	}
}
