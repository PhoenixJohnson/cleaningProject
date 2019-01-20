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
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "CC_FacilityInstrument", indexes = {
        @Index(name="cc_facilityInstrumentId_index", columnList = "facilityInstrumentId"),
        @Index(name="cc_facInstrument_facilityId_index", columnList = "facilityId"),
        @Index(name="cc_facInstrument_status_index", columnList = "status"),
        @Index(name="cc_facInstrument_active_index", columnList = "active"),
        @Index(name="cc_facInstrument_creationDate_index", columnList = "creationDate"),
        @Index(name="cc_facInstrument_lastModifiedDate_index", columnList = "lastModifiedDate")
})
public class FacilityInstrument extends BaseBo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facilityInstrumentId_seq")
    @SequenceGenerator(name="facilityInstrumentId_seq",allocationSize=1,initialValue=5000000,sequenceName="facilityInstrumentId_seq")
    private Long facilityInstrumentId;

    private Long facilityId;

    @Column(length = 128)
    private String instrumentTag;

    @Column(length = 512)
    private String instrumentIntro;

    @Column(precision = 6, scale = 2)
    private double amount;

    /**
     * 机器状态，运行良好、运行警告、运行错误
     */
    @Column(length = 32)
    private String status;

    @Min(0)
    @Max(2)
    @Column(columnDefinition = "TINYINT(1) default '0'")
    private int active;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(nullable = false)
    private Date lastModifiedDate;
}
