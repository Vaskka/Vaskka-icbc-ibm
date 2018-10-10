package com.vaskka.api.icbc.sdk;

import com.icbc.api.IcbcApiException;
import com.vaskka.api.icbc.sdk.exception.ApiSdkRuntimeException;
import com.vaskka.api.icbc.sdk.response.ApiSdkBaseResponse;

import static com.vaskka.api.icbc.sdk.utils.UsualUtil.L;

/**
 * @program: ICBC_IBM_PAY_SDK
 * @description: Test 测试用
 * @author: Vaskka
 * @create: 2018/9/18 下午6:56
 **/

public class Test {

    private static void showInfo(ApiSdkBaseResponse resp) {
        L(resp.isOk());
        L(resp.getMessage());
        L("+-------------------------+");
    }


    public static void main(String[] argc) throws ApiSdkRuntimeException {
        // 测试开户
        ApiSdkBaseResponse resp = ApiSdkRunner.doSettlementOpen("12ASd3ASds4", "123", "12345", "Vaskka", "12306", "12334556", "244343");
        showInfo(resp);

        // 测试充值
        resp = ApiSdkRunner.doSettleRecharge("12FE3", "12dSsa34", "33445", "32324234");
        showInfo(resp);

        // 测试账单二维码生成
        resp = ApiSdkRunner.doCreateQrcode("55Asd667", "3DSas34234", "34243242", "127.0.0.1");
        showInfo(resp);

        // 测试退款二维码生成
        resp = ApiSdkRunner.doRejectQrcode("56df3634564", "3242SadS345", "8888", "46546");
        showInfo(resp);

        // 测试开户短信发送
        resp = ApiSdkRunner.doSmsSend("4534DFs53", "32FDad424", "2234234");
        showInfo(resp);

        // 测试短信验证码校验
        resp = ApiSdkRunner.doSmsVerify("34SDF2s42", "342asdS432", "34242", "3333");
        showInfo(resp);
    }
}

