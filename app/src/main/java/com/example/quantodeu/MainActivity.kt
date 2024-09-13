package com.example.quantodeu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnResultado = findViewById<Button>(R.id.btn_retornar)
        val edtValorConta = findViewById<TextInputEditText>(R.id.edt_valor_conta)
        val edtPorcentagemGorjeta = findViewById<TextInputEditText>(R.id.edt_porcentagem_gorjeta)
        val edtQtdPessoas = findViewById<TextInputEditText>(R.id.edt_qtd_pessoas)

        btnResultado.setOnClickListener {
            if (edtValorConta.text.toString().isEmpty()) {
                Toast.makeText(this, "Digite o valor da conta", Toast.LENGTH_SHORT).show()
            } else if (edtPorcentagemGorjeta.text.toString().isEmpty()) {
                Toast.makeText(this, "Digite a porcentagem da gorjeta", Toast.LENGTH_SHORT).show()
            } else if (edtQtdPessoas.text.toString().isEmpty()) {
                Toast.makeText(this, "Digite a quantidade de pessoas", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("valorConta", edtValorConta.text.toString())
                intent.putExtra("porcentagemGorjeta", edtPorcentagemGorjeta.text.toString())
                intent.putExtra("qtdPessoas", edtQtdPessoas.text.toString())
                startActivity(intent)
            }
        }
    }
}