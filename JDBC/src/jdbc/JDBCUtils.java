package jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class JDBCUtils {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	static {
		try {
			Properties props = new Properties();
			FileInputStream in = new FileInputStream("C:\\Users\\song\\eclipse-workspace\\JDBC\\src\\db.properties");
			props.load(in);
			driver=props.getProperty("driver");
			url=props.getProperty("url");
			user=props.getProperty("user");
			password=props.getProperty("password");
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static Connection getConnection() {
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,user,password);
			return con;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
