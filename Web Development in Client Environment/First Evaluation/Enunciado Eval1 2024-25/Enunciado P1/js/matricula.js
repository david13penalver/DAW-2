let matricula;

window.onload = function () {
    // Constructor
    matricula = new Matricula(
        "",
        "",
        {}
    );


    // Mostrar modulos con botones
    let contenedor = document.getElementById("contenedor");

    const modulosClase = ["cliente", "servidor", "interfaces", "despliegue", "empresa", "ingles"];
    let codigoModulo = 1;

    modulosClase.forEach(modulo => {
        let div = document.createElement("div");
        div.setAttribute("class", "card")

        let imagen = document.createElement("img");
        imagen.setAttribute("src", "./assets/" + modulo + ".png");
        div.appendChild(imagen);

        let boton = document.createElement("button");
        boton.setAttribute("id", codigoModulo);
        codigoModulo++;
        boton.setAttribute("class", "boton btn-primary");
        boton.textContent = modulo;
        div.appendChild(boton);
        contenedor.appendChild(div);
    })

    let botonesModulos = document.getElementsByClassName("boton");
    Array.from(botonesModulos).forEach(boton => {
        boton.addEventListener("click", () => {
            matricula.anyadeModulo(boton.id);
        });
    });

    // Mostrar datos personales del alumno
    const dialog = document.getElementById("dialogDatos");
    const datosPersonales = document.getElementById("btnAbreDatosPersonales")

    datosPersonales.onclick = function () {
        dialog.showModal();
    }

    // Datos dialog
    let dni = document.getElementById("dni");
    let nombre = document.getElementById("nombre");

    // Cerrar dialog
    const cerrarDialog = document.getElementById("btnCierraDatosPersonales").onclick = () => {
        let dni = document.getElementById("dni");
        let nombre = document.getElementById("nombre");
        if (dni.value == "" || nombre.value == "") {
            alert("Introduce un DNI y un nombre")
        } else {
            matricula.dni = dni.value;
            matricula.nombre = nombre.value;
            dialog.close();
        }
    };
}

