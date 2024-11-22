Table of contents
=================

- [Table of contents](#table-of-contents)
- [Introduction (Up)](#introduction-up)
  - [Introduction (Up)](#introduction-up-1)
  - [Static and Dynamic Web Pages (Up)](#static-and-dynamic-web-pages-up)
  - [Web Server Components (Up)](#web-server-components-up)
    - [HTTP Server (Up)](#http-server-up)
    - [Programming Languages (Up)](#programming-languages-up)
    - [DB Manager Systems (Up)](#db-manager-systems-up)
  - [Local Development Environment (Up)](#local-development-environment-up)
    - [Integrated Web Apps (Up)](#integrated-web-apps-up)
    - [Development Environments (Up)](#development-environments-up)
- [Web Java Ecosystem (Up)](#web-java-ecosystem-up)
- [Spring Boot (Up)](#spring-boot-up)
- [Layer Architecture (Up)](#layer-architecture-up)
- [API REST (Up)](#api-rest-up)
- [API REST - Response (Up)](#api-rest---response-up)
- [API REST - Data Manipulation (Up)](#api-rest---data-manipulation-up)
- [Transport Data Between Layers (Up)](#transport-data-between-layers-up)

# Introduction [(Up)](#table-of-contents)

## Introduction [(Up)](#table-of-contents)

The server is dedicated only to:
- Receive customer requests
- Access to the DB
- Return the data to the client
  - The client is responsible of mounting the data in the view

## Static and Dynamic Web Pages [(Up)](#table-of-contents)

- Statics: the content is always the same
- Dynamic: the content is generated in real time
  - Depending on the option
  - We need an interpreter of the language used to generate the content
  - We need a DBMS (DataBase Manager System)

## Web Server Components [(Up)](#table-of-contents)

### HTTP Server [(Up)](#table-of-contents)

TIC programm that processes clients requests. 

Most used HTTP servers:
- Apache
  - Open Source
  - Supervised by the Apache Software Foundation
  - Most used in the world
- Nginx
  - Web/proxy in reverse server
  - Proxy for IMAP/POP3 email protocols
  - Open Source
- IIS (Internet Information Services)
  - Web server and set of services for Microsoft Windows
  - Converts a PC into a server for internet or intranet
- Tomcat
  - Web container for Java Servlets and JSP
  - It can work as a web server by itself
  - Written in Java

### Programming Languages [(Up)](#table-of-contents)

Client: HTML, CSS, JavaScript

Server:
- PHP
  - Open Source
  - It can be embedded in HTML
  - Most used in the world, mainly because of Wordpress
- ASP.NET
  - By Microsoft
  - Successor of ASP
  - The language can be written in C#, Visual Basic, JScript, .NET and N#
- Java
  - Its syntax is similar to C++
  - It can be executed in any platform
- JSP (Java Server Pages)
  - A technology created for building dynamic web pages based on HTML and XML
  - Similar to PHP, but uses Java
  - Its main advantage is that Java can be used in other contexts apart of web development
- Python
  - Basic syntax
  - Easy to learn
- Node.js
  - Execution environment for JavaScript
  - Lightweight and efficient
- Go
  - Google
  - Open Source project
- Ruby
  - Open Source

### DB Manager Systems [(Up)](#table-of-contents)

*Notes here*

## Local Development Environment [(Up)](#table-of-contents)

### Integrated Web Apps [(Up)](#table-of-contents)

*Notes here*

### Development Environments [(Up)](#table-of-contents)

*Notes here*
