package com.example.random.pertemuan2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.random.R
import com.example.random.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    // 1. Deklarasikan binding
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. Inisialisasi binding
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 3. Setup Edge-to-Edge
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 4. Logika klik tombol (tidak perlu findViewById lagi)
        binding.btnSubmit.setOnClickListener {
            // Mengambil value dari inputNama (tambahkan .toString() agar lebih aman)
            val nama = binding.inputNama.text.toString()

            Log.e("Klik btnSubmit", "Tombol berhasil di tekan. Isi dari inputNama = $nama")

            Toast.makeText(this, "Anda telah melakukan klik pada Submit Cihuuyyy $nama", Toast.LENGTH_SHORT).show()
        }
    }
}
