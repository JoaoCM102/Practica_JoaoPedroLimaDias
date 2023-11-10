package com.example.practica2_joaopedrolimadias.VentanaCinco

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class VentanaCinco {
    @OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
    @SuppressLint("NotConstructor")
    @Composable
    fun VentanaCinco(context: Context){

        var textFieldValue by remember { mutableStateOf("") }
        var resultText by remember { mutableStateOf("") }

        var keyboardController by remember { mutableStateOf<SoftwareKeyboardController?>(null) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TextField(
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                label = { Text("Ingrese el texto") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                    }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Button(
                onClick = {
                    resultText = textFieldValue
                    createFile(context,"Num",textFieldValue)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text("Obtener texto")
            }
            Text("Texto obtenido: $resultText", color = Color.Gray)
        }
    }
        fun createFile(context: Context, fileName: String, content: String) {
            try {
                val rutaFichero = context.filesDir
                val ficheroNuevo = File(rutaFichero, fileName)
                val bw = BufferedWriter(FileWriter(ficheroNuevo))
                bw.write(content)
                bw.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
}
