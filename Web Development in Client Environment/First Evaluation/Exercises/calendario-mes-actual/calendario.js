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

let calendar = `<table border=1>`;
let nextWeek = 0
    for (i = inicio; i <= daysCurrentMonth; i++) {
        if (nextWeek % 7 == 0) calendar += "<tr>"
        let day = (i <= 0) ? " " : i
        calendar += "<td>" + day
        nextWeek++
    }

calendar += "</table>"

document.getElementById("table-head").innerHTML += calendar;