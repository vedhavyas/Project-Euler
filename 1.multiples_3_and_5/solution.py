#!/bin/usr/python

import sys

number = sys.argv[1]
total = 0
for i in range (1, int(number)):
  
    if (i % 15 == 0):
       total += i
    elif(i % 3 == 0):
       total += i
    elif(i % 5 == 0):
       total += i 

print total 
