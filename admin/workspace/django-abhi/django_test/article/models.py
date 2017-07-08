# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models

# Create your models here.
class Article(models.Model):
	title = models.CharField(max_length=200)
	body = models.TextField()
	pub_date = models.DateTimeField('date published')
	likes = models.IntegerField()
	
	def __unicode__(self):
		return self.title

class Login(models.Model):
	username=models.CharField(max_length=50)
	password=models.CharField(max_length=50)

	def __unicode__(self):
		return self.username