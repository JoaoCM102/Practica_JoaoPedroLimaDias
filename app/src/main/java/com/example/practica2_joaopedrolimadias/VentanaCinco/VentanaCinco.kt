package com.example.practica2_joaopedrolimadias.VentanaCinco

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
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
import kotlinx.coroutines.selects.select
import java.io.BufferedReader
import java.io.FileReader

class VentanaCinco {
    @OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
    @SuppressLint("NotConstructor")
    @Composable
    fun VentanaCinco(context: Context) : String{

        var textFieldValue by remember { mutableStateOf("") }
        var resultText by remember { mutableStateOf("") }
        var keyboardController by remember { mutableStateOf<SoftwareKeyboardController?>(null) }
        var valor by remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxWidth()
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
            )

        }
        valor = textFieldValue
        return valor
    }

}
@Composable
fun RadioBoton() : String {
    var selectedValue by remember { mutableStateOf("True") }
    var valor by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            RadioButton(
                selected = selectedValue == "True",
                onClick = { selectedValue = "True" },
                modifier = Modifier
                    .selectable(
                        selected = selectedValue == "True",
                        onClick = { selectedValue = "True" }
                    )
            )
            Text("True")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            RadioButton(
                selected = selectedValue == "False",
                onClick = { selectedValue = "False" },
                modifier = Modifier
                    .selectable(
                        selected = selectedValue == "False",
                        onClick = { selectedValue = "False" }
                    )
            )
            Text("False")

        }
      //  Button(
       //     onClick = {
//                createFile(context,"Archivo", "$valor\n$selectedValue ")
//            },
       //     modifier = Modifier
      //          .fillMaxWidth()
       //         .height(50.dp)
      //  ) {
       //     Text("Poner")}
    }
    return selectedValue
}

fun createFile(context: Context, fileName: String, content: String) {
    try {
        val rutaFichero = context.filesDir
        val fichero = File(rutaFichero, fileName)

        if (fichero.exists()) {
            // Si el archivo ya existe, añadir el nuevo contenido al final
            val bw = BufferedWriter(FileWriter(fichero, true))
            bw.write(content)
            bw.newLine()
            bw.close()
        } else {
            // Si el archivo no existe, crearlo con el nuevo contenido
            val bw = BufferedWriter(FileWriter(fichero))
            bw.write(content)
            bw.close()
        }

        readAndProcessFile(context, fileName)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

private fun readAndProcessFile(context: Context, fileName: String) {
    try {
        val rutaFichero = context.filesDir
        val fichero = File(rutaFichero, fileName)
        var lineCount = 0

        BufferedReader(FileReader(fichero)).use { reader ->
            var line1: String? = reader.readLine()
            var line2: String?

            while (line1 != null) {
                line2 = reader.readLine()

                if (line2 != null) {
                    println("$line1")
                    println("$line2")
                } else {
                    // Si el número de líneas en el archivo es impar,
                    // puedes manejar la última línea de manera diferente
                    println("$line2")
                }

                line1 = reader.readLine()
                lineCount += 2
            }
        }

        println("Se procesaron $lineCount líneas.")
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
@Composable
fun Buton(context: Context){
    var Boton  = RadioBoton()
    var Num = VentanaCinco()
    Button(onClick =  { createFile(context, "Archivo", "e") }, Text( "vamos"))

}
