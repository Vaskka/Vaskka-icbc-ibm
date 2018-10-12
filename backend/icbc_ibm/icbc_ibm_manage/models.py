from django.db import models
from django.db.models import CharField, IntegerField, ForeignKey, TextField, DateField, DateTimeField


class User(models.Model):
    """
    用户model
    """

    # 主键
    user_id = CharField(max_length=32, primary_key=True)

    # 昵称
    nick_name = CharField(max_length=50, default="nick_name")

    # 密码
    password = CharField(max_length=32, null=False, blank=False)

    # 真实姓名
    name = CharField(max_length=255, null=False, blank=False)

    # 身份证
    id_card = CharField(max_length=32, null=False, blank=False)

    # 电话
    tel = CharField(max_length=11, null=False, blank=False)

    # 借记卡号
    card_number = CharField(max_length=32, null=False, blank=False)

    # 验证状态 1-未验证 0-已验证
    status = IntegerField(default=1)

    def __str__(self):
        return self.user_id
    pass


class PayOrder(models.Model):
    """
    支付退款订单 model
    """

    # 主键
    order_id = CharField(max_length=32, primary_key=True)

    # 消息号
    msg_id = CharField(max_length=32, null=False, blank=False)

    # 金额
    money = IntegerField(null=False, blank=False)

    # 关联用户
    user = ForeignKey('User', to_field='user_id', null=True, on_delete=models.SET_NULL)

    # 支付关键url
    pay_url = TextField(default='none')

    # 订单类型 0-支付 1-退款
    pay_type = IntegerField(default=0, null=False, blank=False)

    # 发起时间
    create_time = DateTimeField(auto_now_add=True)

    def __str__(self):
        return self.order_id

    pass


class SmsSendOrder(models.Model):
    """
    短信验证码记录的订单 model
    """
    # 主键
    order_id = CharField(max_length=32, primary_key=True)

    # 初始order_id
    original_order_id = CharField(max_length=32, null=False, blank=False)

    # 最新order_id
    new_order_id = CharField(max_length=32, null=False, blank=False)

    # 关联用户
    user = ForeignKey('User', to_field='user_id', null=True, on_delete=models.SET_NULL)

    # 消息号
    msg_id = CharField(max_length=32, null=False, blank=False)

    # 短信发送编码
    sms_code_number = CharField(max_length=20, null=False, blank=False)

    # 发起时间
    create_time = DateTimeField(auto_now_add=True)

    def __str__(self):
        return self.order_id

    pass


class UserSession(models.Model):
    """
    用户session
    """

    # 关联用户
    user = ForeignKey('User', to_field='user_id', null=True, on_delete=models.SET_NULL)

    # session_token
    session_token = CharField(max_length=32, null=False, blank=False)

    def __str__(self):
        return str(self.user.nick_name)
    pass
