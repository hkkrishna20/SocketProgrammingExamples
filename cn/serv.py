#!/usr/bin/python
# -*- coding: latin-1 -*-
import os, sys
from socket import *
s = socket(AF_INET, SOCK_STREAM) # create a TCP socket
s.bind(("127.0.0.1",2000)) # bind it to the server 
s.listen(1) # allow 5 simultaneous
# pending connections
# wait for next client to connect
(connection, address) = s.accept() # connection is a new while 1:
data="h"
while (data!="bye" or data!="bye"):
 data = connection.recv(1024) # receive up to 1K bytes
 print("CLIENT::",data.decode())
 data= input("Server::")
 connection.send(data.encode())
 
connection.close()