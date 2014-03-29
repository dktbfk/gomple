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
	
	public static boolean withdraw(String id, int amount) throws SQLException{
		boolean result = false;
		SqlSession session = AccountDBUtil.getSqlSession();
		try{
			AccountDTO account = (AccountDTO)session.selectOne("selectAccountById", id);
			if(account.getAmount()-amount>=0){
				account.setAmount(account.getAmount() - amount);
				session.commit();
				result=true;
			}else{
				System.out.println("돈없으니까 집에가서 빈대떡이나 먹어");
				session.rollback();
			}
			session.update("updateAccount", account);
		}finally{
			session.close();
		}
		return result;
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
	
	public static void transfer(String myId, String pw, int amount, String id){
		SqlSession session = AccountDBUtil.getSqlSession();
		try{
			AccountDTO account = (AccountDTO)session.selectOne("selectAccountById", id);
			if(checkPw(myId,pw)){
				if(withdraw(myId,amount)){
					if(account!=null){
						deposit(id,amount);
						session.commit();
					}else{
						System.out.println("상대계좌 없음");
						session.rollback();
					}
				}else{
					System.out.println("너 돈없어");
					session.rollback();
				}
			}else{
				System.out.println("비번틀림");
				session.rollback();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
