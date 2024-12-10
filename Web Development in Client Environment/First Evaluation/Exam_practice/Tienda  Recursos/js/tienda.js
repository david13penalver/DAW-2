	criterios=["Sin ordenar","Ascendente por precio", "Descendente por precio"]

	const carrito = new Carrito(13);
	
	function creaListaCriterios(){
		
	}


	function pintaArticulos(orden){
		let contenedor = document.getElementById("contenedor");

		listaArticulos.forEach(a => {
				let card = `
					<div class="col">
						<div class="card">
							<img src="./assets/${a.codigo}.jpg" class="card-img-top">
						<div class="card-body">
							<h5 class="card-title">${a.nombre}</h5>
							<p class="card-text">${a.descripcion}</p>
							<b>
								<p class="card-text text-center">${a.precio}€</p>
							</b>
						</div>
						<button id="${a.codigo}" class="btn-success">Comprar</button>
					</div>
					`
				contenedor.innerHTML += card;
			}
		);

		document.querySelectorAll(".btn-success").forEach(button => {
			button.addEventListener("click", function() {
				ponArticuloEnCarrito(this.id);
			})
		})
	}
	
	
	function ponArticuloEnCarrito(codigo){
		const articulo = listaArticulos.find(a => a.codigo == codigo);
		if (articulo) {
			carrito.anyadeArticulo(articulo);
		}
	}


	function verCarro(){
		if (carrito.articulos.length == 0) {
			alert("No hay articulos en el carrito");
		} else {
			document.getElementById("miDialogo").showModal();

			let tabla = document.getElementById("dialogContent");
			let contenidoTabla = `
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Unidades</th>
					<th>Total</th>
					<th>Acciones</th>
			</tr>
			</thead>
		`;
			let total = 0;
			carrito.articulos.forEach(a => {
				contenidoTabla += `
			<tr>
				<td>${a.nombre}</td>
				<td>${a.precio}</td>
				<td>${a.unidades}</td>
				<td>${a.total}</td>
				<td><button class="btn btn-warning" onclick="modificaUnidades('${a.codigo}',-1)">-</button>
				<button class="btn btn-primary" onclick="modificaUnidades('${a.codigo}',1)">+</button>
				<button class="btn btn-danger" onclick="borraArticulo('${a.codigo}')">X</button></td>
			</tr>
			`;
				total += a.total;
			});

			contenidoTabla += `</tbody></table>`;

			tabla.innerHTML = contenidoTabla;

			document.getElementById("total").innerHTML = `Total: ${total}€`;

			window.addEventListener("click", function () {
				document.querySelectorAll(".btn-primary").forEach(button => {
					button.addEventListener("click", function() {
						let codigo = this.id.split("-")[1];
						carrito.modificaUnidades(codigo,1);
						verCarro();
					})
				})
				document.querySelectorAll(".btn-warning").forEach(button => {
					button.addEventListener("click", function() {
						let codigo = this.id.split("-")[1];
						carrito.modificaUnidades(codigo,-1);
						verCarro();
					})
				})
				document.querySelectorAll(".btn-danger").forEach(button => {
					button.addEventListener("click", function() {
						let codigo = this.id.split("-")[1];
						carrito.borraArticulo(codigo);
						verCarro();
					})
				})
			})
		}
	
	}

	function cerrarDialogo(){
		document.getElementById("miDialogo").close();
	}

	function efectuaPedido(){
		cerrarDialogo();
		console.log(carrito.articulos);
		carrito.articulos = [];
		carrito.id ++;
		document.getElementById("idPedido").innerHTML = `${carrito.id}`;
	
	}

	window.onload=()=>{
	// Opciones del SELECT
		let criteriosOrdenacion = document.getElementById("criteriosOrdenacion");
		const arrayArticulosDefecto = [...listaArticulos];

	// Imagen carrito
		let imgCarrito = document.getElementsByTagName("img")[0];
		imgCarrito.onclick = verCarro;
		pintaArticulos();

	//Modal
		document.getElementById("idPedido").innerHTML = `${carrito.id}`;

		const modal = document.getElementById("miDialogo");

		let cerrarModal = document.getElementById("btnCierraDialog");
		cerrarModal.onclick = cerrarDialogo;

		let efectuarPedido = document.getElementById("btnEfectuaPedido");
		efectuarPedido.onclick = efectuaPedido;

		console.log(listaArticulos);
		console.log("separacion");
		console.log(arrayArticulosDefecto);
	}

