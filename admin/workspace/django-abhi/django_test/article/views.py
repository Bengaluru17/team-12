# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.http import HttpResponse
from django.shortcuts import render
from django.shortcuts import render_to_response
from article.models import Article
from firebase import firebase
firebase=firebase.FirebaseApplication('https://kshamata-1c47d.firebaseio.com/',None)

# Create your views here.
def hello(request):
    name = "Abhi"
    html = "<html><body>Hi %s,this seems to have worked!</body></html>" % name
    return HttpResponse(html)


def articles(request):
    language='en-gb'
    session_language='eg-gb'
    if 'lang' in request.COOKIES:
        language=request.COOKIES['lang']
        return render_to_response('articles.html',
                                  {'articles': Article.objects.all(),'language':language})


def article(request, article_id):
    return render_to_response('article.html',
                              {'article': Article.objects.get(id=article_id)})

def language(request,language='en-gb'):
    response=HttpResponse("Setting Language to %s", language)
    response.set_cookie('lang',language)
    return response

def login(request):
    result = firebase.post('/', {'userx': 'x'})
    print result
    return render_to_response('index.html')

def success(request):
    return render_to_response('dashboard.html')

def search(request):
    return render_to_response('search.html')
def add_volunteers(request):
    return render_to_response('add_volunteers.html')
def scheduling(request):
    return  render_to_response('scheduling.html')