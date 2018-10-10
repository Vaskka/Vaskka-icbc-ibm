package com.vaskka.api.icbc.sdk.response;

/**
 * @program: ICBC_IBM_PAY_SDK
 * @description: ApiSdkRechargeResponse 退款操作返回集
 * @author: Vaskka
 * @create: 2018/10/10 下午10:10
 **/

public class ApiSdkRechargeResponse extends ApiSdkBaseResponse {
    private String rechargeMoney;

    public String getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(String rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public ApiSdkRechargeResponse(boolean ok, String message,String msgId, String orderId, String rechargeAmount) {
        super(ok, message, msgId, orderId);
        this.rechargeMoney = rechargeAmount;
    }
}
