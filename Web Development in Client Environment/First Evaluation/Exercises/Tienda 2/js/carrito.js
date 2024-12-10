import {articulos} from "../../class02-module-example/js/datos";

class Carrito{

	constructor(id){
		this.id = id;
		this.articulos = [];
	}
						
	anyadeArticulo(articulo){
		const articuloExiste = this.articulos.find(c => c.codigo == articulo.codigo);
		if (articuloExiste){
			const nuevoArticulo = {
				codigo: articulo.codigo,
				nombre: articulo.nombre,
				precio: articulo.precio,
				unidades: 1,
				total: articulo.total
			}
			this.articulos.push(nuevoArticulo);
		} else {
			articuloExiste.unidades++;
			articuloExiste.total = articuloExiste.precio * articuloExiste.unidades;
		}
	}
				
	borraArticulo(codigo){
		carrito.articulos.splice(carrito.articulos.findIndex(c => c.codigo == codigo.codigo), 1);
		if (carrito.articulos.length == 0){
			document.getElementById("miDialogo").close();
		}

	}
	
	modificaUnidades(codigo,n) {
		let pos = articulos.indexOf(codigo);
		if (articulos[pos]) {
			articulos[pos].unidades + n;
		}
		if (articulos[pos].unidades == 0){
			this.borraArticulo(codigo);
		}
		articulos[pos].total = articulos[pos].unidades * articulos[pos].precio;
	}
}
