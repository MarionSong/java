package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class Update {
	public static void main(String[] args) {
		try {
			Connection con=JDBCUtils.getConnection();
			String sql="Update employees set name=? where id=?";
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1, "ÖÜ½ÜÂ×");
			pre.setInt(2, 4);
			int line=pre.executeUpdate();
			System.out.println("line="+line);
			pre.close();
			con.close();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
