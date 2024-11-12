# Table of Contents

- [Table of Contents](#table-of-contents)
- [Asynchronous Communication in JavaScript](#asynchronous-communication-in-javascript)
- [AJAX](#ajax)
  - [XMLHttpRequest Object](#xmlhttprequest-object)
  - [GET Petition](#get-petition)
  - [DELETE Petition](#delete-petition)
  - [Sending Data to the Server (POST, PUT and PATCH)](#sending-data-to-the-server-post-put-and-patch)
- [Promises](#promises)
  - [Then](#then)
  - [Catch](#catch)
  - [Fetch](#fetch)
    - [GET Petition](#get-petition-1)
    - [DELETE Petition](#delete-petition-1)
    - [Sending Data to the Server (POST, PUT and PATCH)](#sending-data-to-the-server-post-put-and-patch-1)
  - [Promises Enchainment](#promises-enchainment)
  - [Refactoring](#refactoring)
- [Async / Await](#async--await)

# Asynchronous Communication in JavaScript
[Up](#table-of-contents)

Asynchronous communication has become a key feature in modern web development. 

It allows the program to continue executing code while waiting for a response from the server. This is important because it allows the user to continue interacting with the application while the server is processing the request.

It means that the different tasks are not executed one after the another, but they are executed at the same time or in parallel.

This is thanks to JavaScript, taht allows the browser executes code in a non-blocking way.

Advantages:
- Improves user experience: the interface does not freeze while waiting for a response from the server.
- Increases scalability: the server can handle more requests at the same time.
- Simplifies the code: the code is easier to read and maintain.

Problems:
- Managing multiple asynchronous requests can be complex, because each petition will finish in an undetermined time and, almost sure, they will finish in a different order than they were sent.
- We can have asynchronous petitions that depend on the result of another petition.
- Maybe we want to execute a code after all the petitions have finished.

Use cases:
- Loading data: when we need to load data, it can be loaded asynchronously to avoid blocking the interface.
- API REST petitions: when we need to send or receive data from a server.
- Real time chat.
- Online games.

Mechanisms:
- Callbacks.
- Promises.
- Async / Await.

Indepently, behind all of them is AJAX.

# AJAX
[Up](#table-of-contents)

AJAX (Asynchronous JavaScript and XML) is a technique that allows the browser to communicate with the server without having to reload the page.

This includes HTML, CSS, JavaScript, DOM, XML, XSLT and, most importantly, the XMLHttpRequest object.

When these technologies are combined in the AJAX model, web applications can update the content of a page without reloading the page.

Comparison os the classic model and the AJAX model:
![Comparison of the classic model and the AJAX model](./Assets/07_AJAX_vs_Traditional.png)

## XMLHttpRequest Object
[Up](#table-of-contents)

The fundamental object in AJAX is the `XMLHttpRequest` object.

The basic functionality is the next:
1. Create an instance of the `XMLHttpRequest` object.
```javascript
let xhr = new XMLHttpRequest();
```
2. Initialize the object.
```javascript
xhr.open(method, URL, [async, user, password]);
```
- `method`: the HTTP method to use.
- `URL`: the URL to send the request.
- `async`: a boolean value that indicates if the request should be asynchronous or not. By default, it is `true`.
  - `true`: the request is asynchronous.
  - `false`: the request is synchronous.
- `user` and `password`: the username and password to use for authentication.
- `open` does not send the request. It only initializes the request.
3. Send the petition to the server.
```javascript
xhr.send([body]);
```
- This method sends the request to the server.
- `body`: the body of the request.
  - It is optional.
  - `GET`and `DELETE` petitions do not have a body.
  - `POST`, `PUT` and `PATCH` petitions have a body to send data to the server.
4. Wait for the response.
- Most used events:
  - `load`: the request has finished successfully.
    - Even if the status code is not 200, the request has finished successfully.
    - The response is downloaded completely.
```javascript
xhr.onload = function() {
  alert(`Loaded: ${xhr.status} ${xhr.statusText}`);
}
```
  - `error`: the request has failed.
    - Inaccessible server.
    - Network error.
    - Invalid URL.
```javascript
xhr.onerror = function() {
  alert(`Error: ${xhr.status} ${xhr.statusText}`);
}
```
  - `progress`: the request is in progress.
5. Process the response.
- Once the server has responded, we can receive the result in the next properties:
  - `status`: the status code of the response (200, 201, 404...).
  - `statusText`: the status text of the response (OK for 200, Not Found for 404...).
  - `response`: the response of the server.
    - We can use `responseText` to get the response in different formats:
      - "" (default): the response is a string.
      - "text": the response is a string.
      - "json": the response is a JSON object.
      - "blob": the response is a Blob object.
      - "document": the response is a XML Document object (it can use XPath and other XML methods).
      - "arraybuffer": the response is an ArrayBuffer object.
```javascript
xhr.responseType = "json";
```

Complete petition:
```javascript
lñet xhr = new XMLHttpRequest();
xhr.open(method, URL, [async, user, password]);
xhr.responseType = "json";
xhr.send([body]);

xhr.onload = function() {
  alert(`Loaded: ${xhr.status} ${xhr.statusText}`);
  }

// Error in the petition
xhr.onerror = function() {
  alert(`Error: ${xhr.status} ${xhr.statusText}`);
}
```

## GET Petition
[Up](#table-of-contents)

We are going to do a GET petition with the Rick and Morty API.

We want to get all the characters, so the endpoint is `https://rickandmortyapi.com/api/character`.

```javascript
let xhr = new XMLHttpRequest();
xhr.open("GET", "https://rickandmortyapi.com/api/character", true);
xhr.responseType = "json";
xhr.send();

xhr.onload = function() {
  if (xhr.status == 200) {
    console.log(xhr.response);
  } else {
    console.error("Error in the petition");
  }
}

xhr.onerror = function() {
  console.error("Error in the petition");
}
```


## DELETE Petition
[Up](#table-of-contents)

We want to delete the character with the ID of a prompt, so the endpoint is `https://localhost:3000/articulos/?`, where ? is the number of the prompt.

```javascript
const url = "https://localhost:3000/articulos";

function deleteCharacter() {
  let id = prompt("Enter the ID of the character to delete");
  let xhr = new XMLHttpRequest();
  
  xhr.open("DELETE", `${url}/${id}`, true);
  xhr.responseType = "json";
  xhr.send();

  xhr.onload = function() {
    if (xhr.status == 200) {
      console.log(xhr.response);
    } else {
      console.error("Error in the petition. The article has not been deleted.");
    }
  }

  xhr.onerror = function() {
    console.error("Error in the petition");
  }
}
```

## Sending Data to the Server (POST, PUT and PATCH) 
[Up](#table-of-contents)

*Text here*

# Promises
[Up](#table-of-contents)

*Text here*

## Then
[Up](#table-of-contents)

*Text here*

## Catch
[Up](#table-of-contents)

*Text here*

## Fetch
[Up](#table-of-contents)

*Text here*

### GET Petition
[Up](#table-of-contents)

*Text here*

### DELETE Petition
[Up](#table-of-contents)

*Text here*

### Sending Data to the Server (POST, PUT and PATCH) 
[Up](#table-of-contents)

*Text here*

## Promises Enchainment
[Up](#table-of-contents)

*Text here*

## Refactoring
[Up](#table-of-contents)

*Text here*

# Async / Await
[Up](#table-of-contents)

*Text here*
