package com.example.brandonmartinezexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brandonmartinezexamen.Data.ListEncuesta
import com.example.brandonmartinezexamen.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    private var listEncuesta= ListEncuesta()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)
        
        binding.ingresar.setOnClickListener {val intent=Intent (this,LoginActivity::class.java)
            SurveyActivity(intent)




        }





    }
}