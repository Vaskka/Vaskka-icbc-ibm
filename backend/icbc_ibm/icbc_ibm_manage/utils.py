"""
实用工具

"""
import datetime
import hashlib


def get_current_time(format="%Y%m%d_%H%M%S"):
    """
    得到当前时间
    :return: str
    """
    return str(datetime.datetime.now().strftime(format))
    pass


def get_user_id():
    """
    生成唯一user_id
    :return: str
    """
    return "user" + get_current_time("%Y%m%d%H%M%S") + (str(hash(str(datetime.datetime.now())))[0:14])
    pass


def get_order_id():
    """
    生成唯一订单id
    :return: str
    """
    return "order" + get_current_time("%Y%m%d%H%M%S") + (str(hash(str(datetime.datetime.now())))[0:13])
    pass


def get_msg_id():
    """
    生成唯一信息号id
    :return: str
    """
    return "msg" + get_current_time("%Y%m%d%H%M%S") + (str(hash(str(datetime.datetime.now())))[0:15])
    pass


def md5(s):
    """
    md5
    :param s:
    :return:
    """
    hl = hashlib.md5()
    hl.update(s.encode(encoding='utf-8'))

    return hl.hexdigest()
