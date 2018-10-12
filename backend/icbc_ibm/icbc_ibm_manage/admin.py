
from django.contrib import admin
from .models import *
admin.site.register(User)
admin.site.register(UserSession)
admin.site.register(SmsSendOrder)
admin.site.register(PayOrder)

# Register your models here.
