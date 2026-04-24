package com.example.random.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.random.R
import com.example.random.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inisialisasi binding di awal
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Setup tampilan Edge-to-Edge
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 3. Logika klik tombol submit
        binding.btnSubmit.setOnClickListener {
            // Ambil teks dari input (pastikan ID inputPhone sudah benar untuk mengambil Nama)
            val nama = binding.inputPhone.text.toString().trim()

            if (nama.isNotEmpty()) {
                Toast.makeText(this, "Berhasil Submit: $nama", Toast.LENGTH_SHORT).show()

                // Berpindah ke ThirdResultActivity dengan membawa data
                val intent = Intent(this, ThirdResultActivity::class.java).apply {
                    putExtra("EXTRA_NAMA", nama)
                }
                startActivity(intent)
            } else {
                // Tampilkan pesan jika input kosong
                Toast.makeText(this, "Silahkan isi data dulu!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
