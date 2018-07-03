package com.songming.reflect;

public class ReflectImpl {
	public String name;
	public ReflectImpl(String name) {
		this.name=name;
	}
	public void smile() {
		System.out.println(name+"在笑");
	}
}
