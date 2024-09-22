package com.example.aplikasipenentugenerasi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //inisialisasi komponen
        var edTglLahir = findViewById<EditText>(R.id.ed_tanggal_lahir)
        var btnKlik = findViewById<Button>(R.id.btn_klik)
        var tvHasil = findViewById<TextView>(R.id.tv_hasil)

        btnKlik.setOnClickListener{
            val input = edTglLahir.text.toString()
            val hasil = when(input.toInt()){
                in 1946..1964 -> "Generasi Baby Boomers"
                in 1965..1979 -> "Generasi X"
                in 1980..1994 -> "Generasi Y"
                in 1995..2009 -> "Generasi Z"
                in 2010..2024 -> "Generasi Alpha"
                else -> "Tahun kelahiran tidak dalam rentang yang ditentukan"
            }
            tvHasil.text = "Kamu generasi $hasil"
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}