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
 * ���������ʵ��JDBC�����ӳ�
1.1.1.1.����MyPool��ʵ��javax.sql.DataSource�ӿ�
1.1.1.2.����LinkedList������������ݿ�����
1.1.1.3.�ṩgetConnection������������ȡ���ݿ�����
1.1.1.4.�ṩreturnConn���������������ݿ����ӻ��س���
*/

//1.����MyPool��ʵ��javax.sql.DataSource�ӿ�
public class MyPool implements DataSource{

	//2.����LinkedList������������ݿ�����
	static List<Connection> pool = 
			new LinkedList<Connection>();
	
	//2.1����ʼ��3�����ݿ�����
	static{
		for (int i = 0; i < 3; i++) {
			Connection conn = 
					JDBCUtils.getConnection();
			pool.add(conn);
		}
	}
	
	//3.�ṩgetConnection������������ȡ���ݿ�����
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = pool.remove(0);//��ȡ���Ӳ��ӳ����Ƴ�
		System.out.println(
				"�����������ӱ�����һ��");
		
		//��װConnection����
		Connection connDecorator = 
			new ConnectionDecorator(conn,this);
		
		
//		return conn;
		return connDecorator;
	}
	
	//4.�ṩreturnConn���������������ݿ����ӻ��س���
	public void returnConn(Connection conn){
		try {
			if(conn != null && !conn.isClosed())
				pool.add(conn);
			System.out.println(
					"���ӱ����س��У����ڳ�����"
							+pool.size()+"��");
			
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
