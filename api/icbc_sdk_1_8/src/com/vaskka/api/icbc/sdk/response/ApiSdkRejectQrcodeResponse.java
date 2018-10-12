package com.vaskka.api.icbc.sdk.response;

/**
 * @program: ICBC_IBM_PAY_SDK
 * @description: ApiSdkRejectQrcodeResponse 执行退款操作后返回的结果集
 * @author: Vaskka
 * @create: 2018/10/10 下午10:05
 **/

public class ApiSdkRejectQrcodeResponse extends ApiSdkBaseResponse {
    private String rejectMoney;

    public String getRejectMoney() {
        return rejectMoney;
    }

    public void setRejectMoney(String rejectMoney) {
        this.rejectMoney = rejectMoney;
    }

    public ApiSdkRejectQrcodeResponse(boolean ok, String message, String msgId, String orderId, String rejectMoney) {
        super(ok, message, msgId, orderId);
        this.rejectMoney = rejectMoney;

    }


}
