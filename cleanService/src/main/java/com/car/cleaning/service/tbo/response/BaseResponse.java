package com.car.cleaning.service.tbo.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.core.Response;
import java.util.List;

@Getter
@Setter
public class BaseResponse {
    @JsonIgnore
    private Response.Status status;
    private List<CCErrorDetail> errors;
}