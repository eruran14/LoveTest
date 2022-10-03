package com.eru.lovetest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.eru.lovetest.board.BoardAdapter
import com.eru.lovetest.board.BoardModel
import com.eru.lovetest.databinding.FragmentBoardBinding
import me.relex.circleindicator.CircleIndicator3



class BoardFragment : Fragment() {

    private lateinit var binding: FragmentBoardBinding
    private lateinit var data: ArrayList<BoardModel>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBoardBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        data = arrayListOf()
        loadBoards(data)

        val adapter = BoardAdapter(data, findNavController())
        binding.viewPager.adapter = adapter

        val indicator: CircleIndicator3 = binding.indicator
        indicator.setViewPager(binding.viewPager)
    }

    private fun loadBoards(data: ArrayList<BoardModel>){
        data.add(BoardModel("Have a good time", "You should take the time to help those who need you", R.drawable.board_1))
        data.add(BoardModel("Cherishing love", "It is now no longer possible for you to cherish love", R.drawable.board_2))
        data.add(BoardModel("Have a breakup?", "We have made a correction for you, don't worry, maybe someone is waiting for you", R.drawable.board_3))
    }
}