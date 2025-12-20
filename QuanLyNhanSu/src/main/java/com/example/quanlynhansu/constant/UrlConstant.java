package com.example.quanlynhansu.constant;

public class UrlConstant {

    public static class Department{
        private static final String PRE_FIX = "/departments";
        public static final String DEPARTMENT_COMMON = PRE_FIX;
        public static final String DEPARTMENT_ID = PRE_FIX + "/{id}";
        public static final String DEPARTMENT_NAME = PRE_FIX + "/find";
    }

    public static class Employee{
        private static final String PRE_FIX = "/employees";

        public static final String EMPLOYEE_COMMON = PRE_FIX;

        public static final String EMPLOYEE_ID = PRE_FIX + "/{id}";

        public static final String EMPLOYEE_NAME = PRE_FIX + "/find";

    }

    public static class Contract{

        private static final String PRE_FIX = "/contracts";

        public static final String CONTRACT_COMMON = PRE_FIX;

        public static final String CONTRACT_ID = PRE_FIX + "/{id}";

        public static final String CONTRACT_OF_EMPLOYEE = PRE_FIX + "/find";

    }

    public static class Payroll{
        private static final String PRE_FIX = "/payrolls";

        public static final String PAYROLL_COMMON = PRE_FIX;
    }

    public static class Auth{
        private static final String PRE_FIX = "/auth";

        public static final String LOGIN = PRE_FIX + "/login";
    }

}
