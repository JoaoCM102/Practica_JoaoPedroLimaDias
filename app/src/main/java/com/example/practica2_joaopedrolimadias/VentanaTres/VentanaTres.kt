package com.example.practica2_joaopedrolimadias.VentanaTres

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
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
import androidx.navigation.NavHostController
import com.example.practica2_joaopedrolimadias.AlertaDialogo.Alerta
import com.example.practica2_joaopedrolimadias.Botones.Botones
import com.example.practica2_joaopedrolimadias.ListadoOtroArray
import com.example.practica2_joaopedrolimadias.Rutas.Rutas
import com.example.practica2_joaopedrolimadias.VentanaCinco.VentanaCinco
import com.example.practica2_joaopedrolimadias.VentanaCinco.readAndProcessFile
import com.example.practica2_joaopedrolimadias.VentanaCuatro.VentanaCuatro
import com.example.practica2_joaopedrolimadias.VentanaDos.MeterDatos

class VentanaTres {
    @Composable
    fun Tres(navController: NavHostController?,context: Context){
        var listaPregutas = MeterDatos().Datos()
        var listaPreguntasArray = ArrayList<ListadoOtroArray>()
        listaPreguntasArray = readAndProcessFile(context,"Archivo")
        var cambio by remember { mutableStateOf(0) }
        var cambioNuevo by remember { mutableStateOf(0) }
        var siONo by remember { mutableStateOf(true) }
        var textoo by remember { mutableStateOf("") }
        var colorF by remember { mutableStateOf(Color.Blue) }
        var colorV by remember { mutableStateOf(Color.Blue) }
        var Num by remember { mutableStateOf(0) }

        Column(verticalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxSize()) {
            if (cambio < listaPregutas.size){
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
                            Num++
                        }else{siONo = false
                        }
                        cambio++
                    }, colors = ButtonDefaults.buttonColors(containerColor = colorF)) {
                        Text(text = "Falso")
                    }
                    Button(onClick = { if (listaPregutas[cambio].verdaderoOFalso){
                        siONo = true
                        Num++
                    }else{siONo = false
                    }
                        cambio++
                    }, colors = ButtonDefaults.buttonColors(containerColor = colorV)) {
                        Text(text = "Verdadero")
                    }
                }
                println(Num)
            }else if (cambioNuevo < listaPreguntasArray.size){
                Column(verticalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxSize()) {
                    Text(text = listaPreguntasArray[cambioNuevo].texto, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                    Image(painterResource(id = listaPreguntasArray[cambioNuevo].imagen ), contentDescription = null , modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
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
                            if (!listaPreguntasArray[cambioNuevo].verdaderoOFalso){
                                siONo = true
                                Num++
                            }else{siONo = false
                            }
                            cambioNuevo++
                        }, colors = ButtonDefaults.buttonColors(containerColor = colorF)) {
                            Text(text = "Falso")
                        }
                        Button(onClick = { if (listaPreguntasArray[cambioNuevo].verdaderoOFalso){
                            siONo = true
                            Num++
                        }else{siONo = false
                        }
                            cambioNuevo++
                        }, colors = ButtonDefaults.buttonColors(containerColor = colorV)) {
                            Text(text = "Verdadero")
                        }
                    }
                }
            }else {
                Alerta().Alerta(
                    num = Num,
                    { navController?.navigate(Rutas.PantallaUno.ruta) },
                    listaPreguntasArray.size)
            }
        }
    }
}
