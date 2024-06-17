package com.example.appmycalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OperacionesActivity : AppCompatActivity() {
    private lateinit var outUsuario : TextView
    private lateinit var outResultado : TextView
    private lateinit var inNum1 : EditText
    private lateinit var inNum2 : EditText
    private lateinit var btnSumar : Button
    private lateinit var btnRestar : Button
    private lateinit var btnMultiplicar : Button
    private lateinit var btnLimpiar : Button
    private lateinit var btnDividir : Button
    private lateinit var btnRegresar : Button
    private lateinit var operaciones : Operaciones
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operaciones)

        // init
        init()
        initClickEvents()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun init() {
        inNum1 = findViewById(R.id.inNum1)
        inNum2 = findViewById(R.id.inNum2)

        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        btnMultiplicar = findViewById(R.id.btnMultiplicar)
        btnDividir = findViewById(R.id.btnDividir)

        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnRegresar = findViewById(R.id.btnRegresar)

        outResultado = findViewById(R.id.outResultado)
        outUsuario = findViewById(R.id.outUsuario)

        val bundle : Bundle? = intent.extras
        outUsuario.text = bundle?.getString("name")
    }

    private fun validar() : Boolean {
        if (inNum1.text.toString().contentEquals("") ||
            inNum2.text.toString().contentEquals("")) {
            return false
        }
        return true
    }

    public fun initClickEvents() {

        btnSumar.setOnClickListener(View.OnClickListener {

        })

        btnLimpiar.setOnClickListener(View.OnClickListener {
            inNum1.text.clear()
            inNum2.text.clear()
            outResultado.text = "Resultado: "
        })

        btnRegresar.setOnClickListener(View.OnClickListener { finish() })
    }
}