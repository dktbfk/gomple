package account.exception;

public class pwWrongException extends Exception {
	public pwWrongException(){}
	public pwWrongException(String msg){
		System.out.print(msg);
	}
}
