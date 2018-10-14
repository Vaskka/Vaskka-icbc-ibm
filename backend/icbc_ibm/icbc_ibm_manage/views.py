from django.http import JsonResponse
from django.shortcuts import render

from icbc_ibm_manage.inner_tool import *


def try_to_register(request):
    """
    尝试注册 POST
    :param request:
    :return:
    """
    try:
        param = inner_goto_dict(request)

        name = param["name"]
        id_card = param["id_card"]
        tel = param["tel"]
        card_number = param["card_number"]

        # 验证身份信息唯一性
        res = User.objects.filter(name=name)
        if res.exists():
            return JsonResponse(inner_get_error_response(400, "身份信息有误 （身份证、姓名、电话、借记卡号重复或出错）"))
            pass

        res = User.objects.filter(id_card=id_card)
        if res.exists():
            return JsonResponse(inner_get_error_response(400, "身份信息有误 （身份证、姓名、电话、借记卡号重复或出错）"))
            pass

        res = User.objects.filter(tel=tel)
        if res.exists():
            return JsonResponse(inner_get_error_response(400, "身份信息有误 （身份证、姓名、电话、借记卡号重复或出错）"))
            pass

        res = User.objects.filter(card_number=card_number)
        if res.exists():
            return JsonResponse(inner_get_error_response(400, "身份信息有误 （身份证、姓名、电话、借记卡号重复或出错）"))
            pass

        # 插入数据库
        inner_try_register(param)

        # +待完善
        # 插入验证码表
        # -待完善
        return JsonResponse(inner_get_common_success_response({"user_id": User.objects.get(card_number=card_number).pk}))
    except Exception as e:
        return JsonResponse(inner_get_error_response(500, repr(e)))
    pass


def resend_confirm_code(request):
    """
    重新发送验证码 POST
    :param request:
    :return:
    """
    try:
        # +待完善
        # 用user_id处理新的order_id
        # -待完善
        return JsonResponse(inner_get_common_success_response(dict()))
    except Exception as e:
        return JsonResponse(inner_get_error_response(500, repr(e)))
    pass


def confirm_verify_code(request):
    """
    验证验证码 POST
    :param request:
    :return:
    """

    try:
        # +待完善

        # -待完善

        request_object = inner_goto_dict(request)
        if inner_full_register(request_object["user_id"]):
            return JsonResponse(inner_get_common_success_response(dict()))
        else:
            return JsonResponse(inner_get_error_response(500, "用户未注册"))
    except Exception as e:
        return JsonResponse(inner_get_error_response(500, repr(e)))
    pass


def log_in(request):
    """
    登陆 POST
    :param request:
    :return:
    """
    try:
        request_object = inner_goto_dict(request)
        if inner_check_already_log_in(inner_from_tel_get_user_id(request_object["tel"])):
            return JsonResponse(inner_get_error_response(400, "user already login"))

        if inner_verify_log_in(request_object):
            st = md5(get_current_time())
            user_id = inner_from_tel_get_user_id(request_object["tel"])
            inner_update_in_user_session(user_id=user_id, session_token=st)
            return JsonResponse(inner_get_common_success_response({"session_token": st, "user_id": user_id}))

        return JsonResponse(inner_get_error_response(403, "password or tel error"))
    except Exception as e:
        return JsonResponse(inner_get_error_response(500, repr(e)))
        pass

    pass


def log_out(request):
    """
    登出 POST
    :param request:
    :return:
    """

    try:
        request_object = inner_goto_dict(request)
        if inner_check_identity(request_object):
            inner_go_log_out(request_object)
            return JsonResponse(inner_get_common_success_response(dict()))
        else:
            return JsonResponse(inner_get_error_response(403, "identity verify error"))
    except Exception as e:
        return JsonResponse(inner_get_error_response(500, repr(e)))
        pass
    pass


def pay(request):
    """
    支付 POST
    :param request:
    :return:
    """
    try:
        request_object = inner_goto_dict(request)
        return JsonResponse(inner_get_common_success_response({"pay_url": "https://b2ciicamp.dccnet.com.cn/servlet/wcqr?f=ICBCqr&X=1&T=3&P=6&I=dda5a8c6c91e455b&N=6ffca517a6b68febc5cf2a7d95d8fdfb&L=4e77298cf75dea0b2a4e7d6f4865f05221f1a34ff15b0e06142b1f688705295ba3e561ac93160076"}))
        # if inner_check_identity(request_object):
        #     # +待完善
        #
        #     # -待完善
        #     return JsonResponse(inner_get_common_success_response({"pay_url": "url"}))
        # else:
        #     return JsonResponse(inner_get_error_response(403, "identity verify error"))
    except Exception as e:
        return JsonResponse(inner_get_error_response(500, repr(e)))
    pass


def reject_pay(request):
    """
    退款 POST
    :param request:
    :return:
    """
    try:
        request_object = inner_goto_dict(request)
        if inner_check_identity(request_object):
            # +待完善

            # -待完善
            return JsonResponse(inner_get_common_success_response(dict()))
        else:
            return JsonResponse(inner_get_error_response(403, "identity verify error"))
    except Exception as e:
        return JsonResponse(inner_get_error_response(500, repr(e)))
    pass


def recharge(request):
    """
    充值（返现） POST
    :param request:
    :return:
    """
    try:
        request_object = inner_goto_dict(request)
        if inner_check_identity(request_object):
            # +待完善

            # -待完善
            return JsonResponse(inner_get_common_success_response(dict()))
        else:
            return JsonResponse(inner_get_error_response(403, "identity verify error"))
    except Exception as e:
        return JsonResponse(inner_get_error_response(500, repr(e)))
    pass

    pass


def get_balance(request):
    """
    余额查询
    :param request:
    :return:
    """

    try:
        # 待完善 +
        # 待完善 -
        return JsonResponse(inner_get_common_success_response({"balance": "10000"}))
        pass
    except Exception as e:
        return JsonResponse(inner_get_error_response(500, repr(e)))
    pass
