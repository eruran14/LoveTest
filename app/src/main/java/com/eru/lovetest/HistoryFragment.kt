package com.eru.lovetest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.eru.lovetest.databinding.FragmentHistoryBinding
import com.eru.lovetest.room.AppDatabase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding

    @Inject
    private lateinit var database: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        database.loveDao().getAll().observe(viewLifecycleOwner, Observer {
            it.forEach {
                val data = "${it.firstName} ${it.secondName} \n percentage: ${it.percentage} \n result: ${it.result} \n"
                binding.textView.text = data
            }
        })
    }
}