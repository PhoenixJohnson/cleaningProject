package com.car.cleaning.console.aop;

import com.car.cleaning.core.manager.AdminManager;
import com.car.cleaning.exception.CleanException;
import com.car.cleaning.rpc.ResponseBuilder;
import com.car.cleaning.rpc.role.CCleanRoleGroupEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Created by yunjiang on 6/24/18.
 */
@Aspect
@Component
public class RoleAop {

    @Autowired
    private AdminManager adminManager;

    @Autowired
    private RoleHub roleHub;

    @Around("execution(* com.car.cleaning.console.resource..*(..)) && @annotation(roleAccess)")
    public Object accessExec(ProceedingJoinPoint thisJoinPoint, RoleAccess roleAccess) throws Throwable {

        try {
            Long adminId = roleHub.getAdminIdFromCookie();
            if(adminId == null) {
                return new ResponseEntity<>(ResponseBuilder.buildShortMessageResponse("用户未登陆或者注册，请重新登陆", false), HttpStatus.OK);
            }
            boolean isAllowed = isRoleAuthorized(roleAccess.roles(), adminManager.getRoleListByAdminId(adminId).split(","));
            if (!isAllowed) {
                return new ResponseEntity<>(ResponseBuilder.buildShortMessageResponse("用户未授权",false), HttpStatus.OK);
            } else {
                return thisJoinPoint.proceed();
            }
        } catch (CleanException e) {
            return new ResponseEntity<>(ResponseBuilder.buildShortMessageWithRedirectionResponse(e.getMessage(), false), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(ResponseBuilder.buildShortMessageResponse("用户未授权", false), HttpStatus.OK);
        }
    }


    private boolean isRoleAuthorized(CCleanRoleGroupEnum[] requiredRoles, String[] userRoles) {
        if(null == userRoles) {
            return false;
        }
        if(roleHub.getAdminIdFromCookie() != null && null == requiredRoles) {
            return true;
        }
        for(String userRole: userRoles) {
            for(CCleanRoleGroupEnum requiredRole: requiredRoles) {
                if(CCleanRoleGroupEnum.isAuthed(userRole, requiredRole.name())){
                    return true;
                }
            }
        }
        return false;
    }

}
