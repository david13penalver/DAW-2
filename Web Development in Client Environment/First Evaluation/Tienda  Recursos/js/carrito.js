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
	}
	
	modificaUnidades(codigo,n){
	}
}
