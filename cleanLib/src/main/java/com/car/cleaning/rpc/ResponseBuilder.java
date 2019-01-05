package com.car.cleaning.rpc;

import java.util.List;

/**
 * Created by yunjiang on 6/23/18.
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

    public static CommonResponse buildShortMessageWithRedirectionResponse(String responseMessage, boolean success) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(success);
        commonResponse.setRedirect(true);
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


    public static CommonResponse buildResponseObj(List<?> objList, int totalSize,  boolean success) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(success);
        commonResponse.setCount(totalSize);
        if (objList != null) {
            commonResponse.setResponseObjList(objList);
        }
        return commonResponse;
    }

    public static CommonResponse buildEnvResponse(boolean isPro) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(true);
        commonResponse.setProduction(isPro);
        return commonResponse;
    }

}

