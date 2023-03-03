package com.example.sharedata

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnShareData.setOnClickListener {
            val data: String = binding.tilData.editText?.text.toString()

            if (!TextUtils.isEmpty(data)) {
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_TEXT, data)
                sendIntent.type = "text/plain"
                val shareIntent = Intent.createChooser(sendIntent, "Send To: ")
                startActivity(shareIntent)
            } else {
                Toast.makeText(this@MainActivity, "Field is empty.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}