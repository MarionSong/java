package core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.HttpContext;
import common.ServletContext;
import http.HttpRequest;
import http.HttpResponse;
import utils.JDBCUtils;

/**
 * ��������߳��࣬��������ͻ����������Ӧ
 * @author song
 *
 */
public class ClientHandler implements Runnable{
	//����socket���󣬴���ͻ�������
	private Socket socket;
	public ClientHandler(Socket socket) {
		this.socket=socket;
	}
	@Override
	public void run() {
		try {
			//����Ķ���
			HttpRequest request=new HttpRequest(
					socket.getInputStream());
			//��Ӧ�Ķ���
			HttpResponse response=new HttpResponse(
					socket.getOutputStream());
			//��ServletContext���л�ȡ
			File file=new File(ServletContext.webRoot+request.getUri());
			//���ϵͳҪ���ʵ���Դ�����ڣ�����404ҳ��
			if(!file.exists()) {
				file=new File(
						ServletContext.webRoot+"/"+
								ServletContext.notFoundPage);
				response.setStatus(404);
			}else {
				response.setStatus(200);//��������
			}
			//��ɵ�½��ע��Ĺ���
			if(request.getUri().startsWith("/RegistUser")||
					request.getUri().startsWith("/LoginUser")) {
				service(request,response);
			}
			//��ѭ��Э��
			response.setProtocol(ServletContext.protocol);
			//���Һ�׺��
			response.setContentType(getContentTypeExt(file));
			response.setContentLength((int)file.length());
			//��Ӧ��ҳ�ļ���ȡ��ҳ�ļ������
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
			byte[] bs=new byte[(int)file.length()];
			bis.read(bs);
			OutputStream stream=response.getOutputStream();
			stream.write(bs);
			stream.flush();
			socket.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void service(HttpRequest request, HttpResponse response) {
		//�û�ע��
		Connection conn=null;
		PreparedStatement ps=null;
		if(request.getUri().startsWith("/RegistUser")) {
			try {
				//1,ע������ 2����ȡ���ݿ�����
				conn = JDBCUtils.getConnection();
				//3����ȡ������
				String sql =
						"insert into user values(?,?)";
				ps = conn.prepareStatement(sql);
				//3.1,,���ò����û�������û���
				String username = 
						request.getParam("username");
				//3.3��ȡ��ַ�����û����������
				String password = 
						request.getParam("password");
				ps.setString(1, username);
				ps.setString(2, password);
				ps.executeUpdate();
				//�û�ע����ɷ�����Ӧ����
				response.setProtocol("HTTP/1.1");
				response.setStatus(HttpContext.CODE_OK);
				File file=new File(ServletContext.webRoot+"/"+"reg_success.html");
				response.setContentType(getContentTypeExt(file));
				response.setContentLength((int)file.length());
				BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
				byte[] bs=new byte[(int)file.length()];
				bis.read(bs);
				//����ҳд��ʵ������
				response.getOutputStream().write(bs);
				response.getOutputStream().flush();
				socket.close();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtils.close(conn, ps, null);
			}
		}else {
			try {
				while(true) {
					conn=JDBCUtils.getConnection();
					String sql="select * from user where username=? and password=?";
					ps=conn.prepareStatement(sql);
					ps.setString(1, request.getParam("username"));
					ps.setString(2, request.getParam("password"));
					ResultSet rs=ps.executeQuery();
					if(rs.next()) {
						response.setProtocol("HTTP/1.1");
						response.setStatus(HttpContext.CODE_OK);
						File file=new File(ServletContext.webRoot+"/"+"log_success.html");
						response.setContentType(getContentTypeExt(file));
						response.setContentLength((int)file.length());
						BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
						byte[] bs=new byte[(int)file.length()];
						bis.read(bs);
						response.getOutputStream().write(bs);
						response.getOutputStream().flush();
						socket.close();
						break;
					}else {
						response.setProtocol("HTTP/1.1");
						response.setStatus(HttpContext.CODE_OK);
						File file=new File(ServletContext.webRoot+"/"+"relogin.html");
						response.setContentType(getContentTypeExt(file));
						response.setContentLength((int)file.length());
						BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
						byte[] bs=new byte[(int)file.length()];
						bis.read(bs);
						response.getOutputStream().write(bs);
						response.getOutputStream().flush();
						socket.close();
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	private String getContentTypeExt(File file) {
		//��ȡ�ļ�����
		String fileName=file.getName();
		//��ȡ��չ��
		String ext=fileName.substring(
				fileName.lastIndexOf(".")+1);
		String type=ServletContext.map.get(ext);
		return type;
	}

}
