package com.car.cleaning.engine.domain;



import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AuditClientInfo {
  private String clientIp; 
  private String uuid;
  private String componentName;
  private String serverName;
  private String timestamp;

}
