package com.vaskka.api.icbc.sdk.response;

/**
 * @program: ICBC_IBM_PAY_SDK
 * @description: ApiSdkSmsSendResponse 执行开户二维码发送的结果集
 * @author: Vaskka
 * @create: 2018/10/10 下午10:51
 **/

public class ApiSdkSmsSendResponse extends ApiSdkBaseResponse {
    private String smsCodeNo;

    public String getSmsCodeNo() {
        return smsCodeNo;
    }

    public void setSmsCodeNo(String smsCodeNo) {
        this.smsCodeNo = smsCodeNo;
    }

    public ApiSdkSmsSendResponse(boolean ok, String message, String msgId, String orderId, String smsCodeNo) {
        super(ok, message, msgId, orderId);
        this.smsCodeNo = smsCodeNo;
    }
}
