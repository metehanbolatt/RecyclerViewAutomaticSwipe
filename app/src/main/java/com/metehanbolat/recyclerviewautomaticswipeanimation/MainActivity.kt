package com.metehanbolat.recyclerviewautomaticswipeanimation

import android.os.Bundle
import android.os.CountDownTimer
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import com.metehanbolat.recyclerviewautomaticswipeanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val list = listOf(
            Item(R.color.black, "Black"),
            Item(R.color.purple_200, "Mor"),
            Item(R.color.purple_500, "Lahana"),
            Item(R.color.purple_700, "Marul"),
            Item(R.color.teal_200, "Biber"),
            Item(R.color.teal_700, "Kiraz"),
            Item(android.R.color.holo_orange_dark, "Kavun")

        )
        adapter = ItemAdapter(list)
        object : CountDownTimer(2000, 1000) {
            override fun onFinish() {
                binding.recyclerView.post {
                    binding.recyclerView.smoothScrollToPosition(0)
                }
            }
            override fun onTick(p0: Long) {
                binding.recyclerView.post {
                    binding.recyclerView.smoothScrollToPosition(adapter.itemCount - 1)
                }
            }
        }.start()
        binding.recyclerView.layoutManager = SlowlyLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.adapter = adapter
        var a = 0
        binding.button.setOnClickListener {
            a++
            binding.textView2.text = a.toString()
        }

    }
}