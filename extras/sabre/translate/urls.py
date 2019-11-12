from django.urls import path
from django.conf.urls import url

from . import views


urlpatterns = [
    url(r'^translate/(?P<text>.)+/(?P<src>[\w\-]+)/$', views.index, name="index")
]
