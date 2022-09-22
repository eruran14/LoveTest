package com.eru.lovetest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.eru.lovetest.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firstName = requireArguments().getString("firstName")
        val secondName = requireArguments().getString("secondName")
        val percentage = requireArguments().getString("percent")
        val result = requireArguments().getString("result")

        binding.firstTv.text = firstName
        binding.secondTv.text = secondName
        binding.percentTv.text = percentage
        binding.resultTv.text = result

        binding.tryAgainBtn.setOnClickListener {
            requireActivity().findNavController(R.id.nav_host_fragment_container).navigateUp()
        }
    }

}