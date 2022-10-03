package com.eru.lovetest.board
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.eru.lovetest.Prefs
import com.eru.lovetest.R
import com.eru.lovetest.databinding.ItemBoardBinding
import javax.inject.Inject


class BoardAdapter (private val data: ArrayList<BoardModel>, private val navController: NavController): RecyclerView.Adapter<BoardAdapter.ViewHolder>() {

    @Inject
    lateinit var prefs: Prefs

    inner class ViewHolder(private val binding: ItemBoardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            binding.textView.text = data[position].title
            binding.textView2.text = data[position].description
            binding.imageView.setImageResource(data[position].image)

            if (position == data.lastIndex){
                binding.startBtn.visibility = View.VISIBLE
            } else{
                binding.startBtn.visibility = View.INVISIBLE
            }

            binding.startBtn.setOnClickListener {
                prefs.saveState()
                navController.navigate(R.id.homeFragment)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = data.size
}