package com.example.practica2_joaopedrolimadias.Nav

import android.content.Context
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practica2_joaopedrolimadias.Rutas.Rutas
import com.example.practica2_joaopedrolimadias.VentanaCinco.VentanaCinco
import com.example.practica2_joaopedrolimadias.VentanaCuatro.VentanaCuatro
import com.example.practica2_joaopedrolimadias.VentanaDos.ContenidoVentanaDos
import com.example.practica2_joaopedrolimadias.VentanaTres.VentanaTres
import com.example.practica2_joaopedrolimadias.VentanaUno.Ventanauno

@Composable
fun GrafoNavegacion(context: Context){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.PantallaUno.ruta) {

        // "URL" -> Composable
        composable(Rutas.PantallaUno.ruta){
             Ventanauno().Uno(navController = navController)
        }

        composable(Rutas.PantallaDos.ruta){
            ContenidoVentanaDos().Componente(context)
        }

        composable(Rutas.PantallaTres.ruta){
            VentanaTres().Tres(navController = navController,context)
        }

        composable(Rutas.PantallaCuatro.ruta){
            VentanaCuatro().VentanaCuatro()
        }
        composable(Rutas.PantallaCinco.ruta){
            VentanaCinco().VentanaCinco(context)
        }
    }
}


