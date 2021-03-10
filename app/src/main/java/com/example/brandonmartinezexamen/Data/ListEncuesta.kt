package com.example.brandonmartinezexamen.Data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.brandonmartinezexamen.Entity.EntityEncuesta
import com.example.brandonmartinezexamen.Tools.Constants

class ListEncuesta {



    fun add(encuesta: EntityEncuesta):Int{
        var answer= -1

        if (!existNameFilter(encuesta.nombre)){
            listEncuesta.add(encuesta)
            answer = listEncuesta.size -1

        }
        return answer;
    }

    fun delete(nombre:String):Boolean{
        var answer:Boolean = false

        for ((index,item) in listEncuesta.withIndex()){

            if (item.nombre == nombre){
                listEncuesta.removeAt(index)
                answer=true;
                break;
            }
        }
        return answer;
    }


    fun edit(nombre:String, student: Unit):Boolean{

        var answer:Boolean = false

        for ((index,item) in listEncuesta.withIndex()){

            if (item.nombre == nombre){
                answerList.add("${item.nombre} ${item.deportistafa}${item.inspiracion} ${if(item.gender==1) "Masculino" else if(item.gender==2) "Femenino" else "Genero no seleccionado"} ${item.horario}")
            }
        }
        return answer;

    }

    fun showListEncuesta(){

        Log.d(Constants.LOG_TAG,"${listEncuesta.size}")

        for ((index,item) in listEncuesta.withIndex()){

            Log.d(Constants.LOG_TAG,"$index ${listEncuesta[index].nombre} ${listEncuesta[index].horario} ${listEncuesta[index].gender}")

        }
    }
/*
    fun existsName(name:String):Boolean {
        var answer: Boolean = false
        for (element in listStudents) {
            if (element.name == name) {
                answer = true;
                break;
            }
        }
        return answer;
    }
    */

    fun existNameFilter(nombre:String):Boolean{
        var answer: Boolean=false

        if ( listEncuesta.filter { e-> e.nombre==nombre }.count()==1){
            answer=true
        }

        return answer
    }
    val answerList= arrayListOf<String>()//va dentro del fun getstringarray
    fun getStringArray(name: String):Array<String>{



        for((index,item) in listEncuesta.withIndex()){

            answerList.add("${item.nombre} ${item.deportistafa} ${item.inspiracion} ${if(item.gender==1) "Masculino" else if(item.gender==2) "Femenino" else "Genero no seleccionado"} ${item.horario}" )
        }
        return answerList.toTypedArray()
    }

    fun getEntityEstudentArray():Array<EntityEncuesta>{

        return listEncuesta.toTypedArray()

    }

    fun getStudent(index:Int): EntityEncuesta {

        return listEncuesta[index]

    }

    companion object{
        private var listEncuesta = arrayListOf<EntityEncuesta>()
    }
}