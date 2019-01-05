package com.car.cleaning.console.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.inject.Singleton;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiangyunfan on 2019/1/5.
 */
@Component
@Singleton
@Scope(value = "session",
        proxyMode = ScopedProxyMode.TARGET_CLASS)
@Slf4j
public class RoleHub {

    private Long adminId;
    private static HttpServletRequest request;
    private static HttpServletResponse response;
    private static final String ADMIN_COOKIE_KEY_NAME = "ADMIN_COOKIE_KEY_NAME";


    public void RoleHub() {
        RoleHub.request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        RoleHub.response = ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();

    }

    public Long getAdminIdFromCookie() {
        Cookie[] cookiesReq = RoleHub.request.getCookies();
        for (Cookie cookie : cookiesReq) {
            if (cookie.getName().equals(ADMIN_COOKIE_KEY_NAME)) {
                return Long.parseLong(cookie.getValue());
            }
        }
        return null;
    }

    public void saveAdminIdToClientCookie(Long adminId) {
        boolean alreadyLogin = false;
        this.adminId = adminId;
        Cookie[] cookies = RoleHub.request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(ADMIN_COOKIE_KEY_NAME) && adminId == Long.parseLong(cookie.getValue())) {
                alreadyLogin = true;
                break;
            }
        }
        if (!alreadyLogin) {
            Cookie adminIdCookie = new Cookie(ADMIN_COOKIE_KEY_NAME, String.valueOf(adminId));
            adminIdCookie.setMaxAge(3600 * 24 * 7);
            adminIdCookie.setDomain("cc.clean.console.com");
            RoleHub.response.addCookie(adminIdCookie);
        }
    }


}
