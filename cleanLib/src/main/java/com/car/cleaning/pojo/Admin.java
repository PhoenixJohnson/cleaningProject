package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Setter
@Getter
@Entity
@Table(name = "CC_Admin", indexes = {
        @Index(name="cc_admin_status_index", columnList = "status"),
        @Index(name="cc_admin_creationDate_index",columnList = "creationDate"),
        @Index(name="cc_admin_lastModifiedDate_index",columnList = "lastModifiedDate")
})
public class Admin {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long adminId;

    @Column(length = 512, nullable = false)
    private String password;

    @Column(length = 512)
    private String roleList;

    @Min(0)
    @Max(2)
    @Column(columnDefinition = "TINYINT(1) default '0'")
    private int status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastModifiedDate;

}
