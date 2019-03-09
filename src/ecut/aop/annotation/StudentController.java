package ecut.aop.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * 控制层 ( Controller ) : 对 表示层 的用户操作 做出响应
 * 实现技术可以是: Servlet 、Struts 、Spring MVC
 * @Controller("sc") value ="sc" 相当于bean的名称是sc,默认名称是 studentController
 */

@Controller
public class StudentController {
	
	@Autowired
	@Qualifier( "studentService" )
	private StudentService studentService ;
	
	public String regist( Student s ){
		System.out.println( "StudentController # regist ( Student ) " );
		studentService.save( s );
		return "success" ;
	}
	
	public String logout() {
		
		throw new RuntimeException( "抛出异常" );
		
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
}
