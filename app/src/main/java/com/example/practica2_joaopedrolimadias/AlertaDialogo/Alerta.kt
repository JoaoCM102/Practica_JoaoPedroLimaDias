package com.example.practica2_joaopedrolimadias.AlertaDialogo

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.practica2_joaopedrolimadias.R
import com.example.practica2_joaopedrolimadias.VentanaDos.MeterDatos

class Alerta {
    @SuppressLint("NotConstructor")
    @Composable
    fun Alerta(num : Int ,Atras : () -> Unit){
    var cambio by remember { mutableStateOf(0) }
        var texto by remember { mutableStateOf("") }
        var img by remember { mutableStateOf(R.drawable.flechaderecha) }
        println(num)
        println(MeterDatos().listaPregutas.size )
        if(num == MeterDatos().listaPregutas.size ){
            texto = "Increible, todo bien, seguro facturas millones"
            img = R.drawable.dinero
        }else if(num < MeterDatos().listaPregutas.size && num > ((MeterDatos().listaPregutas.size)/2)){
            texto = "Bueno, no esta mal no eres tan mileurista como pensaba"
            img = R.drawable.moneda
        }else{texto = "Eres un ######### mileurista, ponte a hacer burpees"
            img = R.drawable.pobre}
        Dialog(onDismissRequest = { Atras() }) {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
                shape = RoundedCornerShape(16.dp)
            ){
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(id = img)  , contentDescription = null, modifier = Modifier.fillMaxWidth())
                    Text(text = texto, textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth())
                    Button(onClick = { Atras() }) {
                        Text(text = "Atras")
                    }
            }
        }
        }
}}