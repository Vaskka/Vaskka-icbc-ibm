package com.vaskka.api.icbc.sdk;

import com.vaskka.api.icbc.sdk.exception.ApiSdkRuntimeException;
import com.vaskka.api.icbc.sdk.response.ApiSdkBaseResponse;
import com.vaskka.api.icbc.sdk.response.ApiSdkPayQrcodeResponse;
import com.vaskka.api.icbc.sdk.utils.UsualUtil;

import static com.vaskka.api.icbc.sdk.utils.UsualUtil.L;

/**
 * @program: ICBC_IBM_PAY_SDK
 * @description: Test 测试用
 * @author: Vaskka
 * @create: 2018/9/18 下午6:56
 **/

public class Test {

    /**
     * 用于输出调试
     * @param resp 结果集
     */
    private static void showInfo(ApiSdkBaseResponse resp) {
        L(resp.isOk());
        L(resp.getMessage());
        L("+-------------------------+");
    }

    /**
     * api测试
     * @throws ApiSdkRuntimeException api运行时异常
     */
    private static void coreTest() throws ApiSdkRuntimeException {
        // 测试开户
        ApiSdkBaseResponse resp = ApiSdkRunner.doSettlementOpen(UsualUtil.getMsgId(), UsualUtil.getOrderId(), "12345", "Vaskka", "12306", "12334556", "244343");
        showInfo(resp);

        // 测试充值
        resp = ApiSdkRunner.doSettleRecharge(UsualUtil.getMsgId(), UsualUtil.getOrderId(), "33445", "32324234");
        showInfo(resp);

        // 测试账单二维码生成
        resp = ApiSdkRunner.doCreateQrcode(UsualUtil.getMsgId(), UsualUtil.getOrderId(), "34243242", "127.0.0.1");
        showInfo(resp);
        L(((ApiSdkPayQrcodeResponse) resp).getResultUrl());

        // 测试退款二维码生成
        resp = ApiSdkRunner.doRejectQrcode(UsualUtil.getMsgId(), UsualUtil.getOrderId(), "8888", "46546");
        showInfo(resp);

        // 测试开户短信发送
        resp = ApiSdkRunner.doSmsSend(UsualUtil.getMsgId(), UsualUtil.getOrderId(), "2234234");
        showInfo(resp);

        // 测试短信验证码校验
        resp = ApiSdkRunner.doSmsVerify(UsualUtil.getMsgId(), UsualUtil.getOrderId(), "34242", "3333");
        showInfo(resp);
    }

    /**
     * 其他测试
     */
    private static void otherTest() {
        L(UsualUtil.getMsgId());
        L(UsualUtil.getMsgId().length());
        L(UsualUtil.getOrderId());
        L(UsualUtil.getOrderId().length());
    }

    public static void main(String[] argc) throws ApiSdkRuntimeException {
        coreTest();
        otherTest();
    }
}

