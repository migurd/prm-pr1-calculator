package com.example.appmycalculadora

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inUsuario : EditText
    private lateinit var inPassword : EditText
    private lateinit var btnIngresar : EditText
    private lateinit var btnSalir : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Iniciar componente
        init()
        eventosClic()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun init() {
        inUsuario = findViewById(R.id.inUsuario)
        inPassword = findViewById(R.id.inPassword)
        btnIngresar = findViewById(R.id.btnIngresar)
        btnSalir = findViewById(R.id.btnSalir)
    }

    public fun eventosClic() {
        btnIngresar.setOnClickListener(View.OnClickListener {
            var user : String = getString(R.string.usuario)
            var password : String = getString(R.string.pass)
            var name : String = getString(R.string.nombre)

            if (inUsuario.text.toString().contentEquals(user) &&
                inPassword.text.toString().contentEquals(password)) {

                val intent = Intent(this, OperacionesActivity::class.java)
                intent.putExtra("name", name)
                startActivity(intent)
            } else {
                Toast.makeText(this,
                    "Contraseña y usuario no coinciden",
                    Toast.LENGTH_SHORT).show()
            }
        })

        btnSalir.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}