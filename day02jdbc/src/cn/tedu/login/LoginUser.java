package cn.tedu.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import cn.tedu.utils.JDBCUtils;

/**
 * 这个类用来模拟用户登录
1.2.4.创建main方法，用来提示用户登录
1.2.5.创建login方法，判断用户能否成功登录
 */
public class LoginUser {

	//1,创建main方法，用来提示用户登录
	public static void main(String[] args) {
		//开始接收键盘输入。。。
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入用户名：");
		String username = sc.nextLine();
		
		System.out.println("请输入密码：");
		String password = sc.nextLine();
		
		//2,创建login方法，判断用户能否成功登录
		login(username,password);
	}
	
	//2.1,查询user表，判断是否存在该用户
	private static void login(
			String username, 
				String password) {
		//1，注册驱动 2，获取数据库连接 3，获取传输器
		//4，执行SQL  5，解析结果集 6，释放资源
		Connection conn = null;
//		Statement st = null;
		
		//改造1，，声明一个PreparedStatement对象
		PreparedStatement ps = null;
		
		
		ResultSet rs = null;
		
		try {
			//1，注册驱动 2，获取数据库连接
			conn = JDBCUtils.getConnection();
//			//3，获取传输器
//			st = conn.createStatement();
//			//4，执行SQL,根据用户名和密码查询user表
//			String sql=
//		"select * from user where username='"
//			+username+"' and password='"
//				+password+"'";
//			
//			rs = st.executeQuery(sql);
			
			//改造2，，获取带有预编译效果的传输器
			//?叫做占位符，这样的SQL叫做SQL骨架
			String sql=
			"select * from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			
			//改造3，，设置参数的值,第一个参数代表了问号的位置
			ps.setString(1,username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
//			System.out.println(sql);
			//5，解析结果集
			if(rs.next()){//如果查询到了记录
				System.out.println(
						"恭喜您，登录成功！！");
			}else{//如果没有查询到记录
				System.out.println(
						"请重新输入用户名或密码！！");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6，释放资源
			JDBCUtils.close(conn, ps, rs);
		}
		
	}
}
