package com.car.cleaning.service.resources;

import com.car.cleaning.dal.UserDao;
import com.car.cleaning.pojo.User;
import com.car.cleaning.rpc.CommonResponse;
import com.car.cleaning.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;

/**
 * Created by jiangyunfan on 2018/11/21.
 */
@Controller
@RequestMapping("/cc/api/v1")
public class QueryResource {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value= "/user", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> createCCUser(@RequestBody User user) {
        try{
            return new ResponseEntity<>(ResponseBuilder.buildResponseObj(userDao.createUser(user), true), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(ResponseBuilder.buildShortMessageResponse(e.getMessage(), false), HttpStatus.OK);
        }
    }


}
