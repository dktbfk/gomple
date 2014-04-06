package accounts.test;

import java.sql.SQLException;
import java.util.List;

import account.exception.IdNoExistException;
import account.exception.NoAmountException;
import account.exception.PwWrongException;
import accounts.dao.AccountDAO;
import accounts.dto.AccountDTO;

public class MainTest {
	public static void main(String[] args) {
		
		try{
			List all = AccountDAO.selectAllAccounts();
			for(int index = 0; index < all.size(); index++){
				System.out.println(all.get(index));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("----------------------------------------------------");
	
		
		try{
			System.out.println(AccountDAO.selectAccountById("a001",1111));
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	//	try {
	//		AccountDAO.insertAcccount(new AccountDTO("a013","1234","김선명",12345678,0,010,"서울"));
	//	} catch (SQLException e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
		
		try {
			AccountDAO.deleteAccount("a013");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			System.out.println(AccountDAO.selectAccountById("a001",1111));
			System.out.println(AccountDAO.selectAccountById("a005",5555));
		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			AccountDAO.transfer("a005", "5555", 1000, "a001");
			System.out.println(AccountDAO.selectAccountById("a001",1111));
			System.out.println(AccountDAO.selectAccountById("a005",5555));
		} catch (PwWrongException e1) {
			e1.printStackTrace();
		} catch (NoAmountException e1) {
			e1.printStackTrace();
		} catch (IdNoExistException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	

}
