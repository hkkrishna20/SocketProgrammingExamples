#!/usr/bin/python
# -*- coding: latin-1 -*-
import os, sys
from socket import *
serverHost = "localhost" # servername is localhost
serverPort = 2000 # use arbitrary port > 1024
s = socket(AF_INET, SOCK_STREAM) # create a TCP socket
s.connect((serverHost, serverPort)) # connect to server on the port
data="h"
while (data!="bye" or data!="bye"):
 data= input("Client::")
 s.send(data.encode())# send the data
 data = s.recv(1024) # receive up to 1K bytes
 print("SERVER::",data.decode())
 data=data.decode()