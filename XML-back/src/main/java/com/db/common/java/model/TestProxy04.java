package com.db.common.java.model;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

class ProductServiceImpl{
	  public void saveObject(){
		  System.out.println("save product");
	  }
}
//基于CGLIB如何为目标对象(ProductServiceImpl)产生代理对象
public class TestProxy04 {
	public static void main(String[] args) {
		//1.目标对象
		
			new ProductServiceImpl();
		//2.基于Cglib为目标对象创建代理对象
		Enhancer en=new Enhancer();//通过此对象创建代理对象
		//代理对象和目标对象是继承关系
		en.setSuperclass(ProductServiceImpl.class);
		//设置回调对象
		en.setCallback(new MethodInterceptor() {
			//当执行代理对象的方法时执行此方法
			@Override
			public Object intercept(Object proxy, 
					Method method, 
					Object[] args,
					MethodProxy methodProxy) throws Throwable {
				System.out.println("intercept");
				System.out.println(proxy.getClass().getName());
				return methodProxy.invokeSuper(proxy, args);
			    //return method.invoke(productService, args);
			}
		});
		Object proxy=en.create();//创建代理对象
		//3.执行代理对象方法
		ProductServiceImpl serviceProxy=
		(ProductServiceImpl)proxy;
		serviceProxy.saveObject();
	}
}
