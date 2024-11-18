
criterios=["Sin ordenar","Ascendente por precio", "Descendente por precio"];

const carrito = new Carrito(13);

function creaListaCriterios(){
		
}


function pintaArticulos(){
	let articulos = document.getElementById("contenedor");

	listaArticulos.forEach(a => {
		let card = `
			<div class="col">
			<div class="card">
				<img src="./assets/${a.codigo}.jpg" alt="${"a.nombre"}" class="card-img-top">
				<div class="card-body">
					<h5 class="card-titlle">${a.nombre}</h5>
					<p class="card-text">${a.descripcion}</p>
					<b>
						<p class ="card-text text-center">${a.precio}</p>
					</b>
				</div>
				<button id="${a.codigo}" class="btn-success">Comprar</button>
			</div>
			</div>
		`;

		articulos.innerHTML += card;
		});

		document.querySelectorAll("btn-success").forEach(b => {
			b.addEventListener("click",function() {ponArticuloEnCarrito(this.id)});
		});
}
	
	
function ponArticuloEnCarrito(codigo){
	const articulo = listaArticulos.find(c => c.codigo == codigo);
	if (articulo){
		carrito.anyadeArticulo(articulo);
	}
}


function verCarro(){

}

function cerrarDialogo() {
}

function efectuaPedido(){

}

window.onload=()=>{
	// crear las opciones del select

	let imagenCarrito = document.getElementsByTagName("img")[0];
	imagenCarrito.addEventListener("click",verCarro);
	pintaArticulos();
	document.getElementById("idPedido").innerHTML = `${carrito.id}`;
}
