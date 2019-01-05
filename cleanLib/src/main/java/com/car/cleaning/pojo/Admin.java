package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
@Table(name = "CC_Admin", indexes = {
        @Index(name="cc_admin_status_index", columnList = "status"),
        @Index(name="cc_admin_creationDate_index",columnList = "creationDate"),
        @Index(name="cc_admin_lastModifiedDate_index",columnList = "lastModifiedDate")
})
public class Admin extends BaseBo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adminId_seq")
    @SequenceGenerator(name="adminId_seq",allocationSize=1,initialValue=5000000,sequenceName="adminId_seq")
    private Long adminId;

    private Long storeId;

    @Column(length = 512, nullable = false)
    private String password;

    @Column(length = 512)
    private String roleList;

    @Min(0)
    @Max(2)
    @Column(columnDefinition = "TINYINT(1) default '0'")
    private int status;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(nullable = false)
    private Date lastModifiedDate;

}
