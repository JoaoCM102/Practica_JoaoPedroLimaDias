package com.example.practica2_joaopedrolimadias.Main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.practica2_joaopedrolimadias.Nav.GrafoNavegacion
import com.example.practica2_joaopedrolimadias.VentanaDos.MeterDatos
import com.example.practica2_joaopedrolimadias.R
import com.example.practica2_joaopedrolimadias.VentanaCinco.VentanaCinco
import com.example.practica2_joaopedrolimadias.VentanaDos.ContenidoVentanaDos
import com.example.practica2_joaopedrolimadias.VentanaTres.VentanaTres
import com.example.practica2_joaopedrolimadias.ui.theme.Practica2_JoaoPedroLimaDiasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica2_JoaoPedroLimaDiasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GrafoNavegacion(this)

                }
            }
        }
    }
}




@Preview
@Composable
fun componentePreview(){
   // GrafoNavegacion()
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practica2_JoaoPedroLimaDiasTheme {
        ContenidoVentanaDos().Componente()
    }
}
