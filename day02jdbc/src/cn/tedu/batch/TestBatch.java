package cn.tedu.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.tedu.utils.JDBCUtils;

/**
 * �������������jdbc��������
 */
public class TestBatch {

	//ʵ�ַ�ʽһ������statement����
	@Test
	public void TestStatement(){
		//1,ע������  2����ȡ���ݿ�����
		//3����ȡ������   4��ִ��SQL
		//5�����������  6���ͷ���Դ
		Connection conn = null;
		Statement st = null;
		
		try {
			//1,ע������  2����ȡ���ݿ�����
			conn = JDBCUtils.getConnection();
			
			//�Ż�1����
			conn.setAutoCommit(false);
			
			//3����ȡ������
			st = conn.createStatement();
			
			long start = System.currentTimeMillis();
			
			//4��ִ��SQL,��dept���в���100����¼
			for (int i = 0; i < 100; i++) {
				String sql = 
			"insert into dept(name) values('"+i+"')";
			
				//��100��SQL���һ����
				st.addBatch(sql);
			}
			
			//����ͳһ���͸����ݿ������
			int[] rows = st.executeBatch();
			
			//�Ż�2����
			conn.commit();
			
			
			long end = System.currentTimeMillis();
			System.out.println("==="+(end-start)+"===");
			
			
			//5,���������
			System.out.println(rows.length);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6,�ͷ���Դ
			JDBCUtils.close(conn, st, null);
		}
		
	}
	
	//ʵ�ַ�ʽ��������PreparedStatement����
	@Test
	public void TestPSBatch(){
		//1,ע������  2����ȡ���ݿ����� 
		//3,��ȡ������  4��ִ��SQL
		//5�����������  6���ͷ���Դ
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			//1,ע������  2����ȡ���ݿ����� 
			conn = JDBCUtils.getConnection();
			
			//�����Ż�1�������ر�jdbc���������
			conn.setAutoCommit(false);
			
			
			//3,��ȡ������,?ռλ��
			String sql =
					"insert into dept(name) values(?)";
			ps = conn.prepareStatement(sql);
			
			long start = System.currentTimeMillis();
			
			
			//3.1,���ò���
			for (int j = 0; j < 100; j++) {
				ps.setString(1, "PS"+j);
				//3.2,��SQL���һ����
				ps.addBatch();
			}
			//3.3,����ͳһ���͸�������
			int[] rows = ps.executeBatch();
			
			//�����Ż�2�����ֶ��ύ����
			conn.commit();
			
			long end = System.currentTimeMillis();
			System.out.println("+++"+(end-start)+"+++");
			
			//5,���������
			System.out.println(rows.length);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6,�ͷ���Դ
			JDBCUtils.close(conn, ps, null);
		}
		
	}
	
	
	
	
	
	
	
	
	
}
