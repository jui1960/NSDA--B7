package com.example.a9_calculator
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.a9_calculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var lastNumeric: Boolean = false
    private var lastdot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numberButtons = listOf(
            binding.bt5, binding.bt6, binding.bt7, binding.bt9, binding.bt10, binding.bt11,
            binding.bt13, binding.bt14, binding.bt15, binding.bt17
        )
        for (button in numberButtons) {
            button.setOnClickListener {
                numberClick(button.text.toString())
            }
        }
        binding.bt18.setOnClickListener { dotClick() }
        binding.bt4.setOnClickListener { operatorClick("/") }
        binding.bt12.setOnClickListener { operatorClick("-") }
        binding.bt16.setOnClickListener { operatorClick("*") }
        binding.bt8.setOnClickListener { operatorClick("+") }
        binding.bt3.setOnClickListener { operatorClick("%") }
        binding.bt1.setOnClickListener { allclear() }
        binding.bt2.setOnClickListener { clear() }
        binding.bt20.setOnClickListener { calculateResult() }


    }

    private fun numberClick(value: String) {
        binding.input1.append(value)
        lastNumeric = true
        lastdot = false
    }
    private fun dotClick() {
        if (lastNumeric && !lastdot) {
            binding.input1.append(".")
            lastNumeric = false
            lastdot = true
        }
    }
    private fun operatorClick(operator: String) {
        val currenttext = binding.input1.text.toString()
        if (lastNumeric && !isOperatorAdded(currenttext)) {
            binding.input1.append(operator)
            lastNumeric = false
            lastdot = false

        }
    }
    private fun allclear() {
        binding.input1.text.clear()
        binding.second.text = ""
        lastNumeric = false
        lastdot = false
    }

    private fun clear() {
        val currenttext = binding.input1.text.toString()
        if (currenttext.isNotEmpty()) {
            binding.input1.setText(currenttext.substring(0, currenttext.length - 1))
            val newtext = binding.input1.text.toString()
            if (newtext.isNotEmpty()) {
                val lastchar = newtext.last()
                if (lastchar.isDigit()) lastNumeric = true
                else lastNumeric = false
            }
            lastdot = newtext.contains(".")
        } else {
            lastNumeric = false
            lastdot = false
        }
    }


    private fun calculateResult() {
        if (!lastNumeric) return
        var tvValue = binding.input1.text.toString()


        val operator = when {
            tvValue.contains("+") -> "+"
            tvValue.contains("-") && tvValue.lastIndexOf("-") > 0 -> "-"
            tvValue.contains("*") -> "*"
            tvValue.contains("/") -> "/"
            tvValue.contains("%") -> "%"
            else -> ""
        }
        if (operator.isEmpty()) return

        val splitValue = if (operator == "-" && tvValue.startsWith("-")) {
            tvValue.substring(1).split("-").let { listOf("-" + it[0], it[1]) }
        } else tvValue.split(operator)
        if (splitValue.size < 2) return
        val num1 = splitValue[0].toDoubleOrNull() ?: 0.0
        val num2 = splitValue[1].toDoubleOrNull() ?: 0.0


        val result = when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else "error"
            "%" -> num1 % num2
            else -> ""
        }
        binding.second.text = result.toString()


    }

    private fun isOperatorAdded(value : String): Boolean{
        return if(value.startsWith("-")) {
            val sub = value.substring(1)
            sub.contains("/") || sub.contains("*") || sub.contains("+") || sub.contains("-") || sub.contains("%")
        }
        else{
            value.contains("/") || value.contains("*")||
                    value.contains("+")||value.contains("-")
                    || value.contains("%")
        }

    }
}