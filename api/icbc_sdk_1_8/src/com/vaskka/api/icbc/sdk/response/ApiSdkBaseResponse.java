package com.vaskka.api.icbc.sdk.response;

/**
 * @program: ICBC_IBM_PAY_SDK
 * @description: ApiSdkResponse 执行sdk方法返回的统一数据类型的基类
 * @author: Vaskka
 * @create: 2018/9/18 下午7:16
 **/

public class ApiSdkBaseResponse {
    protected boolean ok;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    protected String message;

    protected String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    protected  String orderId;

    public ApiSdkBaseResponse() {

        ok = false;
        message = "ICBC open api has not returned successfully!";
    }

    public ApiSdkBaseResponse(boolean ok, String message, String msgId, String orderId) {
        this.ok = ok;
        this.message = message;
        this.msgId = msgId;
        this.orderId = orderId;
    }



}
