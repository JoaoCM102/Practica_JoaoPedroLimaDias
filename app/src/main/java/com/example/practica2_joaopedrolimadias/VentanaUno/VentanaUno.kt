package com.example.practica2_joaopedrolimadias.VentanaUno

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.practica2_joaopedrolimadias.Botones.Botones
import com.example.practica2_joaopedrolimadias.R
import com.example.practica2_joaopedrolimadias.Rutas.Rutas
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class Ventanauno {

    @Composable
    fun Uno(navController: NavHostController?) {
        var abre by remember { mutableStateOf(false) }
        var cambio : @Composable () -> Unit ={
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()) {
                Column(modifier = Modifier
                    .fillMaxSize()) {

                    Button(onClick = { navController?.navigate(Rutas.PantallaDos.ruta) },
                        modifier = Modifier
                            .fillMaxWidth()) {
                        Text(text = "Modo Practica")
                    }
                    Button(onClick = { navController?.navigate(Rutas.PantallaTres.ruta) },
                        modifier = Modifier
                            .fillMaxWidth()) {
                        Text(text = "Modo examen")
                    }
                    Button(onClick = { navController?.navigate(Rutas.PantallaCuatro.ruta) },
                        modifier = Modifier
                            .fillMaxWidth()) {
                        Text(text = "Estadisticas")
                    }
                    Button(onClick = { navController?.navigate(Rutas.PantallaCinco.ruta) },
                        modifier = Modifier
                            .fillMaxWidth()) {
                        Text(text = "Añadir pregunta")
                    }
                    Button(onClick = { abre = false },modifier = Modifier
                        .fillMaxWidth()
                        ) {
                        Text(text = "Atras")
                    }
                }
            }
        }
        Column(modifier = Modifier
            .fillMaxSize()) {
            if (abre){cambio()}

            IconButton(onClick = { abre = true}, modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()) {
                Image(painterResource(id = R.drawable.quiz), contentDescription = null)
            }



        }
    }
}
