package com.vaskka.api.icbc.sdk;


import com.icbc.api.DefaultIcbcClient;
import com.icbc.api.IcbcApiException;
import com.icbc.api.IcbcConstants;
import com.icbc.api.request.*;
import com.icbc.api.response.*;
import com.vaskka.api.icbc.sdk.exception.ApiSdkRuntimeException;
import com.vaskka.api.icbc.sdk.response.*;
import com.vaskka.api.icbc.sdk.utils.UsualUtil;

import static com.vaskka.api.icbc.sdk.utils.Const.*;

/**
 * @program: ICBC_IBM_PAY_SDK
 * @description: Runner 主要执行操作的类
 * @author: Vaskka
 * @create_time: 2018/9/18 下午7:12
 **/
public class ApiSdkRunner {

    /**
     * 执行结算账户开户操作
     * @param msgId 消息号
     * @param orderId 订单号
     * @param userId 用户主键
     * @param name 用户姓名
     * @param cardNumber 卡号
     * @param phoneNumber 电话号
     * @param idNumber 身份证号
     * @return 开户结果集
     * @throws ApiSdkRuntimeException 运行时异常（当工行的通用异常抛出时抛出）
     */
    public static ApiSdkOpenAccountResponse doSettlementOpen(String msgId, String orderId, String userId, String name, String cardNumber, String phoneNumber, String idNumber) throws ApiSdkRuntimeException {

        // 测试开户
        DefaultIcbcClient client = new DefaultIcbcClient(APP_ID, MY_PRIVATE_KEY, APIGW_PUBLIC_KEY);
        SettlementAccountOpenRequestV1 request = new SettlementAccountOpenRequestV1();
        SettlementAccountOpenRequestV1.SettlementAccountOpenRequestV1Biz bizContent = new SettlementAccountOpenRequestV1.SettlementAccountOpenRequestV1Biz();
        request.setServiceUrl(SANDBOX_HOST + "/settlement/account/V1/open");

        // 一类卡号//
        bizContent.setBindMedium(cardNumber);
        // 身份证号
        bizContent.setCertNo(idNumber);
        // 证件类型(固定值)//
        bizContent.setCertType(0);
        // 客户id（客户主键user_id）//
        bizContent.setCorpCisNo(userId);
        // 合作方工作日期（当前日期）-
        bizContent.setCorpDate(UsualUtil.getCurrentDate());
        // 合作方介质号（user_id）//
        bizContent.setCorpMediumId(userId);
        // 固定的 机构编号 -
        bizContent.setCorpNo("corpInst1234");
        // 交易单号（order_id）-
        bizContent.setCorpSerno(orderId);
        // 用户姓名//
        bizContent.setCustName(UsualUtil.encodeBase64(name));
        // 性别（1-男 2-女）//
        bizContent.setGender(1);
        // 手机号//
        bizContent.setMobileNo(phoneNumber);
        // 外部服务代码(暂定固定值)-
        bizContent.setOutServiceCode("openaccount");

        // 交易日期(当前日期)-
        bizContent.setTrxAccDate(UsualUtil.getCurrentDate());
        // 交易时间(当前时间)-
        bizContent.setTrxAccTime(UsualUtil.getCurrentTime());
        // sm2加密（不填）-
        // 一类卡号md5
        bizContent.setBindMediumHash(UsualUtil.MD5(cardNumber));
        request.setBizContent(bizContent);
        SettlementAccountOpenResponseV1 response;
        try {
            response = client.execute(request, msgId);
        } catch (IcbcApiException e) {
            throw new ApiSdkRuntimeException(e.getMessage(), String.valueOf(e.getErrCode()));
        }

        if (response.isSuccess()) {

            return new ApiSdkOpenAccountResponse(true, response.getReturnMsg(), msgId, orderId, response.getSmsSendNo());

        }

        return null;
    }


