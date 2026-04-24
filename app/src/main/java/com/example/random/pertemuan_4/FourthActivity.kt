package com.example.random.pertemuan_4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.random.MainActivity
import com.example.random.R
import com.example.random.databinding.ActivityFourthBinding
import com.example.random.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inisialisasi binding di awal
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Setup Edge to Edge menggunakan binding.main
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.e("onCreate", "FourthActivity dibuat pertama kali")

        // 3. Ambil data dari Intent
        val name = intent.getStringExtra("nama")
        val from = intent.getStringExtra("asal")
        val age = intent.getIntExtra("usia", 0)
        Log.e("Data Intent", "Nama: $name , Usia: $age, Asal: $from")

        // 4. Set listener menggunakan binding
        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tutup") {
                    Log.e("Info Snackbar", "Snackbar ditutup")
                }
                .show()
        }

        binding.btnShowAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Ya!")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    finish()
                    Log.e("Info Dialog", "Anda memilih Tidak!")
                }
                .show()
        }
    }


    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: FourthActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "FourthActivity dihapus dari stack")
    }
}
