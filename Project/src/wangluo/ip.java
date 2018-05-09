package wangluo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ip {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress ip=InetAddress.getLocalHost();
		System.out.println(ip);
		ip=InetAddress.getByName("www.tmooc.cn");
		System.out.println(ip);
		
		
		
		
		
	}
}
