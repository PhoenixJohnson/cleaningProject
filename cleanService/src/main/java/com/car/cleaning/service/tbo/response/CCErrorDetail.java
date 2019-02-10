package com.car.cleaning.service.tbo.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by jiangyunfan on 2019/2/10.
 */
@Setter
@Getter
public class CCErrorDetail {

    private String errorId;
    private String source;
    private String message;
}
