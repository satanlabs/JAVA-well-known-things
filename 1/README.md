## Introduction

- This folder will help you to connect to a remote DB-server via a remote-server (via SSH) 
- This case is usually helpful when using AWS-services( RDS , EC2 ).

## Pre-requisites
- maven
- Java IDE

## Requirements
- jsch ( com.jcraft ) - https://mvnrepository.com/artifact/com.jcraft/jsch 

- necessary credentials and .pem files ( of ssh server and DB server).

## Connection - Diagram
![N|Solid](https://raw.githubusercontent.com/clovity/JAVA-well-known-things/master/1/overall_connection_diagram.png)

## Notes
 Some mandatory / required data.
   
    #1 pem file location
    
	[String] PEM_FILE_LOCATION = "/home/test/example-ec2-dev-key.pem"
     
     
    #2 SSH loging username
    
    [String] SSH_USER = "ubuntu"
    
  
    #3 hostname or ip of SSH server
    
    [String] SSH_HOST = "93.184.216.34"
    
  
    #4 remote SSH host port number
   
	[Integer] SSH_PORT  = 22
    
  
    #5 SSH login password
    
  	[String] SSH_PASSWORD = "SomePassword"
  
  
    #6 hostname or ip of your database server
  
    [String] DB_HOST = "db-exmaple.d90dn789dn7z.eu-north-1.rds.amazonaws.com" 
    
	
    #7 database loging username
    
    [String] DB_USERNAME  = "exampleUser"
    
	
    #8 database login password
    
    [String] DB_PASSWORD = "SomePassword"
    
	  
    #9 default schema
    
    [String] DB_DEFAULT_SCHEMA = "student"
    
	
    #10 remote port number of your database
    
    [Integer] DB_PORT = 3306
    
    
	#11 local port number used to bind SSH tunnel
    
  	[Integer] LOCAL_PORT = 3366
