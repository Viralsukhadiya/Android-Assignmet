package com.example.viewpagerandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.myfirstapp.ViewPager.model.Item
import com.example.myfirstapp.databinding.ItemOnBoardingLayoutBinding


class OnBoardingAdapter(var context: Context, var itemList: MutableList<Item>): PagerAdapter() {

    private lateinit var binding: ItemOnBoardingLayoutBinding

    override fun getCount(): Int {
        return itemList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        binding = ItemOnBoardingLayoutBinding.inflate(LayoutInflater.from(context),container,false)

        var item = itemList[position]

        binding.ivThumbnail.setImageResource(item.image)
        binding.tvTitle.text = item.title
        binding.tvDescription.text = item.description

        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object`as View)
    }
}