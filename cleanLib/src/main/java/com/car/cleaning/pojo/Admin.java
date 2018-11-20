package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Setter
@Getter
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long adminId;
    private String password;
    private String roleList;
    private int Status;

}
