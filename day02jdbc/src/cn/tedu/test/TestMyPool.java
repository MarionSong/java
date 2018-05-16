package cn.tedu.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.tedu.pool.MyPool;
import cn.tedu.utils.JDBCUtils;

/**
 * ��������������Զ������ӳ�
 *�����������ӳؼ�������ѯaccount�����������
 */
public class TestMyPool {
	
	//�������ӳض���
	MyPool pool =new MyPool();
	
	@Test
	public void testPool(){
		//1��ע������  2����ȡ���ݿ�����
		//3,��ȡ������  4��ִ��SQL
		//5,���������  6���ͷ���Դ
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//1��ע������  2����ȡ���ݿ�����
			conn = pool.getConnection();
			//3,��ȡ������
			String sql = 
					"select * from account where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "1");
			rs = ps.executeQuery();
			//5,���������
			if(rs.next()){
				System.out.println(
						"id:"+rs.getString(1)+",name:"
						+rs.getString(2)+",money:"
						+rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6,�ͷ���Դ
			/*//�����ӻ��س���
			pool.returnConn(conn);
			JDBCUtils.close(null, ps, rs);
			*/
			
			//conn�ǽ����ӻ��س���
			JDBCUtils.close(conn, ps, rs);
		}
		
		
	}
}
