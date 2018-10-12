"""icbc_ibm URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path

from icbc_ibm_manage.views import *

urlpatterns = [
    path('admin/', admin.site.urls),
    path('api/register/try/', try_to_register),
    path('api/register/confirm/', confirm_verify_code),
    path('api/register/resend/', resend_confirm_code),
    path('api/login/', log_in),
    path('api/logout/', log_out),
    path('api/pay/payment/', pay),
    path('api/pay/reject/', reject_pay),
    path('api/pay/recharge/', recharge),

]
