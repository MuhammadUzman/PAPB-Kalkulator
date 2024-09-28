package com.example.kalkulator

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : Activity() {

    private lateinit var resultDisplay: EditText
    private var currentInput = ""
    private var operator = ""
    private var firstNumber = ""
    private var secondNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultDisplay = findViewById(R.id.result_display)

        // Number buttons
        val button0: Button = findViewById(R.id.btn_0)
        val button1: Button = findViewById(R.id.btn_1)
        val button2: Button = findViewById(R.id.btn_2)
        val button3: Button = findViewById(R.id.btn_3)
        val button4: Button = findViewById(R.id.btn_4)
        val button5: Button = findViewById(R.id.btn_5)
        val button6: Button = findViewById(R.id.btn_6)
        val button7: Button = findViewById(R.id.btn_7)
        val button8: Button = findViewById(R.id.btn_8)
        val button9: Button = findViewById(R.id.btn_9)

        // Operator buttons
        val buttonAdd: Button = findViewById(R.id.btn_add)
        val buttonSubtract: Button = findViewById(R.id.btn_subtract)
        val buttonMultiply: Button = findViewById(R.id.btn_multiply)
        val buttonDivide: Button = findViewById(R.id.btn_divide)

        // Clear and equals buttons
        val buttonClear: Button = findViewById(R.id.btn_clear)
        val buttonEquals: Button = findViewById(R.id.btn_equals)

        // Set click listeners
        button0.setOnClickListener { appendNumber("0") }
        button1.setOnClickListener { appendNumber("1") }
        button2.setOnClickListener { appendNumber("2") }
        button3.setOnClickListener { appendNumber("3") }
        button4.setOnClickListener { appendNumber("4") }
        button5.setOnClickListener { appendNumber("5") }
        button6.setOnClickListener { appendNumber("6") }
        button7.setOnClickListener { appendNumber("7") }
        button8.setOnClickListener { appendNumber("8") }
        button9.setOnClickListener { appendNumber("9") }

        buttonAdd.setOnClickListener { setOperator("+") }
        buttonSubtract.setOnClickListener { setOperator("-") }
        buttonMultiply.setOnClickListener { setOperator("*") }
        buttonDivide.setOnClickListener { setOperator("/") }

        buttonClear.setOnClickListener { clearInput() }
        buttonEquals.setOnClickListener { calculateResult() }
    }

    private fun appendNumber(number: String) {
        currentInput += number
        resultDisplay.setText(currentInput)
    }

    private fun setOperator(op: String) {
        if (currentInput.isNotEmpty()) {
            firstNumber = currentInput
            operator = op
            currentInput = ""
            resultDisplay.setText("")
        }
    }

    private fun calculateResult() {
        if (currentInput.isNotEmpty()) {
            secondNumber = currentInput
            val result = when (operator) {
                "+" -> firstNumber.toDouble() + secondNumber.toDouble()
                "-" -> firstNumber.toDouble() - secondNumber.toDouble()
                "*" -> firstNumber.toDouble() * secondNumber.toDouble()
                "/" -> firstNumber.toDouble() / secondNumber.toDouble()
                else -> 0.0
            }
            resultDisplay.setText(result.toString())
            currentInput = result.toString()
        }
    }

    private fun clearInput() {
        currentInput = ""
        firstNumber = ""
        secondNumber = ""
        operator = ""
        resultDisplay.setText("")
    }
}
