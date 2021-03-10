package com.example.brandonmartinezexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.Toast
import com.example.brandonmartinezexamen.Data.ListEncuesta
import com.example.brandonmartinezexamen.Entity.EntityEncuesta
import com.example.brandonmartinezexamen.Tools.Constants
import com.example.brandonmartinezexamen.databinding.ActivityDetailBinding



class DetailActivity : AppCompatActivity() {
    private val listEncuesta=ListEncuesta()

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle(R.string.text_detalles)

        val id:Int = intent.getIntExtra(Constants.ID,-1)

        if(id!=-1){
            val encuest=listEncuesta.getStudent(id)

            binding.txvNombre.text="${encuest.nombre} ${encuest.deportistafa}"
            binding.txvGender.text="${if(encuest.gender==1) "Masculino" else if(encuest.gender==2) "Femenino" else "Genero no seleccionado"}"
            binding.txvHorario.text="${encuest.horario}"
            binding.txvDeportes.text="Deportes que practica: ${if(encuest.futbol) "Futbol" else ""} ${if(encuest.basquet) "Basquet" else ""} ${if(encuest.tenis) "Tenis" else ""}"
            binding.txvMedicina.text="${if(encuest.salud)"puedes hacer deporte" else "no puedes hacer deporte"}"


            binding.btnEliminar.setOnClickListener{

                if( listEncuesta.delete(encuest.nombre))
                {
                    Toast.makeText(this@DetailActivity, "Elemento eliminado", Toast.LENGTH_SHORT).show()
                    //finish()
                    super.onBackPressed()
                }
                else
                {
                    Toast.makeText(this@DetailActivity, "Elemento no eliminado", Toast.LENGTH_SHORT).show()
                }
            }

        }
        else{
            Toast.makeText(this@DetailActivity,"error al cargar actividad",Toast.LENGTH_SHORT).show()
            finish()

    }

    }

}