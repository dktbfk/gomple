package accounts.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import account.exception.IdNoExistException;
import account.exception.NoAmountException;
import account.exception.PwWrongException;
import accounts.dao.AccountDAO;
import accounts.dto.AccountDTO;

public class MainTest {
	public static void main(String[] args) {
		
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		
		try {
			System.out.println("============================= 계좌 등록 및 전체 출력 =============================");
			AccountDAO.insertAcccount(new AccountDTO("a001","1111","김세윤","20130329001","01001","두잇시스템"));
			AccountDAO.insertAcccount(new AccountDTO("a002","2222","김유리","20130329002","01002","더시스템시스코"));
			AccountDAO.insertAcccount(new AccountDTO("a003","3333","김의태","20130329003","01003","애버커스"));
			AccountDAO.insertAcccount(new AccountDTO("a004","4444","이규혁","20130329004","01004","낙스넷"));
			AccountDAO.insertAcccount(new AccountDTO("a005","5555","김정환","20130329005","01005","인밸류비즈"));
			AccountDAO.insertAcccount(new AccountDTO("a006","6666","김현수","20130329006","01006","애니파이브시스템"));
			AccountDAO.insertAcccount(new AccountDTO("a007","7777","남궁준","20130329007","01007","아이티인프라넷"));
			AccountDAO.insertAcccount(new AccountDTO("a008","8888","배은지","20130329008","01008","낙스넷"));
			AccountDAO.insertAcccount(new AccountDTO("a009","9999","여인률","20130329009","01009","수펙스테크놀러지"));
			AccountDAO.insertAcccount(new AccountDTO("a010","1010","유병찬","20130329010","01010","디지털플러스시스템"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			list = AccountDAO.selectAllAccounts();
			int cnt = list.size();
			for (int i = 0; i < cnt; i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("============================= 5명 입금 =============================");
		try {
			AccountDAO.deposit("a001", 2000);
			AccountDAO.deposit("a002", 12000);
			AccountDAO.deposit("a003", 5000);
			AccountDAO.deposit("a004", 20000);
			AccountDAO.deposit("a005", 1000);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("============================= 계좌 조회 =============================");
		try {
			System.out.println(AccountDAO.selectAccountById("a001", "1111"));
			System.out.println(AccountDAO.selectAccountById("a002", "2222"));
		} catch (PwWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("============================= 틀린 pw =============================");
		try {
			AccountDAO.selectAccountById("a003", "1313");
		} catch (PwWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("============================= 계좌 출금 =============================");
		try {
			AccountDAO.withdraw("a002", "2222", 3000);
			AccountDAO.withdraw("a008", "8888", 1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("============================= 계좌 조회 =============================");
		try {
			System.out.println(AccountDAO.selectAccountById("a002", "1111"));
		} catch (PwWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("============================= 계좌 이체 =============================");
		try {
			AccountDAO.transfer("a001", "1111", 1000, "a006");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			AccountDAO.transfer("a003", "3333", 7000, "a007");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			AccountDAO.transfer("a004", "4444", 7000, "a011");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println("============================= 전체 결과 출력 =============================");
		
		try {
			list = AccountDAO.selectAllAccounts();
			int cnt = list.size();
			for (int i = 0; i < cnt; i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
