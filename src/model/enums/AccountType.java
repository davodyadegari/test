package model.enums;

import Exeptions.InvalidInputException;

public enum AccountType {
    SEPORDE(2),JARI(1),GHARZOL_HASANE(3);

    private Integer value;

    AccountType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static AccountType getAccountType(Integer value){
        for (AccountType accountType : values()) {
            if (accountType.getValue().equals(value))
                return accountType;
        }
        throw new InvalidInputException("invalid value.");
    }
}

