package com.example.brandonmartinezexamen.Entity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

data class EntityEncuesta(
    var nombre:String,
    var deportistafa:String,
    var inspiracion:String,
    var gender:Int,
    var horario:String,
    var futbol:Boolean,
    var basquet:Boolean,
    var tenis:Boolean,
    var salud:Boolean){
    constructor():this("","","",0,"",false,false,false,false)
}