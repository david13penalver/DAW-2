
	
	criterios=["Sin ordenar","Ascendente por precio", "Descendente por precio"]

	const carrito = new Carrito(13);
	
	function creaListaCriterios(){
		
	}


function pintaArticulos(){
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
								<p class="card-text text-center">${a.precio}</p>
							</b>
						</div>
						<button id="${a.codigo}" class="btn-success">Comprar</button>
					</div>
					`
			contenedor.innerHTML += card;		
		}
	);
			
	}
	
	
	function ponArticuloEnCarrito(){
		
	}


	function verCarro(){
		document.getElementById("miDialogo").showModal();
		//miDialogo.showModa();
		// cerrar: miDialogo.close();
	}

	function cerrarDialogo() {
		document.getElementById("miDialogo").close();
	}

	function efectuaPedido(){
	
	}

	window.onload=()=>{
		const carrito = new Carrito(13);
		let imagenCarrito = document.getElementsByTagName("img")[0];
		if (imagenCarrito) imagenCarrito.onclick = verCarro;
		pintaArticulos();
		console.log(pintaArticulos);
		document.getElementById("idPedido").innerHTML = `${carrito.id}`;
		let cerrarModal = document.getElementById("btnCierraDialog");
		cerrarModal.onclick = cerrarDialogo;
	}

