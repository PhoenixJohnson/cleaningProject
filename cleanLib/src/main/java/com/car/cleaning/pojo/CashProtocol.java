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
@Table(name = "CC_CashProtocol", indexes = {
        @Index(name = "cc_cashProtocol_protocolTag_index", columnList = "protocolTag"),
        @Index(name = "cc_cashProtocol_storeId_index", columnList = "storeId"),
        @Index(name = "cc_cashProtocol_storeTaxNumber_index", columnList = "storeTaxNumber"),
        @Index(name = "cc_cashProtocol_createPerson_index", columnList = "createPerson"),
        @Index(name = "cc_cashProtocol_creationDate_index", columnList = "creationDate"),
        @Index(name = "cc_cashProtocol_lastModifiedDate_index", columnList = "lastModifiedDate")
})
public class CashProtocol extends BaseBo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cashProtocolId_seq")
    @SequenceGenerator(name = "cashProtocolId_seq", allocationSize = 1, initialValue = 5000000, sequenceName = "cashProtocolId_seq")
    private Long cashProtocolId;

    private Long storeId;

    //店铺名
    @Column(length =128)
    private String storeName;

    /**
     * YYYY-MM-DD
     */
    @Column(length = 32)
    private String protocolStartDate;

    /**
     * YYYY-MM-DD
     */
    @Column(length = 32)
    private String protocolEndDate;

    /**
     * 每单收1元
     * 总营业额5%
     * 等等
     */
    @Column(length = 128)
    private String protocolTag;

    /**
     * 0.17
     * 0.15
     * 增值税，如果店铺不自己处理增值税，公司代缴，并且收取一定手续费，如果店铺自行提交增值税，填写营业执照税务号
     */
    @Column(length = 32)
    private String dutyTaxRate;

    /**
     * 0.06
     * 0.05
     * 增值税代缴服务费
     */
    @Column(length = 32)
    private String dutyTaxChargeRate;

    /**
     * 店铺税务号
     */
    @Column(length = 256)
    private String storeTaxNumber;

    //自动续约
    @Min(0)
    @Max(2)
    @Column(columnDefinition = "TINYINT(1) default '0'")
    private int renew;

    /**
     * 提现最大额度
     */
    @Column(precision = 8, scale = 2)
    private double cashMaxAmount;

    @Column(length = 1024)
    private String protocolContent;

    @Column(length = 128)
    private String createPerson;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(nullable = false)
    private Date lastModifiedDate;

}
