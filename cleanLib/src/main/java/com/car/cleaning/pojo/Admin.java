package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Setter
@Getter
@Entity
@Table(name = "CC_Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long adminId;
    private String password;
    private String roleList;
    private int Status;

}
