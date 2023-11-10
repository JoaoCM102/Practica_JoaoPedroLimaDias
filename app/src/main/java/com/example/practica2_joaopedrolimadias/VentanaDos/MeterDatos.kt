package com.example.practica2_joaopedrolimadias.VentanaDos

import com.example.practica2_joaopedrolimadias.Pregunta
import com.example.practica2_joaopedrolimadias.R

class MeterDatos(){
    var listaPregutas = Datos()
    fun Datos(): ArrayList<Pregunta> {
        var listaPregutas = ArrayList<Pregunta>()
        var a = Pregunta(R.string.llados, R.drawable.llados, true)
        var b = Pregunta(R.string.Pregunta1, R.drawable.pregunta1, false)
        var d = Pregunta(R.string.Pregunta2, R.drawable.pregunta2, false)
        var e = Pregunta(R.string.Pregunta3, R.drawable.pregunta3, false)
        var f = Pregunta(R.string.Pregunta4, R.drawable.pregunta4, false)
        var g = Pregunta(R.string.Pregunta5, R.drawable.pregunta5, false)
        var h = Pregunta(R.string.Pregunta6, R.drawable.pregunta6, false)
        var i = Pregunta(R.string.Pregunta7, R.drawable.pregunta7, false)
        var j = Pregunta(R.string.Pregunta8, R.drawable.pregunta8, false)
        var k = Pregunta(R.string.Pregunta9, R.drawable.pregunta9, false)
        var l = Pregunta(R.string.Pregunta10, R.drawable.pregunta10, false)
        listaPregutas.add(a)
        listaPregutas.add(b)
        listaPregutas.add(d)
        listaPregutas.add(e)
        listaPregutas.add(f)
        listaPregutas.add(g)
        listaPregutas.add(h)
        listaPregutas.add(i)
        listaPregutas.add(j)
        listaPregutas.add(k)
        listaPregutas.add(l)
        return listaPregutas
    }

}