package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test1 {
	public static void main(String[] args) throws Exception {
		Class cls=Class.forName("reflection.Person");
		Constructor con=cls.getConstructor(String.class,int.class);
		Object obj=con.newInstance("张三",20);
		Method method=cls.getMethod("foo", String.class);
		method.invoke(obj, "wowo");
		Method method1=cls.getMethod("say");
		method1.invoke(obj);
		Field field=cls.getDeclaredField("name");
		field.setAccessible(true);
		field.set(obj, "李四");
		System.out.println(field.get(obj));
		
		
	}
}
