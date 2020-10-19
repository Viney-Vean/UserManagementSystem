package com.usermanagement.system.core;
import lombok.Data;

@Data
public class NumberValidation {
    public NumberValidation(){}

    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
        }

        return false;
    }
}
