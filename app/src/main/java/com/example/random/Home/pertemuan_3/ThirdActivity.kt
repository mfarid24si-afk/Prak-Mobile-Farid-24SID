package com.example.random.Home.pertemuan_3

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.random.R
import com.example.random.databinding.ActivityThirdBinding
import com.example.random.utils.NotificationHelper
import com.example.random.utils.PermissionHelper
import com.example.random.utils.ReminderHelper
import java.util.Calendar

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Toast.makeText(this, "Notifikasi diizinkan", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Notifikasi ditolak", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (PermissionHelper.isNotificationPermissionRequired()) {
            val permission = Manifest.permission.POST_NOTIFICATIONS
            if (!PermissionHelper.hasPermission(this, permission)) {
                PermissionHelper.requestPermission(
                    notificationPermissionLauncher,
                    permission
                )
            }
        }

        // 1. Inisialisasi binding di awal
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 3"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // 2. Setup tampilan Edge-to-Edge
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 3. Logika klik tombol submit
//        binding.btnKirim.setOnClickListener {
//            // Ambil teks dari input (pastikan ID inputPhone sudah benar untuk mengambil Nama)
//            val nama = binding.inputPhone.text.toString().trim()
//
//            if (nama.isNotEmpty()) {
//                Toast.makeText(this, "Berhasil Submit: $nama", Toast.LENGTH_SHORT).show()
//
//                // Berpindah ke ThirdResultActivity dengan membawa data
//                val intent = Intent(this, ThirdResultActivity::class.java).apply {
//                    putExtra("EXTRA_NAMA", nama)
//                }
//                startActivity(intent)
//            } else {
//                // Tampilkan pesan jika input kosong
//                Toast.makeText(this, "Silahkan isi data dulu!", Toast.LENGTH_SHORT).show()
//            }
//        }
        binding.btnKirim.setOnClickListener {
            val noTujuan = binding.inputNoTujuan.text
//            val intent = Intent(this, ThirdResultActivity::class.java)

            //startActivity(intent)

//            NotificationHelper.showNotification(
//                this, //Jika panggil di fragment maka requireContext()
//                "Pesanan Anda",
//                "Halo $noTujuan, Pesanan Anda Sedang Diproses",
//                intent
//            )
            val calendar = Calendar.getInstance().apply {
                add(Calendar.MINUTE, 1) // Tambah 1 menit dari sekarang
            }

            ReminderHelper.setReminder(
                context = this, //Jika panggil di fragment maka requireContext()
                hour = calendar.get(Calendar.HOUR_OF_DAY),
                minute = calendar.get(Calendar.MINUTE),
                title = "Reminder 1 Menit",
                message = "Halo $noTujuan, reminder ini muncul 1 menit setelah tombol ditekan",
                targetActivity = ThirdResultActivity::class.java
            )
            Toast.makeText(
                this,
                "Silahkan tunggu 1 Menit untuk menerima Notifikasi...",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            R.id.action_search -> {
                Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}


