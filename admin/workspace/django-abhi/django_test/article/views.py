# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.http import HttpResponse
from django.shortcuts import render
from django.shortcuts import render_to_response
from article.models import Article
from firebase import firebase
import json
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
    username = 'not username'
    username=request.GET.get('username', None)
    print username
    password=request.GET.get('password', None)
    print password

    #if username == "admin" and password == "pass":
    return render_to_response('dashboard.html')

def search(request):
    return render_to_response('search.html')
def add_volunteers(request):
    name=request.GET.get('name', None)
    id = request.GET.get('id', None)
    address = request.GET.get('address', None)
    contact = request.GET.get('contact', None)
    email = request.GET.get('email', None)
    dob = request.GET.get('dob', None)
    male = request.GET.get('male', None)
    female = request.GET.get('female', None)
    if name != None:
        '''data = {'name': name, 'id': id, 'address': address, 'contact': contact,
            'email': email, 'dob': dob, 'male': male, 'female': female}'''
        for i in range(10):
            '''json_data = json.dumps('id':id)
            json_data.dumps('address':address)
            json_data.dumps('contact':contact)
            json_data.dumps('email':email)
            json_data.dumps('dob':dob)
            json_data.dumps('male':male) = json.dumps('female':female)
            json_data = json.dumps('name':name)'''
            result=firebase.post('/volunteers',json_data)
    return render_to_response('add_volunteers.html')
def scheduling(request):
    return  render_to_response('scheduling.html')