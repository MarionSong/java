package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class Delete {
	public static void main(String[] args) {
		try {
			Connection con=JDBCUtils.getConnection();
			String sql="delete from employees where name=?";
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1, "Õı¡÷");
			int line=pre.executeUpdate();
			System.out.println("line="+line);
			pre.close();
			con.close();
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
			
	}
}
