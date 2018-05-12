package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Select{
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Connection con=
				DriverManager.getConnection("jdbc:mysql://localhost:3306/songming", "root","root");
		String sql="select * from employees where Name=?";
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1, "ÌÆÈý");
		ResultSet re=pre.executeQuery();
		while(re.next()) {
			String id=re.getString("ID");
			String name=re.getString("Name");
			String gender=re.getString("Gender");
			String salary=re.getString("Salary");
			System.out.println(id+"---"+name+"---"+gender+"---"+salary);
		}
		pre.close();
		con.close();	
	}
}
