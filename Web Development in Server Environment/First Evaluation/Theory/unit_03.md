UNIT 03 - API REST

# Table of Contents

- [Table of Contents](#table-of-contents)
- [REST Services](#rest-services)
- [JSON](#json)
- [Status Codes](#status-codes)
- [Endpoints](#endpoints)

# REST Services
[Up](#table-of-contents)

REST (REpresentational State Transfer) is an architectural style for designing networked applications. 

REST services are stateless, meaning that each request from a client to a server must contain all the information necessary to understand the request, and cannot take advantage of any stored context on the server. 

REST services are built on top of the HTTP protocol, and use standard HTTP methods to perform operations on resources:
- GET: retrieve a resource
- POST: create a new resource
- PUT: update an existing resource
- DELETE: remove a resource

# JSON
[Up](#table-of-contents)

JSON (JavaScript Object Notation) is a lightweight data-interchange format that is easy for humans to read and write, and easy for machines to parse and generate.

JavaScript object:
```javascript
let persona = {
    nombre: "Nacho",
    edad: 39
}
```

JSON object:
```json
{
    "nombre": "Nacho",
    "edad": 39
}
```

Javascript colection of objects:
```javascript
let personas = [
    { 
        nombre: "Nacho", 
        edad: 39
    },
    {
        nombre: "Mario", 
        edad: 4
    },
    { 
        nombre: "Laura", 
        edad: 2
    },
    { 
        nombre: "Nora", 
        edad: 10
    }
];
```

JSON colection of objects:
```json
[
    {
        "nombre": "Nacho",
        "edad": 39
    },
    {
        "nombre": "Mario",
        "edad": 4
    },
    {
        "nombre": "Laura",
        "edad": 2
    },
    {
        "nombre": "Nora",
        "edad": 10
    }
]
```

# Status Codes
[Up](#table-of-contents)

- Codes 1XX: Information about a petition normally incomplete. They are not habitually used.
- Codes 2XX: Success. The request was received, understood and accepted.
  - 200: OK. The request was successful.
  - 201: Created. The request was successful and a new resource was created.
  - 204: No Content. The request was successful but there is no content to return.
- 3XX: Redirection. The request has been received, but the client must take additional action to complete the request.
  - 301: Moved Permanently. The requested resource has been moved permanently to a new location.
  - 304: Not Modified. The requested resource has not been modified since the last request.
- 4XX: Client Error. The request contains bad syntax or cannot be fulfilled.
  - 400: Bad Request. The request could not be understood by the server due to incorrect syntax. For example, the form field is not filled correctly.
  - 401: Unauthorized. The request requires user authentication.
  - 403: Forbidden. The server understood the request, but refuses to authorize it.
  - 404: Not Found. The server has not found anything matching the request.
- 5XX: Server Error. The server failed to fulfill a valid request.
  - 500: Internal Server Error. The server encountered an unexpected condition that prevented it from fulfilling the request.
  - 504: Gateway Timeout. The server was acting as a gateway or proxy and did not receive a timely response from the upstream server.

# Endpoints
[Up](#table-of-contents)

An endpoint is a URL pattern used to interact with a RESTful service. An endpoint is composed of the base URL, followed by the resource path, and optionally a query string.

Good practices for designing endpoints:
- Always use nouns to name resources.
- The resource name should be in plural.
- To relate resources, use sub-resources.
- Use hyphens to separate words in the URL.
- Use query strings to filter, sort, or paginate resources.
  - Example: `GET /users?page=3`.