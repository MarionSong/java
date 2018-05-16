package cn.tedu.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.tedu.utils.JDBCUtils;

/**
 * 这个类用来测试jdbc的批处理
 */
public class TestBatch {

	//实现方式一：利用statement对象
	@Test
	public void TestStatement(){
		//1,注册驱动  2，获取数据库连接
		//3，获取传输器   4，执行SQL
		//5，解析结果集  6，释放资源
		Connection conn = null;
		Statement st = null;
		
		try {
			//1,注册驱动  2，获取数据库连接
			conn = JDBCUtils.getConnection();
			
			//优化1，，
			conn.setAutoCommit(false);
			
			//3，获取传输器
			st = conn.createStatement();
			
			long start = System.currentTimeMillis();
			
			//4，执行SQL,向dept表中插入100条记录
			for (int i = 0; i < 100; i++) {
				String sql = 
			"insert into dept(name) values('"+i+"')";
			
				//把100条SQL打成一个批
				st.addBatch(sql);
			}
			
			//把批统一发送给数据库服务器
			int[] rows = st.executeBatch();
			
			//优化2，，
			conn.commit();
			
			
			long end = System.currentTimeMillis();
			System.out.println("==="+(end-start)+"===");
			
			
			//5,解析结果集
			System.out.println(rows.length);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6,释放资源
			JDBCUtils.close(conn, st, null);
		}
		
	}
	
	//实现方式二：利用PreparedStatement对象
	@Test
	public void TestPSBatch(){
		//1,注册驱动  2，获取数据库连接 
		//3,获取传输器  4，执行SQL
		//5，解析结果集  6，释放资源
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			//1,注册驱动  2，获取数据库连接 
			conn = JDBCUtils.getConnection();
			
			//事务优化1，，，关闭jdbc的事务管理
			conn.setAutoCommit(false);
			
			
			//3,获取传输器,?占位符
			String sql =
					"insert into dept(name) values(?)";
			ps = conn.prepareStatement(sql);
			
			long start = System.currentTimeMillis();
			
			
			//3.1,设置参数
			for (int j = 0; j < 100; j++) {
				ps.setString(1, "PS"+j);
				//3.2,把SQL打成一个批
				ps.addBatch();
			}
			//3.3,把批统一发送给服务器
			int[] rows = ps.executeBatch();
			
			//事务优化2，，手动提交事务
			conn.commit();
			
			long end = System.currentTimeMillis();
			System.out.println("+++"+(end-start)+"+++");
			
			//5,解析结果集
			System.out.println(rows.length);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6,释放资源
			JDBCUtils.close(conn, ps, null);
		}
		
	}
	
	
	
	
	
	
	
	
	
}
