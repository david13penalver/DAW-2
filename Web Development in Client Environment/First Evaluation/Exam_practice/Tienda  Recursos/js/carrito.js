class Carrito{
	constructor(id){
		this.id = id;
		this.articulos = [];
	}
						
	anyadeArticulo(articulo){
		const articuloExiste = this.articulos.find(a => a.codigo == articulo.codigo);
		if (!articuloExiste){
			const nuevoArticulo = {
				codigo: articulo.codigo,
				nombre: articulo.nombre,
				precio: articulo.precio,
				unidades: 1,
				total: articulo.precio
			}
			this.articulos.push(nuevoArticulo);
		} else {
			articuloExiste.unidades++;
			articuloExiste.total = articuloExiste.precio * articuloExiste.unidades;
		}
	}
				
	borraArticulo(codigo){
		carrito.articulos.splice(carrito.articulos.findIndex(a => a.codigo == codigo), 1);
		if (carrito.articulos.length == 0) {
			document.getElementById("miDialogo").close();
		}
	}
	
	modificaUnidades(codigo,n){
		let item = this.articulos.find(a => a.codigo == codigo);
		console.log(item);
		if (item)
			item.unidades += n;
		if (item.unidades === 0) {
			this.borraArticulo(codigo);
		}
		item.total = item.precio * item.unidades;
	}	
			
	verCarrito(){
	}			
}
