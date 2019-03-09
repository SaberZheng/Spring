package ecut.aop.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务逻辑层 ( Service ) 具体的业务逻辑
 */
@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao ;
	
	public void save( Student s ) {
		System.out.println( "StudentService # save ( Student ) " );
		studentDao.persist( s );
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

}
