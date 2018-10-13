"""
工具方法
"""
import json

from icbc_ibm_manage.utils import *
from icbc_ibm_manage.models import User, UserSession


def inner_goto_dict(request):
    """
    转换HttpRequest到dict +
    :param request:
    :return: dict
    """
    s = request.body.decode("utf-8")
    return json.loads(s)
    pass


# def inner_check_if_exist_in_user(field_name, info):
#     """
#     检查是否出现在User
#     :param field_name: 字段名
#     :param info: 要检查的信息
#     :return: boolean
#     """
#
#     result = User.objects.all()
#     for item in result:
#         if item.g
#         pass
#     pass


def inner_get_error_response(code, msg):
    """
    构造出错返回集 +
    :param code: 错误码
    :param msg: 信息
    :return: dict
    """
    return {"code": code, "msg": msg}
    pass


def inner_get_common_success_response(info_dict):
    """
    构造通用返回集 +
    :return: dict
    """
    result = {"code": 0, "msg": "success"}

    for k, v in info_dict.items():
        result[k] = v

    return result


def inner_check_identity(param):
    """
    身份验证 +
    :param param
    :return: boolean
    """
    if UserSession.objects.filter(user_id=param["user_id"], session_token=param["session_token"]).exists():
        return True
    return False


def inner_try_register(param):
    """
    尝试注册 +
    :return:
    """
    User.objects.create(user_id=get_user_id(),
                        nick_name=param["nick_name"],
                        password=param["password"],
                        name=param["name"],
                        id_card=param["id_card"],
                        tel=param["tel"],
                        card_number=param["card_number"])
    pass


def inner_full_register(user_id):
    """
    确认注册 +
    :return:
    """
    try:
        User.objects.filter(user_id=user_id).update(status=0)
        return True
    except Exception:
        return False
        pass
    pass


def inner_verify_log_in(param):
    """
    验证登陆 +
    :param param:
    :return: boolean
    """

    if User.objects.filter(tel=param["tel"], password=param["password"]).exists():
        return True

    return False


def inner_check_already_log_in(user_id):
    """
    检查是否已经登陆 +
    :param param:
    :return:
    """

    if UserSession.objects.filter(user_id=user_id).exists():
        return True
    return False


def inner_update_in_user_session(user_id, session_token):
    """
    插入UserSession +
    :param param:
    :return:
    """
    UserSession.objects.create(user_id=user_id, session_token=session_token)
    pass


def inner_from_tel_get_user_id(tel):
    """
    从tel得到user_id +
    :param tel:
    :return:
    """
    try:
        return User.objects.get(tel=tel).pk
    except Exception:
        return None


def inner_go_log_out(param):
    """
    登出
    :param param:
    :return:
    """
    UserSession.objects.filter(user_id=param["user_id"]).delete()
