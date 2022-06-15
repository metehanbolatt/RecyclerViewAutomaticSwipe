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
            Item(R.drawable.image_0, "Summer 0"),
            Item(R.drawable.image_1, "Summer 1"),
            Item(R.drawable.image_2, "Summer 2"),
            Item(R.drawable.image_3, "Summer 3"),
            Item(R.drawable.image_4, "Summer 4"),
            Item(R.drawable.image_5, "Summer 5"),
            Item(R.drawable.image_6, "Summer 6"),
            Item(R.drawable.image_7, "Summer 7"),
            Item(R.drawable.image_8, "Summer 8"),
            Item(R.drawable.image_9, "Summer 9")
        )

        adapter = ItemAdapter(list)

        val timer = object : CountDownTimer(2000, 1000) {
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
        }

        object : CountDownTimer(1000, 1000) {
            override fun onTick(p0: Long) { }
            override fun onFinish() {
                timer.start()
            }
        }.start()

        binding.recyclerView.layoutManager = SlowlyLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.adapter = adapter

    }
}