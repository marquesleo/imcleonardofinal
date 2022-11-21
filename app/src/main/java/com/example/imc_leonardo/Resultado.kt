package com.example.imc_leonardo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.imc_leonardo.data.Pessoa
import com.example.imc_leonardo.databinding.ActivityCadastroBinding
import com.example.imc_leonardo.databinding.ActivityResultadoBinding


class Resultado : AppCompatActivity() {
    private var  pessoa = Pessoa()
    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_resultado)

        val i = intent
        val pessoa: Pessoa? = i.getParcelableExtra(Cadastro.TAG);
        if (pessoa != null){
            TratarIMC(pessoa)
        }

    }

    private fun TratarIMC(pessoa: Pessoa){
        val IMC  = pessoa.RetornarIMC()
        val Adulto = pessoa.Adulto

        val txt : TextView = findViewById(R.id.textView)
        val img : ImageView = findViewById(R.id.img)

        if (Adulto) {
            if (IMC <= 17) {
                img.setImageResource(R.drawable.muito_abaixo_do_peso)
            } else if (IMC >= 17 && IMC <= 18.49) {
                img.setImageResource(R.drawable.abaixo_do_peso)
                txt.text =
                    "Você está abaixo do peso ideal. Isso pode ser apenas uma característica pessoal, mas também pode ser um sinal de " +
                            "desnutrição ou de algum problema de saúde. Caso esteja perdendo peso sem motivo aparente, procure um médico."

            } else if (IMC >= 18.5 && IMC <= 24.49) {
                img.setImageResource(R.drawable.peso_normal)

            } else if (IMC >= 25 && IMC <= 29.9) {
                img.setImageResource(R.drawable.acima_do_peso)
                txt.text =
                    "Alguns quilos a mais já são suficientes para que algumas pessoas desenvolvam doenças associadas, como\n" +
                            "diabetes e hipertensão. É importante rever seus hábitos. Procure um médico."


            } else if (IMC >= 30.0 && IMC >= 34.9) {
                txt.text =
                    "O excesso de peso é fator de risco para desenvolvimento de outros problemas de saúde. A boa notícia\n" +
                            "é que uma pequena perda de peso já traz benefícios à saúde. Procure um médico para definir o tratamento mais adequado\n" +
                            "para você"
                img.setImageResource(R.drawable.obesidade_1)
            } else if (IMC <= 35 && IMC >= 39.9) {

                img.setImageResource(R.drawable.obesidade_2)
                txt.text =
                    "Ao atingir este nível de IMC, o risco de doenças associadas está entre alto e muito alto. Busque\n" +
                            "ajuda de um profissional de saúde; não perca tempo."
            } else if (IMC >= 40) {
                img.setImageResource(R.drawable.obsesidade_3)
                txt.text =
                    "Ao atingir este nível de IMC, o risco de doenças associadas é muito alto. Busque ajuda de um" +
                            "profissional de saúde; não perca tempo."
            }
        }else {
            if (IMC <= 22)
            {
                txt.text = "Baixo Peso"
                img.setImageResource(R.drawable.abaixo_do_peso)
            }else if (IMC > 22 && IMC < 27){
                txt.text="Adequado ou eutrófico"
                img.setImageResource(R.drawable.peso_normal)
            }else if (IMC >= 27){
                img.setImageResource(R.drawable.acima_do_peso)
                txt.text =
                    "Alguns quilos a mais já são suficientes para que algumas pessoas desenvolvam doenças associadas, como\n" +
                            "diabetes e hipertensão. É importante rever seus hábitos. Procure um médico."

            }
        }

    }
}