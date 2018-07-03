package com.songming.reflect;

import java.lang.reflect.Method;

public class Reflect {
	public static void main(String[] args) throws Exception {
		Class<?> cls=Class.forName("com.songming.reflect.ReflectImpl");
		Object object = cls.newInstance();
		/*Method method=cls.getMethod("smile", String.class);
		method.invoke(object, "张三");*/
		System.out.println(object);
	}
}
