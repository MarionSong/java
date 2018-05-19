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
 * �������jdbc�Ĺ�����
6.2.2.�޲ι��캯��˽�л����������ֱ��new����
6.2.3.�ṩ��̬��getConnection����
6.2.4.�ṩ��̬��close����
6.2.5.����
 */
public class JDBCUtils {

	//1,�޲ι��캯��˽�л����������ֱ��new����
	private JDBCUtils(){}
	
	static Properties prop = null;
	
	//��֤�����ļ�ֻ����ȡһ��
	static{
		//a,,,,,��ȡ�����ļ�
		try {
			prop = new Properties();
			File file = new File("jdbc.properties");
			prop.load(new FileInputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//2,�ṩ��̬��getConnection����java.sql.Connection
	public static Connection getConnection(){
		//�������裺1,ע������   2����ȡ���ݿ�����
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
	
	//3,�ṩ��̬��close����
	public static void close(
			Connection conn,
				Statement st,
					ResultSet rs){
		//��ֹ��ָ���쳣
		if(rs != null ){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//�ֶ��ÿգ���֤��Դ�ᱻ�ͷ�
				rs = null;
			}
		}
		//��ֹ��ָ���쳣
		if(st != null ){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//�ֶ��ÿգ���֤��Դ�ᱻ�ͷ�
				st = null;
			}
		}
		//��ֹ��ָ���쳣
		if(conn != null ){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//�ֶ��ÿգ���֤��Դ�ᱻ�ͷ�
				conn = null;
			}
		}
		
	}
	
	
	
	
}
