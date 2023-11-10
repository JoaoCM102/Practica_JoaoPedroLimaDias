package com.example.practica2_joaopedrolimadias.VentanaDos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.practica2_joaopedrolimadias.Botones.Botones

class ContenidoVentanaDos {
    @Composable
    fun Componente(){
        var listaPregutas = MeterDatos().Datos()
        var cambio by remember { mutableStateOf(0) }
        var siONo by remember { mutableStateOf(true) }
        var textoo by remember { mutableStateOf("") }
        var colorF by remember { mutableStateOf(Color.Blue) }
        var colorV by remember { mutableStateOf(Color.Blue) }
        if(cambio == listaPregutas.size){cambio = 0}
        if(cambio < 0){cambio = listaPregutas.size -1 }
        Column(verticalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxSize()) {
            Text(text = stringResource(id = listaPregutas[cambio].texto), textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            Image(painterResource(id = listaPregutas[cambio].imagen ), contentDescription = null , modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
            Row() {
                if (!siONo){
                    Text(text = textoo , color = Color.Red ,textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth())
                }else{
                    Text(text = textoo, color = Color.Green ,textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth())
                }
            }
            Row( horizontalArrangement = Arrangement.SpaceEvenly,modifier = Modifier
                .weight(1f)
                .fillMaxWidth(), verticalAlignment = Alignment.Bottom ) {
                Button(onClick = {
                    if (!listaPregutas[cambio].verdaderoOFalso){
                        siONo = true
                        textoo = "Es como fuck, que buena respuesta"
                        colorF = Color.Green
                        colorV = Color.Red
                    }else{siONo = false
                        textoo = "Lo siento esta mal, otro dia sera"
                        colorV = Color.Red
                        colorV = Color.Green}
                }, colors = ButtonDefaults.buttonColors(containerColor = colorF)) {
                    Text(text = "Falso")
                }
                Button(onClick = { if (listaPregutas[cambio].verdaderoOFalso){
                    siONo = true
                    textoo = "Es como fuck, que buena respuesta"
                    colorV = Color.Green
                    colorF = Color.Red
                }else{siONo = false
                    textoo = "Lo siento esta mal, otro dia sera"
                    colorV = Color.Red
                    colorF = Color.Green}
                }, colors = ButtonDefaults.buttonColors(containerColor = colorV)) {
                    Text(text = "Verdadero")
                }
            }
            Row {
                Botones().Aleatorio(modifier = Modifier.weight(1f), onSiguiente = { nuevoValor -> cambio = nuevoValor
                    colorV = Color.Blue
                    colorF = Color.Blue
                    textoo="" } , bien = cambio, size = listaPregutas.size)}

            Row {
                Botones().Atras(modifier = Modifier.weight(1f), onSiguiente = { nuevoValor -> cambio = nuevoValor
                    colorV = Color.Blue
                    colorF = Color.Blue
                    textoo= ""} , bien = cambio)
                Botones().Siguiente(modifier = Modifier.weight(1f), onSiguiente = { nuevoValor -> cambio = nuevoValor
                    colorV = Color.Blue
                    colorF = Color.Blue
                    if (cambio == listaPregutas.size){cambio = 0}
                    textoo = ""} , bien = cambio)
            }
        }
        }
    }
