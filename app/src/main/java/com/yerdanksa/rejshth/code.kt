package com.yerdanksa.rejshth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.pyide.R

class code : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code)

       val codeout = findViewById<TextView>(R.id.codeout)


        val codeoutput = intent.getStringExtra("codeoutput")
        codeout.text = codeoutput


    }
}
