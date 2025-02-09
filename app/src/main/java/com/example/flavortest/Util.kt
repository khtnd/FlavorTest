package com.example.flavortest

import android.widget.TextView

object Util {
    fun addText(textView: TextView) {
        "${textView.text}\nCommon".also { textView.text = it }
    }
}