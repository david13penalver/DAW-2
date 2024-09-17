/*
let number = prompt("Escoge un número que multiplicar:");
let n = prompt("¿Hasta qué número quieres multiplicar?");

document.getElementById("multiplication").innerHTML = "Tabla de multiplicar del " + number;

for (let i = 1; i <= n; i++) {
    document.getElementById("row1").innerHTML += 
    `<tr>
        <td>${number} x ${i}</td>
        <td>${number * i}</td>
    </tr>`;
}
*/

let total = prompt("¿Cuántas tablas de multiplicar quieres ver?");
let multiplicador = prompt("¿Hasta qué número quieres multiplicar?");

for (let i = 1; i <= total; i++) {
    let number = prompt("Escoge un número que multiplicar:");

    for (let i = 1; i <= multiplicador; i++) {
    document.getElementById("row1").innerHTML += 
    `<tr>
        <td>${number} x ${i}</td>
        <td>${number * i}</td>
    </tr>`;
}
}