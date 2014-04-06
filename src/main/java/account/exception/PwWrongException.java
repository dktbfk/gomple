package account.exception;

public class PwWrongException extends Exception {
	public PwWrongException(){}
	public PwWrongException(String msg){
		super(msg);
	}
}
