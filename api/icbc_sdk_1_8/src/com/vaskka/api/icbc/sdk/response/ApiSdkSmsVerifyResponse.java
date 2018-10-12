package com.vaskka.api.icbc.sdk.response;

/**
 * @program: ICBC_IBM_PAY_SDK
 * @description: ApiSdkSmsVertify 上送验证码操作返回的结果集
 * @author: Vaskka
 * @create: 2018/10/10 下午10:54
 **/

public class ApiSdkSmsVerifyResponse extends ApiSdkBaseResponse {

    private boolean pass;

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public ApiSdkSmsVerifyResponse(boolean ok, String message, String msgId, String orderId, boolean pass) {
        super(ok, message, msgId, orderId);
        this.pass = pass;
    }
}
