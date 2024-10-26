# Table of contents
- [Table of contents](#table-of-contents)
- [Characteristics](#characteristics)
- [Advantages](#advantages)
- [Format](#format)
- [HTTPS Headers](#https-headers)
  - [Petition](#petition)
  - [Answer](#answer)
- [HTTP States](#http-states)
- [Methods](#methods)
- [REST](#rest)
  - [Operators to use](#operators-to-use)
  - [URL Structure](#url-structure)
- [REST Server in NodeJS](#rest-server-in-nodejs)

# Characteristics
[Up](#table-of-contents)

- `Easy`: It is in text mode and is easy to use by a person.
- `Extensible`: You can send more metadata rather than just the default ones.
- `Without state`: Each petition is independent of the previous one.
  - That's a problem for sites like cart shops, where you need to keep the state of the user.

# Advantages
[Up](#table-of-contents)

-`Cache`: Improves speed by caching the data.
- `Authentication`: It allows authenticating the user.
- `Proxys`: It allows the use of proxies transparently.
- `Sessions`: It allows keeping the status between petitions.
- `Formats`: It allows indicating the format of what it is sent, of what it is demanded and of what it is returned.

# Format
[Up](#table-of-contents)

We are going to see the format through an example:

The petition is the next:

```http
GET /index.html HTTP/1.1
Host: www.fpmislata.com
Accept-Language: fr
```

The answer of the server is:

```http
HTTP/1.1 200 OK
Content-Length: 29769
Content-Type: text/html; charset=utf-8

<!DOCTYPE html... (los 29769 bytes de la página)
```

- `GET`: Method of the petition (GET, PUT, POST, DELETE).
- `/index.html`: Path of the document we are demanding on the server.
- `HTTP/1.1`: Version of the protocol. It is practically always 1.1.
- `Host: www.fpmislata.com`: Host of the server.
- `Accept-Language: fr`: Language that we want whe the data is returned.

# HTTPS Headers
[Up](#table-of-contents)

## Petition
[Up](#table-of-contents)

- `Accept`: 
  - The [MIME type](https://en.wikipedia.org/wiki/Media_type) format in which we want the data to be returned. 
  - In `text/html`, in `text/xml`, `application/json`, `application/pdf`, etc. 
  - Then the server will return them in the format it wants/can.
- `Accept-Language`: 
  - The language in which we want the data to be returned. 
  - Then the server will return them in the language it wants/can.
- `Host`: 
  - The domain to which the request is being sent. 
  - This header is very useful because it allows to have several domains hosted in the same server.
- `Content-Type`: 
  - The format of the data sent to the server. 
    - In `text/html`, in `text/xml`, `application/json`, `application/pdf`, etc. 
  - And how they are encoded. 
    - Normally the formats are `utf-8` or `ISO-8859-1`.

## Answer
[Up](#table-of-contents)

- `Content-Type`: 
  - The format of the data being returned.
  - In `text/html`, in `text/xml`, `application/json`, `application/pdf`, etc. 
  - And how they are encoded. 
    - Normally the formats are `utf-8` or `ISO-8859-1`. 
  - It does not have to match `Accept`.
- `Content-Language`: The language of the data being returned.
- `Content-Length`: Size in bytes of the data.
- `Cache-Control`: How long the data can be cached.


> **Note**: The `Content-Type` header is important for the programmer because the server may not know exactly the format of the data and it is necessary that we indicate it, sometimes there are also problems with the encoding if it is `utf-8` or `ISO-8859-1` so it must also be indicated.
On the other hand note that `Content-Type` can be used both in the request and in the response. It is used in the request if data is sent in the request.

# HTTP States
[Up](#table-of-contents)

Their main values are:
- 200-299: The request has been successful.
- 300-399: Data redirection.
- 400-499: The data sent by the client is not correct.
- 500-599: An error has occurred on the server.

Most common codes:
- 200: Everything went well.
- 201: The resource has been created (Usually it is an `INSERT`).
- 204: The request does not return data (Usually it is a `DELETE`).
- 400: The data sent by the client is not correct.
- 401: The user must be logged in.
- 403: The user is logged in but is not allowed to access the document.
- 404: Document not found.
- 500: Server error.

# Methods
[Up](#table-of-contents)

- `GET`: We want to obtain the data (most common when browsing).
- `POST`: We want to send data to the server (most common when sending forms).
- `PUT`: We want to update the data.
- `DELETE`: We want to delete the data.

If we send:

```http
GET /index.html HTTP/1.1
Host: www.fpmislata.com
Accept-Language: fr
```

We will obtain the file `index.html`.

If we send:

```http
DELETE /index.html HTTP/1.1
Host: www.fpmislata.com
Accept-Language: fr
```

The server will delete `index.html`.

# REST
[Up](#table-of-contents)

## Operators to use
[Up](#table-of-contents)

| HTTP Method | Description                                                    | CRUD Method | SQL Method |
|-------------|----------------------------------------------------------------|-------------|------------|
| GET         | Used to read data from the server                              | Read        | SELECT     |
| POST        | Used to add data to the server                                 | Create      | INSERT     |
| PUT         | Used to update data on the server                              | Update      | UPDATE     |
| DELETE      | Used to delete data from the server                            | Delete      | DELETE     |

## URL Structure
[Up](#table-of-contents)

| Description           | URL               | HTTP Method | JSON Sent        | JSON Returned       |
|-----------------------|-------------------|-------------|------------------|---------------------|
| Get a book            | /libro/{idLibro} | GET         | None             | Book read           |
| List of books         | /libro           | GET         | None             | Array of books      |
| Add a book            | /libro           | POST        | Book to insert   | Book inserted       |
| Update a book         | /libro/{idLibro} | PUT         | Book to update   | Book updated        |
| Delete a book         | /libro/{idLibro} | DELETE      | None             | None                |

# REST Server in NodeJS
[Up](#table-of-contents)

The next example can:
- Read headers.
- Accept different methods.
- Return different state codes.
- Return headers.

```javascript
const express = require('express')
const app = express()
const port = 80
  
app.get('/', (request, response) => {
  response.set('Content-Type', 'text/plain');
  response.status(200);
 
  if (request.header('Accept-Language').startsWith("ca-ES")) {
    response.send("Hola mon");
  } else if (request.header('Accept-Language').startsWith("en-EN")) {
    response.send("Hello World");
  } else  {
    response.send("Hola mundo");
  }
 
   
});
app.post('/', (request, response) => {
  response.status(200);
  response.send('Hello from post!');
});
app.delete('/', (request, response) => {
  response.status(200);
  response.send('Hello from delete!');
});
app.delete('/libro/38', (request, response) => {
  response.status(200);
  response.send('Borrado libro 38');
});
app.delete('/libro/39', (request, response) => {
  response.status(404);
  response.send('El libro 39 no existe');
});
  
app.listen(port, (err) => {
  console.log(`server is listening on ${port}`)
})
```
