package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 这个类是jdbc的工具类
6.2.2.无参构造函数私有化，不让外界直接new对象
6.2.3.提供静态的getConnection方法
6.2.4.提供静态的close方法
6.2.5.测试
 */
public class JDBCUtils {

	//1,无参构造函数私有化，不让外界直接new对象
	private JDBCUtils(){}
	
	static Properties prop = null;
	
	//保证属性文件只被读取一次
	static{
		//a,,,,,读取属性文件
		try {
			prop = new Properties();
			File file = new File("jdbc.properties");
			prop.load(new FileInputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//2,提供静态的getConnection方法java.sql.Connection
	public static Connection getConnection(){
		//开发步骤：1,注册驱动   2，获取数据库连接
		try {
			
			Class.forName(
					prop.getProperty("driverClass"));
			Connection conn = 
					DriverManager.getConnection(
					prop.getProperty("jdbcUrl"),
					prop.getProperty("user"),
					prop.getProperty("password"));
			return conn;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	//3,提供静态的close方法
	public static void close(
			Connection conn,
				Statement st,
					ResultSet rs){
		//防止空指针异常
		if(rs != null ){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//手动置空，保证资源会被释放
				rs = null;
			}
		}
		//防止空指针异常
		if(st != null ){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//手动置空，保证资源会被释放
				st = null;
			}
		}
		//防止空指针异常
		if(conn != null ){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//手动置空，保证资源会被释放
				conn = null;
			}
		}
		
	}
	
	
	
	
}
