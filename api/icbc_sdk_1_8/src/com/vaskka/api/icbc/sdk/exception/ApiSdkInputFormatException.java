package com.vaskka.api.icbc.sdk.exception;

/**
 * @program: ICBC_IBM_PAY_SDK
 * @description: ApiSdkInputFormatException 输入参数格式异常
 * @author: Vaskka
 * @create: 2018/10/11 上午12:08
 **/
public class ApiSdkInputFormatException extends Exception {
    private  Object exceptInput;

    public Object getExceptInput() {
        return exceptInput;
    }

    public void setExceptInput(Object exceptInput) {
        this.exceptInput = exceptInput;
    }

    public ApiSdkInputFormatException(String message, Object exceptInput) {
        super(message);
        this.exceptInput = exceptInput;
    }
}
