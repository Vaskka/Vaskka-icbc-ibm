package com.vaskka.api.icbc.sdk.response;

/**
 * @program: ICBC_IBM_PAY_SDK
 * @description: ApiSdkOpenAccountResponse 执行开户操作结果集
 * @author: Vaskka
 * @create: 2018/10/10 下午10:21
 **/

public class ApiSdkOpenAccountResponse extends ApiSdkBaseResponse {
    /**
     * 短信验证码编号
     */
    private String smsCodeNo;



    public String getSmsCodeNo() {
        return smsCodeNo;
    }

    public void setSmsCodeNo(String smsCodeNo) {
        this.smsCodeNo = smsCodeNo;
    }


    public ApiSdkOpenAccountResponse(boolean ok, String message, String msgId, String orderId, String smsCodeNo) {
        super(ok, message, msgId, orderId);
        this.smsCodeNo = smsCodeNo;

    }
}
