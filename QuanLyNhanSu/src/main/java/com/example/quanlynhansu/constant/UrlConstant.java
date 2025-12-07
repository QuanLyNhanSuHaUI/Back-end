package com.example.quanlynhansu.constant;

import com.example.quanlynhansu.domain.entity.Department;

public class UrlConstant {

    public static class Department{
        private static final String PRE_FIX = "/departments";
        public static final String DEPARTMENT_COMMON = PRE_FIX;
        public static final String DEPARTMENT_ID = PRE_FIX + "/{id}";
        public static final String DEPARTMENT_NAME = PRE_FIX + "/find";
    }

}
