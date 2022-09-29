package com.eru.lovetest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.eru.lovetest.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding

    private val viewModel: LoveViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentHomeBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        binding.calculateBtn.setOnClickListener {
            viewModel.getLiveModel(
                binding.firstEd.text.toString(),
                binding.secondEd.text.toString()
            ).observe(viewLifecycleOwner, Observer {
                findNavController().navigate(R.id.resultFragment, Bundle().apply {
                    putString("firstName", it.firstName)
                    putString("secondName", it.secondName)
                    putString("result", it.result)
                    putString("percent", it.percentage)
                })
            })
        }
    }
}
