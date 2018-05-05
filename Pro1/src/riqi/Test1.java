package riqi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test1 {
	public static void main(String[] args) throws ParseException {
		
		Date d=new Date();
		
		System.out.println(d);
		System.out.println(d.getTime());
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
		String s=sm.format(d);
		System.out.println(s);
		d=sm.parse(s);
		System.out.println(d);
		Calendar ca=Calendar.getInstance();
		ca.set(2013, 10, 10);
		s=(new SimpleDateFormat("yyyy-M-d").format(ca.getTime()));
		System.out.println(s);
		int month=ca.get(Calendar.DAY_OF_MONTH);
		System.out.println(month);
	}
}
