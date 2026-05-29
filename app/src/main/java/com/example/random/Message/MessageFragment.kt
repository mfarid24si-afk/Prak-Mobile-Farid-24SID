package com.example.random.Message

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.random.R
import com.example.random.databinding.FragmentMessageBinding
import com.example.random.databinding.FragmentMoreBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://api.dicebear.com/7.x/avataaars/png?seed=Alya"),
        MessageModel("Budi", "Sudah makan?", "https://api.dicebear.com/7.x/avataaars/png?seed=Budi"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://api.dicebear.com/7.x/avataaars/png?seed=Citra"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://api.dicebear.com/7.x/avataaars/png?seed=Dika"),
        MessageModel("Eka", "Nice job kemarin!", "https://api.dicebear.com/7.x/avataaars/png?seed=Eka"),
        MessageModel("Fajar", "Lagi ngapain?", "https://api.dicebear.com/7.x/avataaars/png?seed=Fajar"),
        MessageModel("Gita", "Boleh minta tolong?", "https://api.dicebear.com/7.x/avataaars/png?seed=Gita"),
        MessageModel("Hana", "Lihat email ya", "https://api.dicebear.com/7.x/avataaars/png?seed=Hana"),
        MessageModel("Irfan", "Oke noted", "https://api.dicebear.com/7.x/avataaars/png?seed=Irfan"),
        MessageModel("Joko", "Sampai jumpa besok", "https://api.dicebear.com/7.x/avataaars/png?seed=Joko")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) // <-- Tambahkan super call yang baik

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.toolbar.title = "Message Options"

        // Setup Toolbar klik (Contoh: jika ada tombol back di toolbar)
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

}