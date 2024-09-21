let monthNames = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
    "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    ];
let daysMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

let todayDate = new Date();
let currentYear = todayDate.getFullYear();
let currentMonth = todayDate.getMonth();
let daysCurrentMonth = daysMonth[currentMonth];
let currentDay = todayDate.getDate();
currentDay = (currentDay == 0) ? 7 : currentDay;

document.getElementById("title").innerHTML = `${monthNames[currentMonth]} de ${currentYear}`;

document.getElementById("table-head").innerHTML += `
    <tr>
        <td>Lunes</td>
        <td>Martes</td>
        <td>Miércoles</td>
        <td>Jueves</td>
        <td>Viernes</td>
        <td>Sábado</td>
        <td>Domingo</td>
    </tr>`;

let inicio = 1 - (currentDay - 1)

let cal = `<table border=1>`;
n = 0
    for (i = inicio; i <= daysCurrentMonth; i++) {
        if (n % 7 == 0) cal += "<tr>"
        let texto = (i <= 0) ? " " : i
        cal += "<td>" + texto
        n++
    }

cal += "</table>"

document.getElementById("table-head").innerHTML += cal;