    /**
     * 执行结算账户充值（回馈商户）
     * @param msgId 消息号
     * @param orderId 订单号
     * @param money 充值金额
     * @param cardNumber 卡号
     * @return 结果集
     * @throws ApiSdkRuntimeException 运行时异常（当工行的通用异常抛出时抛出）
     */
    public static ApiSdkRechargeResponse doSettleRecharge(String msgId, String orderId, String money, String cardNumber) throws ApiSdkRuntimeException {
        DefaultIcbcClient client = new DefaultIcbcClient(APP_ID, MY_PRIVATE_KEY, APIGW_PUBLIC_KEY);
        SettlementAccountRechargeRequestV1 request = new SettlementAccountRechargeRequestV1();
        SettlementAccountRechargeRequestV1.SettlementAccountRechargeRequestV1Biz bizContent = new SettlementAccountRechargeRequestV1.SettlementAccountRechargeRequestV1Biz();
        request.setServiceUrl(SANDBOX_HOST + "/settlement/account/V1/recharge");

        bizContent.setCorpNo("corpInst1234"); //合作方机构编号
        bizContent.setTrxAccDate(UsualUtil.getCurrentDate()); //合作方交易日期
        bizContent.setTrxAccTime(UsualUtil.getCurrentTime()); //合作方交易时间
        bizContent.setCorpDate(UsualUtil.getCurrentDate()); //合作方工作日期
        bizContent.setCorpSerno(orderId); //合作方交易单号
        bizContent.setOutServiceCode("recharge"); //外部服务代码
        bizContent.setMediumId(cardNumber); //工行联名卡号
        bizContent.setBindMedium(cardNumber); //绑定的I类卡号
        bizContent.setCcy(1); //币种
        bizContent.setCashExFlag(0); //钞汇标志
        bizContent.setAmount(money); //交易金额
        bizContent.setSummary("summary"); //摘要
        bizContent.setRemarks("remarks"); //注释
        request.setBizContent(bizContent);
        SettlementAccountRechargeResponseV1 response;

        // icbc-sdk 异常引发时
        try {
            response = client.execute(request, msgId);
        } catch (IcbcApiException e) {
            throw new ApiSdkRuntimeException(e.getMessage(), String.valueOf(e.getErrCode()));
        }

        if (response.isSuccess() ) {
            //成功
            return new ApiSdkRechargeResponse(true, response.getReturnMsg(), msgId, orderId, money);

        }

        return  null;
    }

    /**
     * 执行订单的二维码生成
     * @param msgId 消息号
     * @param orderId 订单号
     * @param money 金额
     * @param ip 生成订单的机器ip
     * @return 结果集
     * @throws ApiSdkRuntimeException 运行时异常（当工行的通用异常抛出时抛出）
     */
    public static ApiSdkPayQrcodeResponse doCreateQrcode(String msgId, String orderId, String money, String ip) throws ApiSdkRuntimeException {
        DefaultIcbcClient client = new DefaultIcbcClient(APP_ID, IcbcConstants.SIGN_TYPE_RSA, MY_PRIVATE_KEY, APIGW_PUBLIC_KEY);
        QrcodeGenerateRequestV2 request = new QrcodeGenerateRequestV2();
        request.setServiceUrl(REAL_HOST + "/qrcode/V2/generate");
        QrcodeGenerateRequestV2.QrcodeGenerateRequestV2Biz bizContent = new QrcodeGenerateRequestV2.QrcodeGenerateRequestV2Biz();

        bizContent.setMerId(MER_ID);
        bizContent.setStoreCode(STORE_CODE);

        // 订单号 order_id
        bizContent.setOutTradeNo(orderId);
        // 交易金额
        bizContent.setOrderAmt(money);
        // 交易Date
        bizContent.setTradeDate(UsualUtil.getCurrentDate());
        // 交易Time
        bizContent.setTradeTime(UsualUtil.getCurrentTime());
        // 有效期 (定为固定值)
        bizContent.setPayExpire(PAY_EXPIRE);
        // 机器ip
        bizContent.setTporderCreateIp(ip);
        bizContent.setNotifyFlag("0");

        request.setBizContent(bizContent);
        QrcodeGenerateResponseV2 response = new QrcodeGenerateResponseV2();

        try {
            response = client.execute(request, msgId);

        } catch (IcbcApiException e) {
            throw new ApiSdkRuntimeException(e.getMessage(), String.valueOf(e.getErrCode()));
        }

        // 构造结果集
        if (response.isSuccess()) {
            // 业务处理成功
            return new ApiSdkPayQrcodeResponse(true, response.getReturnMsg(), msgId, orderId, response.getQrcode());
        }

        return null;
    }


    /**
     * 执行退款操作
     * @param msgId 消息号
     * @param orderId 订单号
     * @param money 金额
     * @param userId 用户id
     * @return 结果集
     * @throws ApiSdkRuntimeException 运行时异常（当工行的通用异常抛出时抛出）
     */
    public static ApiSdkRejectQrcodeResponse doRejectQrcode(String msgId, String orderId, String money, String userId) throws ApiSdkRuntimeException {
        DefaultIcbcClient client = new DefaultIcbcClient(APP_ID, IcbcConstants.SIGN_TYPE_RSA, MY_PRIVATE_KEY, APIGW_PUBLIC_KEY);
        QrcodeRejectRequestV2 request = new QrcodeRejectRequestV2();
        request.setServiceUrl(SANDBOX_HOST + "/qrcode/V2/reject");
        QrcodeRejectRequestV2.QrcodeRejectRequestV2Biz bizContent = new QrcodeRejectRequestV2.QrcodeRejectRequestV2Biz();
        bizContent.setMerId(MER_ID);
        bizContent.setCustId(userId);    // 该字段非必输项
        bizContent.setOrderId(orderId);  // 该字段非必输项,out_trade_no和order_id选一项上送即可
        bizContent.setRejectNo(orderId); // 退款码即订单号
        bizContent.setRejectAmt(money);
        request.setBizContent(bizContent);
        QrcodeRejectResponseV2 response;
        try {
            response = client.execute(request, msgId);
        } catch (IcbcApiException e) {
            throw new ApiSdkRuntimeException(e.getMessage(), String.valueOf(e.getErrCode()));
        }

        if (response.isSuccess()) {
            // 业务成功处理
            return new ApiSdkRejectQrcodeResponse(true, response.getReturnMsg(), msgId, orderId, money);
        }
        return null;
    }


