package com.car.cleaning.console.aop;


import com.car.cleaning.rpc.role.CCleanRoleGroupEnum;

import java.lang.annotation.*;

/**
 * Created by yunjiang on 8/5/18.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RoleAccess {

    CCleanRoleGroupEnum[] roles();

}
