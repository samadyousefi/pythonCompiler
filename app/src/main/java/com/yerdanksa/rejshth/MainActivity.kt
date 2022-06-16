package com.yerdanksa.rejshth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
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
       val  CodeArea = findViewById<EditText>(R.id.codearea)
       val Run = findViewById<ImageView>(R.id.run)

        val support = findViewById<ImageView>(R.id.imageView2)
        val progress = findViewById<ProgressBar>(R.id.progressBar)
        progress.visibility = View.GONE
        support.setOnClickListener {
            startActivity(Intent(this,AboutActivity::class.java))
        }
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }


        Run.setOnClickListener {
            progress.visibility = View.VISIBLE

            val handler = Handler()
            handler.postDelayed({
                val intent = Intent(this, code::class.java)
                val py = Python.getInstance()
                val pyObject = py.getModule("pyscript")
                val obj = pyObject.callAttr("main", CodeArea.getText().toString())
                //output.setText(obj.toString());
                intent.putExtra("codeoutput",obj.toString())
                startActivity(intent)
            }, 1500)
        }



    }
}