package ecut.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ecut.jdbc.entity.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

public class CustomerDao {
	
	private JdbcTemplate jdbcTemplate;
	//在表名前后加空格避免空格缺失
	private static final String TABLE = " t_customer " ;
	
	public boolean persist( Customer c ) {
		
		final Integer id = jdbcTemplate.queryForObject( "SELECT max(id) FROM " + TABLE , Integer.class ) ;
		
		System.out.println( "id : " + id );
		
		
		final String SQL = "INSERT INTO " + TABLE + 
									" ( id , email , password , nickname , gender , birthdate , married ) " + 
									" VALUES ( ? , ? , ? , ? , ? , ? , ? ) " ;
		//是一个接口用匿名内部类的方法去实现
		PreparedStatementCallback<Integer> action = new PreparedStatementCallback<Integer>(){
			@Override
			public Integer doInPreparedStatement( PreparedStatement ps ) 
					throws SQLException, DataAccessException {
				
				ps.setInt( 1 ,  id + 1 );
				ps.setString( 2 ,  c.getEmail() );
				ps.setString( 3 ,  c.getPassword() );
				ps.setString( 4 ,  c.getNickname() );
				ps.setString( 5 ,  c.getGender() + "" );
				// c.getBirthdate().getTime() 获得毫秒数
				java.sql.Date date = new java.sql.Date( c.getBirthdate().getTime() ) ;
				ps.setDate( 6 ,  date );
				ps.setString( 7 ,  c.isMarried() ? "Y" : "N" );
				
				int count = ps.executeUpdate() ;
				
				return count;
			}
		};
		//doInPreparedStatement返回类型则jdbcTemplate.execute( SQL , action );也是返回什么类型
		Integer count = jdbcTemplate.execute( SQL , action );
		
		// return count != null && count > 0  ;
		
		if( count != null && count > 0 ) {
			return true ;
		} else {
			return false ;
		}
		
	}
	
	public boolean update( Customer c , Integer id ) {
		final String SQL = "UPDATE " + TABLE + 
									" SET email =?, password = ? , nickname = ? ,gender =? , birthdate = ? , married = ? where id = ?";
		PreparedStatementCallback<Integer> action = new PreparedStatementCallback<Integer>(){
			@Override
			public Integer doInPreparedStatement( PreparedStatement ps ) 
					throws SQLException, DataAccessException {
				
				ps.setString( 1 ,  c.getEmail() );
				ps.setString( 2 ,  c.getPassword() );
				ps.setString( 3 ,  c.getNickname() );
				ps.setString( 4 ,  c.getGender() + "" );
				// c.getBirthdate().getTime() 获得毫秒数
				java.sql.Date date = new java.sql.Date( c.getBirthdate().getTime() ) ;
				ps.setDate( 5 ,  date );
				ps.setString( 6 ,  c.isMarried() ? "Y" : "N" );
				ps.setInt( 7 ,  id );

				int count = ps.executeUpdate() ;
				
				return count;
			}
		};
		//doInPreparedStatement返回类型则jdbcTemplate.execute( SQL , action );也是返回什么类型
		Integer count = jdbcTemplate.execute( SQL , action );
		
		// return count != null && count > 0  ;
		
		if( count != null && count > 0 ) {
			return true ;
		} else {
			return false ;
		}
		
	}
	 
	public boolean delete( Integer id  ) {
		
		final String SQL  = "DELETE FROM " + TABLE +"WHERE id  = ?";
		PreparedStatementCallback<Integer>  action = new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, id);
				int count = ps.executeUpdate();
				return count;
			}
			
		};
		Integer count = jdbcTemplate.execute( SQL , action );
		
		// return count != null && count > 0  ;
		
		if( count != null && count > 0 ) {
			return true ;
		} else {
			return false ;
		}		
	}
	
	public Customer load( Integer id  ) {
		
		final String SQL = "SELECT id , email , password , nickname , gender , birthdate , married FROM " + TABLE + " WHERE id =  ? "  ; 
		
		PreparedStatementCreator psc = new  PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement( Connection conn ) throws SQLException {
				
				PreparedStatement ps = conn.prepareStatement( SQL );
				
				ps.setInt( 1 ,  id );
				
				return ps ;
			}
			
		};
		
		final RowMapper<Customer> rowMapper = new RowMapper<Customer>() {
			@Override
			public Customer mapRow( ResultSet rs, int count ) throws SQLException {
				
				Customer c = new Customer();
				//Integer id = rs.getInt( "id" );可读性好效率低
				Integer id = rs.getInt( 1 );
				c.setId( id );
				
				String email = rs.getString( 2 );
				c.setEmail( email );
				
				String password = rs.getString( 3 );
				c.setPassword(password);
				
				String nickname = rs.getString( 4 );
				c.setNickname(nickname);
				
				String gender = rs.getString( 5 );
				if( gender != null && gender.length() > 0 ) {
					c.setGender( gender.charAt( 0 ) );
				}
				
				java.sql.Date birthdate = rs.getDate( 6 );
				c.setBirthdate( birthdate );
				
				String married = rs.getString( 7 );
				c.setMarried( "Y".equals( married ) ? true : false );
				
				return c;
			}
		} ;
		
		List<Customer> list = jdbcTemplate.query( psc , rowMapper);
		
		if( list != null && list.size() > 0 ) {
			Customer c = list.get( 0 );
			return c ;
		} else {
			return null ;
		}
		
	}
	
	public List<Customer> loadAll() {
		
		final String SQL = "SELECT id , email , password , nickname , gender , birthdate , married FROM " + TABLE ;
		//吧查询后的结果拼装起来返回的对象，将行记录包装成一个个的对象
		final RowMapper<Customer> rowMapper = new RowMapper<Customer>() {
			@Override
			public Customer mapRow( ResultSet rs, int count ) throws SQLException {
				
				Customer c = new Customer();
				
				Integer id = rs.getInt( 1 );
				c.setId( id );
				
				String email = rs.getString( 2 );
				c.setEmail( email );
				
				String password = rs.getString( 3 );
				c.setPassword(password);
				
				String nickname = rs.getString( 4 );
				c.setNickname(nickname);
				
				String gender = rs.getString( 5 );
				if( gender != null && gender.length() > 0 ) {
					c.setGender( gender.charAt( 0 ) );
				}
				
				java.sql.Date birthdate = rs.getDate( 6 );
				c.setBirthdate( birthdate );
				
				String married = rs.getString( 7 );
				c.setMarried( "Y".equals( married ) ? true : false );
				
				return c;
			}
		} ;
		
		List<Customer> list = jdbcTemplate.query( SQL , rowMapper );
		
		return list ;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
