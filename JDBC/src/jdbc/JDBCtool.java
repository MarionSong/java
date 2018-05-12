package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCtool {
	public static final String DRIVERNAME="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/songming";
	public static final String USER="root";
	public static final String PASSWORD="root";
	static {
		try {
			Class.forName(DRIVERNAME);
		}catch (Exception e) {
			System.out.println("Êý¾Ý¿âÇý¶¯×¢²áÊ§°Ü");
		}
	}
	public static  Connection getcon() throws Exception{
		Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
		return con;
	}
}
