package account.exception;

public class IdNoExistException extends Exception {
	public IdNoExistException(){}
	public IdNoExistException(String msg){
		System.out.print(msg);
	}
}
