package com.studentportalbackend.model.enums;

public enum AccountTypeEnum {

    USER("USER"), ADMIN("ADMIN"), COORDINATOR("COORDINATOR");

    private final String accountType;

     AccountTypeEnum(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return  this.accountType;
    }

    public static AccountTypeEnum parse(String accountType) {
        AccountTypeEnum accountTypeEnum = null;
        for (AccountTypeEnum item : AccountTypeEnum.values()) {
            if (item.getAccountType()==accountType) {
                accountTypeEnum = item;
                break;
            }
        }
        return accountTypeEnum;
    }

}
