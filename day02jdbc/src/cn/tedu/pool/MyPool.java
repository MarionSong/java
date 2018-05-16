package cn.tedu.pool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import cn.tedu.decorator.ConnectionDecorator;
import cn.tedu.utils.JDBCUtils;

/**
 * 这个类用来实现JDBC的连接池
1.1.1.1.创建MyPool，实现javax.sql.DataSource接口
1.1.1.2.创建LinkedList，用来存放数据库连接
1.1.1.3.提供getConnection方法，用来获取数据库连接
1.1.1.4.提供returnConn方法，用来把数据库连接还回池中
*/

//1.创建MyPool，实现javax.sql.DataSource接口
public class MyPool implements DataSource{

	//2.创建LinkedList，用来存放数据库连接
	static List<Connection> pool = 
			new LinkedList<Connection>();
	
	//2.1，初始化3个数据库连接
	static{
		for (int i = 0; i < 3; i++) {
			Connection conn = 
					JDBCUtils.getConnection();
			pool.add(conn);
		}
	}
	
	//3.提供getConnection方法，用来获取数据库连接
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = pool.remove(0);//获取连接并从池中移除
		System.out.println(
				"不好啦，连接被拿走一个");
		
		//包装Connection对象
		Connection connDecorator = 
			new ConnectionDecorator(conn,this);
		
		
//		return conn;
		return connDecorator;
	}
	
	//4.提供returnConn方法，用来把数据库连接还回池中
	public void returnConn(Connection conn){
		try {
			if(conn != null && !conn.isClosed())
				pool.add(conn);
			System.out.println(
					"连接被还回池中，现在池中有"
							+pool.size()+"个");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
}
