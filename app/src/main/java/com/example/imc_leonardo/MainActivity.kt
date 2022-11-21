package com.example.imc_leonardo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.imc_leonardo.databinding.ActivityCadastroBinding
import com.example.imc_leonardo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        ConfigurarListeners()
    }

    private fun ConfigurarListeners() {
        val btnIncluir : View = findViewById(R.id.btnIncluir)
        btnIncluir.setOnClickListener(){
            iniciarNovaActivity()
        }


    }

    private fun iniciarNovaActivity() {

        val intent = Intent(this, Cadastro::class.java)
        startActivity(intent)
    }
}