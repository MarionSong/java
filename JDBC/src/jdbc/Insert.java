package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class Insert {
	public static void main(String[] args) {
		
		try {
			Connection con=JDBCUtils.getConnection();
			String sql="insert into employees values(?,?,?,?)";
			PreparedStatement pre=con.prepareStatement(sql);
			String[][] str= {
					{"6","Ğ¡Îè","Å®","11000"},{"7","ÑîÁè","ÄĞ","11000"},{"8","»ôÓêºÆ","ÄĞ","11000"}
			};
			for(int i=0;i<str.length;i++) {
				pre.setString(1, str[i][0]);
				pre.setString(2, str[i][1]);
				pre.setString(3, str[i][2]);
				pre.setString(4, str[i][3]);
				pre.addBatch();
			}
			pre.executeBatch();
			pre.close();
			con.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
}
