package cn.tedu.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import cn.tedu.utils.JDBCUtils;

/**
 * ���������ģ���û���¼
1.2.4.����main������������ʾ�û���¼
1.2.5.����login�������ж��û��ܷ�ɹ���¼
 */
public class LoginUser {

	//1,����main������������ʾ�û���¼
	public static void main(String[] args) {
		//��ʼ���ռ������롣����
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�������û�����");
		String username = sc.nextLine();
		
		System.out.println("���������룺");
		String password = sc.nextLine();
		
		//2,����login�������ж��û��ܷ�ɹ���¼
		login(username,password);
	}
	
	//2.1,��ѯuser���ж��Ƿ���ڸ��û�
	private static void login(
			String username, 
				String password) {
		//1��ע������ 2����ȡ���ݿ����� 3����ȡ������
		//4��ִ��SQL  5����������� 6���ͷ���Դ
		Connection conn = null;
//		Statement st = null;
		
		//����1��������һ��PreparedStatement����
		PreparedStatement ps = null;
		
		
		ResultSet rs = null;
		
		try {
			//1��ע������ 2����ȡ���ݿ�����
			conn = JDBCUtils.getConnection();
//			//3����ȡ������
//			st = conn.createStatement();
//			//4��ִ��SQL,�����û����������ѯuser��
//			String sql=
//		"select * from user where username='"
//			+username+"' and password='"
//				+password+"'";
//			
//			rs = st.executeQuery(sql);
			
			//����2������ȡ����Ԥ����Ч���Ĵ�����
			//?����ռλ����������SQL����SQL�Ǽ�
			String sql=
			"select * from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			
			//����3�������ò�����ֵ,��һ�������������ʺŵ�λ��
			ps.setString(1,username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
//			System.out.println(sql);
			//5�����������
			if(rs.next()){//�����ѯ���˼�¼
				System.out.println(
						"��ϲ������¼�ɹ�����");
			}else{//���û�в�ѯ����¼
				System.out.println(
						"�����������û��������룡��");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6���ͷ���Դ
			JDBCUtils.close(conn, ps, rs);
		}
		
	}
}