    /**
     * 执行开户短信验证码发送
     * @param msgId 消息号
     * @param orderId 本次操作的订单号
     * @param originalOrderId 首次操作的订单号
     * @return 结果集
     * @throws ApiSdkRuntimeException 运行时异常（当工行的通用异常抛出时抛出）
     */
    public static ApiSdkSmsSendResponse doSmsSend(String msgId, String orderId, String originalOrderId) throws ApiSdkRuntimeException {
        DefaultIcbcClient client = new DefaultIcbcClient(APP_ID, MY_PRIVATE_KEY, APIGW_PUBLIC_KEY);
        SettlementAccountSCodeSendRequestV1 request = new SettlementAccountSCodeSendRequestV1();
        SettlementAccountSCodeSendRequestV1.SettlementAccountSCodeRequestV1Biz bizContent = new SettlementAccountSCodeSendRequestV1.SettlementAccountSCodeRequestV1Biz();
        request.setServiceUrl(SANDBOX_HOST + "/settlement/account/scode/V1/send");

        bizContent.setCorpDate(UsualUtil.getCurrentDate());
        bizContent.setCorpNo("corpInst1234");
        bizContent.setCorpSerno(orderId);
        bizContent.setCorpSernoOriginal(originalOrderId);
        bizContent.setOutServiceCode("scode");

        // 时间和日期
        bizContent.setTrxAccDate(UsualUtil.getCurrentDate());
        bizContent.setTrxAccTime(UsualUtil.getCurrentTime());

        request.setBizContent(bizContent);
        SettlementAccountSCodeSendResponseV1 response;

        // 处理原始sdk异常
        try {
            response = client.execute(request, msgId);
        } catch (IcbcApiException e) {
            throw new ApiSdkRuntimeException(e.getMessage(), String.valueOf(e.getErrCode()));
        }

        if (response.isSuccess()) {
            return new ApiSdkSmsSendResponse(true, response.getReturnMsg(), msgId, orderId, response.getSmsSendNo());

        }

        return null;
    }

    /**
     * 验证码验证
     * @param msgId 消息号
     * @param orderId 订单号
     * @param originalOrderId 原始订单号
     * @param smsCode 待验证的短信验证码
     * @return 结果集
     * @throws ApiSdkRuntimeException 运行时异常（当工行的通用异常抛出时抛出）
     */
    public static ApiSdkSmsVerifyResponse doSmsVerify(String msgId, String orderId, String originalOrderId, String smsCode) throws ApiSdkRuntimeException {
        DefaultIcbcClient client = new DefaultIcbcClient(APP_ID, MY_PRIVATE_KEY, APIGW_PUBLIC_KEY);
        SettlementAccountSCodeVerifyRequestV1 request = new SettlementAccountSCodeVerifyRequestV1();
        SettlementAccountSCodeVerifyRequestV1.SettlementAccountSCodeVerifyRequestV1Biz bizContent = new SettlementAccountSCodeVerifyRequestV1.SettlementAccountSCodeVerifyRequestV1Biz();
        request.setServiceUrl(SANDBOX_HOST + "/settlement/account/scode/V1/verify");
        bizContent.setCorpDate(UsualUtil.getCurrentDate());
        bizContent.setCorpNo("corpInst1234");

        // 本次订单号
        bizContent.setCorpSerno(orderId);
        // 原始订单号
        bizContent.setCorpSernoOriginal(originalOrderId);

        bizContent.setOutServiceCode("smscodevertify");
        bizContent.setTrxAccDate(UsualUtil.getCurrentDate());
        bizContent.setTrxAccTime(UsualUtil.getCurrentTime());
        bizContent.setSmsSCode(smsCode);
        request.setBizContent(bizContent);
        SettlementAccountSCodeVerifyResponseV1  response;
        try {
            response = client.execute(request, msgId);
        } catch (IcbcApiException e) {
            throw new ApiSdkRuntimeException(e.getMessage(), String.valueOf(e.getErrCode()));
        }
        if (response.isSuccess() ) {
            return new ApiSdkSmsVerifyResponse(true, response.getReturnMsg(), msgId, orderId,true);
        }

        return null;
    }

}
