

const arrayExample = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

// Ejercicio 1. Escribe una función que tome un array de números y devuelva un nuevo array solo con los números pares.

const arrayPares = arrayExample.filter(
    e => e % 2 == 0
    )

console.log("Ejercicio 1: ", arrayPares);

// Ejercicio 2. Escribe una función que tome un array de números y devuelva la suma de sus cuadrados.
let total = 0;
const sumaCuadrados = [...arrayExample];
sumaCuadrados.forEach(e => {
    total += e * e;
});

console.log("Ejercicio 2: ", total);

// Ejercicio 3. Escribe una función que tome un array de objetos con nombres y apellidos y devuelva un array de strings en formato "Nombre Apellido".

const arrayNombres = [{nombre: "David", apellido: "Peñalver"}, {nombre: "Juan", apellido: "García"}, {nombre: "María", apellido: "López"}];

const arrayNombreYApellidos = [];
arrayNombres.forEach(e => {
    arrayNombreYApellidos.push(e.nombre + " " + e.apellido);
});

console.log("Ejercicio 3: ", arrayNombreYApellidos);

// Ejercicio 4. Escribe una función que tome un array de palabras y devuelva solo aquellas que tengan más de 5 caracteres.

const arrayPalabras = ["hola", "adiós", "casa", "coche", "ordenador", "mesa", "silla", "ventana"];

function palabrasLargas(array) {
    let palabrasLargas = [];
    palabrasLargas = array.filter(p => p.length > 5);
    return palabrasLargas;
};

console.log("Ejercicio 4: ", palabrasLargas(arrayPalabras));

// Ejercicio 5. Escribe una función que tome un array de letras y devuelva un objeto con la cuenta de cada letra.

const arrayLetras = ["a", "b", "c", "a", "e", "b", "a", "c", "d", "e", "a", "b", "c", "d", "e", "a", "b", "c", "d", "e"];

function contarLetras(array) {
    let objetoLetras = {};
    array.forEach(l => {
        if (!objetoLetras[l]) {
            objetoLetras[l] = 1
        } else {
            objetoLetras[l]++;
        }
    });
    return objetoLetras;
}

console.log("Ejercicio 5: ", contarLetras(arrayLetras));

// Ejercicio 6. Escribe una función que tome un array de objetos que representan estudiantes y los ordene por su puntuación de mayor a menor.

const arrayEstudiantes = [{nombre: "David", puntuacion: 10}, {nombre: "Juan", puntuacion: 5}, {nombre: "María", puntuacion: 7}, {nombre: "Pedro", puntuacion: 9}];

arrayEstudiantes.sort((a, b) => b.puntuacion - a.puntuacion);

console.log("Ejercicio 6: ", arrayEstudiantes);

// Ejercicio 7. Escribe una función que tome un array de números y devuelva su promedio.

let media = 0;
const promedio = [...arrayExample];
promedio.forEach(e => {
    media += e;
})
media /= promedio.length;
console.log("Ejercicio 7: ", media);

// Ejercicio 8. Escribe una función que tome un array de números y devuelva un nuevo array sin duplicados.

const arrayDuplicados = [1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9];

const arraySinDuplicados = [];

arrayDuplicados.forEach(e => {
    if (!arraySinDuplicados.includes(e)) {
        arraySinDuplicados.push(e);
    }
})

console.log("Ejercicio 8: ", arraySinDuplicados);

// Ejercicio 9. Escribe una función que tome dos arrays, uno con nombres y otro con edades, y devuelva un array de objetos combinando ambos.

const arrayNombres2 = ["David", "Juan", "María", "Pedro"];
const arrayEdades = [25, 30, 20, 35];

const arrayCombinado = [];

function combinarArrays(array1, array2) {
    for (let i = 0; i < array1.length; i++) {
        arrayCombinado.push({nombre: array1[i], edad: array2[i]});
    }
    return arrayCombinado;
}

console.log("Ejercicio 9: ", combinarArrays(arrayNombres2, arrayEdades));

// Ejercicio 10. Escribe una función que tome un array de palabras y devuelva un objeto con la cantidad de palabras según su longitud.

const arrayPalabras2 = ["hola", "adiós", "casa", "coche", "ordenador", "mesa", "silla", "ventana"];

function contarLetrasPorPalabra(array) {
    let arrayContador = [];
    array.forEach(p => {
        arrayContador.push(p.length);
    })
    return arrayContador
}

console.log("Ejercicio 10: ", contarLetrasPorPalabra(arrayPalabras2));

// Ejercicio 11. Escribe una función que tome un array de objetos con una categoría y un valor, y agrupe los objetos por su categoría.


const arrayCategorias = [{categoria: "frutas", valor: "manzana"}, {categoria: "frutas", valor: "pera"}, {categoria: "verduras", valor: "lechuga"}, {categoria: "verduras", valor: "tomate"}];


function agruparPorCategoria(array) {
    const resultado = {};
    array.forEach(obj => {
        if (!resultado[obj.categoria]) {
            resultado[obj.categoria] = [];
        }
        resultado[obj.categoria].push(obj.valor);
    });
    return resultado;
}

const resultado = agruparPorCategoria(arrayCategorias);
console.log("Ejercicio 11: ", resultado);

// Ejercicio 12. Escribe una función que tome un array de objetos y devuelva un nuevo array con objetos únicos basados en una propiedad.

const arrayObjetos = [{id: 1, nombre: "David"}, {id: 2, nombre: "Juan"}, {id: 3, nombre: "María"}, {id: 4, nombre: "Pedro"}, {id: 1, nombre: "David"}];

function objetosUnicos(array) {
    const resultado = [];
    const ids = [];
    array.forEach(e => {
        if (!ids.includes(e.id)) {
            ids.push(e.id);
            resultado.push(e.nombre);
        }
    })
    return resultado;
}

console.log("Ejercicio 12: ", objetosUnicos(arrayObjetos));