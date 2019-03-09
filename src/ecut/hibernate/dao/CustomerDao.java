package ecut.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import ecut.hibernate.entity.Customer;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class CustomerDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public boolean persist( Customer c ) {
		try{ 
			//没有提交事务所以需要增加事务的配置
			Serializable id = hibernateTemplate.save( c );
			return id != null ;
		} catch ( Exception e) {
			e.printStackTrace();
			return false ;
		}
	}
	
	public boolean update( Customer c ) {
		try{ 
			hibernateTemplate.update( c );
			return true ;
		} catch ( Exception e) {
			return false ;
		}
	}
	
	public boolean delete( Customer c ) {
		try{ 
			hibernateTemplate.delete( c );
			return true ;
		} catch ( Exception e) {
			return false ;
		}
	}
	
	public Customer load( Integer id  ) {
		return hibernateTemplate.get( Customer.class , id ) ;
	}
	//@SuppressWarnings抑制编译器警告
	@SuppressWarnings("unchecked")
	public List<Customer> loadAll() {
		final String HQL = "FROM Customer";
		List<Customer> list = (List<Customer>)hibernateTemplate.find( HQL );
		return list ;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
