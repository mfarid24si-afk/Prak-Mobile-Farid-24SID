    package com.example.random

    import android.content.Intent
    import android.os.Bundle
    import androidx.appcompat.app.AlertDialog
    import androidx.appcompat.app.AppCompatActivity
    import com.example.random.databinding.ActivityAuthBinding // Pastikan binding ini benar

    class AuthActivity : AppCompatActivity() {
        private lateinit var binding: ActivityAuthBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityAuthBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.btnLogin.setOnClickListener {

                val usernameInput = binding.etUsername.text.toString()
                val passwordInput = binding.etPassword.text.toString()

                // 1. Cek apakah Username == Password (sesuai logika tugasmu)
                if (usernameInput == passwordInput && usernameInput.isNotEmpty()) {

                    // 2. Simpan status ke SharedPreferences
                    val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.putBoolean("isLogin", true)
                    editor.putString("username", usernameInput) // Simpan nama yang diketik user
                    editor.apply()

                    // 3. Pindah ke MainActivity
                    val intent = Intent(this, BaseActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    // Tampilkan AlertDialog jika salah sesuai perintah
                    AlertDialog.Builder(this)
                        .setTitle("Peringatan")
                        .setMessage("Silahkan coba lagi")
                        .setPositiveButton("OK", null)
                        .show()
                }
            }
        }
    }
