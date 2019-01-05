package com.car.cleaning.rpc.role;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by jiangyunfan on 12/31/18.
 */
public enum CCleanRoleGroupEnum {
    SEARCH_GROUP(1),
    STORE_GROUP(1 + 2),
    ADMIN_GROUP((int) Math.pow(2, 2)),
    VP_GROUP((int) Math.pow(2, 3)),
    UM_GROUP((int) Math.pow(2, 4));

    @Getter
    private final int authPoint;

    private static final String ROLE_SPLITTER = ",";

    CCleanRoleGroupEnum(int authPoint) {
        this.authPoint = authPoint;
    }

    public static CCleanRoleGroupEnum getRoleByName(String roleName) {
        for (CCleanRoleGroupEnum role : CCleanRoleGroupEnum.values()) {
            if (role.name().equalsIgnoreCase(roleName)) {
                return role;
            }
        }
        return null;
    }

    public static String getAdminRoles() {
        StringBuilder sb = new StringBuilder();
        for (CCleanRoleGroupEnum role : CCleanRoleGroupEnum.values()) {
            sb.append("," + role.name().trim());
        }
        return sb.toString().substring(1);
    }

    public static boolean isContainRole(String inputRoles, CCleanRoleGroupEnum expectedRole) {
        if(StringUtils.isEmpty(inputRoles)) {
            return false;
        }
        String[] roleList = inputRoles.split(ROLE_SPLITTER);
        for(String role:roleList){
            if(role.trim().equalsIgnoreCase(expectedRole.name())){
                return true;
            }
        }
        return false;
    }

    public static boolean isAuthed(String userRole, String requiredRole) {
        CCleanRoleGroupEnum input = CCleanRoleGroupEnum.getRoleByName(userRole);
        CCleanRoleGroupEnum target = CCleanRoleGroupEnum.getRoleByName(requiredRole);
        if (null == input || null == target) {
            return false;
        }
        if ((target.getAuthPoint() & input.getAuthPoint()) == target.getAuthPoint()) {
            return true;
        }
        return false;

    }
}
