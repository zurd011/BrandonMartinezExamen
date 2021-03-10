package com.example.brandonmartinezexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import android.widget.ArrayAdapter
import com.example.brandonmartinezexamen.Data.ListEncuesta
import com.example.brandonmartinezexamen.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val listEncuesta = ListEncuesta()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)
        supportActionBar?.setTitle(R.string.text_list)

        listEncuesta.showListEncuesta()
        val adapter = ArrayAdapter<String>(
            this@HomeActivity, android.R.layout.simple_list_item_1, listEncuesta.getStringArray(
                name = String()
            )
        )
        binding.ltvEncuestas.adapter = adapter

        binding.ltvEncuestas.setOnItemClickListener { adapterView: AdapterView<*>, view1: View, position: Int, id: Long ->

            val selectedItem = adapterView.getItemAtPosition(position)

            Toast.makeText(this@HomeActivity, " $position $id $selectedItem", Toast.LENGTH_SHORT)
                .show()

            //val intent = Intent(this@HomeActivity,
            //  DetailActivity::class.java).apply{
            //putExtra(Constants.ID,position)
            //}

            startActivity((intent))

        }
    }

    override fun onRestart() {
        super.onRestart()
        val adapter = ArrayAdapter<String>(
            this@HomeActivity, android.R.layout.simple_list_item_1, listEncuesta.getStringArray(
                name = String()
            )
        )
        binding.ltvEncuestas.adapter = adapter

    }



}