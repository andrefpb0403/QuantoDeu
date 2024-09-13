package com.example.quantodeu


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ResultadoActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvValorConta = findViewById<TextView>(R.id.tv_valor_conta)
        val tvPorcentagem = findViewById<TextView>(R.id.tv_porcentagem)
        val tvQtdPessoas = findViewById<TextView>(R.id.tv_qtdpessoas)
        val tvResultado = findViewById<TextView>(R.id.tv_totalconta)
        val tvTotalPorPessoa = findViewById<TextView>(R.id.tv_resultado)


        val valorConta = intent.getStringExtra("valorConta")
        val porcentagemGorjeta = intent.getStringExtra("porcentagemGorjeta")
        val qtdPessoas = intent.getStringExtra("qtdPessoas")

        tvValorConta.text = valorConta
        tvPorcentagem.text = porcentagemGorjeta
        tvQtdPessoas.text = qtdPessoas

        val gorjetaPercentual = porcentagemGorjeta!!.toDouble() / 100
        val gorjeta = valorConta!!.toDouble() * gorjetaPercentual
        val totalConta = valorConta.toDouble() + gorjeta
        val valorPessoa = totalConta / qtdPessoas!!.toDouble()

        tvResultado.text = "R$ %.2f".format(totalConta)
        tvTotalPorPessoa.text = "R$ %.2f".format(valorPessoa)

        val btnVoltar = findViewById<Button>(R.id.btn_retornar)
        btnVoltar.setOnClickListener {
        val intent = Intent (this, MainActivity::class.java)
        startActivity(intent)
        }

    }
}