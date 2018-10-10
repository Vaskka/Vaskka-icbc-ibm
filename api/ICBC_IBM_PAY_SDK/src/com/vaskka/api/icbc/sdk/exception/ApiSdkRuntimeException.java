package com.vaskka.api.icbc.sdk.exception;

/**
 * @program: ICBC_IBM_PAY_SDK
 * @description: ApiSdkRuntimeException 运行时异常
 * @author: Vaskka
 * @create: 2018/10/11 上午12:11
 **/
public class ApiSdkRuntimeException extends Exception {
    private String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ApiSdkRuntimeException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
