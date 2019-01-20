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
@Table(name = "CC_CashPay", indexes = {
        @Index(name="cc_cashPay_storeId_index", columnList = "storeId"),
        @Index(name="cc_cashPay_invoiceDay_index", columnList = "invoiceDay"),
        @Index(name="cc_cashPay_cashProtocolId_index", columnList = "cashProtocolId"),
        @Index(name="cc_cashPay_storeCashAccount_index", columnList = "storeCashAccount"),
        @Index(name="cc_cashPay_cashStatus_index", columnList = "cashStatus"),
        @Index(name="cc_cashPay_creationDate_index", columnList = "creationDate"),
        @Index(name="cc_cashPay_lastModifiedDate_index", columnList = "lastModifiedDate")
})
public class CashPay extends BaseBo{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cashPayId_seq")
    @SequenceGenerator(name="cashPayId_seq",allocationSize=1,initialValue=5000000,sequenceName="cashPayId_seq")
    private Long cashPayId;

    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private Long cashProtocolId;

    @Min(0)
    @Max(16777215)
    @Column(columnDefinition = "MEDIUMINT default '0'")
    private int washCount;

    /**
     * YYYY-MM-DD
     */
    @Column(length = 128)
    private String invoiceDay;

    //提现日期或者日期范围
    @Column(length = 256)
    private String cashPayDateSign;

    //提现备注
    @Column(length = 256)
    private String cashComment;

    @Column(length = 256)
    private String storeCashAccount;

    @Column(length = 512)
    private String storeAccountInfo;

    //营业额
    @Column(precision = 8, scale = 2)
    private double rawAmount;

    //总洗车退款额
    @Column(precision = 8, scale = 2)
    private double totalRefundAmount;

    //第三方手续费
    @Column(precision = 8, scale = 2)
    private double serviceCharge;

    //净收益
    @Column(precision = 8, scale = 2)
    private double netAmount;

    //到账净收益 = 净收益 - 提现手续费
    @Column(precision = 8, scale = 2)
    private double netSettledAmount;

    @Column(length = 256)
    private String cashPayToken;

    //提现状态
    @Min(0)
    @Max(2)
    @Column(columnDefinition = "TINYINT(1) default '0'")
    private int cashStatus;

    //到款状态
    @Min(0)
    @Max(2)
    @Column(columnDefinition = "TINYINT(1) default '0'")
    private int cashSettleStatus;

    //提现方式：全部提现，单日提现
    private String cashMethod;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(nullable = false)
    private Date lastModifiedDate;

}
