package com.example.practica2_joaopedrolimadias.VentanaCuatro

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.practica2_joaopedrolimadias.R

class VentanaCuatro {
    @SuppressLint("NotConstructor")
    @Composable
    fun VentanaCuatro(){
        var aciertos by remember { mutableStateOf("") }
        var fallos by remember { mutableStateOf(0) }
        var total by remember { mutableStateOf(0) }
        var sharedPref = LocalContext.current.getSharedPreferences(
            stringResource(id = R.string.preference_file_key),Context.MODE_PRIVATE
        )
        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "Aciertos:  $aciertos")
            Text(text = "Fallos : $fallos")
            Text(text = "Total : $total")
        }
    }
}