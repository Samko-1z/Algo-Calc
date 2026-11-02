package com.example.calculatorapp

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private val _EquationText = MutableLiveData<String>("")
    val EquationText: LiveData<String> = _EquationText

    private val _resultText = MutableLiveData("0")
    val resultText: LiveData<String> = _resultText

    fun onButtonClick(btn: String) {
        Log.i("Clicked Button", btn)

        val currentText = _EquationText.value ?: ""

        if (btn == "AC") {
            _EquationText.value = ""
            _resultText.value = "0"
            return
        }

        if (btn == "C") {
            if (currentText.isNotEmpty()) {
                _EquationText.value = currentText.substring(0, currentText.length - 1)
                return
            }
        }
        if (btn == "=") {
            _EquationText.value = _resultText.value
            return
        }
        _EquationText.value = currentText + btn

        try {
            _resultText.value = calculateresult(_EquationText.value.toString())
        } catch (_: Exception) {}
    }

    fun calculateresult(equation: String): String {
        val context: org.mozilla.javascript.Context = org.mozilla.javascript.Context.enter()
        return try {
            context.optimizationLevel = -1
            val scope = context.initStandardObjects()
            var finalresult = context.evaluateString(scope, equation, "Javascript", 1, null).toString()

            if (finalresult.endsWith(".0")) {
                finalresult = finalresult.replace(".0", "")
            }

            finalresult
        } finally {
            org.mozilla.javascript.Context.exit()
        }
    }

    val isDarkTheme = mutableStateOf(false)

    fun toggleTheme() {
        isDarkTheme.value = !isDarkTheme.value
    }
}
