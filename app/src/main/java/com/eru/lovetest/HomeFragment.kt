package com.eru.lovetest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.eru.lovetest.databinding.FragmentHomeBinding
import com.eru.lovetest.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        binding.calculateBtn.setOnClickListener {
            App.api.calculateLove(binding.firstEd.text.toString(), binding.secondEd.text.toString()).enqueue(object : Callback<LoveModel>{
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    val model: LoveModel = response.body() as LoveModel
                    requireActivity().findNavController(R.id.nav_host_fragment_container).navigate(R.id.resultFragment, Bundle().apply {
                        putString("percent", model.percentage)
                        putString("result", model.result)
                        putString("firstName", model.firstName)
                        putString("secondName", model.secondName)
                    })
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", "onFailure ${t.message}")
                }

            })
        }
    }
}