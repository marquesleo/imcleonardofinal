package com.example.imc_leonardo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.imc_leonardo.data.Pessoa
import com.example.imc_leonardo.databinding.ActivityCadastroBinding
import com.example.imc_leonardo.databinding.ActivityMainBinding

class Cadastro : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private var  pessoa = Pessoa()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_cadastro)
        ConfigurarListeners()
    }

    private fun ValidarCamposParaGravacao() : Boolean  {
        val edtAltura :EditText   = findViewById(R.id.edtAltura)
        val edtPeso :EditText = findViewById(R.id.edtPeso)
        val edtNome :EditText = findViewById(R.id.edtNome)
        val rdoIdoso  :RadioButton = findViewById(R.id.rbIdoso)

        val Altura:Double ? = edtAltura.text.toString().toDoubleOrNull()
        val Peso:Double ? = edtPeso.text.toString().toDoubleOrNull()
        val Nome:String =  edtNome.text.toString()


        if (Altura == null || Altura.equals(0)) {
            Toast.makeText(this, "Altura deve ser preenchida", Toast.LENGTH_SHORT).show()
            return false
        }
        if (Peso == null || Peso.equals(0)) {
            Toast.makeText(this, "Peso deve ser preenchida", Toast.LENGTH_SHORT).show()
            return false
        }


        pessoa.Peso = Peso
        pessoa.Altura = Altura
        pessoa.Nome = Nome
        if (rdoIdoso.isChecked)
            pessoa.Adulto = false
        return true
    }

    private fun EnviarCalculoIMC(){
       if (ValidarCamposParaGravacao()){
           val intent = Intent(this, Resultado::class.java).apply {
               putExtra(TAG, pessoa)
           }
           startActivity(intent)
       }
    }

    private fun ConfigurarListeners() {
        val btnEnviar : Button = findViewById(R.id.btnEnviar)
        btnEnviar.setOnClickListener() {
            EnviarCalculoIMC()
        }
    }

    companion object{
        const val TAG = "PARAM"
    }

}