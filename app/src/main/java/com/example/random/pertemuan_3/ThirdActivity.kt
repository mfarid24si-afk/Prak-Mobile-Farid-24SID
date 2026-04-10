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
        enableEdgeToEdge()

        // Gunakan binding sepenuhnya, hapus findViewById manual
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSubmit.setOnClickListener {
            val nama = binding.inputPhone.text.toString()

            if (nama.isNotEmpty()) {
                Toast.makeText(this, "Berhasil Submit: $nama", Toast.LENGTH_SHORT).show()

                // Membuat intent untuk pindah halaman
                val intent = Intent(this, ThirdResultActivity::class.java)

                // Menitipkan data ke halaman selanjutnya (key, value)
                intent.putExtra("EXTRA_NAMA", nama)

                startActivity(intent)
            } else {
                Toast.makeText(this, "Silahkan isi data dulu!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
