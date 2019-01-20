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
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "CC_Case", indexes = {

        @Index(name="cc_case_payId_index",columnList = "payId"),
        @Index(name="cc_case_storeId_index",columnList = "storeId"),
        @Index(name="cc_case_userId_index",columnList = "userId"),
        @Index(name="cc_case_carId_index",columnList = "carId"),
        @Index(name="cc_case_facilityId_index",columnList = "facilityId"),
        @Index(name="cc_case_serverId_index",columnList = "serverId"),
        @Index(name="cc_case_caseType_index",columnList = "caseType"),
        @Index(name="cc_case_creationDate_index",columnList = "creationDate"),
        @Index(name="cc_case_lastModifiedDate_index",columnList = "lastModifiedDate")
})
public class Case extends BaseBo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caseId_seq")
    @SequenceGenerator(name="caseId_seq",allocationSize=1,initialValue=5000000,sequenceName="caseId_seq")
    private Long caseId;

    @Column(nullable = false)
    private Long payId;

    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long carId;

    @Column(nullable = false)
    private Long facilityId;

    @Column(nullable = false)
    private Long serverId;

    /**
     * 投诉、退款、意见、通知
     */
    @Min(0)
    @Max(9999)
    @Column(columnDefinition = "SMALLINT(4) default '0'", nullable = false)
    private int caseType;

    @Column(length = 256, nullable = false)
    private String caseDesc;

    @Column(columnDefinition = "BLOB")
    private String caseLog;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(nullable = false)
    private Date lastModifiedDate;

}
