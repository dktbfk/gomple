package accounts.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import account.exception.IdNoExistException;
import account.exception.NoAmountException;
import account.exception.PwWrongException;
import accounts.dto.AccountDTO;
import accounts.util.AccountDBUtil;

public class AccountDAO {
	
	public static boolean checkPw(String id, String pw)	{
		boolean result = false;
		SqlSession session = AccountDBUtil.getSqlSession(true);
		try{
			AccountDTO account = (AccountDTO)session.selectOne("selectAccountById", id);
			if(account.getPassword().equals(pw))			{
				result = true;
			}
		}finally{
			session.close();
		}	
		return result;
	}
	
	public static List<AccountDTO> selectAllAccounts() throws SQLException{
		SqlSession session = AccountDBUtil.getSqlSession();
		List<AccountDTO> selectAll = null;
		
		try{
			selectAll = session.selectList("Account.selectAllAccounts");
		}finally{
			session.close();
		}
		return selectAll;
	}
	
	public static AccountDTO selectAccountById(String id, String pw) throws PwWrongException{
		if(!checkPw(id,pw)){
			throw new PwWrongException("비밀번호가 맞지 않습니다.");
		}
		SqlSession session = AccountDBUtil.getSqlSession();
		AccountDTO account = null;
		try {
			account = (AccountDTO)session.selectOne("selectAccountById",id);
		} finally {
			session.close();
		}
		
		return account;
	}
	
	public static void insertAcccount(AccountDTO account) throws SQLException{
		SqlSession session = AccountDBUtil.getSqlSession(true);
		try{
			session.insert("insertAccount", account);
		}finally{
			session.close();
		}
		
	}
	
	public static void deleteAccount(String id) throws SQLException{
		SqlSession session = AccountDBUtil.getSqlSession(true);
		try{
			session.delete("deleteAccountById", id);
		}finally{
			session.close();
		}
		
	}
	
	public static void deposit(String id, int amount) throws SQLException{
		SqlSession session = AccountDBUtil.getSqlSession(true);
		try{
			AccountDTO account = (AccountDTO)session.selectOne("selectAccountById", id);
			account.setAmount(account.getAmount() + amount);
			session.update("updateAccount", account);
		}finally{
			session.close();
		}
	}
	
	public static boolean withdraw(String id,String pw, int amount) throws PwWrongException, NoAmountException{
		if(!checkPw(id,pw)){
			throw new PwWrongException("비밀번호가 맞지 않습니다.");
		}
		boolean result = false;
		SqlSession session = AccountDBUtil.getSqlSession();
		try{
			AccountDTO account = (AccountDTO)session.selectOne("selectAccountById", id);
			if(account.getAmount()-amount < 0){
				throw new NoAmountException("잔액이 부족합니다.");
			}
			account.setAmount(account.getAmount() - amount);
			session.commit();
			result=true;
			session.update("updateAccount", account);
		}finally{
			session.close();
		}
		return result;
	}
	
		
	public static void transfer(String myId, String pw, int amount, String id)
			throws PwWrongException, NoAmountException, IdNoExistException, SQLException{
		SqlSession session = AccountDBUtil.getSqlSession();
		try{
			AccountDTO account = (AccountDTO)session.selectOne("selectAccountById", id);
			if(!checkPw(myId,pw)){
				throw new PwWrongException("비밀번호가 맞지 않습니다.");
			}
			if(!withdraw(myId,pw,amount)){
				throw new NoAmountException("잔액이 부족합니다.");
			}
			if(account == null){
				throw new IdNoExistException("존재하지 않는 계좌 입니다.");
			}
			deposit(id,amount);
			session.commit();
		}finally{
			session.close();
		}
	}
}
