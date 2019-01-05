package com.car.cleaning.console.resource;

import com.car.cleaning.rpc.CConsoleRequest;
import com.car.cleaning.rpc.CommonResponse;
import com.car.cleaning.rpc.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * Created by jiangyunfan on 2019/1/5.
 */

@Controller
@RequestMapping("/api/car")
public class CarReportResource {

    @RequestMapping(value = "/getRealTimeCarList",
            method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> getCarListRT(
            @RequestBody CConsoleRequest request) {
        try {
            return new ResponseEntity<>(ResponseBuilder.buildResponseObj(new ArrayList<>(), true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(ResponseBuilder.buildShortMessageResponse(e.getMessage(), false), HttpStatus.OK);
        }

    }

}
