package com.example.practica2_joaopedrolimadias.Rutas

sealed class Rutas(val ruta: String) {
    /* TODO
        Crear e identificar las rutas (diferentes pantallas) de nuestra app
     */
    object PantallaUno: Rutas("VentanaUno")
    object PantallaDos: Rutas("VentanaDos")
    object PantallaTres: Rutas("VentanaTres")
    object PantallaCuatro: Rutas("VentanaCuatro")
    object PantallaCinco: Rutas("VentanaCinco")
}
