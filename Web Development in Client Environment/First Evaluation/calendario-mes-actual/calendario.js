let todayDate = new Date();
let currentYear = todayDate.getFullYear();
let currentMonth = todayDate.getMonth();
let currentDay = todayDate.getDate();
let currentDayOfWeek = todayDate.getDay();

let monthNames = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
    "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    ];

let daysOfWeek = ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];

document.getElementById("title").innerHTML = `${monthNames[currentMonth]} de ${currentYear}`;

document.getElementById("table-head").innerHTML += `
    <tr>
        <td>${daysOfWeek[1]}</td>
        <td>${daysOfWeek[2]}</td>
        <td>${daysOfWeek[3]}</td>
        <td>${daysOfWeek[4]}</td>
        <td>${daysOfWeek[5]}</td>
        <td>${daysOfWeek[6]}</td>
        <td>${daysOfWeek[0]}</td>
    </tr>`

let firstDayOfMonthOnWeek = new Date(currentYear, currentMonth, 1);
let firstDayOfMonthOnWeekArrayed = daysOfWeek[firstDayOfMonthOnWeek.getDay()];

alert(firstDayOfMonthOnWeekArrayed);

if (firstDayOfMonthOnWeek.getDay == 0) {
    firstDayOfMonthOnWeek = 7;
}

alert(firstDayOfMonthOnWeek)

for (let i = 0; i == firstDayOfMonthOnWeek; i++) {
    <td>document.getElementById("table-body").innerHTML += `0`</td>
}