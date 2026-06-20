package com.example.random.Home.pertemuan_13

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.random.R
import com.example.random.databinding.ActivityThirteenthBinding
import com.google.android.material.tabs.TabLayoutMediator

class ThirteenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirteenthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirteenthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 13"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val tabsAdapter = ThirteenthTabsAdapter(this)
        binding.viewPager.adapter = tabsAdapter

        // 3. Hubungkan TabLayout & ViewPager2 menggunakan Adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->

            when (position) {
                0 -> {
                    tab.text = "Capture"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_capture)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                }
                1 -> {
                    tab.text = "Scan"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_scan)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
//                    badge.number = 2
                }
                2 -> {
                    tab.text = "QR Code"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_qr)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
//                    badge.number =
                }
            }
        }.attach()
    }
    override fun onSupportNavigateUp(): Boolean {
        // Memanggil onBackPressed agar logika back stack dijalankan
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}