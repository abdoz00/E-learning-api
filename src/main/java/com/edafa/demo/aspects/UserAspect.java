package com.edafa.demo.aspects;

import com.edafa.demo.user.ActiveUserStore;
import com.edafa.demo.user.RequestEnum;
import com.edafa.demo.user.UserRequestHandler;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class UserAspect {


    @Autowired
    private ActiveUserStore activeUserStore;

    @Pointcut("execution(* com.edafa.demo.controller.*.*(..))")
    public void AllRequests(){}

    @Before("AllRequests()")
    public void beforeAnyRequest(){
        Map temp;
        int max;
        int current;

        List<String> activeUsers;
        Map<String, Map<RequestEnum, Integer>> userRequests;

        activeUsers = activeUserStore.getUsers();
        userRequests=UserRequestHandler.getUserRequests();
        System.out.println(userRequests);

        if (activeUsers.size()==0){return;}

        temp=userRequests.get(activeUsers.get(0));
        max=(int)temp.get(RequestEnum.MAX);
        current=(int)temp.get(RequestEnum.CURRENT);

        if (current>=max){
            UserRequestHandler.requestFlag=false;
            return;}

        temp.replace(RequestEnum.CURRENT,current+1);
        UserRequestHandler.userRequests.replace(activeUsers.get(0),temp);

    }
}
