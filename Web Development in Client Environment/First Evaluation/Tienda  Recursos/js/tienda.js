
criterios=["Sin ordenar","Ascendente por precio", "Descendente por precio"];

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
		alert("El carrito esta vacio.");
	} else {
		document.getElementById("miDialogo").showModal();
	}

}

function cerrarDialogo() {
	document.getElementById("miDialogo").close();
}

function efectuaPedido(){
	console.log("Pedido efectuado");
	console.log(carrito);
}

window.onload=()=>{
	let imagenCarrito = document.getElementsByTagName("img")[0];
	if (imagenCarrito) imagenCarrito.onclick = verCarro;
	pintaArticulos();
	document.getElementById("idPedido").innerHTML = `${carrito.id}`;
	let cerrarModal = document.getElementById("btnCierraDialog");
	cerrarModal.onclick = cerrarDialogo;
	let efectuarPedido = document.getElementById("btnEfectuaPedido");
	efectuarPedido.onclick = efectuaPedido;
}
