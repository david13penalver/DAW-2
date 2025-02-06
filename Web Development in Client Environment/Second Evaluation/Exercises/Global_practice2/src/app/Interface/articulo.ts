export interface Articulo {
  id: number;
  nombre: string;
  descripcion: string;
  precio: number;
}

export const articulos: Articulo[] = [
  { id: 1, nombre: 'Articulo 01', descripcion: "Descripción 1", precio: 10 },
  { id: 2, nombre: 'Articulo 02', descripcion: "Descripción 2", precio: 5 },
  { id: 3, nombre: 'Articulo 03', descripcion: "Descripción 3", precio: 20 }
];
