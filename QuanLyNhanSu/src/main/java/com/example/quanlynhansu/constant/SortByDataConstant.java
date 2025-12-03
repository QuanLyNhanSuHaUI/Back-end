package com.example.quanlynhansu.constant;

public enum SortByDataConstant implements SortByInterface{
    ;

    @Override
    public String getSortBy(String sortBy) {
        switch (sortBy) {
            case "firstName":
                return "first_name";
            case "lastName":
                return "last_name";
            case "lastModifiedDate":
                return "last_modified_date";
            default:
                return "created_date";
        }
    }
}
