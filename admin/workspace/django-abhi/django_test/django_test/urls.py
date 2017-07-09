"""django_test URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.11/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf.urls import  include, url
from django.contrib import admin
from article.views import *
from article.urls import *
from django.conf import settings
from django.conf.urls.static import static
admin.autodiscover()


urlpatterns = [
    url(r'^admin/', admin.site.urls),
    url(r'^hello/$', article),
    url(r'^articles/', include('article.urls')),
    url(r'^language/(?P<language>[a-z\-]+)/$', language),
    url(r'^login/', login),
    url(r'^success/', success),
    url(r'^search/', search),
    url(r'^add_volunteers/', add_volunteers),
    url(r'^scheduling/', scheduling),
    url(r'^submitted/', success),
    url(r'^searchbyname/', searchname),
    url(r'^searchbyskills/', searchskills),
    url(r'^searchbylocation/', searchlocation)
]
