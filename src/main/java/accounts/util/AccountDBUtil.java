package accounts.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AccountDBUtil {
private static SqlSessionFactory factory = null;
	
	static {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(inputStream);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/* openSession()
	 * - myBatis 기반의 db통신 및 실행 결과 반환 객체를 제공해주는 메소드
	 * - 특징
	 * 		- tx 작업 필요시에는 commit(), rollback() 메소드 코드로 직접 제어
	 * 
	 * - openSession(true)
	 * 	- 특징 : autocommit
	 */
	public static SqlSession getSqlSession() {
		return factory.openSession();
	}

	public static SqlSession getSqlSession(boolean autoCommit) {
		return factory.openSession(autoCommit);
	}

	/*public static void closeSqlSession(SqlSession session) {
		if (session != null) {
			session.close();
		}
	}*/

	public static void closeSqlSession(boolean commit, SqlSession session) {
		if (session != null) {
			if (commit) {
				session.commit();
			} else {
				session.rollback();
			}
			session.close();//자원반환 
		}
	}

}
