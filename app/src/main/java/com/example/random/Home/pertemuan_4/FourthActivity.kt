    package com.example.random.Home.pertemuan_4

    import android.content.Intent
    import android.os.Bundle
    import android.util.Log
    import android.view.MenuItem
    import android.widget.Toast
    import androidx.activity.enableEdgeToEdge
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat
    import com.example.random.Home.pertemuan_3.ThirdResultActivity
    import com.example.random.Home.pertemuan_9.NinithActivity
    import com.example.random.MainActivity
    import com.example.random.R
    import com.example.random.databinding.ActivityFourthBinding
    import com.example.random.databinding.ActivityMainBinding
    import com.example.random.utils.NotificationHelper
    import com.google.android.material.dialog.MaterialAlertDialogBuilder
    import com.google.android.material.snackbar.Snackbar

    class FourthActivity : AppCompatActivity() {
        private lateinit var binding: ActivityFourthBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            // 1. Inisialisasi binding di awal
            binding = ActivityFourthBinding.inflate(layoutInflater)
            setContentView(binding.root)

            setSupportActionBar(binding.toolbar)
            supportActionBar?.apply {
                title = "Fourth Activity"
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
            }

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
                val noTujuan = binding.materialCardView
                val intent = Intent(this, NinithActivity::class.java)

                //startActivity(intent)

                NotificationHelper.showNotification(
                    this, //Jika panggil di fragment maka requireContext()
                    "Pesanan Anda",
                    "Halo $noTujuan, ini snackbar",
                    intent
                )
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
