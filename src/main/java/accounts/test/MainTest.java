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
		
		try {
			AccountDAO.insertAcccount(new AccountDTO("a001","1111","김세윤","20130329001",0,01001,"두잇시스템"));
			/*AccountDAO.insertAcccount(new AccountDTO("a002","2222","김유리","20130329002","0","01002","더시스템시스코"));
			AccountDAO.insertAcccount(new AccountDTO("a003","3333","김의태","20130329003","0","01003","애버커스"));
			AccountDAO.insertAcccount(new AccountDTO("a004","4444","이규혁","20130329004","0","01004","낙스넷"));
			AccountDAO.insertAcccount(new AccountDTO("a005","5555","김정환","20130329005","0","01005","인밸류비즈"));
			AccountDAO.insertAcccount(new AccountDTO("a006","6666","김현수","20130329006","0","01006","애니파이브시스템"));
			AccountDAO.insertAcccount(new AccountDTO("a007","7777","남궁준","20130329007","0","01007","아이티인프라넷"));
			AccountDAO.insertAcccount(new AccountDTO("a008","8888","배은지","20130329008","0","01008","낙스넷"));
			AccountDAO.insertAcccount(new AccountDTO("a009","9999","여인률","20130329009","0","01009","수펙스테크놀러지"));
			AccountDAO.insertAcccount(new AccountDTO("a010","1010","유병찬","20130329010","0","01010","디지털플러스시스템"));
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
