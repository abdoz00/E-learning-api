package com.edafa.demo.service;

import com.edafa.demo.dao.UserRepo;
import com.edafa.demo.entity.User;
import com.edafa.demo.user.ActiveUserStore;
import com.edafa.demo.user.RequestEnum;
import com.edafa.demo.user.UserRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private ActiveUserStore activeUserStore;

    @Autowired
    private UserRepo repo;

    public  Map<String, Map<RequestEnum, Integer>> generateMap() {
        Map<String, Map<RequestEnum, Integer>> userRequests = new HashMap<>();
        List<User> users=repo.findAll();
        for (User user:
             users) {
            Map map=new HashMap<>();
            map.put(RequestEnum.MAX,user.getMax_requests());
            map.put(RequestEnum.CURRENT,user.getCurrent_requests());
            userRequests.put(user.getName(),map);
        }
        System.out.println(userRequests);
        return userRequests;
    }
}
