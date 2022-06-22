package com.yerdanksa.rejshth

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.example.pyide.R


class MainActivity : AppCompatActivity() {


    override fun onResume() {
        val progress = findViewById<ProgressBar>(R.id.progressBar)
        progress.visibility = View.GONE

        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val codeEditText = findViewById<EditText>(R.id.codearea)
        val Run = findViewById<ImageView>(R.id.run)

        val support = findViewById<ImageView>(R.id.imageView2)
        val timeText = findViewById<TextView>(R.id.textView4)
        val numberCountText = findViewById<TextView>(R.id.textCountNumber)
        val lettersCountText = findViewById<TextView>(R.id.textCountLetters)

        val progress = findViewById<ProgressBar>(R.id.progressBar)
        progress.visibility = View.GONE
        support.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }
        val py = Python.getInstance()
        val tScript = py.getModule("tscript")
        val time = tScript.callAttr("time")
        timeText.text = time.toString()


        codeEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val number = tScript.callAttr("count_number", codeEditText.text.toString())
                numberCountText.text = "Numbers : $number"

                val letters = tScript.callAttr("count_letters", codeEditText.text.toString())
                lettersCountText.text = "Letters : $letters"


            }
        })

        Run.setOnClickListener {
            progress.visibility = View.VISIBLE
            val handler = Handler()
            handler.postDelayed({
                val intent = Intent(this, code::class.java)
                val pyObject = py.getModule("pyscript")
                val obj = pyObject.callAttr("main", codeEditText.text.toString())
                intent.putExtra("codeoutput", obj.toString())
                startActivity(intent)
            }, 1500)
        }


    }
}