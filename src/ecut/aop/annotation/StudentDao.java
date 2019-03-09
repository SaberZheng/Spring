package ecut.aop.annotation;

import org.springframework.stereotype.Repository;

/**
 * 数据访问层 ( Repository ) 专门负责访问数据库
 * DAO :Data Access Object , 数据访问对象
 * 对象封装数据
 */
@Repository
public class StudentDao {
	
	public void persist( Student s ) {
		System.out.println( "StudentDao 的  persist 方法提示你: 保存 "+ s.getName()  );
	}

}
