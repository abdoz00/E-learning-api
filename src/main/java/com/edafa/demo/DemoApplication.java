package com.edafa.demo;

import com.edafa.demo.user.RequestEnum;
import com.edafa.demo.user.UserRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoApplication {

	static UserRequestHandler userRequestHandler;
	static Map requestMap;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		UserRequestHandler.setUserRequests(generateMap());
	}

	private static Map<String, Map<RequestEnum, Integer>> generateMap() {

		Map userMap=new HashMap();
		Map requestMap=new HashMap();
		requestMap.put(RequestEnum.CURRENT,5);
		requestMap.put(RequestEnum.MAX,10);
		userMap.put("admin",requestMap);
		System.out.println("generating map "+userMap+" "+Thread.currentThread().getName());
		return userMap;
	}



}
