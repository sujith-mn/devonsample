package com.test.hrms.general.common.api.datatype;

/**
 * All
 */
public enum SecondFactor {

    //No factor required
    NONE("none"),
    //OTP required
    OTP("OTP");

    final String value;


    SecondFactor(String factor) {
        this.value = factor;
    }
}
