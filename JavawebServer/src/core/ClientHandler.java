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
 * 这个类是线程类，用来处理客户端请求和响应
 * @author song
 *
 */
public class ClientHandler implements Runnable{
	//声明socket对象，代表客户端请求
	private Socket socket;
	public ClientHandler(Socket socket) {
		this.socket=socket;
	}
	@Override
	public void run() {
		try {
			//请求的对象
			HttpRequest request=new HttpRequest(
					socket.getInputStream());
			//响应的对象
			HttpResponse response=new HttpResponse(
					socket.getOutputStream());
			//从ServletContext类中获取
			File file=new File(ServletContext.webRoot+request.getUri());
			//如果系统要访问的资源不存在，调到404页面
			if(!file.exists()) {
				file=new File(
						ServletContext.webRoot+"/"+
								ServletContext.notFoundPage);
				response.setStatus(404);
			}else {
				response.setStatus(200);//正常访问
			}
			//完成登陆和注册的功能
			if(request.getUri().startsWith("/RegistUser")||
					request.getUri().startsWith("/LoginUser")) {
				service(request,response);
			}
			//遵循的协议
			response.setProtocol(ServletContext.protocol);
			//查找后缀名
			response.setContentType(getContentTypeExt(file));
			response.setContentLength((int)file.length());
			//响应网页文件读取网页文件并输出
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
		//用户注册
		Connection conn=null;
		PreparedStatement ps=null;
		if(request.getUri().startsWith("/RegistUser")) {
			try {
				//1,注册驱动 2，获取数据库连接
				conn = JDBCUtils.getConnection();
				//3，获取传输器
				String sql =
						"insert into user values(?,?)";
				ps = conn.prepareStatement(sql);
				//3.1,,设置参数用户输入的用户名
				String username = 
						request.getParam("username");
				//3.3获取地址栏上用户输入的密码
				String password = 
						request.getParam("password");
				ps.setString(1, username);
				ps.setString(2, password);
				ps.executeUpdate();
				//用户注册完成返回响应界面
				response.setProtocol("HTTP/1.1");
				response.setStatus(HttpContext.CODE_OK);
				File file=new File(ServletContext.webRoot+"/"+"reg_success.html");
				response.setContentType(getContentTypeExt(file));
				response.setContentLength((int)file.length());
				BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
				byte[] bs=new byte[(int)file.length()];
				bis.read(bs);
				//向网页写出实体内容
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
		//获取文件名字
		String fileName=file.getName();
		//获取扩展名
		String ext=fileName.substring(
				fileName.lastIndexOf(".")+1);
		String type=ServletContext.map.get(ext);
		return type;
	}

}
