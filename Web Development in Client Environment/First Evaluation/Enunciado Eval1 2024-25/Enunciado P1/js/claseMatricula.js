// Definicion clase Matricula		
class Matricula {
	dni;
	nombre;
	modulos = {};

	constructor(dni, nombre, modulos) {
		this.dni = dni;
		this.nombre = nombre;
		this.modulos = modulos;
	}

	anyadeModulo(codigo) {
		let modulo = modulos.find(modulo => modulo.codigo == codigo);
		console.log(modulo)

		if (modulo.codigo == this.modulos.codigo) {
			alert("El modulo ya esta seleccionado")
		} else {
			this.modulos = modulo;
			console.log(this.modulos)
			this.verMatricula();
		}
	}

	borraModulo(codigo) {
		let modulo = modulos.find(modulo => modulo.codigo == codigo);
		if (modulo.id in this.modulos) {
			delete this.modulos[modulo.id];
		} else {
			alert("El modulo no existe")
		}
		this.verMatricula();
	}

	realizarMatricula() {
		if (modulos.length == 0) {
			alert("No hay modulos seleccionados")
		} else {
			alert("Matricula realizada")
			this.modulos = {};
			this.verMatricula();
		}
	}

	verMatricula() {
		let capa = document.getElementById("capaMatricula");

		let tabla = document.createElement("table");
		tabla.setAttribute("class", "table");

		tabla.innerHTML += `
		<table class="table">
			<thead>
				<tr>
					<td>Asignatura</td>
					<td>Creditos</td>
					<td>Accion</td>	
				</tr>
			</thead>
			<tbody>
		`;

		Array.from(this.modulos).forEach(modulo => {
			tabla.innerHTML += `
			<tr>
				<td>${modulo.nombre}</td>
				<td>${modulo.creditos}</td>
				<td><button class="btn btn-danger">Borrar</button></td>
			</tr>
			`;
			let botonBorrar = document.getElementById(modulo.codigo);
			botonBorrar.addEventListener("click", () => {
				this.borraModulo(modulo.codigo)
			})
		}
		)
		tabla.innerHTML += "</tbody></table>";

		capa.appendChild(tabla);

		if (modulos.length != 0) {
			let botonRealizarMatricula = document.createElement("button")
			botonRealizarMatricula.setAttribute("class", "btn btn-primary")
			botonRealizarMatricula.textContent = "Realizar Matricula"
			botonRealizarMatricula.onclick = this.realizarMatricula

			capa.appendChild(botonRealizarMatricula);
		}
	}
}