package com.me.commons.domain.enums;

public enum EntityStatus {

    ACTIVE("Active"), INACTIVE("Inactive"), DELETED("Deleted");

    private String value;

    private EntityStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
