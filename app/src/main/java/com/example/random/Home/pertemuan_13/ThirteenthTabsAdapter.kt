package com.example.random.Home.pertemuan_13

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.random.Tab.TabAFragment
import com.example.random.Tab.TabCaptureFragment
import com.example.random.Tab.TabQrcodeFragment
import com.example.random.Tab.TabScanFragment

class ThirteenthTabsAdapter (activity: FragmentActivity) : FragmentStateAdapter(activity) {

    // Jumlah total tab yang ada
    override fun getItemCount(): Int = 3

    // Menentukan Fragment mana yang akan ditampilkan berdasarkan posisi tab
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabCaptureFragment()
            1 -> TabScanFragment()
            2 -> TabQrcodeFragment()
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}