package com.example.random.Home.pertemuan_7

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.random.R
import com.example.random.databinding.ActivitySeventhBinding

class SeventhActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeventhBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySeventhBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 7"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        // Menampilkan fragment pertama secara default
        replaceFragment(SatuFragment())

        // Setup event click untuk mengganti fragment
        binding.btnFragment1.setOnClickListener {
            replaceFragment(SatuFragment())
        }

        binding.btnFragment2.setOnClickListener {
            replaceFragment(DuaFragment())
        }

        binding.btnFragment3.setOnClickListener {
            replaceFragment(TigaFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager

        // 1. Ambil nama class fragment yang dituju (sebagai tag)
        val fragmentTag = fragment.javaClass.simpleName

        // 2. Cek apakah fragment yang sedang tampil sama dengan yang diklik
        val currentFragment = fragmentManager.findFragmentById(binding.fragmentContainer.id)
        if (currentFragment?.javaClass?.simpleName == fragmentTag) {
            return // Berhenti di sini, jangan lakukan transaksi apapun
        }

        // 3. Bersihkan BackStack agar tidak menumpuk (Opsional, tapi direkomendasikan)
        // Ini akan menghapus riwayat perpindahan fragment sebelumnya
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        // 4. Lakukan transaksi
        fragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            // Kita tidak pakai addToBackStack di sini agar saat di-back langsung keluar Activity,
            // KECUALI kamu memang ingin user bisa back satu per satu.
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        // Memanggil onBackPressed agar logika back stack dijalankan
        onBackPressedDispatcher.onBackPressed()
        return true
    }

}