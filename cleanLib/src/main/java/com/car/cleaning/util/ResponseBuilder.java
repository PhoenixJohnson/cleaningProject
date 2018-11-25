package com.car.cleaning.util;

import com.car.cleaning.rpc.CommonResponse;

import java.util.List;

/**
 * Created by jiangyunfan on 2018/11/22.
 */
public class ResponseBuilder {

    public static CommonResponse buildFailedResponse() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(false);
        return commonResponse;
    }


    public static CommonResponse buildShortMessageResponse(String responseMessage, boolean success) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(success);
        if (responseMessage != null) {
            commonResponse.setShortMessage(responseMessage);
        }
        return commonResponse;
    }

    public static CommonResponse buildResponseObj(Object obj, boolean success) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(success);
        if (obj != null) {
            commonResponse.setResponseObj(obj);
        }
        return commonResponse;
    }

    public static CommonResponse buildResponseObj(List<?> objList, boolean success) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(success);
        if (objList != null) {
            commonResponse.setResponseObjList(objList);
        }
        return commonResponse;
    }
}


