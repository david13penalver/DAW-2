# Table of contents
- [Table of contents](#table-of-contents)
- [Web Server types](#web-server-types)
  - [Apache HTTP Server Project](#apache-http-server-project)
  - [Nginx](#nginx)
- [Integrated web servers](#integrated-web-servers)

# Web Server types
[Up](#table-of-contents)

## Apache HTTP Server Project
[Up](#table-of-contents)

It is a project of the Apache Software Foundation. The project is called Apache HTTP Server Project.

- Installation:To use the Apache server just download it and run the program “/bin/httpd.exe”.
- Deployment:To deploy web pages in Apache just copy them to the “htdocs” folder.
- Configuration/administration:To configure/administer the server you have to modify the files in the “conf” folder.

## Nginx
[Up](#table-of-contents)

- Installation:To use the nginx server just download it and run the program “nginx.exe”.
- Deployment:To deploy web pages in nginx you only have to copy them in the “html” folder.
- Configuration/administration:To configure/administer the server you have to modify the files in the “conf” folder.

# Integrated web servers
[Up](#table-of-contents)

NodeJS has an integrated web server that can be used to deploy web pages called Express.

Installing Express:
```bash
npm install express
```

Hello World example:
```bash
#!/usr/bin/env node
 
const express = require('express')
const app = express()
const port = 8080
 
app.get('/', (request, response) => {
  response.send('Hello from Express!')
})
 
 
app.listen(port, (err) => {
  console.log(`server is listening on ${port}`)
})
```

Executing the file:
```bash
node file.js
```

If we go to `localhost:8080` we will see the message “Hello from Express!”.
