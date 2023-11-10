package com.example.practica2_joaopedrolimadias.Botones

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.practica2_joaopedrolimadias.R
import com.example.practica2_joaopedrolimadias.Rutas.Rutas

class Botones {

    @Composable
    fun Aleatorio(modifier: Modifier, onSiguiente: (Int) -> Unit, bien : Int, size : Int){

        Button(onClick = { val bien = (0..size-1).random();onSiguiente(bien) }
            , colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            , modifier = modifier,
        ) {
            Icon(painterResource(id = R.drawable.ic_action_dice5)  , contentDescription = null)
            Text(text = "Random")
        }
    }
    @Composable
    fun Siguiente(modifier: Modifier, onSiguiente: (Int) -> Unit, bien : Int){

        Button(onClick = { onSiguiente(bien + 1) },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            , modifier = modifier) {
            Text(text = "Siguiente   ")
            Icon(painterResource(id = R.drawable.flechaderecha)  , contentDescription = null)
        }
    }
    @Composable
    fun Atras(modifier: Modifier, onSiguiente: (Int) -> Unit, bien : Int){
        Button(onClick = { onSiguiente(bien - 1) },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            , modifier = modifier) {
            Icon(painterResource(id = R.drawable.izquierda)  , contentDescription = null)
            Text(text = "   Atras")
        }
    }
    @Composable
    fun Practica(modifier: Modifier, onSiguiente: () -> Unit ,){
        Button(onClick = { onSiguiente() }) {
            Text(text = "Modo Practica")
        }
    }
    @Composable
    fun Examen(modifier: Modifier,onSiguiente: () -> Unit){
        Button(onClick = { onSiguiente() }) {
            Text(text = "Modo Examen")

        }
    }
}