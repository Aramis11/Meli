package com.example.meli.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.text.NumberFormat
import java.util.*

class Utils {

    fun hideKeyboard(activity: Activity) {
        val view = activity.findViewById<View>(android.R.id.content)
        val inputManager =
            activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            view.windowToken,
            0
        )
    }

    fun convertStringInCurrency(textValue: String): String {
        return try {
            if (textValue != "" && textValue != "$") {
                val formatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)
                formatter.maximumFractionDigits = 0
                var cleanString = textValue.replace("$", "")
                cleanString = cleanString.replace(".", "")
                cleanString = cleanString.replace(",", "")
                val parsed = cleanString.toDouble()
                var formatted = formatter.format(parsed)
                formatted = formatted.replace(",", ".")
                formatted
            } else {
                ""
            }
        } catch (_: Exception) {
            ""
        }
    }
}