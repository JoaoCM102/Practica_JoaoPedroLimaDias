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
import com.example.practica2_joaopedrolimadias.ListadoOtroArray
import com.example.practica2_joaopedrolimadias.R
import kotlinx.coroutines.selects.select
import java.io.BufferedReader
import java.io.FileReader

class VentanaCinco {
    @OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
    @SuppressLint("NotConstructor")
    @Composable
    fun VentanaCinco(context: Context){

        var textFieldValue by remember { mutableStateOf("") }
        var resultText by remember { mutableStateOf("") }
        var valorDeTrueOrFalse by remember { mutableStateOf("") }

        var keyboardController by remember { mutableStateOf<SoftwareKeyboardController?>(null) }
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
            RadioBoton(valorDeTrueOrFalse) { newValue ->
                valorDeTrueOrFalse = newValue
            }
            Button(
                onClick = {
                    resultText = textFieldValue
                    createFile(context,"Archivo", "$resultText\n$valorDeTrueOrFalse ")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Poner")}

        }


    }

}
@Composable
fun RadioBoton(selectValue: String, Cambio : (String) -> Unit) {
    var selectedValue by remember { mutableStateOf("True") }
    Cambio("True")
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
                onClick = {
                    selectedValue="True"
                    Cambio("True")
                },
                modifier = Modifier
                    .selectable(
                        selected = selectedValue == "True",
                        onClick = {
                            selectedValue="True"
                            Cambio("True")
                        }
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
                onClick = {
                    selectedValue="False"
                    Cambio("False")
                },
                modifier = Modifier
                    .selectable(
                        selected = selectedValue == "False",
                        onClick = {
                            Cambio("False")
                            selectedValue="False"
                        }
                    )
            )
            Text("False")

        }
    }
}

fun createFile(context: Context, fileName: String, content: String) {
    try {
        val rutaFichero = context.filesDir
        val fichero = File(rutaFichero, fileName)

        if (fichero.exists()) {
            // Si el archivo ya existe, añadir el nuevo contenido al final
            val bw = BufferedWriter(FileWriter(fichero, true))
            bw.write(content+ "\n")
            bw.close()
        } else {
            // Si el archivo no existe, crearlo con el nuevo contenido
            val bw = BufferedWriter(FileWriter(fichero))
            bw.write(content + "\n")
            bw.close()
        }

        readAndProcessFile(context, fileName)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
    fun readAndProcessFile(context: Context, fileName: String) : ArrayList<ListadoOtroArray>{
    var BienMal = true
    var Texto = ""
    var listadoOtroArray = ArrayList<ListadoOtroArray>()
    try {
        val rutaFichero = context.filesDir
        val fichero = File(rutaFichero, fileName)
        var lineCount = 0

        BufferedReader(FileReader(fichero)).use { reader ->
            var line: String?

            var texto = ""
            var trueOrFalse = true
            while (reader.readLine().also { line = it } != null) {
                lineCount++

                if (lineCount % 2 == 1) {

                    println("Primer valor = $line")
                    texto = "$line"
                } else {
                    // Línea par, considerar como "Primer valor booleano"

                    println("Primer valor booleano = $line")
                    if ("$line".equals("True")){
                        trueOrFalse = true
                    }else{ trueOrFalse = false}

                }
                var meter = ListadoOtroArray(texto, R.drawable.quiz,trueOrFalse)
                listadoOtroArray.add(meter)
            }
        }
        println("Se procesaron $lineCount líneas.")
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return listadoOtroArray
}
