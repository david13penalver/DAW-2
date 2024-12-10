/*----------------------- FETCH ---------------------*/


const url = "https://pokeapi.co/api/v2/pokemon/";
const pokemonName = prompt('Enter a Pokemon id: ');
const encounter = prompt('Enter "encounters"');

fetch(url)
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        return fetch(url + pokemonName)
             .then(response => {
                if (!response.ok) {
                    throw new Error("Network error with pokemon name");
                }
                return response.json();
            })
    })
    .then(data => {
        return fetch(url + pokemonName + "/" + encounter)
             .then(response => {
                if (!response.ok) {
                    throw new Error("Network error with encounters");
                }
                return response.json
    })
    .then(data => {
        console.log(data);
    })
    .catch(error => alert(error));
    });

const serverURL = "http://localhost:3000";
const serverURL_articulos = "/articulos";
const serverURL_proveedores = "/proveedores";

let idProveedor = prompt("ID proveedor: ");

fetch(serverURL + serverURL_proveedores + "/" + idProveedor)
    .then(response => {
        if (!response.ok) {
            throw new Error("Network error with proveedores");
        }
        return response.json()
    })
    .then(data => {
        let idArticulo = data.idArticulo;
        return fetch(serverURL + serverURL_articulos + "/" + idArticulo)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network error with articulos");
                }
                return response.json();
            })
    })
.then(data => {
    console.log(data);
})
.catch(error => alert(error));


// Listado de articulos

fetch(serverURL + serverURL_articulos)
    .then(response => {
        if (!response.ok) {
            throw new Error("Network error with articulos");
        }
        return response.json();
    })
    .then(data => {
        console.log("Listado de articulos");
        console.log(data)
    })
    .catch(error => alert(error));

// listado de articulos de cada proveedor

fetch(serverURL + serverURL_proveedores + "/" + idProveedor)
    .then(response => {
        if (!response.ok) {
            throw new Error("Network error with " + idProveedor);
        }
        return response.json();
    })
    .then(data => {
        let idArticulo = data.idArticulo;
        return fetch(serverURL + serverURL_articulos + "/" + idArticulo)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network error with " + idArticulo);
                }
                return response.json();
            })
    })
    .then(data => {
        console.log("Listado de articulos de un proveedor");
        console.log(data)
    })
    .catch(error => alert(error));

/*----------------------- ASYNC ---------------------*/

async function getArticulos() {
    try {
        const response = await fetch(serverURL + serverURL_articulos);
        if (!response.ok) {
            throw new Error("Network error with articulos");
        }
        const data = await response.json();
        console.log("Listado de articulos con async");
        console.log(data);
    } catch (error) {
        alert(error);
    }
}

async function getProveedores() {
    try {
        const response = await fetch(serverURL + serverURL_proveedores)
        if (!response.ok) {
            throw new Error("Network error with proveedores");
        }
        const data = await response.json();
        console.log("Listado de proveedores con async");
        console.log(data);
    }
    catch (error) {
        console.log(error);
    }
}

async function getArticulo(id) {
    try {
        const response = await fetch(serverURL + serverURL_articulos + "/" + id);
        if (!response.ok) {
            throw new Error("Network error with articulo " + id);
        }
        const data = await response.json();
        console.log("Articulo con async");
        console.log(data);
    } catch (error) {
        console.log(error);
    }
}

async function getProveedor(id) {
    try {
        const response = await fetch(serverURL + serverURL_proveedores + "/" + id);
        if (!response.ok) {
            throw new Error("Network error with proveedor " + id);
        }
        const data = await response.json();
        console.log("Proveedor con async");
        console.log(data);
    } catch (error) {
        console.log(error);
    }
}

async function getArticuloDeProveedor(idP) {
    try {
        const response = await fetch(serverURL + serverURL_proveedores + "/" + idP);
        if (!response.ok) {
            throw new Error("Network error with proveedor " + idP);
        }
        const proveedor = await response.json();
        const idArticulo = proveedor.idArticulo;

        const responseArticulo = await fetch(serverURL + serverURL_articulos + "/" + idArticulo)
        if (!response.ok) {
            throw new Error("Network error with articulo " + idArticulo);
        }
        const articulo = await responseArticulo.json();
        console.log("Articulo " + articulo.nombre + " del proveedor " + proveedor.nombre);
    } catch (error) {
        console.log(error);
    }
}

async function getArticuloDeProveedorFactorizado(idP) {
    try {
        const response = await getProveedorFactorizado(idP);
        const idArticulo = await response.idArticulo;
        console.log(idArticulo);
        const articulo = await getArticuloFactorizado(idArticulo);
        console.log("TOP:")
        console.log(articulo);
    } catch (error) {
        console.log(error);
    }
}

async function getProveedorFactorizado(id) {
    try {
        const response = await fetch(serverURL + serverURL_proveedores + "/" + id);
        if (!response.ok) {
            throw new Error("Network error with proveedor " + id);
        }
        const data = await response.json();
        return data;
    } catch (error) {
        console.log(error);
    }
}

async function getArticuloFactorizado(id) {
    try {
        const response = await fetch(serverURL + serverURL_articulos + "/" + id);
        if (!response.ok) {
            throw new Error("Network error with articulo " + id);
        }
        const data = await response.json();
        return data;
    } catch (error) {
        console.log(error);
    }
}

console.log(getArticulos());
console.log(getProveedores());
console.log(getArticulo(1));
console.log(getProveedor(1));
console.log(getArticuloDeProveedor(2));
console.log(getArticuloDeProveedorFactorizado(2));

