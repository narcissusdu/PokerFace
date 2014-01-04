package MyException;

public class CardInitialException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 0x00001L;
	private String ErrorMessage;
	public CardInitialException(String string) {
		// TODO Auto-generated constructor stub
		ErrorMessage = string;
	}
	public String getMessage(){
		return this.ErrorMessage;
	}
	

}
