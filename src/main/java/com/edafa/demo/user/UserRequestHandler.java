package com.edafa.demo.user;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserRequestHandler {

    public static boolean requestFlag=true;

    public static Map<String, Map<RequestEnum, Integer>> userRequests=new HashMap<>();

    public UserRequestHandler(Map<String, Map<RequestEnum, Integer>> userRequests) {

        this.userRequests = userRequests;
    }

    public static Map<String, Map<RequestEnum, Integer>> getUserRequests() {
        return userRequests;
    }

    public static void setUserRequests(Map<String, Map<RequestEnum, Integer>> map) {
        userRequests=map;
    }


}
