package com.vaskka.api.icbc.sdk.response;

/**
 * @program: ICBC_IBM_PAY_SDK
 * @description: ApiSdkPayQrcodeResponse 执行支付操作返回的数据结果集
 * @author: Vaskka
 * @create: 2018/10/10 下午10:01
 **/
public class ApiSdkPayQrcodeResponse extends ApiSdkBaseResponse {

    private String resultUrl;

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }

    public ApiSdkPayQrcodeResponse(boolean ok, String message,String msgId, String orderId, String resultUrl) {
        super(ok, message, msgId, orderId);
        this.resultUrl = resultUrl;
    }


}
