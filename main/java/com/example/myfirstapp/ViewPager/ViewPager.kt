package com.example.myfirstapp.ViewPager

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.myfirstapp.R
import com.example.myfirstapp.ViewPager.model.Item
import com.example.myfirstapp.databinding.ActivityViewPagerBinding
import com.example.viewpagerandroid.adapter.OnBoardingAdapter

class ViewPager : AppCompatActivity() {

    lateinit var binding: ActivityViewPagerBinding
    private var itemList = mutableListOf<Item>()
    private lateinit var mAdapter: OnBoardingAdapter

    var currentItex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemList.add(
            Item(
                1,
                "Fresh Food",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever.",
                R.drawable.onboarding1
            )
        )
        itemList.add(
            Item(
                2,
                "Fast Delivery",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever.",
                R.drawable.onboarding2
            )
        )
        itemList.add(
            Item(
                3,
                "Easy Payment",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever.",
                R.drawable.onboarding3
            )
        )
        binding.btnGet.setOnClickListener {
            // navigate to login
        }

        binding.btnNext.setOnClickListener {
            if (currentItex < mAdapter.count-1)
                currentItex++
            binding.viewPager.currentItem = currentItex

        }

        //passing data to adapter
        mAdapter = OnBoardingAdapter(this,itemList)
        binding.viewPager.adapter = mAdapter

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                currentItex = position
                Toast.makeText(applicationContext, "$position", Toast.LENGTH_SHORT).show()

                if (currentItex == mAdapter.count-1){
                    binding.btnNext.visibility = View.INVISIBLE
                    binding.btnNext.isClickable = false
                    binding.btnGet.visibility = View.VISIBLE

                }else{
                    binding.btnNext.visibility = View.VISIBLE
                    binding.btnGet.visibility = View.GONE
                    binding.btnNext.isClickable = true

                }

                updataIndicator(position)

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

    }

    private fun updataIndicator(position: Int) {
        binding.layoutDots.removeAllViews()

        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        lp.setMargins(8,0,8,0)

        for(i in 0 until mAdapter.count){
            var imageView = ImageView(this)

            if (position == i){
                imageView.setImageResource(R.drawable.shape_color)
                imageView.layoutParams = lp
            }else{
                imageView.setImageResource(R.drawable.shape_border)
                imageView.layoutParams = lp
            }
            binding.layoutDots.addView(imageView)
        }

    }
}