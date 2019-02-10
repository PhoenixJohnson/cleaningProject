package com.car.cleaning.service.resources;

import com.car.cleaning.rpc.CommonResponse;
import com.car.cleaning.rpc.ResponseBuilder;
import com.car.cleaning.service.tbo.request.JournalRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by jiangyunfan on 2018/11/21.
 */
@Controller
@RequestMapping("/v1")
public class JournalResource {

    @RequestMapping(value = "/journal", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> findPaymentById(@RequestBody JournalRequest journalRequest) {
        try {
            System.out.print(journalRequest.toString());
            return new ResponseEntity<>(ResponseBuilder.buildResponseObj(null, true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(ResponseBuilder.buildShortMessageResponse(e.getMessage(), false), HttpStatus.OK);
        }
    }


}
