package com.example.appmycalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
        operaciones = Operaciones(0f, 0f)
    }

    private fun validar() : Boolean {
        if (inNum1.text.toString().contentEquals("") ||
            inNum2.text.toString().contentEquals("")) {
            return false
        }
        return true
    }

    private fun assignValues() {
        if (validar()) {
            operaciones.num1 = inNum1.text.toString().toFloat()
            operaciones.num2 = inNum2.text.toString().toFloat()
        } else {
            throw IllegalArgumentException("Inserte valores válidos en ambos campos, por favor.")
        }
    }

    private fun formatNumber(n : Float) : String {
        val formattedNumber = String.format("%.2f", n)
        return formattedNumber
    }

    public fun initClickEvents() {

        btnSumar.setOnClickListener(View.OnClickListener {
            try {
                if (validar()) {
                    assignValues()
                    outResultado.text = "Resultado: " + formatNumber(operaciones.suma())
                } else {
                    Toast.makeText(this, "Inserte valores, por favor.", Toast.LENGTH_SHORT).show()
                }
            } catch(e : IllegalArgumentException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        })
        btnRestar.setOnClickListener(View.OnClickListener {
            try {
                if (validar()) {
                    assignValues()
                    outResultado.text = "Resultado: " + formatNumber(operaciones.restar())
                } else {
                    Toast.makeText(this, "Inserte valores, por favor.", Toast.LENGTH_SHORT).show()
                }
            } catch(e : IllegalArgumentException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        })
        btnMultiplicar.setOnClickListener(View.OnClickListener {
            try {
                if (validar()) {
                    assignValues()
                    outResultado.text = "Resultado: " + formatNumber(operaciones.multiplicar())
                } else {
                    Toast.makeText(this, "Inserte valores, por favor.", Toast.LENGTH_SHORT).show()
                }
            } catch(e : IllegalArgumentException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        })
        btnDividir.setOnClickListener(View.OnClickListener {
            try {
                if (validar()) {
                    assignValues()
                    if (operaciones.num2.toInt() == 0) {
                        outResultado.text = "Resultado: INDEFINIDO"
                    } else {
                        outResultado.text = "Resultado: " + formatNumber(operaciones.dividir())
                    }
                } else {
                    Toast.makeText(this, "Inserte valores, por favor.", Toast.LENGTH_SHORT).show()
                }
            } catch(e : IllegalArgumentException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        })

        btnLimpiar.setOnClickListener(View.OnClickListener {
            inNum1.text.clear()
            inNum2.text.clear()
            outResultado.text = "Resultado: "
        })

        btnRegresar.setOnClickListener(View.OnClickListener { finish() })
    }
}