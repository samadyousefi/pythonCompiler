package com.yerdanksa.rejshth

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pyide.R


class AboutActivity : AppCompatActivity() {
   // lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_about)


        val telG = findViewById<LinearLayout>(R.id.telGroup)

        telG.setOnClickListener {


            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/rejehshteh1401"))
                val pm = packageManager
                if (intent.resolveActivity(pm) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Error message", Toast.LENGTH_LONG).show()
                }
            } catch (ignored: Exception) {
            }
        }

    }
}