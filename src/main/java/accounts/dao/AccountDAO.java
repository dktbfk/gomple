package accounts.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import accounts.dto.AccountDTO;
import accounts.util.AccountDBUtil;

public class AccountDAO {
	
	public static List selectAllAccounts() throws SQLException{
		SqlSession session = AccountDBUtil.getSqlSession();
		List selectAll = null;
		
		try{
			selectAll = session.selectList("Account.selectAllAccounts");
		}finally{
			session.close();
		}
		return selectAll;
	}
	
	public static AccountDTO selectAccountById(String id, int pw) throws SQLException{
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
			session.delete("deleteAccount", id);
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
	
	public static void withdraw(String id, int amount) throws SQLException{
		SqlSession session = AccountDBUtil.getSqlSession(true);
		try{
			AccountDTO account = (AccountDTO)session.selectOne("selectAccountById", id);
			account.setAmount(account.getAmount() - amount);
			session.update("updateAccount", account);
		}finally{
			session.close();
		}
	}
	
	public static boolean checkPw(String id, String pw)
	{
		boolean result = false;
		SqlSession session = AccountDBUtil.getSqlSession(true);
		try{
			AccountDTO account = (AccountDTO)session.selectOne("selectAccountById", id);
			if(account.getPassword().equals(pw))
			{
				result = true;
			}
		}finally{
			session.close();
		}	
		return result;
	}
}
