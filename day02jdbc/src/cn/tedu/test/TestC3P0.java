package cn.tedu.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.tedu.pool.MyPool;
import cn.tedu.utils.JDBCUtils;

/**
 * 这个类用来测试C3P0连接池
 *需求：利用连接池技术，查询account表的所有数据
 */
public class TestC3P0 {
	
	//声明连接池对象
//	MyPool pool =new MyPool();
	
	
	//C3P0连接池
	//1,,,声明C3P0对象
	ComboPooledDataSource pool = 
			new ComboPooledDataSource();
	
	@Test
	public void testPool(){
		//1，注册驱动  2，获取数据库连接
		//3,获取传输器  4，执行SQL
		//5,解析结果集  6，释放资源
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//1，注册驱动  2，获取数据库连接
			//2,,,设置数据库连接的参数
		/*pool.setDriverClass(
				"com.mysql.jdbc.Driver");
		pool.setJdbcUrl(
			"jdbc:mysql://localhost:3306/jt_db");	
		pool.setUser("root");	
		pool.setPassword("root");*/
		
		//3，，，从C3P0池中获取连接
			conn = pool.getConnection();
			
			//3,获取传输器
			String sql = 
					"select * from account where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "1");
			rs = ps.executeQuery();
			//5,解析结果集
			if(rs.next()){
				System.out.println(
						"id:"+rs.getString(1)+",name:"
						+rs.getString(2)+",money:"
						+rs.getString(3));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//6,释放资源
			/*//把连接还回池中
			pool.returnConn(conn);
			JDBCUtils.close(null, ps, rs);
			*/
			
			//conn是将连接还回池中
			JDBCUtils.close(conn, ps, rs);
		}
		
		
	}
}
