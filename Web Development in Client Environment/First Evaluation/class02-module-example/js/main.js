import {articulos} from "./datos.js"
import {verMensaje} from "./utilidades.js"

window.onload=function(){
    verMensaje()
    alert("Total articulos: " + articulos.length)
}

document.getElementById('btn').addEventListener("click", verMensaje)
