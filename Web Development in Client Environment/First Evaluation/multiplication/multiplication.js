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


function date() {
    let date = new Date();
    let day = date.getDay();
    let dayNumber = date.getDate();
    let month = date.getMonth() + 1;
    let year = date.getFullYear();

    switch (day) {
        case 0:
            day = "Domingo";
            break;
        case 1:
            day = "Lunes";
            break;
        case 2:
            day = "Martes";
            break;
        case 3:
            day = "Miércoles";
            break;
        case 4:
            day = "Jueves";
            break;
        case 5:
            day = "Viernes";
            break;
        case 6:
            day = "Sábado";
            break;
        default:
            break;
    }

    switch (month) {
        case 1:
            month = "Enero";
            break;
        case 2:
            month = "Febrero";
            break;
        case 3:
            month = "Marzo";
            break;
        case 4:
            month = "Abril";
            break;
        case 5:
            month = "Mayo";
            break;
        case 6:
            month = "Junio";
            break;
        case 7:
            month = "Julio";
            break;
        case 8:
            month = "Agosto";
            break;
        case 9:
            month = "Septiembre";
            break;
        case 10:
            month = "Octubre";
            break;
        case 11:
            month = "Noviembre";
            break;
        case 12:
            month = "Diciembre";
            break;
        default:
            break;
    }

    document.getElementById("todayDate").innerHTML = `Hoy es ${day} ${dayNumber} de ${month} del ${year}`;
}

window.onload = date();

