package com.example.brandonmartinezexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.brandonmartinezexamen.Data.ListEncuesta
import com.example.brandonmartinezexamen.Entity.EntityEncuesta
import com.example.brandonmartinezexamen.databinding.ActivitySurveyBinding
import com.google.android.material.snackbar.Snackbar

class SurveyActivity(intent: Intent) : AppCompatActivity() {

    private lateinit var binding : ActivitySurveyBinding

    private var listEncuesta= ListEncuesta()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySurveyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle(R.string.text_encuesta)


        binding.ButtonGuardar.setOnClickListener {

            //va dentro del if

            if(binding.edtNombre.text.isNotEmpty()&& binding.edtInspiracion.text.isNotEmpty()&& binding.edtDeporte.text.isNotEmpty()) {

                val encuest =
                    EntityEncuesta()

                encuest.nombre = binding.edtNombre.text.toString()
                encuest.deportistafa = binding.edtDeporte.text.toString()
                encuest.inspiracion = binding.edtInspiracion.text.toString()
                encuest.gender = binding.spnGenero.selectedItemPosition
                // val genderText:String=binding.spnGender.selectedItem.toString()

                when (binding.rgdHorario.checkedRadioButtonId) {

                    binding.rdbUnfinishedStudies.id -> {
                        encuest.horario = "Mas de 3 horas"
                    }
                    binding.rdbUniversityIntern.id -> {
                        encuest.horario = "Menos de 3 horas"
                    }
                    binding.rdbFinishedStudies.id -> {
                        encuest.horario = "Nada"
                    }

                }

                encuest.futbol = binding.ckbFutbol.isChecked
                encuest.basquet = binding.ckbBasquet.isChecked
                encuest.tenis = binding.ckbTenis.isChecked

                encuest.salud = binding.swtSalud.isChecked



                val index = listEncuesta.add(encuest)

                if (index >= 0) {

                    Toast.makeText(this@SurveyActivity, "Encuesta guardada", Toast.LENGTH_SHORT).show()

                    binding.edtNombre.text.clear()

                    binding.edtDeporte.text.clear()

                    binding.edtInspiracion.text.clear()

                    binding.rgdHorario.clearCheck()

                    binding.ckbFutbol.isChecked=false

                    binding.ckbBasquet.isChecked=false

                    binding.ckbTenis.isChecked=false

                    binding.swtSalud.isChecked=false

                    binding.spnGenero.setSelection(0)


                } else {

                    Snackbar.make(it, "Encuesta NO guardada", Snackbar.LENGTH_SHORT).show()

                }


            }
            else
            {
                Snackbar.make(it, "Todos los campos son OBLIGATORIOS", Snackbar.LENGTH_SHORT).show()
            }




        }

        /*
        binding.spnGender.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                val selectedText = p0?.getItemAtPosition(p2)

                Toast.makeText(this@FormActivity,"estoy en evento onItemSelected $p2 $selectedText",Toast.LENGTH_SHORT).show()

            }


            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@FormActivity,"estoy en evento onNothingSelected",Toast.LENGTH_SHORT).show()
            }

        }

        binding.swtFinancialAssistance.setOnCheckedChangeListener { it,isChecked ->

            val checked = if (isChecked) "On" else "Off"

            Toast.makeText(this@FormActivity,"estoy en evento setOnCheckedListener $checked",Toast.LENGTH_SHORT).show()

        }

        */


    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_form,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.itmList ->{
                val intent = Intent(this@SuervyActivity,
                    LoginActivity::class.java)
                startActivity(intent)
            }
            R.id.itmForm ->{
                val intent = Intent(this@FormActivity,
                    EditarEliminarActivity::class.java)
                startActivity(intent)

            }
            R.id.itmExit ->{
                finish()

            }
        }


        return super.onOptionsItemSelected(item)
    }*/
}